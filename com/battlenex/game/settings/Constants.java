package com.battlenex.game.settings;

import com.battlenex.Server;
import com.battlenex.game.Client;
import com.battlenex.game.players.Player;
import com.battlenex.game.players.PlayerAssistant;
import com.battlenex.timers.Saving;
import com.battlenex.utils.Utils;

public class Constants {
	
	/**
	 * Name of the organization.
	 */
	public static String SERVER_NAME = "BattleNex";
	
	/**
	 * Server welcome message.
	 */
	public static String SERVER_WELCOME_MESSAGE = "Welcome to "+SERVER_NAME+".";
	
	/**
	 * Server news message.
	 */
	public static String SERVER_NEWS = "We will be establishing new game updates this upcoming week.";
	
	/**
	 * Message to logout.
	 */
	public static String LOGOUT_MESSAGE = "Click here to logout!";
	
	/**
	 * Message when you die.
	 */
	public static String DEATH_MESSAGE = "Oh dear you are dead!";
	
	/**
	 * The ip of the server.
	 */
	public static final String SERVER_IP = "127.0.0.1";
	
	/**
	 * The port of the server.
	 */
	public static final int SERVER_PORT = 43594;
	
	
	/**
	 * Versions, revisions and access keys.
	 */
	public static final int REVISION = 317, SUB_REVISION = 1;
	public static final int VERSION_ID = 1;
	public static final int CACHE_VERSION = 2;
	public static final int ACCESS_KEY = 82507242;

	/**
	 * Sound switch.
	 */
	public static final boolean SOUND = true;
	
	/**
	 * Music switch.
	 */
	public static boolean musicEnabled = true;
	
	/**
	 * Server backup password.
	 */
	public static String BACKUP_PASSWORD = SERVER_NAME+"_"+CACHE_VERSION+ACCESS_KEY;

	/**
	 * Server debug
	 */
	public static final boolean SERVER_DEBUG = false;
	
	/**
	 * Control panel.
	 */
	public static boolean CONTROL_PANEL = true;
	
	/**
	 * Lock exp.
	 */
	public static boolean LOCK_EXPERIENCE = false;
	
	/**
	 * Minigames.
	 */
	public static boolean MINI_GAMES = true;
	
	/**
	 * Double experience?
	 */
	public static boolean DOUBLE_EXP = true;
	
	/**
	 * Server experience bonus.
	 */
	public static final double SERVER_EXP_BONUS = 1;
	
	/**
	 * Message delaying
	 */
	public static final int MESSAGE_DELAY = 6000;

	/**
	 * Teleblock delay.
	 */
	public static final int TELEBLOCK_DELAY = 20000;
	
	/**
	 * Bank size
	 */
	public static final int BANK_SIZE = 352;

	/**
	 * Connection & client build configuration.
	 */
	public static final int PORT = 43594;
	public static final int CLIENT_BUILD = REVISION;
	
	/**
	 * Start player hp.
	 */
	public static final int START_PLAYER_HITPOINTS = 100;

	/**
	 * Server limits
	 */
	public static final int MAX_PLAYERS = 2500;
	public static final int MAX_NPCS = Server.npcHandler.maxNPCs;
	public static final int MAX_ITEMS = 25000;
	
	/**
	 * Connected ips limit.
	 */
	public static final int IPS_ALLOWED = 3;
	
	/**
	 * World list fixing.
	 */
	public static final boolean WORLD_LIST_FIX = false;
	
	/**
	 * Can admins trade, drop or sell items?
	 */
	public static boolean ADMIN_CAN_TRADE = false; // can admins trade?
	public static boolean ADMIN_DROP_ITEMS = false;
	public static boolean ADMIN_CAN_SELL_ITEMS = false;
	
	/**
	 * Starting and respawn locations of the player.
	 */
	public static final int START_LOCATION_X = 2530;
	public static final int START_LOCATION_Y = 4775;
	public static final int RESPAWN_X = 3087;
	public static final int RESPAWN_Y = 3500;
	public static final int DUELING_RESPAWN_X = 3362;
	public static final int DUELING_RESPAWN_Y = 3263;
	public static final int RANDOM_DUELING_RESPAWN = 5;
	
	/**
	 * No teleport wilderness level.
	 */
	public static final int NO_TELEPORT_WILD_LEVEL = 20; 

	/**
	 * Server timers.
	 */
	public static final int SKULL_TIMER = 1200; 
	public static final int SAVE_TIMER = 120;


	/**
	 * Single/multi zones.
	 */
	public static final boolean SINGLE_AND_MULTI_ZONES = true;
	
	/**
	 * Combat level differences.
	 */
	public static final boolean COMBAT_LEVEL_DIFFERENCE = true;
	
	/**
	 * Item requirements.
	 */
	public static final boolean itemRequirements = true;
	
	/**
	 * Xp rating for combat.
	 */
	public static final int MELEE_EXP_RATE = 1000; // damage * exp rate
	public static final int RANGE_EXP_RATE = 1000;
	public static final int MAGIC_EXP_RATE = 1000;
	
