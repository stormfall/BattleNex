package com.battlenex.game.players.packets;

import com.battlenex.game.Client;
import com.battlenex.game.players.PacketType;

public class ChangeRegion implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		c.getPA().removeObjects();
		// Server.objectManager.loadObjects(c);
	}

}
