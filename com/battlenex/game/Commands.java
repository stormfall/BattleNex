package com.battlenex.game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.battlenex.Connection;
import com.battlenex.Server;
import com.battlenex.game.players.PacketType;
import com.battlenex.game.players.Player;
import com.battlenex.game.players.PlayerHandler;
import com.battlenex.game.players.PlayerSave;
import com.battlenex.game.settings.Constants;
import com.battlenex.utils.Jarvis;
import com.battlenex.utils.Utils;

public class Commands implements PacketType {
	
	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		String playerCommand = c.getInStream().readString();
		Utils.println(c.playerName + " playerCommand: " + playerCommand);
		
		playerCommands(c, playerCommand);

		if (playerCommand.equalsIgnoreCase("players")) {
			c.sendMessage("There are currently "+ PlayerHandler.getPlayerCount() + " players online.");
		}
		if (playerCommand.startsWith("/") && playerCommand.length() > 1) {
			 if (Connection.isMuted(c)) { 
				 c.sendMessage("You are muted for breaking a rule.");
                 return;
             }
				if (c.clanId >= 0) {
					System.out.println(playerCommand);
					playerCommand = playerCommand.substring(1);
					Server.clanChat.playerMessageToClan(c.playerId, playerCommand, c.clanId);
				} else {
					if (c.clanId != -1)
						c.clanId = -1;
					c.sendMessage("You are not in a clan.");
				}
				return;
			}
		
		
		if (c.playerRights >= 1 || c.playerRights >= 2 || c.playerRights >= 3) {
			 if (Connection.isMuted(c)) {
				 c.sendMessage("You are muted for breaking a rule.");
                 return;
             }
			 staffCommands(c, playerCommand);   
			  try {
	              new SimpleDateFormat("MM/dd/yyyy");
	              BufferedWriter out = new BufferedWriter(new FileWriter("./data/logs/commands/log.txt", true));
	              try {
	                  out.newLine();
	                  out.write(c.playerName + " used the command "+playerCommand+".");
	              } finally {
	                  out.close();
	              }
	          } catch (IOException e) {
	              e.printStackTrace();
	          	}
			}
			 
	         
		if (playerCommand.startsWith("empty") && playerCommand.length() > 5) {
	         	c.getItems().removeAllItems();
		}
		
