package com.battlenex.game.items;

import com.battlenex.game.Client;

public class Ornamenting {

	private static Client c;
	
	public Ornamenting(Client c) {
		this.c = c;	
	}

		public static void ornamenting(int itemUsed, int useWith) {

			int[][] ornamenting = {
						{19346, 11335, 19336}, {19350, 14479, 19337}, {19348, 4087, 19338}, {19348, 4585, 19339}, {19352, 1187, 19340},
						{19354, 11335, 19341}, {19358, 14479, 19342}, {19356, 4087, 19343}, {19356, 4585, 19344}, {19360, 1187, 19345}, 
 						{19333,  6585, 19335}
					       };

			for (int i = 0; i < ornamenting.length; i++) {

				if (itemUsed == ((int) ornamenting[i][0]) && useWith == ((int) ornamenting[i][1]) || itemUsed == ((int) ornamenting[i][1]) && useWith == ((int) ornamenting[i][0])) {
				
					c.getItems().deleteItem(itemUsed, 1);
					c.getItems().deleteItem(useWith, 1);
					c.sendMessage("You attach the "+ c.getItems().getItemName(((int) ornamenting[i][0]))+" To the"+ c.getItems().getItemName(((int) ornamenting[i][1]))+".");
					c.sendMessage("You recieve a "+c.getItems().getItemName(((int) ornamenting[i][2]))+".");
					c.getItems().addItem(((int) ornamenting[i][2]),1);

				}
			}
		}


		public static void splitting(int itemId) {

			int[][] splitting = {
						{19346, 11335, 19336}, {19350, 14479, 19337}, {19348, 4087, 19338}, {19348, 4585, 19339}, {19352, 1187, 19340},
						{19354, 11335, 19341}, {19358, 14479, 19342}, {19356, 4087, 19343}, {19356, 4585, 19344}, {19360, 1187, 19345}, 
 						{19333,  6585, 19335}
					       };

			for (int i = 0; i < splitting.length; i++) {
			
				if(itemId == ((int) splitting[i][2])) {
					if (c.getItems().freeSlots() >= 1) {
						c.getItems().deleteItem(itemId, 1);
						c.sendMessage("You split the "+ c.getItems().getItemName(((int) splitting[i][0]))+" from the "+ c.getItems().getItemName(((int) splitting[i][2]))+".");
						c.sendMessage("You recieve a "+c.getItems().getItemName(((int) splitting[i][1]))+" and a "+ c.getItems().getItemName(((int) splitting[i][0]))+".");
						c.getItems().addItem(((int) splitting[i][0]), 1);
						c.getItems().addItem(((int) splitting[i][1]), 1);
					} else {
						c.sendMessage("You Need At Least 1 Free Inventory Space Before Doing This.");
					}

				}
			}
		}
}