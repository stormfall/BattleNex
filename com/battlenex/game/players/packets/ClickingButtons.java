package com.battlenex.game.players.packets;

import com.battlenex.Server;
import com.battlenex.game.Client;
import com.battlenex.game.items.GameItem;
import com.battlenex.game.npcs.NPCHandler;
import com.battlenex.game.players.PacketType;
import com.battlenex.game.players.Player;
import com.battlenex.game.players.PlayerHandler;
import com.battlenex.game.players.skills.summoning.Summoning;
import com.battlenex.game.settings.Constants;
import com.battlenex.utils.Utils;

/**
 * Clicking most buttons
 **/
public class ClickingButtons implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		int actionButtonId = Utils.hexToInt(c.getInStream().buffer, 0,
				packetSize);
		// int actionButtonId = c.getInStream().readShort();
		if (c.isDead)
			return;
		

		//If interface is open,  but the button is not a part of the interface..
		if (c.getInterface().isInterface(c.openInterfaceId) && !Interface.isInterfaceButton(c.openInterfaceId, actionButtonId)) {
			if (c.getInterface().hasMessage(c.openInterfaceId)) {
				c.sendMessage("You can't do that now.");
			}
			return;
		}
		
		//If no interface open, but that button belongs to an interface..
		if (c.openInterfaceId == -1 && Interface.isInterfaceButton(actionButtonId)) {
			if(c.getInterface().hasMessage(c.openInterfaceId))
				c.sendMessage("You can't do that now.");
			return;
		}
		
		//If an interface is open, but the button belongs to other interface..
		if (!c.getInterface().isInterface(c.openInterfaceId) && Interface.isInterfaceButton(actionButtonId)) {
			if(c.getInterface().hasMessage(c.openInterfaceId))
				c.sendMessage("You can't do that now.");
			return;
		}
		
			c.sendMessage(c.playerName + " - actionbutton: " + actionButtonId);
		switch (actionButtonId) {
		case 118098:
			c.getPA().castVeng();
		break;
			
	
		case 1: // xp counter
			switch (actionButtonId) {
			case 0: // reset
				if (c.expCounter == 0) {
					return;
				}
				c.getDH().sendDialogues(62);
				break;
		}
			
		case 82024:
			for (int i = 0; i < c.playerEquipment.length; i++) {
				int itemId = c.playerEquipment[i];
				int itemAmount = c.playerEquipmentN[i];
				c.getItems().removeItem(itemId, i);
				c.getItems().bankItem(itemId, c.getItems().getItemSlot(itemId), itemAmount);
			}
		break;
		
		case 70115: //Summoning - Call follower
		case 19144:
			//Summoning.callFamiliar(c, NPCHandler.npcs[c.familiarIndex]);
		break;
	
		case 70109: //Summoning - Withdraw BoB
		case 19142: //Summoning - Take BoB
		case 10146: //Summoning - Take BoB
			//c.getStorage().withdrawBoB();
		break;
	
		case 19145: //Summoning - Follower details
			c.getPA().sendFrame106(10);
		break;
	
		case 70118: //Summoning - Dismiss familiar
		case 19143:
			//Summoning.dismissFamiliar(c, true, true);
		break;
	
		case 70112: //Summoning - Renew familiar
		case 19141:
			//Summoning.renewFamiliar(c);
		break;

		case 82020:
			for (int i = 0; i < c.playerItems.length; i++) {
				c.getItems().bankItem(c.playerItems[i], i, c.playerItemsN[i]);
			}
			break;
		
		case 150:
			if (c.autoRet == 0)
				c.autoRet = 1;
			else
				c.autoRet = 0;
			break;
			
		case 75010:
				c.getPA().startTeleport(Constants.LUMBRIDGE_X, Constants.LUMBRIDGE_Y, 0, "modern");
			break;
						
		case 9190:
			c.getPA().startTeleport(Constants.VARROCK_X, Constants.VARROCK_Y, 0, "modern");
			break;
		// mining - 3046,9779,0
		// smithing - 3079,9502,0

		// 2nd tele option
		case 9191:
			if (c.dialogueAction == 83) {
				c.getDH().sendDialogues(84, 945);
			}
			if (c.teleAction == 1) {
				// tav dungeon
				c.getPA().spellTeleport(2884, 9798, 0);
			} else if (c.teleAction == 2) {
				// pest control
				c.getPA().spellTeleport(2662, 2650, 0);
			} else if (c.teleAction == 3) {
				// kbd
				c.getPA().spellTeleport(3007, 3849, 0);
			} else if (c.teleAction == 4) {
				// graveyard
				c.getPA().spellTeleport(3164, 3685, 0);
			} else if (c.teleAction == 5) {
				c.getPA().spellTeleport(3079, 9502, 0);
			}
			if (c.dialogueAction == 10) {
				c.getPA().spellTeleport(2796, 4818, 0);
				c.dialogueAction = -1;
			} else if (c.dialogueAction == 11) {
				c.getPA().spellTeleport(2527, 4833, 0);
				c.dialogueAction = -1;
			} else if (c.dialogueAction == 12) {
				c.getPA().spellTeleport(2464, 4834, 0);
				c.dialogueAction = -1;
			}
			break;
		// 3rd tele option

		case 9192:
			if (c.teleAction == 1) {
				// slayer tower
				c.getPA().spellTeleport(3428, 3537, 0);
			} else if (c.teleAction == 2) {
				// tzhaar
				c.getPA().spellTeleport(2444, 5170, 0);
			} else if (c.teleAction == 3) {
				// dag kings
				c.getPA().spellTeleport(2479, 10147, 0);
			} else if (c.teleAction == 4) {
				// 44 portals
				c.getPA().spellTeleport(2975, 3873, 0);
			} else if (c.teleAction == 5) {
				c.getPA().spellTeleport(2813, 3436, 0);
			}
			if (c.dialogueAction == 10) {
				c.getPA().spellTeleport(2713, 4836, 0);
				c.dialogueAction = -1;
			} else if (c.dialogueAction == 11) {
				c.getPA().spellTeleport(2162, 4833, 0);
				c.dialogueAction = -1;
			} else if (c.dialogueAction == 12) {
				c.getPA().spellTeleport(2207, 4836, 0);
				c.dialogueAction = -1;
			}
			break;
		// 4th tele option
		case 9193:
			if (c.teleAction == 1) {
				// brimhaven dungeon
				c.getPA().spellTeleport(2710, 9466, 0);
			} else if (c.teleAction == 2) {
				// duel arena
				c.getPA().spellTeleport(3366, 3266, 0);
			} else if (c.teleAction == 3) {
				// chaos elemental
				c.getPA().spellTeleport(3295, 3921, 0);
			} else if (c.teleAction == 4) {
				// gdz
				c.getPA().spellTeleport(3288, 3886, 0);
			} else if (c.teleAction == 5) {
				c.getPA().spellTeleport(2724, 3484, 0);
				c.sendMessage("For magic logs, try north of the duel arena.");
			}
			if (c.dialogueAction == 10) {
				c.getPA().spellTeleport(2660, 4839, 0);
				c.dialogueAction = -1;
			} else if (c.dialogueAction == 11) {
				// c.getPA().spellTeleport(2527, 4833, 0); astrals here
				c.getRunecrafting().craftRunes(2489);
				c.dialogueAction = -1;
			} else if (c.dialogueAction == 12) {
				// c.getPA().spellTeleport(2464, 4834, 0); bloods here
				c.getRunecrafting().craftRunes(2489);
				c.dialogueAction = -1;
			}
			break;
		// 5th tele option
		case 9194:
			if (c.teleAction == 1) {
				// island
				c.getPA().spellTeleport(2895, 2727, 0);
			} else if (c.teleAction == 2) {
				// last minigame spot
				c.sendMessage("Suggest something for this spot on the forums!");
				c.getPA().closeAllWindows();
			} else if (c.teleAction == 3) {
				// last monster spot
				c.sendMessage("Suggest something for this spot on the forums!");
				c.getPA().closeAllWindows();
			} else if (c.teleAction == 4) {
				// ardy lever
				c.getPA().spellTeleport(2561, 3311, 0);
			} else if (c.teleAction == 5) {
				c.getPA().spellTeleport(2812, 3463, 0);
			}
			if (c.dialogueAction == 10 || c.dialogueAction == 11) {
				c.dialogueId++;
				c.getDH().sendDialogues(c.dialogueId, 0);
			} else if (c.dialogueAction == 12) {
				c.dialogueId = 17;
				c.getDH().sendDialogues(c.dialogueId, 0);
			}
			break;

		case 71074:
			if (c.clanId >= 0) {
				if (Server.clanChat.isOwner(c)) {
					Server.clanChat.sendLootShareMessage(c.clanId, "Lootshare has been toggled to " + (!Server.clanChat.clans[c.clanId].lootshare ? "on" : "off") + " by the clan leader.");
					Server.clanChat.clans[c.clanId].lootshare = !Server.clanChat.clans[c.clanId].lootshare;
				} else
					c.sendMessage("Only the owner of the clan has the power to do that.");
			}
			break;
		case 34185:
		case 34184:
		case 34183:
		case 34182:
		case 34189:
		case 34188:
		case 34187:
		case 34186:
		case 34193:
		case 34192:
		case 34191:
		case 34190:
			if (c.craftingLeather)
				c.getCrafting().handleCraftingClick(actionButtonId);
			if (c.getFletching().fletching)
				c.getFletching().handleFletchingClick(actionButtonId);
			break;

		case 15147:
			if (c.smeltInterface) {
				c.smeltType = 2349;
				c.smeltAmount = 1;
				c.getSmithing().startSmelting(c.smeltType);
			}
			break;

		case 15151:
			if (c.smeltInterface) {
				c.smeltType = 2351;
				c.smeltAmount = 1;
				c.getSmithing().startSmelting(c.smeltType);
			}
			break;

		case 15159:
			if (c.smeltInterface) {
				c.smeltType = 2353;
				c.smeltAmount = 1;
				c.getSmithing().startSmelting(c.smeltType);
			}
			break;

		case 29017:
			if (c.smeltInterface) {
				c.smeltType = 2359;
				c.smeltAmount = 1;
				c.getSmithing().startSmelting(c.smeltType);
			}
			break;

		case 29022:
			if (c.smeltInterface) {
				c.smeltType = 2361;
				c.smeltAmount = 1;
				c.getSmithing().startSmelting(c.smeltType);
			}
			break;

		case 29026:
			if (c.smeltInterface) {
				c.smeltType = 2363;
				c.smeltAmount = 1;
				c.getSmithing().startSmelting(c.smeltType);
			}
			break;
			
		case 83093:
		case 58253:
			c.getPA().showInterface(15106);
			c.getItems().writeBonus();
			break;
			
		case 59004:
			c.getPA().removeAllWindows();
			break;
			
		case 70212:
			if (c.clanId > -1)
				Server.clanChat.leaveClan(c.playerId, c.clanId);
			else
				c.sendMessage("You are not in a clan.");
			break;
		case 62137:
			if (c.clanId >= 0) {
				c.sendMessage("You are already in a clan.");
				break;
			}
			if (c.getOutStream() != null) {
				c.getOutStream().createFrame(187);
				c.flushOutStream();
			}
			break;

		case 9178:
			if (c.usingGlory)
				c.getPA().startTeleport(Constants.EDGEVILLE_X, Constants.EDGEVILLE_Y,
						0, "modern");
			if (c.dialogueAction == 2)
				c.getPA().startTeleport(3428, 3538, 0, "modern");
			if (c.dialogueAction == 3)
				c.getPA().startTeleport(Constants.EDGEVILLE_X, Constants.EDGEVILLE_Y,
						0, "modern");
			if (c.dialogueAction == 4)
				c.getPA().startTeleport(3565, 3314, 0, "modern");
			if (c.dialogueAction == 20) {
				c.getPA().startTeleport(2897, 3618, 4, "modern");
				c.killCount = 0;
			}

			break;

		case 9179:
			if (c.usingGlory)
				c.getPA().startTeleport(Constants.AL_KHARID_X, Constants.AL_KHARID_Y,
						0, "modern");
			if (c.dialogueAction == 2)
				c.getPA().startTeleport(2884, 3395, 0, "modern");
			if (c.dialogueAction == 3)
				c.getPA().startTeleport(3243, 3513, 0, "modern");
			if (c.dialogueAction == 4)
				c.getPA().startTeleport(2444, 5170, 0, "modern");
			if (c.dialogueAction == 20) {
				c.getPA().startTeleport(2897, 3618, 12, "modern");
				c.killCount = 0;
			}
			break;

		case 9180:
			if (c.usingGlory)
				c.getPA().startTeleport(Constants.KARAMJA_X, Constants.KARAMJA_Y, 0,
						"modern");
			if (c.dialogueAction == 2)
				c.getPA().startTeleport(2471, 10137, 0, "modern");
			if (c.dialogueAction == 3)
				c.getPA().startTeleport(3363, 3676, 0, "modern");
			if (c.dialogueAction == 4)
				c.getPA().startTeleport(2659, 2676, 0, "modern");
			if (c.dialogueAction == 20) {
				c.getPA().startTeleport(2897, 3618, 8, "modern");
				c.killCount = 0;
			}
			break;

		case 9181:
			if (c.usingGlory)
				c.getPA().startTeleport(Constants.MAGEBANK_X, Constants.MAGEBANK_Y, 0, "modern");
			if (c.dialogueAction == 2)
				c.getPA().startTeleport(2669, 3714, 0, "modern");
			if (c.dialogueAction == 3)
				c.getPA().startTeleport(2540, 4716, 0, "modern");
			if (c.dialogueAction == 4) {
				c.getPA().startTeleport(3366, 3266, 0, "modern");
				c.sendMessage("Dueling is at your own risk. Good luck...");
			}
			if (c.dialogueAction == 20) {
				c.getPA().startTeleport(3366, 3266, 0, "modern");
				c.killCount = 0;
			}
			break;

		case 1093:
		case 1094:
		case 1097:
			if (c.autocastId > 0) {
				c.getPA().resetAutocast();
			} else {
				if (c.playerMagicBook == 1) {
					if (c.playerEquipment[c.playerWeapon] == 4675)
						c.setSidebarInterface(0, 1689);
					else
						c.sendMessage("You can't autocast ancients without an ancient staff.");
				} else if (c.playerMagicBook == 0) {
					if (c.playerEquipment[c.playerWeapon] == 4170) {
						c.setSidebarInterface(0, 12050);
					} else {
						c.setSidebarInterface(0, 1829);
					}
				}

			}
			break;
				//1st option click
		case 9157:// barrows tele to tunnels
			
			if (c.dialogueAction == 1) {
				int r = 4;
				// int r = Misc.random(3);
				switch (r) {
				case 0:
					c.getPA().movePlayer(3534, 9677, 0);
					break;

				case 1:
					c.getPA().movePlayer(3534, 9712, 0);
					break;

				case 2:
					c.getPA().movePlayer(3568, 9712, 0);
					break;

				case 3:
					c.getPA().movePlayer(3568, 9677, 0);
					break;
				case 4:
					c.getPA().movePlayer(3551, 9694, 0);
					break;
				}
			} else if (c.dialogueAction == 2) {
				c.getPA().movePlayer(2507, 4717, 0);
			} else if (c.dialogueAction == 5) {
				c.getSlayer().giveTask();
			} else if (c.dialogueAction == 6) {
				c.getSlayer().giveTask2();
			} else if (c.dialogueAction == 7) {
				c.getPA().startTeleport(3088, 3933, 0, "modern");
				c.sendMessage("NOTE: You are now in the wilderness...");
			} else if (c.dialogueAction == 8) {
				c.getPA().resetBarrows();
				c.sendMessage("Your barrows have been reset.");
			}
			c.dialogueAction = 0;
			c.getPA().removeAllWindows();
			break;

		case 9158:
			if (c.dialogueAction == 8) {
				c.getPA().fixAllBarrows();
			} else {
				c.dialogueAction = 0;
				c.getPA().removeAllWindows();
			}
			break;

		/** Specials **/
		case 29188:
			c.specBarId = 7636; // the special attack text - sendframe126(S P E
								// C I A L A T T A C K, c.specBarId);
			c.usingSpecial = !c.usingSpecial;
			c.getItems().updateSpecialBar();
			break;

		case 29163:
			c.specBarId = 7611;
			c.usingSpecial = !c.usingSpecial;
			c.getItems().updateSpecialBar();
			break;

		case 33033:
			c.specBarId = 8505;
			c.usingSpecial = !c.usingSpecial;
			c.getItems().updateSpecialBar();
			break;

		case 29038:
			c.specBarId = 7486;
			/*
			 * if (c.specAmount >= 5) { c.attackTimer = 0;
			 * c.getCombat().attackPlayer(c.playerIndex); c.usingSpecial = true;
			 * c.specAmount -= 5; }
			 */
			c.getCombat().handleGmaulPlayer();
			c.getItems().updateSpecialBar();
			break;

		case 29063:
			if (c.getCombat()
					.checkSpecAmount(c.playerEquipment[c.playerWeapon])) {
				c.gfx0(246);
				c.forcedChat("Raarrrrrgggggghhhhhhh!");
				c.startAnimation(1056);
				c.playerLevel[2] = c.getLevelForXP(c.playerXP[2])
						+ (c.getLevelForXP(c.playerXP[2]) * 15 / 100);
				c.getPA().refreshSkill(2);
				c.getItems().updateSpecialBar();
			} else {
				c.sendMessage("You don't have the required special energy to use this attack.");
			}
			break;

		case 48023:
			c.specBarId = 12335;
			c.usingSpecial = !c.usingSpecial;
			c.getItems().updateSpecialBar();
			break;

		case 29138:
			c.specBarId = 7586;
			c.usingSpecial = !c.usingSpecial;
			c.getItems().updateSpecialBar();
			break;

		case 29113:
			c.specBarId = 7561;
			c.usingSpecial = !c.usingSpecial;
			c.getItems().updateSpecialBar();
			break;

		case 29238:
			c.specBarId = 7686;
			c.usingSpecial = !c.usingSpecial;
			c.getItems().updateSpecialBar();
			break;

		/** Dueling **/
		case 26065: // no forfeit
		case 26040:
			c.duelSlot = -1;
			c.getTradeAndDuel().selectRule(0);
			break;

		case 26066: // no movement
		case 26048:
			c.duelSlot = -1;
			c.getTradeAndDuel().selectRule(1);
			break;

		case 26069: // no range
		case 26042:
			c.duelSlot = -1;
			c.getTradeAndDuel().selectRule(2);
			break;

		case 26070: // no melee
		case 26043:
			c.duelSlot = -1;
			c.getTradeAndDuel().selectRule(3);
			break;

		case 26071: // no mage
		case 26041:
			c.duelSlot = -1;
			c.getTradeAndDuel().selectRule(4);
			break;

		case 26072: // no drinks
		case 26045:
			c.duelSlot = -1;
			c.getTradeAndDuel().selectRule(5);
			break;

		case 26073: // no food
		case 26046:
			c.duelSlot = -1;
			c.getTradeAndDuel().selectRule(6);
			break;

		case 26074: // no prayer
		case 26047:
			c.duelSlot = -1;
			c.getTradeAndDuel().selectRule(7);
			break;

		case 26076: // obsticals
		case 26075:
			c.duelSlot = -1;
			c.getTradeAndDuel().selectRule(8);
			break;

		case 2158: // fun weapons
		case 2157:
			c.duelSlot = -1;
			c.getTradeAndDuel().selectRule(9);
			break;

		case 30136: // sp attack
		case 30137:
			c.duelSlot = -1;
			c.getTradeAndDuel().selectRule(10);
			break;

		case 53245: // no helm
			c.duelSlot = 0;
			c.getTradeAndDuel().selectRule(11);
			break;

		case 53246: // no cape
			c.duelSlot = 1;
			c.getTradeAndDuel().selectRule(12);
			break;

		case 53247: // no ammy
			c.duelSlot = 2;
			c.getTradeAndDuel().selectRule(13);
			break;

		case 53249: // no weapon.
			c.duelSlot = 3;
			c.getTradeAndDuel().selectRule(14);
			break;

		case 53250: // no body
			c.duelSlot = 4;
			c.getTradeAndDuel().selectRule(15);
			break;

		case 53251: // no shield
			c.duelSlot = 5;
			c.getTradeAndDuel().selectRule(16);
			break;

		case 53252: // no legs
			c.duelSlot = 7;
			c.getTradeAndDuel().selectRule(17);
			break;

		case 53255: // no gloves
			c.duelSlot = 9;
			c.getTradeAndDuel().selectRule(18);
			break;

		case 53254: // no boots
			c.duelSlot = 10;
			c.getTradeAndDuel().selectRule(19);
			break;

		case 53253: // no rings
			c.duelSlot = 12;
			c.getTradeAndDuel().selectRule(20);
			break;

		case 53248: // no arrows
			c.duelSlot = 13;
			c.getTradeAndDuel().selectRule(21);
			break;

		case 26018:
			Client o = (Client) PlayerHandler.players[c.duelingWith];
			if (o == null) {
				c.getTradeAndDuel().declineDuel();
				return;
			}

			if (c.duelRule[2] && c.duelRule[3] && c.duelRule[4]) {
				c.sendMessage("You won't be able to attack the player with the rules you have set.");
				break;
			}
			c.duelStatus = 2;
			if (c.duelStatus == 2) {
				c.getPA().sendFrame126("Waiting for other player...", 6684);
				o.getPA().sendFrame126("Other player has accepted.", 6684);
			}
			if (o.duelStatus == 2) {
				o.getPA().sendFrame126("Waiting for other player...", 6684);
				c.getPA().sendFrame126("Other player has accepted.", 6684);
			}

			if (c.duelStatus == 2 && o.duelStatus == 2) {
				c.canOffer = false;
				o.canOffer = false;
				c.duelStatus = 3;
				o.duelStatus = 3;
				c.getTradeAndDuel().confirmDuel();
				o.getTradeAndDuel().confirmDuel();
			}
			break;

		case 25120:
			if (c.duelStatus == 5) {
				break;
			}
			Client o1 = (Client) PlayerHandler.players[c.duelingWith];
			if (o1 == null) {
				c.getTradeAndDuel().declineDuel();
				return;
			}

			c.duelStatus = 4;
			if (o1.duelStatus == 4 && c.duelStatus == 4) {
				c.getTradeAndDuel().startDuel();
				o1.getTradeAndDuel().startDuel();
				o1.duelCount = 4;
				c.duelCount = 4;
				c.duelDelay = System.currentTimeMillis();
				o1.duelDelay = System.currentTimeMillis();
			} else {
				c.getPA().sendFrame126("Waiting for other player...", 6571);
				o1.getPA().sendFrame126("Other player has accepted", 6571);
			}
			break;

		case 4169: // god spell charge
			c.usingMagic = true;
			if (!c.getCombat().checkMagicReqs(48)) {
				break;
			}

			if (System.currentTimeMillis() - c.godSpellDelay < Constants.GOD_SPELL_CHARGE) {
				c.sendMessage("You still feel the charge in your body!");
				break;
			}
			c.godSpellDelay = System.currentTimeMillis();
			c.sendMessage("You feel charged with a magical power!");
			c.gfx100(c.MAGIC_SPELLS[48][3]);
			c.startAnimation(c.MAGIC_SPELLS[48][2]);
			c.usingMagic = false;
			break;

		case 28164: // item kept on death
			break;

		case 152:
			c.isRunning2 = !c.isRunning2;
			int frame = c.isRunning2 == true ? 1 : 0;
			c.getPA().sendFrame36(173, frame);
			break;

		case 9154:
			if (c.inTrade) {
				c.sendMessage("You can't logout during trade!");
				return;
			}
			if (c.inDuel) {
				c.sendMessage("You can't logout during duel!");
				return;
			}
			c.logout();
			break;

		case 21010:
			c.takeAsNote = true;
			break;

		case 21011:
			c.takeAsNote = false;
			break;


		case 4171:
		case 50056:
		if (c.inTrade) {
			c.sendMessage("You can't teleport while trading!");
			return;
		}
		if (c.inDuel) {
			c.sendMessage("You can't teleport while dueling!");
			return;
		}
		String type = c.playerMagicBook == 0 ? "modern" : "ancient";
		c.getPA().startTeleport(Constants.LUMBRIDGE_X, Constants.LUMBRIDGE_Y, 0, "modern");
		break;
		
		case 50235:
		case 4140:
		if (c.inTrade) {
			c.sendMessage("You can't teleport while trading!");
			return;
		}
		if (c.inDuel) {
			c.sendMessage("You can't teleport while dueling!");
			return;
		}	
		c.getPA().startTeleport(Constants.VARROCK_X, Constants.VARROCK_Y, 0, "modern");
		c.teleAction = 1;
		break;
		
		case 4143:
		case 50245:
		if (c.inTrade) {
			c.sendMessage("You can't teleport while trading!");
			return;
		}
		if (c.inDuel) {
			c.sendMessage("You can't teleport while dueling!");
			return;
		}		
		c.getPA().startTeleport(Constants.LUMBRIDGE_X, Constants.LUMBRIDGE_Y, 0, "modern");
		c.teleAction = 2;
		break;
		
		case 50253:
		case 4146:
		if (c.inTrade) {
			c.sendMessage("You can't teleport while trading!");
			return;
		}
		if (c.inDuel) {
			c.sendMessage("You can't teleport while dueling!");
			return;
		}	
		c.getPA().startTeleport(Constants.FALADOR_X, Constants.FALADOR_Y, 0, "modern");
		c.teleAction = 3;
		break;
		

		case 51005:
		case 4150:
		if (c.inTrade) {
			c.sendMessage("You can't teleport while trading!");
			return;
		}
		if (c.inDuel) {
			c.sendMessage("You can't teleport while dueling!");
			return;
		}
		c.getPA().startTeleport(Constants.CAMELOT_X, Constants.CAMELOT_Y, 0, "modern");
		c.teleAction = 4;
		break;			
		
		case 51013:
		case 6004:
		if (c.inTrade) {
			c.sendMessage("You can't teleport while trading!");
			return;
		}
		if (c.inDuel) {
			c.sendMessage("You can't teleport while dueling!");
			return;
		}
		c.getPA().startTeleport(Constants.ARDOUGNE_X, Constants.ARDOUGNE_Y, 0, "modern");
		c.teleAction = 5;
		break; 
		
		case 51023:
		case 6005:
		if (c.inTrade) {
			c.sendMessage("You can't teleport while trading!");
			return;
		}
		if (c.inDuel) {
			c.sendMessage("You can't teleport while dueling!");
			return;
		}	
		c.getPA().startTeleport(Constants.WATCH_TOWER_X, Constants.WATCH_TOWER_Y, 0, "modern");
		c.teleAction = 6;
		break; 
		
		case 51031:
		case 29031:
		if (c.inTrade) {
			c.sendMessage("You can't teleport while trading!");
			return;
		}
		if (c.inDuel) {
			c.sendMessage("You can't teleport while dueling!");
			return;
		}
		c.getPA().startTeleport(Constants.TROLLHEIM_X, Constants.TROLLHEIM_Y, 0, "modern");
		c.teleAction = 7;
		break; 		


		case 9125: // Accurate
		case 6221: // range accurate
		case 22228: // punch (unarmed)
		case 48010: // flick (whip)
		case 21200: // spike (pickaxe)
		case 1080: // bash (staff)
		case 6168: // chop (axe)
		case 6236: // accurate (long bow)
		case 17102: // accurate (darts)
		case 8234: // stab (dagger)
			c.fightMode = 0;
			if (c.autocasting)
				c.getPA().resetAutocast();
			break;

		case 9126: // Defensive
		case 48008: // deflect (whip)
		case 22229: // block (unarmed)
		case 21201: // block (pickaxe)
		case 1078: // focus - block (staff)
		case 6169: // block (axe)
		case 33019: // fend (hally)
		case 18078: // block (spear)
		case 8235: // block (dagger)
			c.fightMode = 1;
			if (c.autocasting)
				c.getPA().resetAutocast();
			break;

		case 9127: // Controlled
		case 48009: // lash (whip)
		case 33018: // jab (hally)
		case 6234: // longrange (long bow)
		case 6219: // longrange
		case 18077: // lunge (spear)
		case 18080: // swipe (spear)
		case 18079: // pound (spear)
		case 17100: // longrange (darts)
			c.fightMode = 3;
			if (c.autocasting)
				c.getPA().resetAutocast();
			break;

		case 9128: // Aggressive
		case 6220: // range rapid
		case 22230: // kick (unarmed)
		case 21203: // impale (pickaxe)
		case 21202: // smash (pickaxe)
		case 1079: // pound (staff)
		case 6171: // hack (axe)
		case 6170: // smash (axe)
		case 33020: // swipe (hally)
		case 6235: // rapid (long bow)
		case 17101: // repid (darts)
		case 8237: // lunge (dagger)
		case 8236: // slash (dagger)
			c.fightMode = 2;
			if (c.autocasting)
				c.getPA().resetAutocast();
			break;

		/** Prayers **/
		case 21233: // thick skin
			c.getCombat().activatePrayer(0);
			break;
		case 21234: // burst of str
			c.getCombat().activatePrayer(1);
			break;
		case 21235: // charity of thought
			c.getCombat().activatePrayer(2);
			break;
		case 70080: // range
			c.getCombat().activatePrayer(3);
			break;
		case 70082: // mage
			c.getCombat().activatePrayer(4);
			break;
		case 21236: // rockskin
			c.getCombat().activatePrayer(5);
			break;
		case 21237: // super human
			c.getCombat().activatePrayer(6);
			break;
		case 21238: // improved reflexes
			c.getCombat().activatePrayer(7);
			break;
		case 21239: // hawk eye
			c.getCombat().activatePrayer(8);
			break;
		case 21240:
			c.getCombat().activatePrayer(9);
			break;
		case 21241: // protect Item
			c.getCombat().activatePrayer(10);
			break;
		case 70084: // 26 range
			c.getCombat().activatePrayer(11);
			break;
		case 70086: // 27 mage
			c.getCombat().activatePrayer(12);
			break;
		case 21242: // steel skin
			c.getCombat().activatePrayer(13);
			break;
		case 21243: // ultimate str
			c.getCombat().activatePrayer(14);
			break;
		case 21244: // incredible reflex
			c.getCombat().activatePrayer(15);
			break;
		case 21245: // protect from magic
			c.getCombat().activatePrayer(16);
			break;
		case 21246: // protect from range
			c.getCombat().activatePrayer(17);
			break;
		case 21247: // protect from melee
			c.getCombat().activatePrayer(18);
			break;
		case 70088: // 44 range
			c.getCombat().activatePrayer(19);
			break;
		case 70090: // 45 mystic
			c.getCombat().activatePrayer(20);
			break;
		case 2171: // retrui
			c.getCombat().activatePrayer(21);
			break;
		case 2172: // redem
			c.getCombat().activatePrayer(22);
			break;
		case 2173: // smite
			c.getCombat().activatePrayer(23);
			break;
		case 70092: // chiv
			c.getCombat().activatePrayer(24);
			break;
		case 70094: // piety
			c.getCombat().activatePrayer(25);
			break;

		case 13092:
			if (System.currentTimeMillis() - c.lastButton < 400) {

				c.lastButton = System.currentTimeMillis();

				break;

			} else {

				c.lastButton = System.currentTimeMillis();

			}
			Client ot = (Client) PlayerHandler.players[c.tradeWith];
			if (ot == null) {
				c.getTradeAndDuel().declineTrade();
				c.sendMessage("Trade declined as the other player has disconnected.");
				break;
			}
			c.getPA().sendFrame126("Waiting for other player...", 3431);
			ot.getPA().sendFrame126("Other player has accepted", 3431);
			c.goodTrade = true;
			ot.goodTrade = true;

			for (GameItem item : c.getTradeAndDuel().offeredItems) {
				if (item.id > 0) {
					if (ot.getItems().freeSlots() < c.getTradeAndDuel().offeredItems
							.size()) {
						c.sendMessage(ot.playerName
								+ " only has "
								+ ot.getItems().freeSlots()
								+ " free slots, please remove "
								+ (c.getTradeAndDuel().offeredItems.size() - ot
										.getItems().freeSlots()) + " items.");
						ot.sendMessage(c.playerName
								+ " has to remove "
								+ (c.getTradeAndDuel().offeredItems.size() - ot
										.getItems().freeSlots())
								+ " items or you could offer them "
								+ (c.getTradeAndDuel().offeredItems.size() - ot
										.getItems().freeSlots()) + " items.");
						c.goodTrade = false;
						ot.goodTrade = false;
						c.getPA().sendFrame126("Not enough inventory space...",
								3431);
						ot.getPA().sendFrame126(
								"Not enough inventory space...", 3431);
						break;
					} else {
						c.getPA().sendFrame126("Waiting for other player...",
								3431);
						ot.getPA().sendFrame126("Other player has accepted",
								3431);
						c.goodTrade = true;
						ot.goodTrade = true;
					}
				}
			}
			if (c.inTrade && !c.tradeConfirmed && ot.goodTrade && c.goodTrade) {
				c.tradeConfirmed = true;
				if (ot.tradeConfirmed) {
					c.getTradeAndDuel().confirmScreen();
					ot.getTradeAndDuel().confirmScreen();
					break;
				}

			}

			break;

		case 13218:
			if (System.currentTimeMillis() - c.lastButton < 400) {

				c.lastButton = System.currentTimeMillis();

				break;

			} else {

				c.lastButton = System.currentTimeMillis();

			}
			c.tradeAccepted = true;
			Client ot1 = (Client) PlayerHandler.players[c.tradeWith];
			if (ot1 == null) {
				c.getTradeAndDuel().declineTrade();
				c.sendMessage("Trade declined as the other player has disconnected.");
				break;
			}

			if (c.inTrade && c.tradeConfirmed && ot1.tradeConfirmed
					&& !c.tradeConfirmed2) {
				c.tradeConfirmed2 = true;
				if (ot1.tradeConfirmed2) {
					c.acceptedTrade = true;
					ot1.acceptedTrade = true;
					c.getTradeAndDuel().giveItems();
					ot1.getTradeAndDuel().giveItems();
					break;
				}
				ot1.getPA().sendFrame126("Other player has accepted.", 3535);
				c.getPA().sendFrame126("Waiting for other player...", 3535);
			}
			break;
		
		
		case 87231:
			c.getCombat().activatePrayer(26);
			break;
			case 87233:
			c.getCombat().activatePrayer(27);
			break;
			case 87235:
			c.getCombat().activatePrayer(28);
			break;
			case 87237:
			c.getCombat().activatePrayer(29);
			break;
			case 87239:
			c.getCombat().activatePrayer(30);
			break;
			case 87241:
			c.getCombat().activatePrayer(31);
			break;
			case 87243:
			c.getCombat().activatePrayer(32);
			break;
			case 87245:
			c.getCombat().activatePrayer(33);
			break;
			case 87247:
			c.getCombat().activatePrayer(34);
			break;
			case 87249:
			c.getCombat().activatePrayer(35);
			break;
			case 87251:
			c.getCombat().activatePrayer(36);
			break;
			case 87253:
			c.getCombat().activatePrayer(37);
			break;
			case 87255:
			c.getCombat().activatePrayer(38);
			break;
			case 88001:
			c.getCombat().activatePrayer(39);
			break;
			case 88003:
			c.getCombat().activatePrayer(40);
			break;
			case 88005:
			c.getCombat().activatePrayer(41);
			break;
			case 88007:
			c.getCombat().activatePrayer(42);
			break;
			case 88009:
			c.getCombat().activatePrayer(43);
			break;
			case 88011:
			c.getCombat().activatePrayer(44);
			break;
			case 88013:
			c.getCombat().activatePrayer(45);
			break;
			
		
		case 125011:
			if (!c.ruleAgreeButton) {
				c.ruleAgreeButton = true;
				c.getPA().sendFrame36(701, 1);
			} else {
				c.ruleAgreeButton = false;
				c.getPA().sendFrame36(701, 0);
			}
			break;
		case 125003:// Accept
			if (c.ruleAgreeButton) {
				c.getPA().showInterface(3559);
				c.newPlayer = false;
			} else if (!c.ruleAgreeButton) {
				c.sendMessage("You need to click on you agree before you can continue on.");
			}
			break;
		case 125006:// Decline
			c.sendMessage("You have chosen to decline, Client will be disconnected from the server.");
			break;

		case 74176:
			if(!c.mouseButton) {
				c.mouseButton = true;
				c.getPA().sendFrame36(500, 1);
				c.getPA().sendFrame36(170,1);
			} else if(c.mouseButton) {
				c.mouseButton = false;
				c.getPA().sendFrame36(500, 0);
				c.getPA().sendFrame36(170,0);					
			}
			break;
		case 74184:
			if(!c.splitChat) {
				c.splitChat = true;
				c.getPA().sendFrame36(502, 1);
				c.getPA().sendFrame36(287, 1);
			} else {
				c.splitChat = false;
				c.getPA().sendFrame36(502, 0);
				c.getPA().sendFrame36(287, 0);
			}
			break;
		case 74180:
			if(!c.chatEffects) {
				c.chatEffects = true;
				c.getPA().sendFrame36(501, 1);
				c.getPA().sendFrame36(171, 0);
			} else {
				c.chatEffects = false;
				c.getPA().sendFrame36(501, 0);
				c.getPA().sendFrame36(171, 1);
			}
			break;
		case 74188:
			if(!c.acceptAid) {
				c.acceptAid = true;
				c.getPA().sendFrame36(503, 1);
				c.getPA().sendFrame36(427, 1);
			} else {
				c.acceptAid = false;
				c.getPA().sendFrame36(503, 0);
				c.getPA().sendFrame36(427, 0);
			}
			break;
		case 74192:
			if(!c.isRunning2) {
				c.isRunning2 = true;
				c.getPA().sendFrame36(504, 1);
				c.getPA().sendFrame36(173, 1);
			} else {
				c.isRunning2 = false;
				c.getPA().sendFrame36(504, 0);
				c.getPA().sendFrame36(173, 0);
			}
			break;
		case 74201://brightness1
			c.getPA().sendFrame36(505, 1);
			c.getPA().sendFrame36(506, 0);
			c.getPA().sendFrame36(507, 0);
			c.getPA().sendFrame36(508, 0);
			c.getPA().sendFrame36(166, 1);
			break;
		case 74203://brightness2
			c.getPA().sendFrame36(505, 0);
			c.getPA().sendFrame36(506, 1);
			c.getPA().sendFrame36(507, 0);
			c.getPA().sendFrame36(508, 0);
			c.getPA().sendFrame36(166,2);
			break;

		case 74204://brightness3
			c.getPA().sendFrame36(505, 0);
			c.getPA().sendFrame36(506, 0);
			c.getPA().sendFrame36(507, 1);
			c.getPA().sendFrame36(508, 0);
			c.getPA().sendFrame36(166,3);
			break;

		case 74205://brightness4
			c.getPA().sendFrame36(505, 0);
			c.getPA().sendFrame36(506, 0);
			c.getPA().sendFrame36(507, 0);
			c.getPA().sendFrame36(508, 1);
			c.getPA().sendFrame36(166,4);
			break;
		case 74206:// area1
			c.getPA().sendFrame36(509, 1);
			c.getPA().sendFrame36(510, 0);
			c.getPA().sendFrame36(511, 0);
			c.getPA().sendFrame36(512, 0);
			break;
		case 74207:// area2
			c.getPA().sendFrame36(509, 0);
			c.getPA().sendFrame36(510, 1);
			c.getPA().sendFrame36(511, 0);
			c.getPA().sendFrame36(512, 0);
			break;
		case 74208:// area3
			c.getPA().sendFrame36(509, 0);
			c.getPA().sendFrame36(510, 0);
			c.getPA().sendFrame36(511, 1);
			c.getPA().sendFrame36(512, 0);
			break;
		case 74209:// area4
			c.getPA().sendFrame36(509, 0);
			c.getPA().sendFrame36(510, 0);
			c.getPA().sendFrame36(511, 0);
			c.getPA().sendFrame36(512, 1);
			break;
		case 168:
			c.startAnimation(855);
			break;
		case 169:
			c.startAnimation(856);
			break;
		case 162:
			c.startAnimation(857);
			break;
		case 164:
			c.startAnimation(858);
			break;
		case 165:
			c.startAnimation(859);
			break;
		case 161:
			c.startAnimation(860);
			break;
		case 170:
			c.startAnimation(861);
			break;
		case 171:
			c.startAnimation(862);
			break;
		case 163:
			c.startAnimation(863);
			break;
		case 167:
			c.startAnimation(864);
			break;
		case 172:
			c.startAnimation(865);
			break;
		case 166:
			c.startAnimation(866);
			break;
		case 52050:
			c.startAnimation(2105);
			break;
		case 52051:
			c.startAnimation(2106);
			break;
		case 52052:
			c.startAnimation(2107);
			break;
		case 52053:
			c.startAnimation(2108);
			break;
		case 52054:
			c.startAnimation(2109);
			break;
		case 52055:
			c.startAnimation(2110);
			break;
		case 52056:
			c.startAnimation(2111);
			break;
		case 52057:
			c.startAnimation(2112);
			break;
		case 52058:
			c.startAnimation(2113);
			break;
		case 43092:
			c.startAnimation(0x558);
			break;
		case 2155:
			c.startAnimation(0x46B);
			break;
		case 25103:
			c.startAnimation(0x46A);
			break;
		case 25106:
			c.startAnimation(0x469);
			break;
		case 2154:
			c.startAnimation(0x468);
			break;
		case 52071:
			c.startAnimation(0x84F);
			break;
		case 52072:
			c.startAnimation(0x850);
			break;
		case 59062:
			c.startAnimation(2836);
			break;
		case 72032:
			c.startAnimation(3544);
			break;
		case 72033:
			c.startAnimation(3543);
			break;
		case 72254:
			c.startAnimation(3866);
			break;
		/* END OF EMOTES */
		case 28166:

			break;
			
		case 34142: // tab 1
			c.getSI().menuCompilation(1);
			break;

		case 34119: // tab 2
			c.getSI().menuCompilation(2);
			break;

		case 34120: // tab 3
			c.getSI().menuCompilation(3);
			break;

		case 34123: // tab 4
			c.getSI().menuCompilation(4);
			break;

		case 34133: // tab 5
			c.getSI().menuCompilation(5);
			break;

		case 34136: // tab 6
			c.getSI().menuCompilation(6);
			break;

		case 34139: // tab 7
			c.getSI().menuCompilation(7);
			break;

		case 34155: // tab 8
			c.getSI().menuCompilation(8);
			break;

		case 34158: // tab 9
			c.getSI().menuCompilation(9);
			break;

		case 34161: // tab 10
			c.getSI().menuCompilation(10);
			break;

		case 59199: // tab 11
			c.getSI().menuCompilation(11);
			break;

		case 59202: // tab 12
			c.getSI().menuCompilation(12);
			break;
		case 59203: // tab 13
			c.getSI().menuCompilation(13);
			break;
			
		case 33206: // attack
			c.getSI().attackComplex(1);
			c.getSI().selected = 0;
			//c.forcedText = "My Attack level is " + c.playerLevel[0] + "";
			//c.forcedChatUpdateRequired = true;
			//c.updateRequired = true;
			break;
		case 33209: // strength
			c.getSI().strengthComplex(1);
			c.getSI().selected = 1;
			//c.forcedText = "My Strength level is " + c.playerLevel[2] + "";
			//c.forcedChatUpdateRequired = true;
			//c.updateRequired = true;
			break;
		case 33212: // Defence
			c.getSI().defenceComplex(1);
			c.getSI().selected = 2;
			//c.forcedText = "My Defence level is " + c.playerLevel[1] + "";
			//c.forcedChatUpdateRequired = true;
			//c.updateRequired = true;
			break;
		case 33215: // range
			c.getSI().rangedComplex(1);
			c.getSI().selected = 3;
			//c.forcedText = "My Range level is " + c.playerLevel[4] + "";
			//c.forcedChatUpdateRequired = true;
			//c.updateRequired = true;
			break;
		case 33218: // prayer
			c.getSI().prayerComplex(1);
			c.getSI().selected = 4;
			//c.forcedText = "My Prayer level is " + c.playerLevel[5] + "";
			//c.forcedChatUpdateRequired = true;
			//c.updateRequired = true;
			break;
		case 33221: // mage
			c.getSI().magicComplex(1);
			c.getSI().selected = 5;
			//c.forcedText = "My Magic level is " + c.playerLevel[6] + "";
			//c.forcedChatUpdateRequired = true;
			//c.updateRequired = true;
			break;
		case 33224: // runecrafting
			c.getSI().runecraftingComplex(1);
			c.getSI().selected = 6;
			//c.forcedText = "My Runecrafting level is " + c.playerLevel[20] + "";
			//c.forcedChatUpdateRequired = true;
			//c.updateRequired = true;
			break;
		case 33207: // hp
			c.getSI().hitpointsComplex(1);
			c.getSI().selected = 7;
			//c.forcedText = "My Hitpoints level is " + c.playerLevel[3] + "";
			//c.forcedChatUpdateRequired = true;
			//c.updateRequired = true;
			break;
		case 33210: // agility
			c.getSI().agilityComplex(1);
			c.getSI().selected = 8;
			//c.forcedText = "My Agility level is " + c.playerLevel[16] + "";
			//c.forcedChatUpdateRequired = true;
			//c.updateRequired = true;
			break;
		case 33213: // herblore
			c.getSI().herbloreComplex(1);
			c.getSI().selected = 9;
			//c.forcedText = "My Herblore level is " + c.playerLevel[15] + "";
			//c.forcedChatUpdateRequired = true;
			//c.updateRequired = true;
			break;
		case 33216: // theiving
			c.getSI().thievingComplex(1);
			c.getSI().selected = 10;
			//c.forcedText = "My Thieving level is " + c.playerLevel[17] + "";
			//c.forcedChatUpdateRequired = true;
			//c.updateRequired = true;
			break;
		case 33219: // crafting
			c.getSI().craftingComplex(1);
			c.getSI().selected = 11;
			//c.forcedText = "My Crafting level is " + c.playerLevel[12] + "";
			//c.forcedChatUpdateRequired = true;
			//c.updateRequired = true;
			break;
		case 33222: // fletching
			c.getSI().fletchingComplex(1);
			c.getSI().selected = 12;
			//c.forcedText = "My Fletching level is " + c.playerLevel[9] + "";
			//c.forcedChatUpdateRequired = true;
			//c.updateRequired = true;
			break;
		case 47130:// slayer
			c.getSI().slayerComplex(1);
			c.getSI().selected = 13;
			//c.forcedText = "I must slay another " + c.taskAmount + " " + Server.npcHandler.getNpcListName(c.slayerTask) + ".";
			//c.forcedChatUpdateRequired = true;
			//c.updateRequired = true;
			break;
			
		case 33208: //mining
		    c.getSI().miningComplex(1);
			c.getSI().selected = 14;
			//c.forcedText = "My Mining level is " + c.playerLevel[14] + "";
			//c.forcedChatUpdateRequired = true;
			//c.updateRequired = true;
			break;
			
		case 33211: //smithing
			c.getSI().smithingComplex(1);
			c.getSI().selected = 15;
			//c.forcedText = "My Smithing level is " + c.playerLevel[13] + "";
			//c.forcedChatUpdateRequired = true;
			//c.updateRequired = true;
			break;

		case 33214: // fishing
			c.getSI().fishingComplex(1);
			c.getSI().selected = 16;
			//c.forcedText = "My Fishing level is " + c.playerLevel[10] + "";
			//c.forcedChatUpdateRequired = true;
			//c.updateRequired = true;
			break;
		case 33217: // cooking
			c.getSI().cookingComplex(1);
			c.getSI().selected = 17;
			//c.forcedText = "My Cooking level is " + c.playerLevel[7] + "";
			//c.forcedChatUpdateRequired = true;
		    //c.updateRequired = true;
			break;
		case 33220: // firemaking
			c.getSI().firemakingComplex(1);
			c.getSI().selected = 18;
			//c.forcedText = "My Firemaking level is " + c.playerLevel[11] + "";
			//c.forcedChatUpdateRequired = true;
			//c.updateRequired = true;
			break;
		case 33223: // woodcut
			c.getSI().woodcuttingComplex(1);
			c.getSI().selected = 19;
			//c.forcedText = "My Woodcutting level is " + c.playerLevel[8] + "";
			//c.forcedChatUpdateRequired = true;
			//c.updateRequired = true;
			break;
		case 54104: // farming
			c.getSI().farmingComplex(1);
			c.getSI().selected = 20;
			//c.forcedText = "My Farming level is " + c.playerLevel[19] + "";
			//c.forcedChatUpdateRequired = true;
			//c.updateRequired = true;
			break;

		case 24017:
			c.getPA().resetAutocast();
			// c.sendFrame246(329, 200, c.playerEquipment[c.playerWeapon]);
			c.getItems()
					.sendWeapon(
							c.playerEquipment[c.playerWeapon],
							c.getItems().getItemName(
									c.playerEquipment[c.playerWeapon]));
			// c.setSidebarInterface(0, 328);
			// c.setSidebarInterface(6, c.playerMagicBook == 0 ? 1151 :
			// c.playerMagicBook == 1 ? 12855 : 1151);
			break;
		}
		if (c.isAutoButton(actionButtonId))
			c.assignAutocast(actionButtonId);
	}

}
