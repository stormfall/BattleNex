package com.battlenex.game.content;

public enum ContentControl {

	/**
	 * Content.
	 */
	DUEL_ARENA(),
	FIGHT_PITS(),
	TRADING(),
	STAKING(),
	PEST_CONTROL(),
	WIELDING_ITEMS(),
	PVP(),
	PVN(),
	SHOP_SELLING(),
	SHOP_BUYING(),
	AGILITY(),
	PRAYER(),
	THIEVING(),
	WOODCUTTING(),
	COOKING(),
	CRAFTING(),
	DUNGEONEERING(),
	FARMING(),
	FIREMAKING(),
	FISHING(),
	FLETCHING(),
	HERBLORE(),
	MINING(),
	SLAYER(),
	SMITHING(),
	SUMMONING(),
	CLAN_WARS(),
	LOGIN(),
	CLAN_CHAT();
	
	boolean enabled;
	
	ContentControl(boolean enabled) {
		this.enabled = enabled;
	}
	
	ContentControl() {
		this.enabled = true;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public boolean isDisabled() {
		return !enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
