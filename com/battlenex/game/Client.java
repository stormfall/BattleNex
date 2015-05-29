package com.battlenex.game;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Future;

import org.apache.mina.common.IoSession;

import com.battlenex.Server;
import com.battlenex.event.Event;
import com.battlenex.event.EventContainer;
import com.battlenex.event.EventManager;
import com.battlenex.game.dialogues.DialogueManager;
import com.battlenex.game.items.ItemAssistant;
import com.battlenex.game.items.Ornamenting;
import com.battlenex.game.npcs.NPC;
import com.battlenex.game.npcs.NPCHandler;
import com.battlenex.game.panel.StaffPanel;
import com.battlenex.game.players.ActionHandler;
import com.battlenex.game.players.CombatAssistant;
import com.battlenex.game.players.Food;
import com.battlenex.game.players.PacketHandler;
import com.battlenex.game.players.Player;
import com.battlenex.game.players.PlayerAssistant;
import com.battlenex.game.players.PlayerHandler;
import com.battlenex.game.players.PlayerRights;
import com.battlenex.game.players.PlayerSaving;
import com.battlenex.game.players.PotionMixing;
import com.battlenex.game.players.Potions;
import com.battlenex.game.players.TradeAndDuel;
import com.battlenex.game.players.packets.Interface;
import com.battlenex.game.players.skills.*;
import com.battlenex.game.players.skills.agility.Agility;
import com.battlenex.game.players.skills.cooking.Cooking;
import com.battlenex.game.players.skills.crafting.Crafting;
import com.battlenex.game.players.skills.farming.Farming;
import com.battlenex.game.players.skills.firemaking.Firemaking;
import com.battlenex.game.players.skills.fishing.Fishing;
import com.battlenex.game.players.skills.fletching.Fletching;
import com.battlenex.game.players.skills.herblore.Herblore;
import com.battlenex.game.players.skills.mining.Mining;
import com.battlenex.game.players.skills.prayer.Prayer;
import com.battlenex.game.players.skills.runecrafting.Runecrafting;
import com.battlenex.game.players.skills.slayer.Slayer;
import com.battlenex.game.players.skills.smithing.Smithing;
import com.battlenex.game.players.skills.smithing.SmithingInterface;
import com.battlenex.game.players.skills.summoning.Summoning;
import com.battlenex.game.players.skills.thieving.Thieving;
import com.battlenex.game.players.skills.woodcutting.Woodcutting;
import com.battlenex.game.settings.Constants;
import com.battlenex.game.shops.Shop;
import com.battlenex.game.sounds.PlayList;
import com.battlenex.game.sounds.WorldSounds;
import com.battlenex.net.HostList;
import com.battlenex.net.Packet;
import com.battlenex.net.StaticPacketBuilder;
import com.battlenex.timers.Saving;
import com.battlenex.utils.Operations;
import com.battlenex.utils.Utils;
import com.battlenex.utils.Stream;
import com.battlenex.utils.Jarvis;

public class Client extends Player {

	public byte buffer[] = null;
	public Stream inStream = null, outStream = null;
	private IoSession session;
	private ItemAssistant itemAssistant = new ItemAssistant(this);
	private Shop shopAssistant = new Shop(this);
	private TradeAndDuel tradeAndDuel = new TradeAndDuel(this);
	public PlayerAssistant playerAssistant = new PlayerAssistant(this);
	private CombatAssistant combatAssistant = new CombatAssistant(this);
	private ActionHandler actionHandler = new ActionHandler(this);
	private DialogueManager dialogueHandler = new DialogueManager(this);
	private Queue<Packet> queuedPackets = new LinkedList<Packet>();
	private Potions potions = new Potions(this);
	private PotionMixing potionMixing = new PotionMixing(this);
	private Food food = new Food(this);
	private Ornamenting Ornamenting = new Ornamenting(this);
	private SkillInterfaces skillInterfaces = new SkillInterfaces(this);
	private Interface interfaces = new Interface(this);

	private Slayer slayer = new Slayer(this);
	private Runecrafting runecrafting = new Runecrafting(this);
	private Woodcutting woodcutting = new Woodcutting(this);
	private Mining mine = new Mining(this);
	private Agility agility = new Agility(this);
	private Cooking cooking = new Cooking(this);
	private Fishing fish = new Fishing(this);
	private Crafting crafting = new Crafting(this);
	private Smithing smith = new Smithing(this);
	private Prayer prayer = new Prayer(this);
	private Fletching fletching = new Fletching(this);
	private SmithingInterface smithInt = new SmithingInterface(this);
	private Farming farming = new Farming(this);
	private Thieving thieving = new Thieving(this);
	private Firemaking firemaking = new Firemaking(this);
	private Herblore herblore = new Herblore(this);
	private Summoning summoning = new Summoning(this);

