package com.battlenex.game.players.packets;

import com.battlenex.Server;
import com.battlenex.game.Client;
import com.battlenex.game.players.PacketType;
import com.battlenex.game.settings.Constants;

/**
 * Drop Item
 **/
public class DropItem implements PacketType {

	public boolean droppable;

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		int itemId = c.getInStream().readUnsignedWordA();
		c.getInStream().readUnsignedByte();
		c.getInStream().readUnsignedByte();
		int slot = c.getInStream().readUnsignedWordA();
		for (int p : Constants.CAT_ITEMS) {
			if (p == itemId) {
			if(c.hasNpc == true) {
				droppable = false;
				break;
			}
		}
	}
		if(itemId == 1560) {
			if (!c.hasNpc) {
				Server.npcHandler.spawnNpc3(c, Server.npcHandler.summonItemId(itemId), c.absX, c.absY-1, c.heightLevel, 0, 120, 25, 200, 200, true, false, true);
				c.getPA().followPlayer();
				c.getItems().deleteItem(itemId, slot, c.playerItemsN[slot]);
				c.hasNpc = true;
				//c.summonId = 2;
			} else
				return;
		}
		if(itemId == 1559) {
			if (!c.hasNpc) {
				c.sendMessage("You drop your Kitten");
				Server.npcHandler.spawnNpc3(c, Server.npcHandler.summonItemId(itemId), c.absX, c.absY-1, c.heightLevel, 0, 120, 25, 200, 200, true, false, true);
				c.getItems().deleteItem(itemId, slot, c.playerItemsN[slot]);
				c.getPA().followPlayer();
				c.hasNpc = true;
				//c.summonId = 3;
			} else
				return;
		}
		if(itemId == 1558) {
			if (!c.hasNpc) {
				c.sendMessage("You drop your Kitten");
				//c.summonId = 4;
				c.hasNpc = true;
				Server.npcHandler.spawnNpc3(c, Server.npcHandler.summonItemId(itemId), c.absX, c.absY-1, c.heightLevel, 0, 120, 25, 200, 200, true, false, true);
				c.getItems().deleteItem(itemId, slot, c.playerItemsN[slot]);
				c.getPA().followPlayer();
			} else
				return;
		}
		if(itemId == 1557) {
			if (!c.hasNpc) {
				c.hasNpc = true;
				c.sendMessage("You drop your Kitten");
				//c.summonId = 5;
				Server.npcHandler.spawnNpc3(c, Server.npcHandler.summonItemId(itemId), c.absX, c.absY-1, c.heightLevel, 0, 120, 25, 200, 200, true, false, true);
				c.getItems().deleteItem(itemId, slot, c.playerItemsN[slot]);
				c.getPA().followPlayer();
			} else
				return;
		}
		if(itemId == 1556) {
			if (!c.hasNpc) {
				c.hasNpc = true;
				c.sendMessage("You drop your Kitten");
				Server.npcHandler.spawnNpc3(c, Server.npcHandler.summonItemId(itemId), c.absX, c.absY-1, c.heightLevel, 0, 120, 25, 200, 200, true, false, true);
				c.getItems().deleteItem(itemId, slot, c.playerItemsN[slot]);
				c.getPA().followPlayer();
				//c.summonId = 6;
			} else
				return;
		}
		if(itemId == 1555) {
			if (!c.hasNpc) {
				c.hasNpc = true;
				c.sendMessage("You drop your Kitten");
				Server.npcHandler.spawnNpc3(c, Server.npcHandler.summonItemId(itemId), c.absX, c.absY-1, c.heightLevel, 0, 120, 25, 200, 200, true, false, true);
				c.getItems().deleteItem(itemId, slot, c.playerItemsN[slot]);
				c.getPA().followPlayer();
				//c.summonId = 7;
			} else
				return;
		}
		if(itemId == 1561) {
			if (!c.hasNpc) {
				c.hasNpc = true;
				c.sendMessage("You drop your Cat");
				Server.npcHandler.spawnNpc3(c, Server.npcHandler.summonItemId(itemId), c.absX, c.absY-1, c.heightLevel, 0, 120, 25, 200, 200, true, false, true);
				c.getItems().deleteItem(itemId, slot, c.playerItemsN[slot]);
				c.getPA().followPlayer();
				//c.summonId = 8;
			} else
				return;
		}
		if(itemId == 1562) {
			if (!c.hasNpc) {
				c.hasNpc = true;
				c.sendMessage("You drop your Cat");
				//c.summonId = 9;
				Server.npcHandler.spawnNpc3(c, Server.npcHandler.summonItemId(itemId), c.absX, c.absY-1, c.heightLevel, 0, 120, 25, 200, 200, true, false, true);
				c.getItems().deleteItem(itemId, slot, c.playerItemsN[slot]);
				c.getPA().followPlayer();
			} else
				return;
		}
		if(itemId == 1563 && !c.hasNpc) {
			if (!c.hasNpc) {
				c.hasNpc = true;
				c.sendMessage("You drop your Cat");
				Server.npcHandler.spawnNpc3(c, Server.npcHandler.summonItemId(itemId), c.absX, c.absY-1, c.heightLevel, 0, 120, 25, 200, 200, true, false, true);
				c.getItems().deleteItem(itemId, slot, c.playerItemsN[slot]);
				c.getPA().followPlayer();
				//c.summonId = 10;
			} else
				return;
		}
		if(itemId == 1564) {
			if (!c.hasNpc) {
				c.hasNpc = true;
				c.sendMessage("You drop your Cat");
				//c.summonId = 11;
					Server.npcHandler.spawnNpc3(c, Server.npcHandler.summonItemId(itemId), c.absX, c.absY-1, c.heightLevel, 0, 120, 25, 200, 200, true, false, true);
				c.getItems().deleteItem(itemId, slot, c.playerItemsN[slot]);
				c.getPA().followPlayer();
			} else
				return;
		}
		if(itemId == 1565) {
			if (!c.hasNpc) {
				c.hasNpc = true;
				c.sendMessage("You drop your Cat");
				Server.npcHandler.spawnNpc3(c, Server.npcHandler.summonItemId(itemId), c.absX, c.absY-1, c.heightLevel, 0, 120, 25, 200, 200, true, false, true);
				c.getItems().deleteItem(itemId, slot, c.playerItemsN[slot]);
				c.getPA().followPlayer();
				//c.summonId = 12;
			} else
					return;
		}
		if(itemId == 7583) {
			if (!c.hasNpc) {
				c.hasNpc = true;
				c.sendMessage("You drop your Hell Kitten");
				Server.npcHandler.spawnNpc3(c, Server.npcHandler.summonItemId(itemId), c.absX, c.absY-1, c.heightLevel, 0, 120, 25, 200, 200, true, false, true);
				c.getItems().deleteItem(itemId, slot, c.playerItemsN[slot]);
				c.getPA().followPlayer();
				//c.summonId = 12;
			} else
					return;
		}
		if(itemId == 1566) {
			if (!c.hasNpc) {
					c.hasNpc = true;
					c.sendMessage("You drop your Cat");
							Server.npcHandler.spawnNpc3(c, Server.npcHandler.summonItemId(itemId), c.absX, c.absY-1, c.heightLevel, 0, 120, 25, 200, 200, true, false, true);
					c.getItems().deleteItem(itemId, slot, c.playerItemsN[slot]);
					c.getPA().followPlayer();
					//c.summonId = 13;
				} else
					return;
		}
		if(itemId == 7585) {
			if (!c.hasNpc) {
				c.hasNpc = true;
				c.sendMessage("You drop your Hellcat");
				//c.summonId = 14;
				Server.npcHandler.spawnNpc3(c, Server.npcHandler.summonItemId(itemId), c.absX, c.absY-1, c.heightLevel, 0, 120, 25, 200, 200, true, false, true);
				c.getItems().deleteItem(itemId, slot, c.playerItemsN[slot]);
				c.getPA().followPlayer();
			} else
				return;
		}
		if(itemId == 7584) {
			if (!c.hasNpc) {
				c.hasNpc = true;
				c.sendMessage("You drop your Lazy Hellcat");
				//c.summonId = 15;
				Server.npcHandler.spawnNpc3(c, Server.npcHandler.summonItemId(itemId), c.absX, c.absY-1, c.heightLevel, 0, 120, 25, 200, 200, true, false, true);
				c.getItems().deleteItem(itemId, slot, c.playerItemsN[slot]);
				c.getPA().followPlayer();
			} else 
				return;
		}
		if (System.currentTimeMillis() - c.alchDelay < 1800) {
			return;
		}
		if (c.arenas()) {
			c.sendMessage("You can't drop items inside the arena!");
			return;
		}
		if (c.inTrade) {
			c.sendMessage("You can't drop items while trading!");
			return;
		}

		boolean droppable = true;
		for (int i : Constants.UNDROPPABLE_ITEMS) {
			if (i == itemId) {
				droppable = false;
				break;
			}
		}
		if (c.playerItemsN[slot] != 0 && itemId != -1
				&& c.playerItems[slot] == itemId + 1) {
			if (droppable) {
				if (c.underAttackBy > 0) {
					if (c.getShops().getItemShopValue(itemId) > 1000) {
						c.sendMessage("You may not drop items worth more than 1000 while in combat.");
						return;
					}
				}
				Server.itemHandler.createGroundItem(c, itemId, c.getX(),
						c.getY(), c.playerItemsN[slot], c.getId());
				c.getItems().deleteItem(itemId, slot, c.playerItemsN[slot]);
			} else {
				c.sendMessage("This items cannot be dropped.");
			}
		}

	}
}
