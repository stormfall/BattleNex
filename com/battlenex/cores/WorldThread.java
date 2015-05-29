package com.battlenex.cores;

/**
 * 
 * @author thaBoom
 *
 */

public final class WorldThread extends Thread {

	protected WorldThread() {
		setPriority(Thread.MAX_PRIORITY);
		setName("World Thread");
	}
	public static long LAST_CYCLE_CTM;

}
