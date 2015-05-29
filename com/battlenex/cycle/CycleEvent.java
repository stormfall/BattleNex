package com.battlenex.cycle;

public abstract class CycleEvent {
	public int runDelay;
	public int defaultDelay;
	private int runTimes;
	private boolean repeating;
	private boolean instant;
	
	protected CycleEvent() {
		repeating = true;
		this.runDelay = 1;
		this.defaultDelay = 1;
		this.instant = false;
	}

	protected CycleEvent(int runDelay) {
		repeating = false;
		this.runTimes = 1;
		this.runDelay = runDelay;
		this.defaultDelay = runDelay;
		this.instant = false;
	}

	protected CycleEvent(int runDelay, boolean repeating) {
		this.repeating = repeating;
		this.runDelay = runDelay;
		this.defaultDelay = runDelay;
		this.instant = false;
	}
	
	protected CycleEvent(int runDelay, boolean repeating, boolean instant) {
		this.repeating = repeating;
		this.runDelay = runDelay;
		this.defaultDelay = runDelay;
		this.instant = instant;
	}
	
	protected CycleEvent(int runDelay, int runTimes, boolean repeating, boolean instant) {
		this.repeating = repeating;
		this.runDelay = runDelay;
		this.defaultDelay = runDelay;
		this.instant = instant;
		this.runTimes = runTimes;
	}

	protected CycleEvent(int runDelay, int runTimes) {
		this.runDelay = runDelay;
		this.runTimes = runTimes;
		this.defaultDelay = runDelay;
		this.instant = false;
	}

	public abstract void execute();

	public void processEvent() {
		if(this.instant == true) {
			this.execute();
			this.instant = false;
			return;
		}
		runDelay--;
		if (runDelay == 0) {
			if (repeating || --runTimes > 0) {
				runDelay = defaultDelay;
			}
			this.execute();
		}
	}

	protected void stop() {
		repeating = false;
		runTimes = 0;
		this.dispose();
	}

	public void dispose() {
		
	}

	public void forceStop() {
		repeating = false;
		runTimes = 0;
		runDelay = 0;
		this.dispose();
	}

	public int getRunTimes() {
		return runTimes;
	}
}