	/**
	 * Xp multipliers for skills.
	 */
	public static final int WOODCUTTING_EXPERIENCE = 10;
	public static final int MINING_EXPERIENCE = 10;
	public static final int SMITHING_EXPERIENCE = 10;
	public static final int FARMING_EXPERIENCE = 10;
	public static final int FIREMAKING_EXPERIENCE = 10;
	public static final int HERBLORE_EXPERIENCE = 10;
	public static final int FISHING_EXPERIENCE = 10;
	public static final int AGILITY_EXPERIENCE = 10;
	public static final int PRAYER_EXPERIENCE = 10;
	public static final int RUNECRAFTING_EXPERIENCE = 10;
	public static final int CRAFTING_EXPERIENCE = 10;
	public static final int THIEVING_EXPERIENCE = 10;
	public static final int SLAYER_EXPERIENCE = 10;
	public static final int COOKING_EXPERIENCE = 10;
	public static final int FLETCHING_EXPERIENCE = 10;
	
	/**
	 * Special attack increase amount.
	 */
	public static final int INCREASE_SPECIAL_AMOUNT = 17500;
	
	/**
	 * Required levels of prayer and magic.
	 */
	public static final boolean PRAYER_POINTS_REQUIRED = true; 
	public static final boolean PRAYER_LEVEL_REQUIRED = true;
	public static final boolean MAGIC_LEVEL_REQUIRED = true;
	
	/**
	 * God spell charge limit.
	 */
	public static final int GOD_SPELL_CHARGE = 300000;
	
	/**
	 * Are magic runes required?
	 */
	public static final boolean RUNES_REQUIRED = true;
	
	/**
	 * Use correct arrows?
	 */
	public static final boolean CORRECT_ARROWS = true; 
	
	/**
	 * Enable Crystal bow degrades?
	 */
	public static final boolean CRYSTAL_BOW_DEGRADES = true;

	/**
	 * NPC constants of the server.
	 */
	public static final int NPC_RANDOM_WALK_DISTANCE = 5;
	public static final int NPC_FOLLOW_DISTANCE = 10;
	public static final int[] UNDEAD_NPCS = { 90, 91, 92, 93, 94, 103, 104, 73,
			74, 75, 76, 77 };
	
	/**
	 * Allow trading or selling?
	 */
	public static final boolean ALLOW_TRADING = true;
	public static final boolean ALLOW_SELLING = true;

	
	/**
	 * Launching settings
	 */
	public static boolean DEBUG;
	public static boolean HOSTED;
	public static boolean ECONOMY;
	
