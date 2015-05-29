package com.battlenex.game.players.packets;

import java.util.Map;
import java.util.HashMap;

public class WalkingCheck
{
	public static void check(){
		tiles.put(0 << 28 | 2604 << 14 | 3099, true);
		tiles.put(0 << 28 | 3096 << 14 | 3502, true);
		
		objects.put(1 | 0 << 28 |2660 << 14 | 2589, true);
	}
		
	public static Map<Integer, Boolean> tiles = new HashMap<Integer, Boolean>();
	public static Map<Integer, Boolean> objects = new HashMap<Integer, Boolean>();
	
}