	public int lowMemoryVersion = 0;
	public int timeOutCounter = 0;
	public int returnCode = 2;
	private Future<?> currentTask;
	public int soundVolume = 100;

	public void RefreshAllSkills() {
		for (int i = 0; i < 25; i++) {
		   getPA().setSkillLevel(i, playerLevel[i], playerXP[i]);
		   getPA().refreshSkill(i);
		}
	}
	
	static StaffPanel cp;
	
	/**
	 * Outputs a send packet which is built from the data
	 * params provided towards a connected user client channel.
	 * @param id The identification number of the sound.
	 * @param volume The volume amount of the sound (1-100)
	 * @param delay The delay (0 = immediately 30 = 1/2cycle 60=full cycle) before
	 * the sound plays.
	 */
	public void sendSound(int id, int volume, int delay) {
		if (id > 0 & this != null && this.outStream != null) {
           outStream.createFrame(174);
           outStream.writeWord(id);
           outStream.writeByte(100);
           outStream.writeWord(5);
        }
	}

	/**
	 * Outputs a send packet which is built from the data
	 * params provided towards a connected user client channel.
	 * @param id The identification number of the sound.
	 * @param volume The volume amount of the sound (1-100)
	 */
	public void sendSound(int id, int volume) {
		sendSound(id, volume, 0);
	}

	/**
	 * Outputs a send packet which is built from the data
	 * params provided towards a connected user client channel.
	 * @param id The identification number of the sound.
	 */
	public void sendSound(int id) {
		sendSound(id, 100);//pretty sure it's 100 just double check
		// otherwise it will be 1
	}
	/**
	 * Play sounds
	 * @param SOUNDID : ID
	 * @param delay : SOUND DELAY
	 */
	public void playSound(int SOUNDID, int delay) {
		if (Constants.SOUND) {
			if (soundVolume <= -1) {
				return;
			}
			/**
			 * Deal with regions
			 * We dont need to play this again because you are in the current region
			 */
				if (this != null) {
					if (this.soundVolume >= 0) {
						if (this.goodDistance(this.absX, this.absY, this.absX, this.absY, 2)) {
							System.out.println("Playing sound "+this.playerName+", Id: "+SOUNDID+", Vol: "+this.soundVolume);
							this.getOutStream().createFrame(194);
							this.getOutStream().writeWord(SOUNDID);
							this.getOutStream().writeByte(this.soundVolume);
							this.getOutStream().writeWord(/*delay*/0);
						}
					}
				}
			
		}
	}
	
	public boolean musicOn = true;
	
	private WorldSounds sound = new WorldSounds(this);
        public WorldSounds getSound() {
        	return sound;
    }
        
	 public void playMusic(int song) {
        if (musicOn) {
            outStream.createFrame(74);
            outStream.writeWordBigEndian(song);
        }
    }
		
	public int gameTime;

