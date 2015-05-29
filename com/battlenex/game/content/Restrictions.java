package com.battlenex.game.content;

import com.battlenex.game.Client;

public class Restrictions {

	public void setRestrictions(Client c) {
		if (c.inTrade) {
			c.sendMessage("You can't do this while trading!");
			return;
		}
		if (c.inDuel) {
			c.sendMessage("You can't do this while dueling!");
			return;
		}	
		if (c.inWild()) {
			c.sendMessage("You can't do this in the wilderness!");
			return;
		}	
	}
}