		if (playerCommand.startsWith("info") && playerCommand.length() > 4) {
	             String playerInfo = playerCommand.substring(5);
	             for(int i = 0; i < Constants.MAX_PLAYERS; i++) {
	                 if(PlayerHandler.players[i] != null) {
	                     if(PlayerHandler.players[i].playerName.equalsIgnoreCase(playerInfo)) {
	                         Client info = (Client)PlayerHandler.players[i];
	                         c.sendMessage("Your username is: "+info.playerName);
	                         c.sendMessage("Your password is: "+info.playerName);
	                     	} 
	                 	}
	             	}
	         }
	}
	
	
	
	Constants Config;
	
	/**
	 * Name of the organization.
	 */
	static String SERVER_NAME = Constants.SERVER_NAME;
	
	/**
	 * How to use the command.
	 */
	static String HTU = "To use, enter as '::command id' or use as '::command id amount'.";
	
	/**
	 * This command is unavailable.
	 */
	static String UNAVAILABLE = "This command does not exist or has been disabled.";

	/**
	 * Player must be offline message.
	 */
	static String PLAYER_OFFLINE = "You cannot perform a promotion on a player that is online.";

	/**
	 * Ban message.
	 */
	static String BAN = "You have banned that player.";

	/**
	 * Unban message.
	 */
	static String UNBAN = "You have unbanned that player.";
	
	/**
	 * Promote message.
	 */
	static String PROMOTE = "Congratulations! You have been promoted to...";

	/**
	 * Demote message.
	 */
	static String DEMOTE = "Oh no! You have been demoted from the Staff team.";
	
	/**
	 * Mute message.
	 */
	static String MUTE = "A staff member has muted you.";
	
	/**
	 * Unmute message.
	 */
	static String UNMUTE = "A staff member has unmuted you.";

	/**
	 * Contact email address of the owner.
	 */
	static String CONTACT_EMAIL = "purplephatrs@gmail.com";

	/**
	 * Name of the owner.
	 */
	static String OWNER = "Thee Li0n";
	
	/**
	 * Cheat commands switch.
	 */
	static boolean CHEAT_COMMANDS = true;
	
	/**
	 * Staff commands switch.
	 */
	static boolean STAFF_COMMANDS = true;
	
	/**
	 * Ban commands switch.
	 */
	static boolean BAN_COMMANDS = true;
	
	/**
	 * Mute commands switch.
	 */
	static boolean MUTE_COMMANDS = true;
	
	/**
	 * Clan chat commands switch.
	 */
	static boolean CLAN_COMMANDS = true;
	
	/**
	 * Teleport commands switch.
	 */
	static boolean TELEPORT_COMMANDS = true;
	
	/**
	 * Player commands switch.
	 */
	static boolean PLAYER_COMMANDS = true;
	
	/**
	 * Confirm email switch.
	 */
	static boolean CONFIRM_EMAIL = false;
	
	/**
	 * URL commands switch.
	 */
	static boolean URL_COMMANDS = true;
	
	/**
	 * NPC commands switch.
	 */
	static boolean NPC_COMMANDS = true;
	
	/**
	 * Other commands switch.
	 */
	static boolean OTHER_COMMANDS = true;
	
	/**
	 * Website url.
	 */
	static String WEBSITE = "http://www.battle-soul.com/";
	
	/**
	 * Vote url.
	 */
	static String VOTE = "http://www.battle-soul.com/vote";
	
	/**
	 * Donate url.
	 */
	static String DONATE = "http://www.battle-soul.com/donate";

	/**
	 * Community url.
	 */
	static String COMMUNITY = "http://www.battle-soul.com/forum";
	
	/**
	 * Help url.
	 */
	static String HELP = "http://www.battle-soul.com/help";
		
	/**
	 * Cheat commands.
	 * @param c
	 * @param playerCommand
	 */
	public static void cheatCommands(Client c, String playerCommand) {
		if(CHEAT_COMMANDS == true) {
			
		/**
		 * Spawn items in game.
		 */
		if (playerCommand.startsWith("item") || playerCommand.startsWith("pickup")) {
			try {
				String[] args = playerCommand.split(" ");
				if (args.length == 3) {
					int newItemID = Integer.parseInt(args[1]);
					int newItemAmount = Integer.parseInt(args[2]);
					if ((newItemID <= newItemAmount) && (newItemID >= 0)) {
						c.getItems().addItem(newItemID, newItemAmount);
					} else {
						c.sendMessage("That item does not exist in the system.");
					}
				} else {
					c.sendMessage(HTU);
				}
			} catch (Exception e) {
				c.sendMessage(UNAVAILABLE);
				}
		}
		
		/**
		 * Master
		 */
        if (playerCommand.startsWith("master")) {
            for (int i = 0; i < 22; i++) {
                c.playerLevel[i] = 99;
                c.playerXP[i] = c.getPA().getXPForLevel(100);
                c.getPA().refreshSkill(i);    
            }
            c.getPA().requestUpdates();
        }
		}
	}
	
	/**
	 * Promote and demote commands.
	 * @param c
	 * @param playerCommand
	 */
	public static void promoteCommands(Client c, String playerCommand) {
		if(OTHER_COMMANDS == true) {

		/**
		 * Promote player to a moderator.
		 */
		if (playerCommand.startsWith("promote_mod")) {
			try {
				String promoteModerator = playerCommand.substring(8);
				for (int i = 0; i < Constants.MAX_PLAYERS; i++) {
					if (PlayerHandler.players[i] != null) {
						if (PlayerHandler.players[i].playerName.equalsIgnoreCase(promoteModerator)) {
							Client c2 = (Client) PlayerHandler.players[i];
							c2.sendMessage(PROMOTE + " Moderator.");
							c2.playerRights = 1;
							c2.logout();
							break;
						}
					}
				}
			} catch (Exception e) {
				c.sendMessage(PLAYER_OFFLINE);
			}
		}
		
		/**
		 * Demote a staff member.
		 */
		if (playerCommand.startsWith("demote")) {
			try {
				String playerToDemote = playerCommand.substring(7);
				for (int i = 0; i < Constants.MAX_PLAYERS; i++) {
					if (PlayerHandler.players[i] != null) {
						if (PlayerHandler.players[i].playerName.equalsIgnoreCase(playerToDemote)) {
							Client c2 = (Client) PlayerHandler.players[i];
							c2.sendMessage(DEMOTE);
							c2.playerRights = 0;
							c2.logout();
							break;
						}
					}
				}
			} catch (Exception e) {
				c.sendMessage(PLAYER_OFFLINE);
			}
		
	        /**
	         * A better promote command.
	         */
	        if (playerCommand.startsWith("promote")) {
	            try {
	            for(int i = 0; i < Constants.MAX_PLAYERS; i++) {
	                if(PlayerHandler.players[i] != null) {
	                    if(PlayerHandler.players[i].playerName.equalsIgnoreCase(args(playerCommand)[1])) {
	                        Client other = (Client)PlayerHandler.players[i];
	                        other.playerRights = Integer.parseInt(args(playerCommand)[2]);
	                        other.logout();
	                        c.sendMessage(PROMOTE);
	                    } 
	                }
	            }
	            } catch (Exception e) {
	                System.out.println(HTU);
	            	} 
	        	}
			}
		}
	}
	
	/**
	 * Staff commands.
	 * @param c
	 * @param playerCommand
	 */
	
	@SuppressWarnings("static-access")
	public static void staffCommands(Client c, String playerCommand) {	
		if(STAFF_COMMANDS == true) {
	
		/**
		 * The commands of promoting.
		 */
		if (c.playerRights >= 2 || c.playerRights > 3) {
		promoteCommands(c, playerCommand);
		}
		
		/**
		 * The commands for cheating.
		 */
		cheatCommands(c, playerCommand);
		
		/**
		 * The commands for players.
		 */
		playerCommands(c, playerCommand);
		
		/**
		 * The commands for banning.
		 */
		if (Player.playerRights >= 1 || c.playerRights >= 2) {
		banCommands(c, playerCommand);
		}
		
		/**
		 * The commands for teleports.
		 */
		teleportCommands(c, playerCommand);
		
		/**
		 * The commands for muting.
		 */
		muteCommands(c, playerCommand);
		
		/**
		 * The commands for the urls of the server.
		 */
		urlCommands(c, playerCommand);
		
		/**
		 * The commands for spawning npcs.
		 */
		npcCommands(c, playerCommand);
		
		/**
		 * Commands that contain more commands.
		 */
		otherCommands(c, playerCommand);

		if (playerCommand.startsWith("home") || playerCommand.startsWith("edgeville")) {
			try {
				c.sendMessage("You teleport to Edgeville...");
				c.getPA().startTeleport(Constants.EDGEVILLE_X, Constants.EDGEVILLE_Y, 0, "modern");				
			} catch (Exception e) {
				c.sendMessage(UNAVAILABLE);
				}
		}
		
		/**
		 * Saves all character data.
		 */
		if (playerCommand.equals("save") || playerCommand.equals("rebuild_character")) {
			for (Player player : PlayerHandler.players) {
				if (player != null) {
					Client c1 = (Client) player;
					if (PlayerSave.saveGame(c1)) {
						c1.sendMessage("Your character has been saved.");
					}
				}
			}
		}
	
		/**
		 * Update
		 */
		if (playerCommand.startsWith("update")) {
			PlayerHandler.updateSeconds = 120;
			PlayerHandler.updateAnnounced = false;
			PlayerHandler.updateRunning = true;
			PlayerHandler.updateStartTime = System.currentTimeMillis();
		}
		
		/**
		 * Draws interfaces on screen in game.
		 */
		if (playerCommand.startsWith("interface") || playerCommand.startsWith("inter")) {
			try {
			String[] args = playerCommand.split(" ");
			c.getPA().showInterface(Integer.parseInt(args[1]));
		} catch (Exception e) {
			c.sendMessage(HTU);
		}
	}
		
		/**
		 * Checks the query of a character in game.
		 */
		if (playerCommand.startsWith("query")) {
			try {
				String playerToBan = playerCommand.substring(6);
				for (int i = 0; i < Constants.MAX_PLAYERS; i++) {
					if (PlayerHandler.players[i] != null) {
						if (PlayerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
							c.sendMessage("IP: " + PlayerHandler.players[i].connectedFrom);
							}
						}
					}
				} catch (Exception e) {
					c.sendMessage(PLAYER_OFFLINE);
				}
			}
		
		String[] cmd = playerCommand.toLowerCase().split(" ");
        switch (cmd[0]) {
        
        case "object":
        	try {
            c.getPA().object(Integer.parseInt(args(playerCommand)[1]), c.absX, c.absY, Integer.parseInt(args(playerCommand)[2]), Integer.parseInt(args(playerCommand)[3]));
        		} catch (Exception e) {
        			c.sendMessage(HTU);
        		}
        		return;
        	}
		}
	}
	
	/**
	 * Ban commands.
	 * @param c
	 * @param playerCommand
	 */
	@SuppressWarnings("static-access")
	public static void banCommands(Client c, String playerCommand) {
		if(BAN_COMMANDS == true) {

		/**
		 * Bans the desired character.
		 */
		if (playerCommand.startsWith("ban") && playerCommand.charAt(3) == ' ' || playerCommand.startsWith("ban_player") && playerCommand.charAt(3) == ' ' || playerCommand.startsWith("ban_user") && playerCommand.charAt(3) == ' ') {
			try {
				String playerToBan = playerCommand.substring(4);
				Connection.addNameToBanList(playerToBan);
				Connection.addNameToFile(playerToBan);
				for (int i = 0; i < Constants.MAX_PLAYERS; i++) {
					if (PlayerHandler.players[i] != null) {
						if (PlayerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
							PlayerHandler.players[i].disconnected = true;
						}
					}
				}
			} catch (Exception e) {
				c.sendMessage(PLAYER_OFFLINE);
			}
		}
		
		/**
		 * Unbans the desired character that is banned.
		 */
		if (playerCommand.startsWith("unban") || playerCommand.startsWith("un_ban") || playerCommand.startsWith("lift_ban")) {
			try {
				String playerToBan = playerCommand.substring(6);
				Connection.removeNameFromBanList(playerToBan);
				c.sendMessage(UNBAN);
			} catch (Exception e) {
				c.sendMessage(PLAYER_OFFLINE);
			}
		}
		
		/**
		 * Bans the ip of the desired character.
		 */
		if (playerCommand.startsWith("ip_ban")) {
			try {
				String playerToBan = playerCommand.substring(6);
				for (int i = 0; i < Constants.MAX_PLAYERS; i++) {
					if (PlayerHandler.players[i] != null) {
						if (PlayerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
							if (PlayerHandler.players[i].connectedFrom.equalsIgnoreCase(Constants.SERVER_IP)) {
								c.sendMessage(BAN);
								return;
							}
							if (c.duelStatus < 5 && PlayerHandler.players[i].duelStatus < 5) {
								if (PlayerHandler.players[i].playerRights < 1) {
									Connection.addIpToBanList(PlayerHandler.players[i].connectedFrom);
									Connection.addIpToFile(PlayerHandler.players[i].connectedFrom);
									c.sendMessage(BAN);
									PlayerHandler.players[i].disconnected = true;
								} else {
									c.sendMessage("You cannot perform a ban on staff members.");
									}
								}
							}
						}
					}
				} catch (Exception e) {
					c.sendMessage(PLAYER_OFFLINE);
				}
			}
		}
	}
	
	/**
	 * Teleport commands.
	 * @param c
	 * @param playerCommand
	 */
	public static void teleportCommands(Client c, String playerCommand) {
		if(TELEPORT_COMMANDS == true) {
		
		/**
		 * Teleport to a location.
		 */
		if (playerCommand.startsWith("tele") || playerCommand.startsWith("teleport") || playerCommand.startsWith("goto")) {
			String[] arg = playerCommand.split(" ");
			if (arg.length > 3)
				c.getPA().movePlayer(Integer.parseInt(arg[1]), Integer.parseInt(arg[2]), Integer.parseInt(arg[3]));
			else if (arg.length == 3)
				c.getPA().movePlayer(Integer.parseInt(arg[1]), Integer.parseInt(arg[2]), c.heightLevel);
		}	

		/**
		 * Teleport to a character.
		 */
		if (playerCommand.startsWith("tele_to")) {
			String name = playerCommand.substring(8);
			for (int i = 0; i < Constants.MAX_PLAYERS; i++) {
				if (PlayerHandler.players[i] != null) {
					if (PlayerHandler.players[i].playerName.equalsIgnoreCase(name)) {
						c.getPA().movePlayer(PlayerHandler.players[i].getX(),
								PlayerHandler.players[i].getY(),
								PlayerHandler.players[i].heightLevel);
						}
					}
				}
			}
		}	
	}
	
	/**
	 * Muting commands.
	 * @param c
	 * @param playerCommand
	 */
	public static void muteCommands(Client c, String playerCommand) {
		if(MUTE_COMMANDS == true) {
			
		/**
		 * Mutes the desired character.
		 */
		if (playerCommand.startsWith("mute") || playerCommand.startsWith("mute_player")) {
				try {
					String playerToMute = playerCommand.substring(5);
					Connection.addNameToMuteList(playerToMute);
					for (int i = 0; i < Constants.MAX_PLAYERS; i++) {
						if (PlayerHandler.players[i] != null) {
							if (PlayerHandler.players[i].playerName.equalsIgnoreCase(playerToMute)) {
								Client c2 = (Client) PlayerHandler.players[i];
								c2.sendMessage(MUTE);
								c.sendMessage("You have muted " + PlayerHandler.players[i].playerName +".");
								break;
							}
						}
					}
				} catch (Exception e) {
					c.sendMessage(PLAYER_OFFLINE);
				}
			}
	
		/**
		 * Unmutes the desired character that is muted.
		 */
		if (playerCommand.startsWith("unmute")) {
			try {
				String playerToMute = playerCommand.substring(7);
				Connection.unMuteUser(playerToMute);
				for (int i = 0; i < Constants.MAX_PLAYERS; i++) {
					if (PlayerHandler.players[i] != null) {
						if (PlayerHandler.players[i].playerName.equalsIgnoreCase(playerToMute)) {
							Client c2 = (Client) PlayerHandler.players[i];
							c2.sendMessage(UNMUTE);
							c.sendMessage("You have unmuted " + PlayerHandler.players[i].playerName +".");
							break;
						}
					}
				}
			} catch (Exception e) {
				c.sendMessage(PLAYER_OFFLINE);
				}
			}
		}	
		
		/**
		 * Mutes the ip of the character.
		 */
		if (playerCommand.startsWith("ipmute") || playerCommand.startsWith("ip_mute") || playerCommand.startsWith("mute_ip")) {
			try {
				String playerToBan = playerCommand.substring(7);
				for (int i = 0; i < Constants.MAX_PLAYERS; i++) {
					if (PlayerHandler.players[i] != null) {
						if (PlayerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
							Connection.addIpToMuteList(PlayerHandler.players[i].connectedFrom);
							c.sendMessage("You have muted the ip address of the user "+ PlayerHandler.players[i].playerName +".");
							Client c2 = (Client) PlayerHandler.players[i];
							c2.sendMessage(MUTE);
							break;
						}
					}
				}
			} catch (Exception e) {
				c.sendMessage(PLAYER_OFFLINE);
			}
		}
		
		/**
		 * Unmutes the ip of the character that has been ip muted.
		 */
		if (playerCommand.startsWith("unipmute") || playerCommand.startsWith("demute") || playerCommand.startsWith("unmute")) {
			try {
				String playerToBan = playerCommand.substring(9);
				for (int i = 0; i < Constants.MAX_PLAYERS; i++) {
					if (PlayerHandler.players[i] != null) {
						if (PlayerHandler.players[i].playerName.equalsIgnoreCase(playerToBan)) {
							Connection.unIPMuteUser(PlayerHandler.players[i].connectedFrom);
							c.sendMessage("You have unmuted the ip address of the user "+ PlayerHandler.players[i].playerName +".");
							break;
						}
					}
				}
			} catch (Exception e) {
				c.sendMessage(PLAYER_OFFLINE);
			}
		}
	}
	/**
	 * URL commands.
	 * @param c
	 * @param playerCommand
	 */
	public static void urlCommands(Client c, String playerCommand) {
		if(URL_COMMANDS == true) {

		/**
		 * Homepage url.
		 */
		if (playerCommand.startsWith("homepage") || playerCommand.startsWith("home") || playerCommand.startsWith("website")) {
			c.getPA().sendFrame126(WEBSITE, 12000);
		}
		
		/**
		 * Community url.
		 */
		if (playerCommand.startsWith("community") || playerCommand.startsWith("forums") || playerCommand.startsWith("forum")) {
			c.getPA().sendFrame126(COMMUNITY, 12000);
		}
		
		/**
		 * Vote url.
		 */
		if (playerCommand.startsWith("vote")) {
			c.getPA().sendFrame126(VOTE, 12000);
		}
		
		/**
		 * Vote url.
		 */
		if (playerCommand.startsWith("donate")) {
			c.getPA().sendFrame126(DONATE, 12000);
		}
		
		/**
		 * Help url.
		 */
		if (playerCommand.startsWith("help")) {
			c.getPA().sendFrame126(HELP, 12000);
			}
		}	
	}	
	
	/**
	 * Player commands.
	 * @param c
	 * @param playerCommand
	 */
	public static void playerCommands(Client c, String playerCommand) {
		if(PLAYER_COMMANDS == true) {
			
		/**
		 * The commands for the urls of the server.
		 */
		urlCommands(c, playerCommand);
		
		/**
		 * Change your password.
		 */
		if (playerCommand.startsWith("change_password") && playerCommand.length() > 15 || playerCommand.startsWith("change_pass") && playerCommand.length() > 15) {
			c.playerPass = playerCommand.substring(15);
			if(CONFIRM_EMAIL == true) {
			c.sendMessage("Congratulations! You changed your password. Go to your email address to confirm the change.");
			}
			if(CONFIRM_EMAIL == false) {
			c.sendMessage("Congratulations! You changed your password. Your new password is "+ c.playerPass +".");
			}
			
			if (playerCommand.startsWith("sound")) {
				int sound = Integer.parseInt(args(playerCommand)[1]);
				c.getPA().sendSound(sound);
				c.sendMessage(""+sound);
			}
			
			if (playerCommand.startsWith("song")) {
				int song = Integer.parseInt(args(playerCommand)[1]);
				c.getPA().sendSong(song);
				c.sendMessage(""+song);
				}
			}
		}
	}
	

       

	/**
	 * NPC commands.
	 * @param c
	 * @param playerCommand
	 */
	public static void npcCommands(Client c, String playerCommand) {
		if(NPC_COMMANDS == true) {

		/**
		 * Spawns an npc.
		 */
		if (playerCommand.startsWith("npc") || playerCommand.startsWith("spawn_npc") || playerCommand.startsWith("pnpc")) {
			try {
				int newNPC = Integer.parseInt(playerCommand.substring(4));
				if (newNPC > 0) {
					Server.npcHandler.spawnNpc(c, newNPC, c.absX, c.absY,
					c.heightLevel, 0, 120, 7, 70, 70, false, false);
					c.sendMessage("You spawn an npc on the choords of: " + c.absX +","+ c.absY +","+ c.heightLevel+".");
				} else {
					c.sendMessage("That npc does not exist in the system.");
				}
			} catch (Exception e) {
				c.sendMessage(HTU);
			}
		}
	}
}

	/**
	 * Other commands.
	 * @param c
	 * @param playerCommand
	 */
	public static void otherCommands(Client c, String playerCommand) {
		if(OTHER_COMMANDS == true) {

		/**
		 * Draws a dialogue.
		 */
		if (playerCommand.startsWith("dialogue")) {
			int npcType = 1552;
			int id = Integer.parseInt(playerCommand.split(" ")[1]);
			c.getDH().sendDialogues(id, npcType);
		}
		
		/**
		 * Draw a graphic.
		 */
		if (playerCommand.startsWith("gfx")) {
			String[] args = playerCommand.split(" ");
			c.gfx0(Integer.parseInt(args[1]));
		}
		
		/**
		 * Draw an animation.
		 */
		if (playerCommand.startsWith("anim")) {
			String[] args = playerCommand.split(" ");
			c.startAnimation(Integer.parseInt(args[1]));
			c.getPA().requestUpdates();
		}
		
		/**
		 * Position of the player.
		 */
		if (playerCommand.equalsIgnoreCase("mypos") || playerCommand.startsWith("choords") || playerCommand.startsWith("pos")) {
			c.sendMessage("Your choordinates are: "+ c.absX +","+ c.absY +","+ c.heightLevel);
			}
		}
	}

	public static String[] args(String command) {
        return command.toLowerCase().split(" ");    
    }
}