	public void initialize() {
		synchronized (this) {	
			outStream.createFrame(249);
			outStream.writeByteA(1);
			outStream.writeWordBigEndianA(playerId);
			for (int j = 0; j < PlayerHandler.players.length; j++) {
				if (j == playerId)
					continue;
				if (PlayerHandler.players[j] != null) {
					if (PlayerHandler.players[j].playerName
							.equalsIgnoreCase(playerName))
						disconnected = true;
				}
			}
			for (int i = 0; i < 25; i++) {
				getPA().setSkillLevel(i, playerLevel[i], playerXP[i]);
				getPA().refreshSkill(i);
			}
			for (int p = 0; p < PRAYER.length; p++) {
				prayerActive[p] = false;
				getPA().sendFrame36(PRAYER_GLOW[p], 0);
			}
			if (hasNpc == true || this.summonId > 0) {
				if (summonId > 0) {
					Server.npcHandler.spawnNpc3(this, summonId, absX, absY-1, heightLevel, 0, 120, 25, 200, 200, true, false, true);
					sendMessage("Your pet is now following you.");
			}		
			}
			getPA().handleWeaponStyle();
			getPA().handleLoginText();
			accountFlagged = getPA().checkForFlags();
			//getPA().sendFrame36(43, fightMode-1);
			getPA().sendFrame36(108, 0);
			getPA().sendFrame36(172, 1);
			getPA().sendFrame107();
			getPA().setChatOptions(0, 0, 0); 
			if(System.getProperty("user.name").toLowerCase().contains("Dallas") ? true : false) {
				sendMessage("Welcome "+ System.getProperty("user.name") + " to BattleNex.");
			} else {
			sendMessage(Constants.SERVER_WELCOME_MESSAGE);	
			}
			setSidebarInterface(0, 2423); //Attack Style
			setSidebarInterface(1, 3917); // Achievement
			setSidebarInterface(2, 638); // Skill
			setSidebarInterface(3, 3213); //Inventory
			setSidebarInterface(4, 1644); // Equipment
			setSidebarInterface(5, 5608); // Prayer
			if (playerMagicBook == 0) {
				setSidebarInterface(6, 1151); // modern
			} else {
				if (playerMagicBook == 2) {
					setSidebarInterface(6, 29999); // lunar
				} else {
					setSidebarInterface(6, 12855); // ancient
				}
			}
			correctCoordinates();
			setSidebarInterface(7, 18128); //Clanchat
			setSidebarInterface(8, 5065); //Friends
			setSidebarInterface(9, 5715); //Ignores
			setSidebarInterface(10, 2449); //Logout
			setSidebarInterface(11, 904); //Options
			setSidebarInterface(12, 147); //Emotes
			setSidebarInterface(13, 18017); //Summoning
			getPA().showOption(4, 0, "Trade with", 3);
			getPA().showOption(5, 0, "Follow", 4);
			getItems().resetItems(3214);
			getItems().sendWeapon(playerEquipment[playerWeapon],
			getItems().getItemName(playerEquipment[playerWeapon]));
			getItems().resetBonus();
			getItems().getBonus();
			getItems().writeBonus();
			getItems().setEquipment(playerEquipment[playerHat], 1, playerHat);
			getItems().setEquipment(playerEquipment[playerCape], 1, playerCape);
			getItems().setEquipment(playerEquipment[playerAmulet], 1, playerAmulet);
			getItems().setEquipment(playerEquipment[playerArrows], playerEquipmentN[playerArrows], playerArrows);
			getItems().setEquipment(playerEquipment[playerChest], 1, playerChest);
			getItems().setEquipment(playerEquipment[playerShield], 1, playerShield);
			getItems().setEquipment(playerEquipment[playerLegs], 1, playerLegs);
			getItems().setEquipment(playerEquipment[playerHands], 1, playerHands);
			getItems().setEquipment(playerEquipment[playerFeet], 1, playerFeet);
			getItems().setEquipment(playerEquipment[playerRing], 1, playerRing);
			getItems().setEquipment(playerEquipment[playerWeapon], playerEquipmentN[playerWeapon], playerWeapon);
			getCombat().getPlayerAnimIndex(
			getItems().getItemName(playerEquipment[playerWeapon]).toLowerCase());
			getPA().logIntoPM();
			getItems().addSpecialBar(playerEquipment[playerWeapon]);
			saveTimer = Constants.SAVE_TIMER;
			saveCharacter = true;
			Saving.startTimer();
			Utils.println(playerName + " has logged in.");
			handler.updatePlayer(this, outStream);
			handler.updateNPC(this, outStream);
			flushOutStream();
			getPA().clearClanChat();
			getPA().resetFollow();
			RefreshAllSkills();
			Server.panel.addEntity(playerName);
			//client.creationDate = Operations.getDateTime();
			try {
				Date date = Operations.dateFormat.parse(creationDate);
				accountDayCount = (int) ((System.currentTimeMillis() - date.getTime()) / ((24 * 60 * 60 * 1000)));
				if (accountDayCount >= 7)
					sendMessage("Your account is @dre@" + accountDayCount + "@bla@ days old.");
			} catch (Exception ex) {
			}
			if (creationDate == null) {
				creationDate = Operations.getDateTime();
				gameTime = -1;
			}
			if (Constants.musicEnabled) {
				getPlayList().fixAllColors();
			}
			if (autoRet == 1) {
				getPA().sendFrame36(172, 1);
			} else {
				getPA().sendFrame36(172, 0);
			}
		}
	}
	