	/**
	 * Graphical User Interface settings
	 */
	public static final String GUI_SIGN = "Funpk GUI";
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public static final int[][] NPC_DROPS = {
		// Men
			{1,526,1,0}, {2,526,1,0}, {3,526,1,0},
		// Bandos Boss
			{2550,995,200000,7}, {2550,11704,1,23}, {2550,11710,1,17}, {2550,11712,1,17}, 
			{2550,11714,1,15}, {2550,11724,1,23}, {2550,11726,1,23}, {2550,11728,1,17},
			{2250,3024,1, 0}, 
		// Armadyl Boss
			{2558,995,200000,7}, {2558,11710,1,17}, {2558,11712,1,17}, {2558,11714,1,17},
			{2558,11702,1,23}, {2558,11718,1,17}, {2558,11720,1,17}, {2558,11722,1,17},
			{2558,3024,1,0},
		// Saradomin Boss
			{2562,995,200000,7}, {2562,11710,1,17}, {2562,11712,1,17}, {2562,11714,1,17},
			{2562,11706,1,23}, {2562,11730,1,23},
		// Zamorak Boss
			{2554,995,200000,7}, {2554,11710,1,16}, {2554,11712,1,14}, {2554,11714,1,14},
			{2554,11708,1,23}, {2554,3024,1,0},
		// Abyssal Demon
			{1615,995,5000,7}, {1615,1333,1,8}, {1615,1247,1,8}, {1615,830,40,9}, {1615,1319,1,8},
			{1615,4587,1,11}, {1615,1079,1,8}, {1615,1147,1,6}, {1615,1149,1,9}, {1615,4151,1,17},
			{1615,592,1,0},
		// Banshee
			{1612,995,5000,9}, {1612,1333,1,10}, {1612,1247,1,8}, {1612,830,20,9}, {1612,592,1,0},
		// Crawing Hand
			{1648,526,1,0}, {1649,526,1,0}, {1650,526,1,0}, {1651,526,1,0}, {1652,526,1,0},
		// Infernal Mage
			{1643,526,1,0}, {1643,4675,1,14}, {1643,555,50,7}, {1643,560,20,8}, {1643,565,20,8},
			{1643,4089,1,9}, {1643,4091,1,13}, {1643,4093,1,13}, {1643,4094,1,14}, {1643,4101,1,14},
			{1643,4103,1,14}, {1643,4111,1,14}, {1643,4113,1,14},
			{1644,526,1,0}, {1644,4675,1,14}, {1644,555,50,7}, {1644,560,20,8}, {1644,565,20,8},
			{1644,4089,1,9}, {1644,4091,1,13}, {1644,4093,1,13}, {1644,4094,1,14}, {1644,4101,1,14},
			{1644,4103,1,14}, {1644,4111,1,14}, {1644,4113,1,14},
			{1645,526,1,0}, {1645,4675,1,14}, {1645,555,50,7}, {1645,560,20,8}, {1645,565,20,8},
			{1645,4089,1,9}, {1645,4091,1,13}, {1645,4093,1,13}, {1645,4094,1,14}, {1645,4101,1,14},
			{1645,4103,1,14}, {1645,4111,1,14}, {1645,4113,1,14},
			{1646,526,1,0}, {1646,4675,1,14}, {1646,555,50,7}, {1646,560,20,8}, {1646,565,20,8},
			{1646,4089,1,9}, {1646,4091,1,13}, {1646,4093,1,13}, {1646,4094,1,14}, {1646,4101,1,14},
			{1646,4103,1,14}, {1646,4111,1,14}, {1646,4113,1,14},
			{1647,526,1,0}, {1647,4675,1,14}, {1647,555,50,7}, {1647,560,20,8}, {1647,565,20,8},
			{1647,4089,1,9}, {1647,4091,1,13}, {1647,4093,1,13}, {1647,4094,1,14}, {1647,4101,1,14},
			{1647,4103,1,14}, {1647,4111,1,14}, {1647,4113,1,14},
		// Bloodveld
			{1619,995,5000,7}, {1619,1333,1,12}, {1619,1247,1,11}, {1619,830,40,12}, {1619,1319,1,14},
			{1619,4587,1,11}, {1619,1079,1,13}, {1619,1147,1,13}, {1619,1149,1,12},
			{1619,592,1,0},
		// DustDevil
			{1624,995,5000,7}, {1624,3140,1,27}, {1624,592,1,0}, {1624,1333,1,9}, {1624,1247,1,10},
		// Gargoyle
			{1610,526,1,0}, {1610,1333,1,9}, {1610,4153,1,14},
			{1611,526,1,0}, {1611,1333,1,9}, {1611,4153,1,14},
		// Nechryeal
			{1613,592,1,0}, {1613,11732,1,15}, {1613,4131,1,13},
		// Dark Beast
			{2783,995,5000,7}, {2783,1333,1,8}, {2783,1247,1,8}, {2783,830,40,9}, {2783,1319,1,8},
			{2783,4587,1,11}, {2783,1079,1,8}, {2783,1147,1,6}, {2783,1149,1,9}, {2783,11235,1,17},
			{2783,11212,5,14},{2783,526,1,0},
		// Green Dragon
			{941,536,1,0}, {941,1754,1,0}, {941,1333,1,9}, {941,1247,1,10}, {941,1319,1,11}, {941,4587,1,12},
		// Blue Dragon
			{55,536,1,0}, {55,1751,1,0}, {55,1333,1,9}, {55,1247,1,10}, {55,1319,1,10}, {55,4597,1,10},
		// Skeleton
			{92,526,1,0}, {92,1247,1,8}, {92,995,5000,7},
		// Magic Axe
			{127,1373,1,9}, {127,1363,1,0},
		// Lesser Demon
			{752,592,1,0}, {752,1333,1,9}, {752,1247,1,7},
		// Baby Blue Dragon
			{52,534,1,0},
		// Black Demon
			{84,592,1,0}, {84,1333,1,8}, {84,1247,1,9}, {84,5698,1,10}, {84,4587,1,10},
		// Hill Giant
			{117,995,5000,9}, {117,1333,1,9}, {117,1247,1,9}, {117,830,40,9}, {117,1319,1,9},
			{117,4587,1,9}, {117,1079,1,9}, {117,1147,1,9}, {117,1149,1,9}, 
			{117,532,1,0},
		// Moss Giant
			{112,995,5000,9}, {112,1333,1,9}, {112,1247,1,9}, {112,830,40,9}, {112,1319,1,9},
			{112,4587,1,9}, {112,1079,1,9}, {112,1147,1,9}, {112,1149,1,9}, 
			{112,532,1,0},
		// Fire Giant
			{110,995,5000,12}, {110,1333,1,13}, {110,1247,1,13}, {110,830,40,14}, {110,1319,1,13},
			{110,4587,1,11}, {110,1079,1,13}, {110,1147,1,10}, {110,1149,1,14}, 
			{110,532,1,0},
		// Elf Warrior
			{1183,526,1,0}, {1183,4212,1,18},
		// Dags
			{2881,536,1,0}, {2882,536,1,0}, {2883,536,1,0},
			{2881,6737,1,18}, {2882,6737,1,18}, {2883,6737,1,18},
		// Chaos Elemental
			{3200,11730,1,24}, {3200,592,0,1},
		// KBD
			{50,536,1,0}, {50,11286,1,23}, {50,11732,1,18}, {50,14484,1,25},
		// Tzhaar
			{2591,6522,20,10}, {2591,6523,1,10}, {2591,6524,1,10}, {2591,6525,1,10}, 
			{2591,6526,1,10}, {2591,6527,1,10}, {2591,6528,1,10}, {2591,6571,1,10},
			{2592,6522,20,10}, {2592,6523,1,10}, {2592,6524,1,10}, {2592,6525,1,10}, 
			{2592,6526,1,10}, {2592,6527,1,10}, {2592,6528,1,10}, {2592,6571,1,10},
			{2593,6522,20,10}, {2593,6523,1,10}, {2593,6524,1,10}, {2593,6525,1,10}, 
			{2593,6526,1,10}, {2593,6527,1,10}, {2593,6528,1,10}, {2593,6571,1,10},
			{2594,6522,20,10}, {2594,6523,1,10}, {2594,6524,1,10}, {2594,6525,1,10}, 
			{2594,6526,1,10}, {2594,6527,1,10}, {2594,6528,1,10}, {2594,6571,1,10},
			{2595,6522,20,10}, {2595,6523,1,10}, {2595,6524,1,10}, {2595,6525,1,10}, 
			{2595,6526,1,10}, {2595,6527,1,10}, {2595,6528,1,10}, {2595,6571,1,10},
			{2596,6522,20,10}, {2596,6523,1,10}, {2596,6524,1,10}, {2596,6525,1,10}, 
			{2596,6526,1,10}, {2596,6527,1,10}, {2596,6528,1,10}, {2596,6571,1,10},
			{2597,6522,20,10}, {2597,6523,1,10}, {2597,6524,1,10}, {2597,6525,1,10}, 
			{2597,6526,1,10}, {2597,6527,1,10}, {2597,6528,1,10}, {2597,6571,1,10},
			{2598,6522,20,10}, {2598,6523,1,10}, {2598,6524,1,10}, {2598,6525,1,10}, 
			{2598,6526,1,10}, {2598,6527,1,10}, {2598,6528,1,10}, {2598,6571,1,10},
			{2599,6522,20,10}, {2599,6523,1,10}, {2599,6524,1,10}, {2599,6525,1,10}, 
			{2599,6526,1,10}, {2599,6527,1,10}, {2599,6528,1,10}, {2599,6571,1,10},
			{2600,6522,20,10}, {2600,6523,1,10}, {2600,6524,1,10}, {2600,6525,1,10}, 
			{2600,6526,1,10}, {2600,6527,1,10}, {2600,6528,1,10}, {2600,6571,1,10},
			{2601,6522,20,10}, {2601,6523,1,10}, {2601,6524,1,10}, {2601,6525,1,10}, 
			{2601,6526,1,10}, {2601,6527,1,10}, {2601,6528,1,10}, {2601,6571,1,10},
			{2602,6522,20,10}, {2602,6523,1,10}, {2602,6524,1,10}, {2602,6525,1,10}, 
			{2602,6526,1,10}, {2602,6527,1,10}, {2602,6528,1,10}, {2602,6571,1,10},
			{2603,6522,20,10}, {2603,6523,1,10}, {2603,6524,1,10}, {2603,6525,1,10}, 
			{2603,6526,1,10}, {2603,6527,1,10}, {2603,6528,1,10}, {2603,6571,1,10},
			{2604,6522,20,10}, {2604,6523,1,10}, {2604,6524,1,10}, {2604,6525,1,10}, 
			{2604,6526,1,10}, {2604,6527,1,10}, {2604,6528,1,10}, {2604,6571,1,10},
			{2605,6522,20,10}, {2605,6523,1,10}, {2605,6524,1,10}, {2605,6525,1,10}, 
			{2605,6526,1,10}, {2605,6527,1,10}, {2605,6528,1,10}, {2605,6571,1,10},
			{2606,6522,20,10}, {2606,6523,1,10}, {2606,6524,1,10}, {2606,6525,1,10}, 
			{2606,6526,1,10}, {2606,6527,1,10}, {2606,6528,1,10}, {2606,6571,1,10},
			{2607,6522,20,10}, {2607,6523,1,10}, {2607,6524,1,10}, {2607,6525,1,10}, 
			{2607,6526,1,10}, {2607,6527,1,10}, {2607,6528,1,10}, {2607,6571,1,10},
			{2608,6522,20,10}, {2608,6523,1,10}, {2608,6524,1,10}, {2608,6525,1,10}, 
			{2608,6526,1,10}, {2608,6527,1,10}, {2608,6528,1,10}, {2608,6571,1,10},
			{2609,6522,20,10}, {2609,6523,1,10}, {2609,6524,1,10}, {2609,6525,1,10}, 
			{2609,6526,1,10}, {2609,6527,1,10}, {2609,6528,1,10}, {2609,6571,1,10},
			{2610,6522,20,10}, {2610,6523,1,10}, {2610,6524,1,10}, {2610,6525,1,10}, 
			{2610,6526,1,10}, {2610,6527,1,10}, {2610,6528,1,10}, {2610,6571,1,10},
			{2611,6522,20,10}, {2611,6523,1,10}, {2611,6524,1,10}, {2611,6525,1,10}, 
			{2611,6526,1,10}, {2611,6527,1,10}, {2611,6528,1,10}, {2611,6571,1,10},
			{2612,6522,20,10}, {2612,6523,1,10}, {2612,6524,1,10}, {2612,6525,1,10}, 
			{2612,6526,1,10}, {2612,6527,1,10}, {2612,6528,1,10}, {2612,6571,1,10},
			{2613,6522,20,10}, {2613,6523,1,10}, {2613,6524,1,10}, {2613,6525,1,10}, 
			{2613,6526,1,10}, {2613,6527,1,10}, {2613,6528,1,10}, {2613,6571,1,10},
			{2614,6522,20,10}, {2614,6523,1,10}, {2614,6524,1,10}, {2614,6525,1,10}, 
			{2614,6526,1,10}, {2614,6527,1,10}, {2614,6528,1,10}, {2614,6571,1,10},
			{2615,6522,20,10}, {2615,6523,1,10}, {2615,6524,1,10}, {2615,6525,1,10}, 
			{2615,6526,1,10}, {2615,6527,1,10}, {2615,6528,1,10}, {2615,6571,1,10},
			{2616,6522,20,10}, {2616,6523,1,10}, {2616,6524,1,10}, {2616,6525,1,10}, 
			{2616,6526,1,10}, {2616,6527,1,10}, {2616,6528,1,10}, {2616,6571,1,10}
		};

	
	
