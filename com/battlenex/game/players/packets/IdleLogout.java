package com.battlenex.game.players.packets;

import com.battlenex.game.Client;
import com.battlenex.game.players.PacketType;

public class IdleLogout implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		// if (!c.playerName.equalsIgnoreCase("Sanity"))
		// c.logout();
	}
}