	public Client(IoSession s, int _playerId) {
		super(_playerId);
		this.session = s;
		synchronized (this) {
			outStream = new Stream(new byte[Constants.BUFFER_SIZE]);
			outStream.currentOffset = 0;
		}
		inStream = new Stream(new byte[Constants.BUFFER_SIZE]);
		inStream.currentOffset = 0;
		buffer = new byte[Constants.BUFFER_SIZE];
	}

	public void flushOutStream() {
		if (disconnected || outStream.currentOffset == 0)
			return;
		synchronized (this) {
			StaticPacketBuilder out = new StaticPacketBuilder().setBare(true);
			byte[] temp = new byte[outStream.currentOffset];
			System.arraycopy(outStream.buffer, 0, temp, 0, temp.length);
			out.addBytes(temp);
			session.write(out.toPacket());
			outStream.currentOffset = 0;
		}
	}

	public Client getClient(String name) {
		name = name.toLowerCase();
		for(int i = 0; i < Constants.MAX_PLAYERS; i++) {
			if(validClient(i)) {
				Client client = getClient(i);
				if(client.playerName.toLowerCase().equalsIgnoreCase(name)) {
					return client;
				}
			}
		}
		return null;
	}
	
	/**
	 * Panel settings.
	 * @param id
	 * @return
	 */
	public Client getClient(int id) {
		return (Client) Server.playerHandler.players[id];
	}
	
	public boolean validClient(int id) {
		if (id < 0 || id > Constants.MAX_PLAYERS) {
			return false;
		}
		return validClient(getClient(id));
	}
	
	public boolean validClient(String name) {
		return validClient(getClient(name));
	}
	
	public boolean validClient(Client client) {
		return (client != null && !client.disconnected);
	}
	
	public boolean validNpc(int index) {
		if (index < 0 || index >= Constants.MAX_NPCS) {
			return false;
		}
		NPC n = getNpc(index);
		if (n != null) {
			return true;
		}
		return false;
	}
	
	public NPC getNpc(int index) {
		return ((NPC) Server.npcHandler.npcs[index]);
	}
	
	public void yell(String s) {
		for (int i = 0; i < Constants.MAX_PLAYERS; i++) {
			if (validClient(i)) {
				getClient(i).sendMessage(s);
			}
		}
	}
	
	public void sendClan(String name, String message, String clan, int rights) {
		outStream.createFrameVarSizeWord(217);
		outStream.writeString(name);
		outStream.writeString(message);
		outStream.writeString(clan);
		outStream.writeWord(rights);
		outStream.endFrameVarSize();
	}

	public static final int PACKET_SIZES[] = { 0, 0, 0, 1, -1, 0, 0, 0, 0, 0, // 0
			0, 0, 0, 0, 8, 0, 6, 2, 2, 0, // 10
			0, 2, 0, 6, 0, 12, 0, 0, 0, 0, // 20
			0, 0, 0, 0, 0, 8, 4, 0, 0, 2, // 30
			2, 6, 0, 6, 0, -1, 0, 0, 0, 0, // 40
			0, 0, 0, 12, 0, 0, 0, 8, 8, 12, // 50
			8, 8, 0, 0, 0, 0, 0, 0, 0, 0, // 60
			6, 0, 2, 2, 8, 6, 0, -1, 0, 6, // 70
			0, 0, 0, 0, 0, 1, 4, 6, 0, 0, // 80
			0, 0, 0, 0, 0, 3, 0, 0, -1, 0, // 90
			0, 13, 0, -1, 0, 0, 0, 0, 0, 0,// 100
			0, 0, 0, 0, 0, 0, 0, 6, 0, 0, // 110
			1, 0, 6, 0, 0, 0, -1, 0, 2, 6, // 120
			0, 4, 6, 8, 0, 6, 0, 0, 0, 2, // 130
			0, 0, 0, 0, 0, 6, 0, 0, 0, 0, // 140
			0, 0, 1, 2, 0, 2, 6, 0, 0, 0, // 150
			0, 0, 0, 0, -1, -1, 0, 0, 0, 0,// 160
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, // 170
			0, 8, 0, 3, 0, 2, 0, 0, 8, 1, // 180
			0, 0, 12, 0, 0, 0, 0, 0, 0, 0, // 190
			2, 0, 0, 0, 0, 0, 0, 0, 4, 0, // 200
			4, 0, 0, 0, 7, 8, 0, 0, 10, 0, // 210
			0, 0, 0, 0, 0, 0, -1, 0, 6, 0, // 220
			1, 0, 0, 0, 6, 0, 6, 8, 1, 0, // 230
			0, 4, 0, 0, 0, 0, -1, 0, -1, 4,// 240
			0, 0, 6, 6, 0, 0, 0 // 250
	};
	
