package com.battlenex.game;

import com.battlenex.game.players.PacketType;

public class WorldChat implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		c.setChatTextEffects(c.getInStream().readUnsignedByteS());
		c.setChatTextColor(c.getInStream().readUnsignedByteS());
		c.setChatTextSize((byte) (c.packetSize - 2));
		c.inStream.readBytes_reverseA(c.getChatText(), c.getChatTextSize(), 0);
	}
}
