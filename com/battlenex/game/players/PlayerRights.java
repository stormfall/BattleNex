package com.battlenex.game.players;

import com.battlenex.game.Client;

public enum PlayerRights {

	REGULAR(0, 0, "regular", "", ""),
	HELPER(0, 6, "helper", "<img=5><col=1B6BDB>", "<col=1B6BDB>Helper"),
	MODERATOR(1, 1, "moderator", "<img=0>", "<img=0><col=c0c0c0>Player Moderator"),
	GLOBAL_MODERATOR(1, 2, "global", "<img=1><col=4C824C>", "<img=1><col=5B9D5C>Global Moderator"),
	ADMIN(2, 3, "admin", "<img=2>@yel@<shad=0>", "<img=2>@yel@Administrator"),
	OFFICE_ADMIN(3, 3, "admin", "<img=2><col=F7FF0B><shad=0>", "<img=2><col=F7FF0B>Executive Admin"),
	DEVELOPER(3, 7, "developer", "<img=6><col=9113BF>", "<img=6><col=9113BF>Developer"),
	MANAGER(0, 0, "regular", "", ""),
	CEO(0, 0, "regular", "", "");

	/**
	 * Sets the rights of the player.
	 * @param c
	 * @param name
	 */
	public static void setRights(Client c, String playerName) {
		playerName = playerName.toLowerCase();
		if (playerName.equals("Thee Lion") || playerName.equals("") || playerName.equals("") || playerName.equals("")) {
			c.playerRights = 2;
		}
	}
	
	/**
	 * Returns whether or not the player has exclusive bypass access.
	 * @param player
	 * @return
	 */
	public static boolean isExclusive(Player player) {
		String name = player.playerName.toLowerCase();
		return isExclusive(name);
	}

	/**
	 * Returns whether or not the player has exclusive bypass access.
	 * @param player
	 * @return
	 */
	public static boolean isExclusive(String name) {
		name = name.toLowerCase();
		if (name.startsWith("mod ")) {
			if (name.equals("") || name.equals("") || name.contains("")) {
				return true;
			}
		} else if (name.equals("Thee Lion") || name.equals("") || name.equals("") || name.equals("")) {
			return true;
		}
		return false;
	}

	public static PlayerRights getRights(String title) {
		title = title.toLowerCase();
		for (PlayerRights value : PlayerRights.values()) {
			if (!title.equals(value.getRankName())) {
				continue;
			}
			return value;
		}
		return PlayerRights.REGULAR;
	}

	private final int value;
	private final int clientValue;
	private final String rankName;
	private final String yellName;
	private final String rightClickName;

	PlayerRights(int value, int clientValue, String rankName, String yellName, String rightClickName) {
		this.value = value;
		this.clientValue = clientValue;
		this.rankName = rankName;
		this.yellName = yellName;
		this.rightClickName = rightClickName;
	}

	public int getValue() {
		return value;
	}

	public int getClientValue() {
		return clientValue;
	}


	public String getRankName() {
		return rankName;
	}

	public String getFormattedName() {
		return yellName;
	}

	public String getRightClickName() {
		return rightClickName;
	}
}