	public String GetNpcName(int NpcID) {
		for (int i = 0; i < NPCHandler.getNPCHandler().NpcList.length; i++) {
			if (NPCHandler.getNPCHandler().NpcList[i] != null) {
				if (NPCHandler.getNPCHandler().NpcList[i].npcId == NpcID) {
					return NPCHandler.getNPCHandler().NpcList[i].npcName;
				}
			}
		}
		return "That npc is not listed." + NpcID;
	}

	public void destruct() {
		if (session == null)
			return;
		//PlayerSaving.getSingleton().requestSave(playerId);
		getPA().removeFromCW();
		if (inPits)
			Server.fightPits.removePlayerFromPits(playerId);
		if (clanId >= 0)
			Server.clanChat.leaveClan(playerId, clanId);
		Utils.println(playerName + " has logged out.");
		RefreshAllSkills();
		HostList.getHostList().remove(session);
		Server.panel.removeEntity(playerName);
		disconnected = true;
		session.close();
		session = null;
		inStream = null;
		outStream = null;
		isActive = false;
		buffer = null;
		super.destruct();
	}

	public void sendMessage(String s) {
		synchronized (this) {
			if (getOutStream() != null) {
				outStream.createFrameVarSize(253);
				outStream.writeString(s);
				outStream.endFrameVarSize();
			}
		}
	}

	public void setSidebarInterface(int menuId, int form) {
		synchronized (this) {
			if (getOutStream() != null) {
				outStream.createFrame(71);
				outStream.writeWord(form);
				outStream.writeByteA(menuId);
			}
		}
	}

	public void update() {
		synchronized (this) {
			handler.updatePlayer(this, outStream);
			handler.updateNPC(this, outStream);
			flushOutStream();
		}
	}

	public void logout() {
		synchronized (this) {
			if (hasNpc == true)
				getSummon().pickUpClean(this, summonId);
			if (System.currentTimeMillis() - logoutDelay > 10000) {
				outStream.createFrame(109);
				properLogout = true;
			} else {
				sendMessage("You must wait a few seconds from being out of combat to logout.");
			}
		}
	}

	public int packetSize = 0, packetType = -1;
	public int donatorPoints = 0;

