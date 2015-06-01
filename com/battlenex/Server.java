package com.battlenex;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;

import org.apache.mina.common.IoAcceptor;
import org.apache.mina.transport.socket.nio.SocketAcceptor;
import org.apache.mina.transport.socket.nio.SocketAcceptorConfig;
import com.battlenex.clip.region.ObjectDef;
import com.battlenex.clip.region.Region;
import com.battlenex.cycle.CycleEventContainer;
import com.battlenex.cycle.CycleEventHandler;
import com.battlenex.event.EventManager;
import com.battlenex.game.Client;
import com.battlenex.game.Initializer;
import com.battlenex.game.items.ItemHandler;
import com.battlenex.game.minigames.CastleWars;
import com.battlenex.game.minigames.FightCaves;
import com.battlenex.game.minigames.FightPits;
import com.battlenex.game.minigames.PestControl;
import com.battlenex.game.minigames.TriviaBot;
import com.battlenex.game.npcs.NPCDrops;
import com.battlenex.game.npcs.NPCHandler;
import com.battlenex.game.npcs.NPCSpawns;
import com.battlenex.game.objects.ObjectHandler;
import com.battlenex.game.objects.ObjectManager;
import com.battlenex.game.objects.doors.Doors;
import com.battlenex.game.objects.doors.DoubleDoors;
import com.battlenex.game.panel.StaffPanel;
import com.battlenex.game.players.Player;
import com.battlenex.game.players.PlayerAssistant;
import com.battlenex.game.players.PlayerHandler;
import com.battlenex.game.players.PlayerSave;
import com.battlenex.game.players.PlayerSaving;
import com.battlenex.game.players.clanchat.ClanChatHandler;
import com.battlenex.game.players.clanchat.Clans;
import com.battlenex.game.settings.Constants;
import com.battlenex.game.shops.ShopManager;
import com.battlenex.net.ConnectionHandler;
import com.battlenex.net.ConnectionThrottleFilter;
import com.battlenex.pulse.PulseManager;
import com.battlenex.utils.Jarvis;
import com.battlenex.utils.SimpleTimer;
import com.battlenex.world.PlayerManager;

public class Server {

	public static final boolean SOUND = true;

	public static boolean sleeping;
	public static final int cycleRate;
	public static boolean UpdateServer = false;
	public static long lastMassSave = System.currentTimeMillis();
	private static IoAcceptor acceptor;
	private static ConnectionHandler connectionHandler;
	private static ConnectionThrottleFilter throttleFilter;
	private static SimpleTimer engineTimer, debugTimer;
	private static long cycleTime, cycles, totalCycleTime, sleepTime;
	private static DecimalFormat debugPercentFormat;
	public static boolean shutdownServer = false;
	public static int garbageCollectDelay = 40;
	public static boolean shutdownClientHandler;
	public static int serverlistenerPort;
	public static ItemHandler itemHandler = new ItemHandler();
	public static PlayerHandler playerHandler = new PlayerHandler();
	public static NPCHandler npcHandler = new NPCHandler();
	public static ShopManager shopHandler = new ShopManager();
	public static ObjectHandler objectHandler = new ObjectHandler();
	public static ObjectManager objectManager = new ObjectManager();
	public static CastleWars castleWars = new CastleWars();
	public static FightPits fightPits = new FightPits();
	public static PestControl pestControl = new PestControl();
	public static NPCDrops npcDrops = new NPCDrops();
	public static ClanChatHandler clanChat = new ClanChatHandler();
	public static FightCaves fightCaves = new FightCaves();
	public static StaffPanel panel = new StaffPanel(Constants.CONTROL_PANEL);
	private static CycleEventContainer eventContainer = new CycleEventContainer();
	public static PlayerManager playerManager = null;
	public static Clans clans = new Clans();

