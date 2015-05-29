package com.battlenex.game.players.skills;

import com.battlenex.game.players.Player;

public class SkillButton {

	public static boolean clicked(int buttonId, Player player) {
		int skillId = getSkillId(buttonId);
		if (skillId == -1) {
			return false;
		}
		if (buttonId >= 22782 && buttonId <= 22806) {
			SkillMenu.openInterface(player, skillId);
			return true;
		}
		return false;
	}

	private static int getSkillId(int buttonId) {
		switch (buttonId) {
			case 22782:
			case 22782 - 50:
				return SkillConstants.ATTACK;
			case 22783:
			case 22783 - 50:
				return SkillConstants.HITPOINTS;
			case 22784:
			case 22784 - 50:
				return SkillConstants.MINING;
			case 22786:
			case 22786 - 50:
				return SkillConstants.STRENGTH;
			case 22787:
			case 22787 - 50:
				return SkillConstants.AGILITY;
			case 22788:
			case 22788 - 50:
				return SkillConstants.SMITHING;
			case 22789:
			case 22789 - 50:
				return SkillConstants.DEFENCE;
			case 22790:
			case 22790 - 50:
				return SkillConstants.HERBLORE;
			case 22791:
			case 22791 - 50:
				return SkillConstants.FISHING;
			case 22792:
			case 22792 - 50:
				return SkillConstants.RANGE;
			case 22793:
			case 22793 - 50:
				return SkillConstants.THIEVING;
			case 22794:
			case 22794 - 50:
				return SkillConstants.COOKING;
			case 22795:
			case 22795 - 50:
				return SkillConstants.PRAYER;
			case 22796:
			case 22796 - 50:
				return SkillConstants.CRAFTING;
			case 22797:
			case 22797 - 50:
				return SkillConstants.FIREMAKING;
			case 22798:
			case 22798 - 50:
				return SkillConstants.MAGIC;
			case 22799:
			case 22799 - 50:
				return SkillConstants.FLETCHING;
			case 22800:
			case 22800 - 50:
				return SkillConstants.WOODCUTTING;
			case 22801:
			case 22801 - 50:
				return SkillConstants.RUNECRAFTING;
			case 22802:
			case 22802 - 50:
				return SkillConstants.SLAYER;
			case 22803:
			case 22803 - 50:
				return SkillConstants.FARMING;
			case 22804:
			case 22804 - 50:
				return SkillConstants.DUNGEONEERING;
			case 22805:
			case 22805 - 50:
				return SkillConstants.SUMMONING;
			case 22806:
			case 22806 - 50:
				return SkillConstants.HUNTER;
			default:
				return -1;
		}
	}

}