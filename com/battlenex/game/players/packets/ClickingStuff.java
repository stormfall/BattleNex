package com.battlenex.game.players.packets;

import com.battlenex.game.Client;
import com.battlenex.game.players.PacketType;
import com.battlenex.game.players.PlayerHandler;
import com.battlenex.utils.Utils;

/**
 * Clicking stuff (interfaces)
 **/
public class ClickingStuff implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		if (c.inTrade) {
			if (!c.acceptedTrade) {
				Utils.println("trade reset");
				c.getTradeAndDuel().declineTrade();
			}
		}

		Client o = (Client) PlayerHandler.players[c.duelingWith];
		if (o != null) {
			if (c.duelStatus >= 1 && c.duelStatus <= 4) {
				c.getTradeAndDuel().declineDuel();
				o.getTradeAndDuel().declineDuel();
			}
		}

		if (c.duelStatus == 6) {
			c.getTradeAndDuel().claimStakedItems();
		}

	}

}