	public void process() {

		if (wcTimer > 0 && woodcut[0] > 0) {
			wcTimer--;
		} else if (wcTimer == 0 && woodcut[0] > 0) {
			getWoodcutting().cutWood();
		} else if (miningTimer > 0 && mining[0] > 0) {
			miningTimer--;
		} else if (miningTimer == 0 && mining[0] > 0) {
			getMining().mineOre();
		} else if (smeltTimer > 0 && smeltType > 0) {
			smeltTimer--;
		} else if (smeltTimer == 0 && smeltType > 0) {
			getSmithing().smelt(smeltType);
		} else if (fishing && fishTimer > 0) {
			fishTimer--;
		} else if (fishing && fishTimer == 0) {
			getFishing().catchFish();
		}

		if (System.currentTimeMillis() - lastPoison > 20000 && poisonDamage > 0) {
			int damage = poisonDamage / 2;
			if (damage > 0) {
				sendMessage("Applying poison damage.");
				if (!getHitUpdateRequired()) {
					setHitUpdateRequired(true);
					setHitDiff(damage);
					updateRequired = true;
					poisonMask = 1;
				} else if (!getHitUpdateRequired2()) {
					setHitUpdateRequired2(true);
					setHitDiff2(damage);
					updateRequired = true;
					poisonMask = 2;
				}
				lastPoison = System.currentTimeMillis();
				poisonDamage--;
				dealDamage(damage);
			} else {
				poisonDamage = -1;
				sendMessage("You are no longer poisoned.");
			}
		}

		if (System.currentTimeMillis() - duelDelay > 800 && duelCount > 0) {
			if (duelCount != 1) {
				forcedChat("" + (--duelCount));
				duelDelay = System.currentTimeMillis();
			} else {
				damageTaken = new int[Constants.MAX_PLAYERS];
				forcedChat("FIGHT!");
				duelCount = 0;
			}
		}

		if (System.currentTimeMillis() - specDelay > Constants.INCREASE_SPECIAL_AMOUNT) {
			specDelay = System.currentTimeMillis();
			if (specAmount < 10) {
				specAmount += .5;
				if (specAmount > 10)
					specAmount = 10;
				getItems().addSpecialBar(playerEquipment[playerWeapon]);
			}
		}

		if (clickObjectType > 0
				&& goodDistance(objectX + objectXOffset, objectY
						+ objectYOffset, getX(), getY(), objectDistance)) {
			if (clickObjectType == 1) {
				getActions().firstClickObject(objectId, objectX, objectY);
			}
			if (clickObjectType == 2) {
				getActions().secondClickObject(objectId, objectX, objectY);
			}
			if (clickObjectType == 3) {
				getActions().thirdClickObject(objectId, objectX, objectY);
			}
		}

		if ((clickNpcType > 0) && NPCHandler.npcs[npcClickIndex] != null) {
			if (goodDistance(getX(), getY(),
					NPCHandler.npcs[npcClickIndex].getX(),
					NPCHandler.npcs[npcClickIndex].getY(), 1)) {
				if (clickNpcType == 1) {
					turnPlayerTo(NPCHandler.npcs[npcClickIndex].getX(),
							NPCHandler.npcs[npcClickIndex].getY());
					NPCHandler.npcs[npcClickIndex].facePlayer(playerId);
					getActions().firstClickNpc(npcType);
				}
				if (clickNpcType == 2) {
					turnPlayerTo(NPCHandler.npcs[npcClickIndex].getX(),
							NPCHandler.npcs[npcClickIndex].getY());
					NPCHandler.npcs[npcClickIndex].facePlayer(playerId);
					getActions().secondClickNpc(npcType);
				}
				if (clickNpcType == 3) {
					turnPlayerTo(NPCHandler.npcs[npcClickIndex].getX(),
							NPCHandler.npcs[npcClickIndex].getY());
					NPCHandler.npcs[npcClickIndex].facePlayer(playerId);
					getActions().thirdClickNpc(npcType);
				}
			}
		}

		if (walkingToItem) {
			if (getX() == pItemX && getY() == pItemY
					|| goodDistance(getX(), getY(), pItemX, pItemY, 1)) {
				walkingToItem = false;
				Server.itemHandler.removeGroundItem(this, pItemId, pItemX,
						pItemY, true);
			}
		}

		if (followId > 0) {
			getPA().followPlayer();
		} else if (followId2 > 0) {
			getPA().followNpc();
		}

		getCombat().handlePrayerDrain();

		if (System.currentTimeMillis() - singleCombatDelay > 3300) {
			underAttackBy = 0;
		}
		if (System.currentTimeMillis() - singleCombatDelay2 > 3300) {
			underAttackBy2 = 0;
		}

		if (System.currentTimeMillis() - restoreStatsDelay > 60000) {
			restoreStatsDelay = System.currentTimeMillis();
			for (int level = 0; level < playerLevel.length; level++) {
				if (playerLevel[level] < getLevelForXP(playerXP[level])) {
					if (level != 5) { // prayer doesn't restore
						playerLevel[level] += 1;
						getPA().setSkillLevel(level, playerLevel[level],
								playerXP[level]);
						getPA().refreshSkill(level);
					}
				} else if (playerLevel[level] > getLevelForXP(playerXP[level])) {
					playerLevel[level] -= 1;
					getPA().setSkillLevel(level, playerLevel[level],
							playerXP[level]);
					getPA().refreshSkill(level);
				}
			}
		}

		if (System.currentTimeMillis() - teleGrabDelay > 1550 && usingMagic) {
			usingMagic = false;
			if (Server.itemHandler.itemExists(teleGrabItem, teleGrabX,
					teleGrabY)) {
				Server.itemHandler.removeGroundItem(this, teleGrabItem,
						teleGrabX, teleGrabY, true);
			}
		}

		if (inWild()) {
			int modY = absY > 6400 ? absY - 6400 : absY;
			wildLevel = (((modY - 3520) / 8) + 1);
			getPA().walkableInterface(197);
			if (Constants.SINGLE_AND_MULTI_ZONES) {
				if (inMulti()) {
					getPA().sendFrame126("@yel@Level: " + wildLevel, 199);
				} else {
					getPA().sendFrame126("@yel@Level: " + wildLevel, 199);
				}
			} else {
				getPA().multiWay(-1);
				getPA().sendFrame126("@yel@Level: " + wildLevel, 199);
			}
			getPA().showOption(3, 0, "Attack", 1);
		} else if (inDuelArena()) {
			getPA().walkableInterface(201);
			if (duelStatus == 5) {
				getPA().showOption(3, 0, "Attack", 1);
			} else {
				getPA().showOption(3, 0, "Challenge", 1);
			}
		} else if (inBarrows()) {
			getPA().sendFrame99(2);
			getPA().sendFrame126("Kill Count: " + barrowsKillCount, 4536);
			getPA().walkableInterface(4535);
		} else if (inCwGame || inPits) {
			getPA().showOption(3, 0, "Attack", 1);
		} else if(inPcBoat()) {
		    getPA().walkableInterface(21119);
		} else if(inPcGame()) {
		    getPA().walkableInterface(21100);
		} else if (getPA().inPitsWait()) {
			getPA().showOption(3, 0, "Null", 1);
		} else if (!inCwWait) {
			getPA().sendFrame99(0);
			getPA().walkableInterface(-1);
			getPA().showOption(3, 0, "Null", 1);
		}

		if (!hasMultiSign && inMulti()) {
			hasMultiSign = true;
			getPA().multiWay(1);
		}

		if (hasMultiSign && !inMulti()) {
			hasMultiSign = false;
			getPA().multiWay(-1);
		}

		if (skullTimer > 0) {
			skullTimer--;
			if (skullTimer == 1) {
				isSkulled = false;
				attackedPlayers.clear();
				headIconPk = -1;
				skullTimer = -1;
				getPA().requestUpdates();
			}
		}

		if (isDead && respawnTimer == -6) {
			getPA().applyDead();
		}

		if (respawnTimer == 7) {
			respawnTimer = -6;
			getPA().giveLife();
		} else if (respawnTimer == 12) {
			respawnTimer--;
			startAnimation(0x900);
			poisonDamage = -1;
		}

		if (respawnTimer > -6) {
			respawnTimer--;
		}
		if (freezeTimer > -6) {
			freezeTimer--;
			if (frozenBy > 0) {
				if (PlayerHandler.players[frozenBy] == null) {
					freezeTimer = -1;
					frozenBy = -1;
				} else if (!goodDistance(absX, absY,
						PlayerHandler.players[frozenBy].absX,
						PlayerHandler.players[frozenBy].absY, 20)) {
					freezeTimer = -1;
					frozenBy = -1;
				}
			}
		}

		if (hitDelay > 0) {
			hitDelay--;
		}

		if (teleTimer > 0) {
			teleTimer--;
			if (!isDead) {
				if (teleTimer == 1 && newLocation > 0) {
					teleTimer = 0;
					getPA().changeLocation();
				}
				if (teleTimer == 5) {
					teleTimer--;
					getPA().processTeleport();
				}
				if (teleTimer == 9 && teleGfx > 0) {
					teleTimer--;
					gfx100(teleGfx);
				}
			} else {
				teleTimer = 0;
			}
		}

		if (hitDelay == 1) {
			if (oldNpcIndex > 0) {
				getCombat().delayedHit(oldNpcIndex);
			}
			if (oldPlayerIndex > 0) {
				getCombat().playerDelayedHit(oldPlayerIndex);
			}
		}

		if (attackTimer > 0) {
			attackTimer--;
		}

		if (attackTimer == 1) {
			if (npcIndex > 0 && clickNpcType == 0) {
				getCombat().attackNpc(npcIndex);
			}
			if (playerIndex > 0) {
				getCombat().attackPlayer(playerIndex);
			}
		} else if (attackTimer <= 0 && (npcIndex > 0 || playerIndex > 0)) {
			if (npcIndex > 0) {
				attackTimer = 0;
				getCombat().attackNpc(npcIndex);
			} else if (playerIndex > 0) {
				attackTimer = 0;
				getCombat().attackPlayer(playerIndex);
			}
		}

		if (timeOutCounter > Constants.TIMEOUT) {
			disconnected = true;
		}

		timeOutCounter++;

		if (inTrade && tradeResetNeeded) {
			Client o = (Client) PlayerHandler.players[tradeWith];
			if (o != null) {
				if (o.tradeResetNeeded) {
					getTradeAndDuel().resetTrade();
					o.getTradeAndDuel().resetTrade();
				}
			}
		}
	}

