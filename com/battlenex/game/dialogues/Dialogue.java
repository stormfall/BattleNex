package com.battlenex.game.dialogues;

import com.battlenex.game.Client;
import com.battlenex.game.players.PacketType;

public class Dialogue implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {

		if (c.nextChat > 0) {
			c.getDH().sendDialogues(c.nextChat, c.talkingNpc);
		} else {
			c.getDH().sendDialogues(0, -1);
		}

	}

}
