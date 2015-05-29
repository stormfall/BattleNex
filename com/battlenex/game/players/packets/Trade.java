package com.battlenex.game.players.packets;

import com.battlenex.game.Client;
import com.battlenex.game.players.PacketType;
import com.battlenex.game.settings.Constants;

/**
 * Trading
 */
public class Trade implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		int tradeId = c.getInStream().readSignedWordBigEndian();
		c.getPA().resetFollow();
		if (c.disconnected) {
			c.tradeStatus = 0;
		}
		if (c.arenas()) {
			c.sendMessage("You can't trade inside the arena!");
			return;
		}

		if (c.playerRights == 2 && !Constants.ADMIN_CAN_TRADE) {
			c.sendMessage("Trading as an admin has been disabled.");
			return;
		}
		if (tradeId != c.playerId)
			c.getTradeAndDuel().requestTrade(tradeId);
	}

}