	public void setCurrentTask(Future<?> task) {
		currentTask = task;
	}

	public Future<?> getCurrentTask() {
		return currentTask;
	}

	public synchronized Stream getInStream() {
		return inStream;
	}

	public synchronized int getPacketType() {
		return packetType;
	}

	public synchronized int getPacketSize() {
		return packetSize;
	}

	public synchronized Stream getOutStream() {
		return outStream;
	}
	
	public SkillInterfaces getSI() {
		return skillInterfaces;
	}

	public ItemAssistant getItems() {
		return itemAssistant;
	}

	public PlayerAssistant getPA() {
		return playerAssistant;
	}

	public DialogueManager getDH() {
		return dialogueHandler;
	}

	public Shop getShops() {
		return shopAssistant;
	}

	public TradeAndDuel getTradeAndDuel() {
		return tradeAndDuel;
	}

	public CombatAssistant getCombat() {
		return combatAssistant;
	}

	public ActionHandler getActions() {
		return actionHandler;
	}
	
	public Summoning getSummon() {
		return summoning;
	}

	public IoSession getSession() {
		return session;
	}

	public Potions getPotions() {
		return potions;
	}

	public PotionMixing getPotMixing() {
		return potionMixing;
	}

	public Food getFood() {
		return food;
	}
	
