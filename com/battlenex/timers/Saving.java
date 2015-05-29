package com.battlenex.timers;

import com.battlenex.game.Client;
import com.battlenex.game.players.Player;
import com.battlenex.game.players.PlayerSave;
import com.battlenex.game.settings.Constants;

/**
 * 
 * @author thaBoom
 *
 */

public class Saving {
	
	public static Constants Config = new Constants();
	
	static Client c;
	
	/**
	 * Runs the timer.
	 */
	public static void startTimer() {	
			int timer = Config.SAVE_TIMER;
				if (timer == 1) {
					PlayerSave.saveGame(c);
					c.sendMessage("<col=FF0000>Your player has been saved.</col>");
					timer = 250;
				}
				if (timer > 0) {
					timer--;
			}
		}
	
	private transient Player player;

	public Saving(Player player) {
		this.player = player;
	}
}