	/**
	 * Teleport Strings
	 */
	
	public static final String VARROCK = "";
	public static final String LUMBY = "";
	public static final String FALADOR = "";
	public static final String CAMELOT = "";
	public static final String ARDOUGNE = "";
	public static final String WATCHTOWER = "";
	public static final String TROLLHEIM = "";
	
	/**
	 * Glory
	 */
	public static final int EDGEVILLE_X = 3087;
	public static final int EDGEVILLE_Y = 3500;
	public static final String EDGEVILLE = "";
	public static final int AL_KHARID_X = 3293;
	public static final int AL_KHARID_Y = 3174;
	public static final String AL_KHARID = "";
	public static final int KARAMJA_X = 3087;
	public static final int KARAMJA_Y = 3500;
	public static final String KARAMJA = "";
	public static final int MAGEBANK_X = 2538;
	public static final int MAGEBANK_Y = 4716;
	public static final String MAGEBANK = "";
	
	/**
	 * Modern
	 */
	public static final int VARROCK_X = 3210, VARROCK_Y = 3424;
	public static final int YANILLE_X = 2569, YANILLE_Y = 3099;
	public static final int DRAYNOR_X = 3093, DRAYNOR_Y = 3244;
	public static final int LUMBRIDGE_X = 3222, LUMBRIDGE_Y = 3218;
	public static final int FALADOR_X = 2964, FALADOR_Y = 3378;
	public static final int CAMELOT_X = 2757, CAMELOT_Y = 3479;
	public static final int ARDOUGNE_X = 2662, ARDOUGNE_Y = 3305;
	public static final int WATCH_TOWER_X = 2547, WATCH_TOWER_Y = 3112;
	public static final int TROLLHEIM_X = 2910, TROLLHEIM_Y = 3612;
	public static final int APE_ATOLL_X = 2754, APE_ATOLL_Y = 2784;

