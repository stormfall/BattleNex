package com.battlenex.game.players;

import java.util.ArrayList;

import com.battlenex.Server;
import com.battlenex.game.Client;
import com.battlenex.utils.Jarvis;

public class PlayerSaving implements Runnable {

	private ArrayList<Integer> requests = new ArrayList<Integer>();
	private Thread thread;
	private static PlayerSaving singleton;
	private static long lastGroupSave;
	private static final int SAVE_TIMER = 300000;

	public static PlayerSaving getSingleton() {
		return singleton;
	}

	public static void initialize() {
		singleton = new PlayerSaving();
		singleton.thread = new Thread(singleton);
		singleton.thread.start();
	}

	public synchronized void run() {
		while (true) {
			saveAllPlayers();
			try {
				Thread.sleep(300000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void requestSave(int i) {
		if (!requests.contains(i)) {
			requests.add(i);
			notify();
		}
	}

	public void saveAllPlayers() {
		lastGroupSave = System.currentTimeMillis();
		// requests.clear();
		long start = lastGroupSave;
		for (Player p : PlayerHandler.players) {
			if (p != null)
				PlayerSave.saveGame((Client) p);
			if (System.currentTimeMillis() - start >= (Server.getSleepTimer() - 5)) {
				return;
			}
		}
		System.out.println("The character database has been rebuild and all players have been saved.");
	}

	public void saveRequests() {
		int totalSave = 0;
		for (int id : requests) {
			if (PlayerHandler.players[id] != null) {
				PlayerSave.saveGame((Client) PlayerHandler.players[id]);
				totalSave++;
			}
		}
		System.out.println("Saved a total of: " + totalSave + " games.");
		requests.clear();
	}

	public static boolean saveRequired() {
		return System.currentTimeMillis() - lastGroupSave > SAVE_TIMER;
	}
}