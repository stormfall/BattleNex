package com.battlenex.cycle;

import com.battlenex.Server;

public class CycleEventHandler {
	public static CycleEventContainer getInstance() {
		return Server.getEventContainer();
	}
}
