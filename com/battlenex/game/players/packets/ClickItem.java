package com.battlenex.game.players.packets;

import com.battlenex.Server;
import com.battlenex.game.Client;
import com.battlenex.game.players.PacketType;
import com.battlenex.game.players.skills.summoning.SummoningCreature;

/**
 * Clicking an item, bury bone, eat food etc
 **/
public class ClickItem implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		c.getInStream().readSignedWordBigEndianA();
		int itemSlot = c.getInStream().readUnsignedWordA();
		int itemId = c.getInStream().readUnsignedWordBigEndian();
		for (int i = 0; i < SummoningCreature.getLength(); i++) {
			if (itemId == SummoningCreature.getPouchId(i)) {
				Server.npcHandler.summonNpc(c, SummoningCreature.getNpcId(i), c.absX, c.absY - 1, c.heightLevel, 0, 120);
				c.getItems().deleteItem(SummoningCreature.getPouchId(i), 1);
				c.sendMessage("You summon a " + SummoningCreature.getPouchName(i) + ".");
			}
		}
		if (itemId != c.playerItems[itemSlot] - 1) {
			return;
		}
		if (itemId >= 5509 && itemId <= 5514) {
			int pouch = -1;
			int a = itemId;
			if (a == 5509)
				pouch = 0;
			if (a == 5510)
				pouch = 1;
			if (a == 5512)
				pouch = 2;
			if (a == 5514)
				pouch = 3;
			c.getPA().fillPouch(pouch);
			return;
		}
		if (c.getHerblore().isUnidHerb(itemId))
			c.getHerblore().handleHerbClick(itemId);
		if (c.getFood().isFood(itemId))
			c.getFood().eat(itemId, itemSlot);
		// ScriptManager.callFunc("itemClick_"+itemId, c, itemId, itemSlot);
		if (c.getPotions().isPotion(itemId))
			c.getPotions().handlePotion(itemId, itemSlot);
		if (c.getPrayer().IsABone(itemId))
			c.getPrayer().buryBone(itemId, itemSlot);
		if (itemId == 952) {
			if (c.inArea(3553, 3301, 3561, 3294)) {
				c.teleTimer = 3;
				c.newLocation = 1;
			} else if (c.inArea(3550, 3287, 3557, 3278)) {
				c.teleTimer = 3;
				c.newLocation = 2;
			} else if (c.inArea(3561, 3292, 3568, 3285)) {
				c.teleTimer = 3;
				c.newLocation = 3;
			} else if (c.inArea(3570, 3302, 3579, 3293)) {
				c.teleTimer = 3;
				c.newLocation = 4;
			} else if (c.inArea(3571, 3285, 3582, 3278)) {
				c.teleTimer = 3;
				c.newLocation = 5;
			} else if (c.inArea(3562, 3279, 3569, 3273)) {
				c.teleTimer = 3;
				c.newLocation = 6;
			}
		}
	}

}
