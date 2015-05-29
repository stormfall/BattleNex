package com.battlenex.world;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.battlenex.Server;
import com.battlenex.game.Client;
import com.battlenex.utils.Jarvis;

public class PlayerManager {

	private static PlayerManager singleton = null;
	private Map<Integer, Queue<Client> > playersByRegion = new HashMap<Integer, Queue<Client>>();;
	public final int areaSize = 26;
	
	public static PlayerManager getSingleton() {
		if (singleton == null) {
			singleton = new PlayerManager();
		}
		return singleton;
	}

	public void setupRegionPlayers(){
		int hash = 0;
		for(int i = 0; i < 9999; i += areaSize){
			for(int j = 0; j < 12500; j += areaSize){
				int g = ((i /areaSize))+((j / areaSize) * 100);
				Queue<Client> he = new LinkedList<Client>();
				playersByRegion.put(g,he);
				hash++;
			}
		}
		if(!Server.dedi)
			System.out.println(hash+" Regions Created");
	}
	public Queue<Client> getClientRegion(int id) {
		return playersByRegion.get(id);
	}
}
