package com.battlenex.game.players.packets;

import com.battlenex.game.Client;
import com.battlenex.game.items.UseItem;
import com.battlenex.game.npcs.NPCHandler;
import com.battlenex.game.players.PacketType;

public class ItemOnNpc implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		int itemId = c.getInStream().readSignedWordA();
		int i = c.getInStream().readSignedWordA();
		int slot = c.getInStream().readSignedWordBigEndian();
		int npcId = NPCHandler.npcs[i].npcType;
		if (!c.getItems().playerHasItem(itemId, 1, slot)) {
			return;
		}

		UseItem.ItemonNpc(c, itemId, npcId, slot);
	}
}
