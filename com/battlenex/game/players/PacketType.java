package com.battlenex.game.players;

import com.battlenex.game.Client;

public interface PacketType {

	public void processPacket(Client c, int packetType, int packetSize);
}
