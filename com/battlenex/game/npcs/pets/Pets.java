package com.battlenex.game.npcs.pets;

import com.battlenex.Server;
import com.battlenex.game.Client;
import com.battlenex.game.npcs.NPCHandler;

public class Pets {

	public void pickUp(Client c, int Type) {
		if (c.inWild()) {
			c.sendMessage("@red@Warning! Leaving your pet in the Wilderness could risk you losing it.");
		}
		if (c.inTrade) {
			c.sendMessage("You can't do this while trading!");
		}
		if (c.inDuel) {
			c.sendMessage("You can't do this while dueling!");
		}
		for (int i = 0; i < NPCHandler.maxNPCs; i++) {
			if (NPCHandler.npcs[i] == null)
					continue;	
			}       
		for (int i = 0; i < NPCHandler.maxNPCs; i++) {
			if (NPCHandler.npcs[i] != null) {
				if (NPCHandler.npcs[i].npcType == Type) {
					if (NPCHandler.npcs[i].spawnedBy == c.playerId && NPCHandler.npcs[i].spawnedBy > 0) {
						NPCHandler.npcs[i].absX = 0;
						NPCHandler.npcs[i].absY = 0;
						NPCHandler.npcs[i] = null;
					break;					
					}
				}
			}			
		}
	}
	
		int[][] Pets = { 
			{3505, 7583}, //Hell Kitten		
			{3506, 7584}, //Lazy Hellcat
			{766, 1560}, //Hell Kitten	
			{3507, 7585}, //Wily hellcat	
			{765, 1559}, //Pet Kitten
			{764, 1558}, //Pet Kitten
			{763, 1557}, //Pet Kitten	
			{762, 1556}, //Pet Kitten	
			{761, 1555}, //Pet Kitten
			{768, 1561}, //Pet Kitten	
			{769, 1562}, //Pet Kitten
			{770, 1563}, //Pet Kitten	
			{771, 1564}, //Pet Kitten	
			{772, 1565}, //Pet Kitten	
			{773, 1566}, //Pet Kitten
			{4000, 12500}, //Prince
			{4001, 12501}, //Ele Jr
			{4002, 12502}, //Bandos
			{4003, 12503}, //Arma
			{4004, 12504}, //Zammy
			{4005, 12505}, //Sara
			{4006, 12506}, //Dag Sup
			{4007, 12507}, //Dag Pri
			{4008, 12508}, //Dag Rex
		};
	
	public void pickUpClean(Client c, int id) {
		for (int i = 0; i < Pets.length; i++)
			if (Pets[i][0] == id)
				c.getItems().addItem(Pets[i][1], 1);
		for (int i = 0; i < NPCHandler.maxNPCs; i++) {
			if (NPCHandler.npcs[i] == null)
				continue;
			if (NPCHandler.npcs[i].npcType == id) {
				NPCHandler.npcs[i].absX = 0;
				NPCHandler.npcs[i].absY = 0;
			}
		}
		c.hasNpc = false;
	}
	
	public void dropPet(Client c, int itemId) { 
			if (!c.hasNpc && c.summonId < 1) {
				c.turnPlayerTo(c.absX, c.absY-1);
				Server.npcHandler.spawnNpc3(c, Server.npcHandler.summonItemId(itemId), c.absX, c.absY-1, c.heightLevel, 0, 120, 25, 200, 200, true, false, true);
				c.getPA().followPlayer();
				c.getItems().deleteItem(itemId, 1);
				c.hasNpc = true;
			} else {
				c.sendMessage("You already have a pet following you.");
				return;
	}
	}
}