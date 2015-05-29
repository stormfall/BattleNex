package com.battlenex.cycle;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class CycleEventContainer {
	private final List<CycleEvent> cycleEvents = new LinkedList<CycleEvent>();

	public void addEvent(CycleEvent e) {
		cycleEvents.add(e);
	}

	public void addEvent(CycleEvent e, int delay) {
		e.runDelay = delay;
		e.defaultDelay = delay;
		cycleEvents.add(e);
	}

	public void clear() {
		for (CycleEvent event : cycleEvents) {
			event.dispose();
		}
		cycleEvents.clear();
	}

	public void processEvents() {
		Iterator<CycleEvent> iterator = cycleEvents.iterator();
		while (iterator.hasNext()) {
			CycleEvent e = iterator.next();
			e.processEvent();
			if (e.runDelay == 0) {
				e.dispose();
				iterator.remove();
			}
		}
	}
}