	/**
	 * Ancient
	 */
	public static final int PADDEWWA_X = 3098;
	public static final int PADDEWWA_Y = 9884;
	public static final int SENNTISTEN_X = 3322;
	public static final int SENNTISTEN_Y = 3336;
	public static final int KHARYRLL_X = 3492;
	public static final int KHARYRLL_Y = 3471;
	public static final int LASSAR_X = 3006;
	public static final int LASSAR_Y = 3471;
	public static final int DAREEYAK_X = 3161;
	public static final int DAREEYAK_Y = 3671;
	public static final int CARRALLANGAR_X = 3156;
	public static final int CARRALLANGAR_Y = 3666;
	public static final int ANNAKARL_X = 3288;
	public static final int ANNAKARL_Y = 3886;
	public static final int GHORROCK_X = 2977;
	public static final int GHORROCK_Y = 3873;
		
	/**
	 * Item constants
	 */
	public static final int[] ITEM_SELLABLE = { 3842, 3844, 3840, 8844, 8845,
		8846, 8847, 8848, 8849, 8850, 10551, 6570, 7462, 7461, 7460, 7459,
		7458, 7457, 7456, 7455, 7454, 8839, 8840, 8842, 11663, 11664,
		11665, 10499, 9748, 9754, 9751, 9769, 9757, 9760, 9763, 9802, 9808,
		9784, 9799, 9805, 9781, 9796, 9793, 9775, 9772, 9778, 9787, 9811,
		9766, 9749, 9755, 9752, 9770, 9758, 9761, 9764, 9803, 9809, 9785,
		9800, 9806, 9782, 9797, 9794, 9776, 9773, 9779, 9788, 9812, 9767,
		9747, 9753, 9750, 9768, 9756, 9759, 9762, 9801, 9807, 9783, 9798,
		9804, 9780, 9795, 9792, 9774, 9771, 9777, 9786, 9810, 9765, 995 }; 
	
	public static final int[] ITEM_TRADEABLE = { 3842, 3844, 3840, 8844, 8845,
		8846, 8847, 8848, 8849, 8850, 10551, 6570, 7462, 7461, 7460, 7459,
		7458, 7457, 7456, 7455, 7454, 8839, 8840, 8842, 11663, 11664,
		11665, 10499, 9748, 9754, 9751, 9769, 9757, 9760, 9763, 9802, 9808,
		9784, 9799, 9805, 9781, 9796, 9793, 9775, 9772, 9778, 9787, 9811,
		9766, 9749, 9755, 9752, 9770, 9758, 9761, 9764, 9803, 9809, 9785,
		9800, 9806, 9782, 9797, 9794, 9776, 9773, 9779, 9788, 9812, 9767,
		9747, 9753, 9750, 9768, 9756, 9759, 9762, 9801, 9807, 9783, 9798,
		9804, 9780, 9795, 9792, 9774, 9771, 9777, 9786, 9810, 9765 };
	
