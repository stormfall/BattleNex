package com.battlenex.pulse;

import java.util.ArrayList;
import java.util.List;


public class PulseManager {

	/**
	 * The instance of this class
	 */
	private static PulseManager instance;

	/**
	 * Returns the instance of this class
	 * 
	 * @return
	 */
	public static PulseManager getSingleton() {
		if (instance == null) {
			instance = new PulseManager();
		}
		return instance;
	}

	/**
	 * Holds all of our events currently being ran
	 */
	private static List<PulseContainer> events;

	/**
	 * Creates a new instance of this class
	 */
	public PulseManager() {
		this.events = new ArrayList<PulseContainer>();
	}

	/**
	 * Add an event to the list
	 * 
	 * @param id
	 * @param owner
	 * @param event
	 * @param cycles
	 */
	public void startPulse(Object owner, PulseEvent event) {
		this.events.add(new PulseContainer(-1, owner, event));
	}

	

	/**
	 * Execute and remove events
	 */
	public static void process() {
		List<PulseContainer> eventsCopy = new ArrayList<PulseContainer>(events);
		List<PulseContainer> remove = new ArrayList<PulseContainer>();
                
		for (PulseContainer c : eventsCopy) {
			if (c != null) {
				if (c.needsExecution() && c.isRunning())
					c.execute();
				if (!c.isRunning()) {
					remove.add(c);
				}
			}
		}
                
		for (PulseContainer c : remove) {
			events.remove(c);
		}
	}

	/**
	 * Returns the amount of events currently running
	 * 
	 * @return amount
	 */
	public int getEventsCount() {
		return this.events.size();
	}

	/**
	 * Stops all events for a specific owner and id
	 * 
	 * @param owner
	 */
	public void stopEvents(Object owner) {
		for (PulseContainer c : events) {
			if (c.getOwner() == owner) {
				c.stop();
			}
		}
	}

	/**
	 * Stops all events for a specific owner and id
	 * 
	 * @param owner
	 * @param id
	 */
	public void stopEvents(Object owner, int id) {
		for (PulseContainer c : events) {
			if (c.getOwner() == owner && id == c.getID()) {
				c.stop();
			}
		}
	}

	/**
	 * Stops all events for a specific owner and id
	 * 
	 * @param id
	 */
	public void stopEvents(int id) {
		for (PulseContainer c : events) {
			if (id == c.getID()) {
				c.stop();
			}
		}
	}
}