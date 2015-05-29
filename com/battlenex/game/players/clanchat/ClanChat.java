package com.battlenex.game.players.clanchat;

import com.battlenex.Connection;
import com.battlenex.Server;
import com.battlenex.game.Client;
import com.battlenex.game.players.PacketType;
import com.battlenex.game.players.Player;
import com.battlenex.utils.*;

/**
 * Chat
 **/
public class ClanChat implements PacketType {
	
	Player player;

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		if(Connection.isMuted(c)) {
			c.sendMessage("You are muted for breaking a rule.");
			return;
		}
		String textSent = Utils.longToPlayerName2(c.getInStream().readQWord());
		textSent = textSent.replaceAll("_", " ");
		Server.clanChat.handleClanChat(c, textSent);
	}
}
