package com.battlenex.game.players.packets;

import com.battlenex.game.Client;
import com.battlenex.game.players.PacketType;

/**
 * Slient Packet
 **/
public class SilentPacket implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {

	}
}
