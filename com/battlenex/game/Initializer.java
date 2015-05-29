package com.battlenex.game;

import com.battlenex.Connection;
import com.battlenex.Server;
import com.battlenex.clip.region.ObjectDef;
import com.battlenex.clip.region.Region;
import com.battlenex.cycle.CycleEventHandler;
import com.battlenex.event.EventManager;
import com.battlenex.game.npcs.NPCSpawns;
import com.battlenex.game.objects.doors.Doors;
import com.battlenex.game.objects.doors.DoubleDoors;
import com.battlenex.game.players.PlayerSaving;
import com.battlenex.game.players.clanchat.Clans;
import com.battlenex.game.players.packets.WalkingCheck;
import com.battlenex.game.settings.Constants;
import com.battlenex.pulse.PulseManager;
import com.battlenex.sql.SQLManager;
import com.battlenex.utils.Jarvis;

public class Initializer {
		
	/**
	 * Instances
	 */
	public static WalkingCheck walkingCheck = new WalkingCheck();

	/**
	 * Name of the server.
	 */
	public static String SERVER_NAME = Constants.SERVER_NAME;
	
	/**
	 * Saving switch.
	 */
	public static boolean SAVING = true;
	
	/**
	 * Sql switch.
	 */
	public static boolean SQL = false;
	
	/**
	 * Stops loading.
	 */
	public static boolean LOAD = true;

	/**
	 * Shortcut.
	 */
	
	/**
	 * Processes classes.
	 */
	public static void processClasses() {
		if(LOAD = true) {
		Server.itemHandler.process();
		Server.playerHandler.process();
		Server.objectManager.process();
		Server.fightPits.process();
		Server.pestControl.process();
		Server.shopHandler.process();
		Server.npcHandler.process();
	    Server.clans.process();
		}
	}
	
	/**
	 * Loads and runs classes.
	 */
	public static void loadClasses() {
	if(LOAD = true) {
		long start = System.currentTimeMillis();
		ObjectDef.loadConfig();
		Doors.getSingleton().load();
	    DoubleDoors.getSingleton().load();
		NPCSpawns.spawnNPCS();
		Region.load();
		EventManager.initialize();
		PulseManager.getSingleton();
		Connection.initialize();
		CycleEventHandler.getInstance();
		Clans.loadClans();
		WalkingCheck.check();
		if(SAVING == true) {
		PlayerSaving.initialize();
		}
		if(SQL == true) {
		SQLManager.createConnection();
		}
		loadText();
		Jarvis.printText(SERVER_NAME + " took " + (System.currentTimeMillis() - start) +"ms to process.");
		}
	}
	
	public static void loadText() {
		Jarvis.printText("Loaded Object Configuration");
		Jarvis.printText("Loaded Doors");
	    Jarvis.printText("Loaded Region");
		Jarvis.printText("Loaded EventManager");
		Jarvis.printText("Loaded PulseManager");
		Jarvis.printText("Loaded Connections");
		Jarvis.printText("Loaded Cycle Events");
		Jarvis.printText("Loaded Saving");
		Jarvis.printText("Loaded SQL Manager");
		Jarvis.printText("Loaded Items");
		Jarvis.printText("Loaded Players");
		Jarvis.printText("Loaded Objects");
		Jarvis.printText("Loaded Fight Pits");
		Jarvis.printText("Loaded Pest Control");
		Jarvis.printText("Loaded Shops");
		Jarvis.printText("Loaded Npcs");

	}
}
