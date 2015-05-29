package com.battlenex.game.dialogues;

import com.battlenex.game.Client;

public class OptionDialogue {
	
	private String[] lines;

	public OptionDialogue(String[] lines) {
		this.lines = lines;
	}

	public void display(Client c) {
		c.getPA().showOptions(c, lines);
	}

	public String[] getLines() {
		return lines;
	}
}