	public static final int[] UNDROPPABLE_ITEMS = {};
	
	public static final int[] FUN_WEAPONS = { 2460, 2461, 2462, 2463, 2464,
		2465, 2466, 2467, 2468, 2469, 2470, 2471, 2471, 2473, 2474, 2475,
		2476, 2477 };	
	
	/**
	 * World cycle and buffer size settings.
	 */
	
	public static final int CONNECTION_DELAY = 100;
	public static final int TIMEOUT = 20;
	public static final int CYCLE_TIME = 600;
	public static final int BUFFER_SIZE = 10000;
	
	/**
	 * Slayer tasks.
	 */
	public static final int[][] SLAYER_TASKS = { 
		{ 1, 87, 90, 4, 5 },
		{ 6, 7, 8, 9, 10 },
		{ 11, 12, 13, 14, 15 },
		{ 1, 1, 15, 20, 25 },
		{ 30, 35, 40, 45, 50 },
		{ 60, 75, 80, 85, 90 } };
	
	/**
	 * Quests
	 */
	
	public static final int QUESTS = 183;
	
	/**
	 * Server items limit.
	 */
	public static final int ITEM_LIMIT = MAX_ITEMS;

	/**
	 * Webste Extensions
	 */
	
	public static final String[] WEBSITE_EXTENTIONS = {
		"ti8",	
		"ata",
		"6ia",
		"eco",
		"spawn",
		"staff",
		"free",
		"come",
		"join",
		".arpa",
		".asia",
		".cat",
		".info",
		".int",
		".name",
		".org",
		".coop",
		".biz",
		"no.ip",
		".com",
		".edu",
		".firm",
		".gov",
		".int",
		".mil",
		".mobi",
		".nato",
		".net",
		".nom",
		".org",
		".store", 
		".web", 
		".ac", 
		".edu",
		".ad", //Andorra
		".ae", // United Arab Emirates
		// ".af", //Afghanistan
		".ag", // Antigua and Barbuda
		".ai", // Anguilla
		// ".al", //Albania
		// ".am", //Armenia
		// ".an", //Netherlands Antilles
		".ao", // Angola
		".aq", // Antarctica
		// ".ar", //Argentina
		// ".as", //American Samoa
		// ".at", //Austria
		".au", // Australia
		".aw", // Aruba
		".az", // Azerbaijan
		// ".ba", //Bosnia/Herzegovinia
		// ".bb", //Barbados
		// ".bd", //Bangladesh
		// ".be", //Belgium
		".bf", // Burkina Faso
		".bg", // Bulgaria
		// ".bh", //Bahrain
		".bi", // Burundi
		".bj", // Benin
		".bm", // Bermuda
		".bn", // Brunei Darussalam
		// ".bo", //Bolivia
		".br", // Brazil
		// ".bs", //Bahamas
		".bt", // Bhutan
		".bv", // Bouvet Island
		".bw", // Botswana
		// ".by", //1". Belarus 2". Byelorussia
		".bz", // Belize
		".ca", // Canada
		".cc", // Cocos Islands - Keelings
		".cf", // Central African Republic
		".cg", // Congo
		// ".ch", //Switzerland
		".ci", // Cote D&#226;€™Ivoire, or Ivory Coast
		".ck", // Cook Islands
		".cl", // Chile
		".cm", // Cameroon
		".cn", // China
		".co", // Colombia
		// ".cr", //Costa Rica
		".cs", // Czechoslovakia (former)
		// ".cu", //Cuba
		".cv", // Cape Verde
		".cx", // Christmas Island
		".cy", // Cyprus
		".cz", // Czech Republic
		// ".de", //Germany
		".dj", // Djibouti
		".dk", // Denmark
		".dm", // Dominica
		// ".do", //Dominican Republic
		".dz", // Algeria
		// ".ec", //Ecuador
		// ".ee", //Estonia
		".eg", // Egypt
		// ".eh", //Western Sahara
		// ".er", //Eritrea
		// ".es", //Spain
		".et", // Ethiopia
		".eu", // European Union
		".fi", // Finland
		".fj", // Fiji
		// ".fk", //Falkland Islands/Malvinas
		".fm", // Micronesia
		".fo", // Faroe Islands
		".fr", // France
		".fx", // Metropolitan France
		".ga", // Gabon
		".gb", // Great Britain
		".gd", // Grenada
		// ".ge", //Georgia
		".gf", // French Guiana
		".gh", // Ghana
		".gi", // Gibraltar
		".gl", // Greenland
		".gm", // Gambia
		".gn", // Guinea
		".gp", // Guadeloupe
		".gq", // Equatorial Guinea
		".gr", // Greece
		".gs", // South Georgia and South Sandwich Islands
		".gt", // Guatemala
		".gu", // Guam
		".gw", // Guinea-Bissau
		".gy", // Guyana
		".hk", // Hong Kong
		// ".hm", //Heard and McDonald Islands
		".hn", // Honduras
		".hr", // Croatia/Hrvatska
		".ht", // Haiti
		".hu", // Hungary
		".id", // Indonesia
		// ".ie", //Ireland
		// ".il", //Israel
		// ".in", //India
		".io", // British Indian Ocean Territory
		".iq", // Iraq
		".ir", // Iran
		// ".is", //Iceland
		// ".it", //Italy
		".jm", // Jamaica
		// ".jo", //Jordan
		".jp", // Japan
		".ke", // Kenya
		".kg", // Kyrgyzstan
		".kh", // Cambodia
		".ki", // Kiribati
		".km", // Comoros
		".kn", // Saint Kitts and Nevis
		".kp", // North Korea
		".kr", // South Korea
		".kw", // Kuwait
		".ky", // Cayman Islands
		".kz", // Kazakhstan
		// ".la", //Laos
		".lb", // Lebanon
		".lc", // Saint Lucia
		// ".li", //Liechtenstein
		".lk", // Sri Lanka
		".lr", // Liberia
		".ls", // Lesotho
		".lt", // Lithuania
		".lu", // Luxembourg
		".lv", // Latvia
		".ly", // Libya
		// ".ma", //Morocco
		".mc", // Monaco
		".md", // Moldova
		".mg", // Madagascar
		".mh", // Marshall Islands
		".mk", // Macedonia
		".ml", // Mali
		// ".mm", //Myanmar
		".mn", // Mongolia
		// ".mo", //Macau
		".mp", // Northern Mariana Islands
		".mq", // Martinique
		".mr", // Mauritania
		".ms", // Montserrat
		".mt", // Malta
		// ".mu", //Mauritius
		".mv", // Maldives
		".mw", // Malawi
		".mx", // Mexico
		// ".my", //Malaysia
		".mz", // Mozambique
		// ".na", //Namibia
		".nc", // New Caledonia
		// ".ne", //Niger
		".nf", // Norfolk Island
		".ng", // Nigeria
		// ".ni", //Nicaragua
		".nl", // Netherlands
		// ".no", //Norway
		// ".np", //Nepal
		// ".nr", //Nauru
		".nt", // Neutral Zone
		".nu", // Niue
		".nz", // New Zealand (Aotearoa)
		// ".om", //Oman
		// ".pa", //Panama
		// ".pe", //Peru
		".pf", // French Polynesia
		".pg", // Papua New Guinea
		".ph", // Philippines
		".pk", // Pakistan
		".pl", // Poland
		// ".pm", //St". Pierre and Miquelon
		".pn", // Pitcairn
		".pr", // Puerto Rico
		".pt", // Portugal
		// ".pw", //Palau
		".py", // Paraguay
		".qa", // Qatar
		// ".re", //Reunion
		// ".ro", //Romania
		// ".ru", //Russian Federation
		".rw", // Rwanda
		// ".sa", //Saudi Arabia
		".sb", // Solomon Islands
		".sc", // Seychelles
		".sd", // Sudan
		// ".se", //Sweden
		".sg", // Singapore
		".sh", // Saint Helena
		// ".si", //Slovenia
		".sj", // Svalbard and Jan Mayen Islands
		".sk", // Slovakia
		".sl", // Sierra Leone
		// ".sm", //San Marino
		// ".sn", //Senegal
		// ".so", //Somalia
		// ".sr", //Suriname
		// ".st", //Sao Torme and Principe
		// ".su", //Former USSR
		".sv", // El Salvador
		".sy", // Syria
		".sz", // Swaziland
		".tc", // Turks and Caicos Islands
		".td", // Chad
		".tf", // French Southern Territory
		".tg", // Togo
		// ".th", //Thailand
		".tj", // Tajikistan
		".tk", // Tokelau
		".tm", // Turkmenistan
		".tn", // Tunisia
		// ".to", //Tonga
		".tp", // East Timor
		".tr", // Turkey
		".tt", // Trinidad and Tobago
		".tv", // Tuvalu
		".tw", // Taiwan
		".tz", // Tanzania
		".ua", // Ukraine
		// ".ug", //Uganda
		".uk", // United Kingdom
		// ".um", //U".S". Minor Outlying Islands
		".us", // United States
		".uy", // Uruguay
		".uz", // Uzbekistan
		// ".va", //Vatican City State
		".vc", // Saint Vincent and the Grenadines
		".ve", // Venezuela
		".vg", // British Virgin Islands
		// ".vi", //U".S". Virgin Islands
		".vn", // Viet Nam
		// ".vu", //Vanuatu
		".wf", // Wallis and Futuna Islands
		".ws", // Samoa
		// ".ye", //Yemen
		".yt", // Mayotte
		// ".yu", //Yugoslavia
		".za", // South Africa
		".zm", // Zambia
		".zr", // Zaire
		".zw", // Zimbabwe
	};


