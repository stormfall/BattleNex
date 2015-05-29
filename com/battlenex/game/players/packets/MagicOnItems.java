package com.battlenex.game.players.packets;

import com.battlenex.game.Client;
import com.battlenex.game.players.PacketType;

/**
 * Magic on items
 **/
public class MagicOnItems implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		int slot = c.getInStream().readSignedWord();
		int itemId = c.getInStream().readSignedWordA();
		c.getInStream().readSignedWord();
		int spellId = c.getInStream().readSignedWordA();

		c.usingMagic = true;
		c.getPA().magicOnItems(slot, itemId, spellId);
		c.usingMagic = false;

	}

}
