package com.battlenex.game.players.packets;

import com.battlenex.game.Client;
import com.battlenex.game.players.PacketType;
import com.battlenex.utils.Utils;


public class ItemClick3 implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		int itemId11 = c.getInStream().readSignedWordBigEndianA();
		int itemId1 = c.getInStream().readSignedWordA();
		int itemId = c.getInStream().readSignedWordA();
		if (!c.getItems().playerHasItem(itemId, 1)) {
			return;
		}

		switch (itemId) {

		case 1712:
			c.getPA().handleGlory(itemId);
			break;

		default:
			if (c.playerRights == 3)
				Utils.println(c.playerName + " - Item3rdOption: " + itemId
						+ " : " + itemId11 + " : " + itemId1);
			break;
		}

	}

}