	public static final long WORLD_CYCLE_TIME = 0;
	
	/**
	 * Free domains
	 */

	public static String[] FREE_DOMAINS = {
		"ooowebhost", "2ip.jp", "ata.jp", "about.gs", "about.tc", "aboutus.gs", "aboutus.ms", "aboutus.tc", "aboutus.vg", "about.vg", "band.io", "beijing.am", "biografi.biz", "biografi.info",
		"biografi.org", "biografi.us", "blogs.io", "boke.am", "church.io", "clan.io", "clubs.io", "consensus.jp", "datadiri.biz", "datadiri.cc", "datadiri.com", "datadiri.info", "datadiri.net",
		"datadiri.org", "datadiri.tv", "datadiri.us", "desyo.jp", "dif.jp", "ecv.gs", "ecv.ms", "ecv.tc", "ecv.vg", "eprofile.us", "faith.io", "fans.io", "food.io", "freekong.cn", "go2net.ws",
		"groups.io", "hello.cn.com", "hello.io", "hits.io", "hostingweb.us", "hub.io", "ide.am", "inc.io", "incn.in", "indo.bz", "indo.cc", "indo.gs", "indo.ms", "indo.tc", "indo.vg",
		"infinitehosting.net", "infinites.net", "invited.at", "jushige.cn", "jushige.com", "kids.io", "kongjian.in", "lan.io", "learn.ac", "learn.io", "llc.nu", "maimai.in", "max.io",
		"musician.io", "mycv.bz", "mycv.nu", "mycv.tv", "myfam.io", "myweb.io", "ourprofile.biz", "ourprofile.info", "ourprofile.net", "ourprofile.org", "ourprofile.us", "pastels.jp",
		"powerbJarvis.jp", "profil.bz", "profil.cc", "profil.cn", "profil.gs", "profil.in", "profil.ms", "profil.tc", "profil.tv", "profil.vg", "qiye.in", "registered.md", "site.io", "tips.io",
		"trips.io", "vippers.jp", "wan.io", "web-cam.ws", "webpages.jp", "webs.io", "xixu.cc", "zaici.am", "zip.io", "zuzhi.in", ".tk", "co.nr", "tiny.cc", "tinyurl.com", "url2cut.com",
		"tinyurl.co.uk", "9f.com", "7p.com", "4t.com", "8m.com", "8m.net", "8k.com", "s5.com", "itgo.com", "iwarp.com", "4mg.com", "gq.nu", "faithweb.com", "tvheaven.com", "freehosting.net",
		"htmlplanet.com", "scriptmania.com", "uni.cc", "afraid.org", "fadlan.com", "c-o.in", "c-o.cc", "coz.in", "cq.bz", "net.tc", "eu.tc", "us.tc", "pro.tc", "de.tc", "at.tc", "co.at.tc",
		"it.tc", "es.tc", "ru.tc", "se.tc", "dk.tc", "be.tc", "no.tc", "int.tc", "pl.tc", "bg.tc", "cz.tc", "mx.tc", "br.tc", "hk.tc", "kr.tc", "th.tc", "ph.tc", "net.tf", "eu.tf", "us.tf",
		"int.tf", "ca.tf", "de.tf", "at.tf", "ch.tf", "edu.tf", "ru.tf", "pl.tf", "cz.tf", "bg.tf", "sg.tf", "waaa.ws", "net.ms", "us.ms", "info.ms", "shop.ms", "au.ms", "de.ms", "fr.ms",
		"br.ms", "cn.ms", "hk.ms", "CY.eu.org", "GR.eu.org", "IL.eu.org", "NL.eu.org", "PT.eu.org", "DK.eu.org", "IE.eu.org", "co.cc", "DNIC.ORG",
	};
	
