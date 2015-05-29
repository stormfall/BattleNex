package com.battlenex.game.players.packets;

import com.battlenex.game.Client;
import com.battlenex.game.players.PacketType;
import com.battlenex.game.players.PlayerHandler;
import com.battlenex.game.settings.Constants;

public class ChatOptions implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		c.publicChatMode = (byte) c.getInStream().readUnsignedByte();
		c.privateChatMode = (byte) c.getInStream().readUnsignedByte();
		c.tradeMode = (byte) c.getInStream().readUnsignedByte();

		for (int i = 1; i < Constants.MAX_PLAYERS; i++) {
			if (PlayerHandler.getPlayerHandler().players[i] == null) {
				continue;
			}
			Client p = (Client) PlayerHandler.getPlayerHandler().players[i];
			if (p != null) {
				p.getPA().updatePM(c.playerId);
			}
		}
	}

}
