package com.battlenex.game.players.skills.summoning;

public class SummoningCreature {
	
	private static final Object[][] DATA = { 
			{ 6829, 12047, "Spirit wolf", 1 },
			{ 6825, 12043, "Dreadfowl", 4 },
			{ 6841, 12059, "Spirit spider", 10 },
			{ 6806, 12019, "Thorny snail", 13 },
			{ 6796, 12009, "Granite crab", 16 },
			{ 7361, 12808, "Spirit Tz-Kih", 22 },
			{ 6847, 12067, "Albino rat", 23 },
			{ 6871, 12091, "Compost mound", 28 },
			{ 6845, 12065, "Honey badger", 32 },
			{ 6808, 12021, "Beaver", 33 },
			{ 6853, 12073, "Bronze minotaur", 36 },
			{ 6867, 12087, "Bull ant", 40 }, 
			{ 7377, 12816, "Pyrelord", 46 },
			{ 6855, 12075, "Iron minotaur", 46 },
			{ 6794, 12007, "Spirit terrorbird", 52 },
			{ 6857, 12077, "Steel minotaur", 56 }, 
			{ 6991, 12531, "Ibis", 56 },
			{ 7363, 12810, "Spirit graahk", 57 },
			{ 7365, 12812, "Spirit kyatt", 57 },
			{ 6809, 12023, "Karamthulhu overlord", 58 },
			{ 6802, 12015, "Spirit cobra", 63 },
			{ 6859, 12079, "Mithril minotaur", 66 },
			{ 6815, 12031, "War tortoise", 67 }, 
			{ 6813, 12029, "Bunyip", 68 },
			{ 6798, 12011, "Praying mantis", 75 },
			{ 6861, 12081, "Adamant minotaur", 76 },
			{ 6800, 12013, "Giant ent", 78 },
			{ 7355, 12802, "Fire titan", 79 },
			{ 7357, 12804, "Moss titan", 79 },
			{ 7359, 12806, "Ice titan", 79 }, 
			{ 6811, 12025, "Hydra", 80 },
			{ 6804, 12017, "Spirit daggannoth", 83 },
			{ 7341, 12788, "Lava titan", 83 },
			{ 7329, 12776, "Swamp titan", 85 },
			{ 6863, 12083, "Rune minotaur", 86 },
			{ 7339, 12786, "Geyser titan", 89 },
			{ 7375, 12822, "Iron titan", 95 },
			{ 6873, 12093, "Pack Yack", 96 },
			{ 7343, 12790, "Steel titan", 99 },

	};

	public static int getLength() {
		return DATA.length;
	}

	public static int getNpcId(int i) {
		return (Integer) DATA[i][0];
	}

	public static int getPouchId(int i) {
		return (Integer) DATA[i][1];
	}

	public static String getPouchName(int i) {
		return DATA[i][2].toString();
	}

	public static int getLevel(int i) {
		return (Integer) DATA[i][3];
	}

	public static int getScrollId(int i) {
		return (Integer) DATA[i][4];
	}

	public static String getScrollName(int i) {
		return DATA[i][5].toString();
	}
}