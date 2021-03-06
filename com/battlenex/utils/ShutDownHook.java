package com.battlenex.utils;

import com.battlenex.game.Client;
import com.battlenex.game.players.PlayerHandler;

public class ShutDownHook extends Thread {

	@Override
	public void run() {
		System.out.println("Shutdown thread run.");
		for (int j = 0; j < PlayerHandler.players.length; j++) {
			if (PlayerHandler.players[j] != null) {
				Client c = (Client) PlayerHandler.players[j];
				com.battlenex.game.players.PlayerSave.saveGame(c);
			}
		}
		System.out.println("Shutting down...");
	}

}