	/**
	 * Blocked terms
	 */
	
	public static String[] BLOCKED_TERMS = {
		"soulveng", "insanepk", ".net", ".n3t", "alljoin", "everyonejoin", "sickpvp", "websiteblock9", "inception", "funchaotic", "rsmoney", "gold4", "gold4", "gold4ss", "rsacc", "runescape",
		"rsgold", "rsgp", "jmgold", "goldsales", "freechaotic", "genocide", "insanityx", "torva-x", "t0rvax", "torvax", "doublingmoney", "duping", "dupe", "duped", "pvpmasters", "nrpk", "rsqp",
		"crazed-x", "near-reality", "nearreality", "pkxile", "sophiegirl", "proxy", "nigger", "smfnew", "http", "smfforfree", "joinnow", "jointoday", "pwnxile", "battlescape", "nearreality",
		"legacy", "friendlystaff", "teamviewer", "teamvieuwer", "kanker", "scape", "runescape", "noip", "[admin]", "[mod]", "[moderator]", "[administrator]", "[owner]", "[founder]", "spawnpk"
	};
	
	public static final int[] CAT_ITEMS = {
		1555,1556,1557,1558,1559,1560,1561,1562,1563,1564,1565,7585,7584};

	public static final boolean CLIP_WORLD = true;

	public static final String[] ITEMS_ALWAYS_KEPT_ON_DEATH = { "", "", ""} ;

	/**
	 * An integer needed for the above code.
	 */
	public static final int MAXITEM_AMOUNT = Integer.MAX_VALUE;

	public static final int[] MAP_SIZES = { 104, 120, 136, 168, 72 };

	/**
	 * Developer pc.
	 */
	public static final boolean isDeveloperPC() {
		return System.getProperty("user.name").toLowerCase().contains("Dallas") ? true : false;		
	}
		
	public PlayerAssistant getPA() {
		Client c = null;
		return c.playerAssistant;
	}
	
	public Constants() {
		
	}
}