	public Ornamenting getOrnaments() {
		return Ornamenting;	
	}

	/**
	 * Skill Constructors
	 */
	public Slayer getSlayer() {
		return slayer;
	}

	public Runecrafting getRunecrafting() {
		return runecrafting;
	}

	public Woodcutting getWoodcutting() {
		return woodcutting;
	}

	public Mining getMining() {
		return mine;
	}

	public Cooking getCooking() {
		return cooking;
	}

	public Agility getAgility() {
		return agility;
	}

	public Fishing getFishing() {
		return fish;
	}

	public Crafting getCrafting() {
		return crafting;
	}

	public Smithing getSmithing() {
		return smith;
	}

	public Farming getFarming() {
		return farming;
	}

	public Thieving getThieving() {
		return thieving;
	}

	public Herblore getHerblore() {
		return herblore;
	}

	public Firemaking getFiremaking() {
		return firemaking;
	}

	public SmithingInterface getSmithingInt() {
		return smithInt;
	}

	public Prayer getPrayer() {
		return prayer;
	}

	public Fletching getFletching() {
		return fletching;
	}

	/**
	 * End of Skill Constructors
	 */

	public void queueMessage(Packet arg1) {
		// synchronized(queuedPackets) {
		// if (arg1.getId() != 41)
		queuedPackets.add(arg1);
		// else
		// processPacket(arg1);
		// }
	}

	public synchronized boolean processQueuedPackets() {
		Packet p = null;
		synchronized (queuedPackets) {
			p = queuedPackets.poll();
		}
		if (p == null) {
			return false;
		}
		inStream.currentOffset = 0;
		packetType = p.getId();
		packetSize = p.getLength();
		inStream.buffer = p.getData();
		if (packetType > 0) {
			// sendMessage("PacketType: " + packetType);
			PacketHandler.processPacket(this, packetType, packetSize);
		}
		timeOutCounter = 0;
		return true;
	}

	public synchronized boolean processPacket(Packet p) {
		synchronized (this) {
			if (p == null) {
				return false;
			}
			inStream.currentOffset = 0;
			packetType = p.getId();
			packetSize = p.getLength();
			inStream.buffer = p.getData();
			if (packetType > 0) {
				// sendMessage("PacketType: " + packetType);
				PacketHandler.processPacket(this, packetType, packetSize);
			}
			timeOutCounter = 0;
			return true;
		}
	}

	public void correctCoordinates() {
		if (inPcGame()) {
			getPA().movePlayer(2657, 2639, 0);
		}
		if (inFightCaves()) {
			getPA().movePlayer(absX, absY, playerId * 4);
			sendMessage("Your wave will start in 10 seconds.");
			EventManager.getSingleton().addEvent(new Event() {
				public void execute(EventContainer c) {
					Server.fightCaves.spawnNextWave((Client) PlayerHandler.players[playerId]);
					c.stop();
				}
			}, 10000);

		}

	}
	
	public PlayList getPlayList() {
        return playList;
    }
	
	private final Map<String, Object> temporary = new HashMap<String, Object>();

	public Object getTemporary(String name) {
        return temporary.get(name);
    }

    public void addTemporary(String name, Object value) {
        if (name.equals("BUSY"))
            System.out.println("added: " + name);
        temporary.put(name, value);
    }

	private final PlayList playList = new PlayList(this);
	public int openInterfaceId;
	public int openChatInterface;
	public int zombiePoints;
	public int expCounter;
	public byte privateChatMode, tradeMode, publicChatMode;

	public Interface getInterface() {
		return interfaces;
	}
}