	/**
	 * Data.
	 */
	private static final File dataRepository = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "battlenex/beta" + System.getProperty("file.separator") + "server" + System.getProperty("file.separator") + "data");
	private static final String configuration = "http://cs042.battle-soul.com/priv/website_configs/";

	static {
		if (!Constants.SERVER_DEBUG) {
			serverlistenerPort = 43594;
		} else {
			serverlistenerPort = 43594;
		}
		cycleRate = 600;
		shutdownServer = false;
		engineTimer = new SimpleTimer();
		debugTimer = new SimpleTimer();
		sleepTime = 0;
		debugPercentFormat = new DecimalFormat("0.0#%");
	}

	public static void main(java.lang.String args[])
			throws NullPointerException, IOException {

		/**
		 * Sends the greeting of Jarvis.
		 */
		Jarvis.init();
		
		System.setOut(new Jarvis(System.out));
		System.setErr(new Jarvis(System.err));			

		acceptor = new SocketAcceptor();
		connectionHandler = new ConnectionHandler();
		SocketAcceptorConfig sac = new SocketAcceptorConfig();
		sac.getSessionConfig().setTcpNoDelay(false);
		sac.setReuseAddress(true);
		sac.setBacklog(100);
		throttleFilter = new ConnectionThrottleFilter(Constants.CONNECTION_DELAY);
		sac.getFilterChain().addFirst("throttleFilter", throttleFilter);
		acceptor.bind(new InetSocketAddress(serverlistenerPort), connectionHandler, sac);

		Initializer.loadClasses();

		try {
			while (!Server.shutdownServer) {
				if (sleepTime >= 0)
					Thread.sleep(sleepTime);
				else
					Thread.sleep(600);
				Initializer.processClasses();
				engineTimer.reset();
				cycleTime = engineTimer.elapsed();
				sleepTime = cycleRate - cycleTime;
				totalCycleTime += cycleTime;
				cycles++;
				debug();
				garbageCollectDelay--;
				if (garbageCollectDelay == 0) {
					garbageCollectDelay = 40;
					System.gc();
				}
				if (System.currentTimeMillis() - lastMassSave > 300000) {
					for (Player p : PlayerHandler.players) {
						if (p == null)
							continue;
						PlayerSave.saveGame((Client) p);
						System.out.println("Saved game for " + p.playerName
								+ ".");
						lastMassSave = System.currentTimeMillis();
					}

				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("A fatal exception has been thrown!");
			for (Player p : PlayerHandler.players) {
				if (p == null)
					continue;
				PlayerSave.saveGame((Client) p);
				System.out.println(p.playerName + " has been saved into the database.");
			}
		}
		acceptor = null;
		connectionHandler = null;
		sac = null;
		System.exit(0);
	}
	
	public static File getDataRepository() {
		return Server.dataRepository;
	}
	
	public static CycleEventContainer getEventContainer() {
		return Server.eventContainer;
	}
	
	public static String getConfiguration() {
		return Server.configuration;
	}

	public static void processAllPackets() {
		for (int j = 0; j < PlayerHandler.players.length; j++) {
			if (PlayerHandler.players[j] != null) {
				while (PlayerHandler.players[j].processQueuedPackets())
					;
			}
		}
	}
	
	/**
	 * Membership
	 */
	
	private static Calendar calendar = new GregorianCalendar();

	public static Calendar getCalendar() {
		return calendar;
	}

	public static boolean playerExecuted = false;
	public static boolean dedi;

	public static void debug() {
		if (debugTimer.elapsed() > 360 * 1000 || playerExecuted) {
			long averageCycleTime = totalCycleTime / cycles;
			System.out
					.println("Average Cycle Time: " + averageCycleTime + "ms");
			double engineLoad = ((double) averageCycleTime / (double) cycleRate);
			System.out
					.println("Players online: " + PlayerHandler.playerCount
							+ ", engine load: "
							+ debugPercentFormat.format(engineLoad));
			//Uses the system's cycle to yell the question.
			TriviaBot.askQuestion();
			totalCycleTime = 0;
			cycles = 0;
			System.gc();
			System.runFinalization();
			debugTimer.reset();
			playerExecuted = false;
		}
	}

	public static long getSleepTimer() {
		return sleepTime;
	}

}
