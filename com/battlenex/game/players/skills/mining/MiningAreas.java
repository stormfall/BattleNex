package com.battlenex.game.players.skills.mining;

import com.battlenex.game.Client;
import com.battlenex.game.players.PacketType;

public abstract class MiningAreas implements PacketType {

	public MiningAreas() {
	}
	
	static Client c;
	static int i;


	public static void processObjects() {
		switch (i) {	
			default:
			break;
					case 2109: //essence
						c.mining[0] = 1436;
						c.mining[1] = 1;
						c.mining[2] = 9;
						c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
					break;

					
					case 2090://copper
					case 2091:
						c.mining[0] = 436;
						c.mining[1] = 1;
						c.mining[2] = 12;
						c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
					break;
					
					case 2094://tin
						c.mining[0] = 438;
						c.mining[1] = 1;
						c.mining[2] = 12;
						c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
					break;		
					
					case 145856:
					case 2092:
					case 2093: //iron
						c.mining[0] = 440;
						c.mining[1] = 15;
						c.mining[2] = 24;
						c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
					break;

					case 4029:
					case 4030:		
					case 4028: //lime
						c.mining[0] = 3211;
						c.mining[1] = 22;
						c.mining[2] = 29;
						c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
					break;

					case 14850:
					case 14851:
					case 14852:
					case 2096:
					case 2097: //coal
						c.mining[0] = 453;
						c.mining[1] = 30;
						c.mining[2] = 48;
						c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
					break;		
					
					case 2098:
					case 2099: //gold
						c.mining[0] = 444;
						c.mining[1] = 40;
						c.mining[2] = 71;
						c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
					break;
					
					case 2102:
					case 2103:
					case 14853:
					case 14854:
					case 14855: //mith ore
						c.mining[0] = 447;
						c.mining[1] = 55;
						c.mining[2] = 96;
						c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
					break;
					
					case 2105:
					case 14862: //addy ore
						c.mining[0] = 449;
						c.mining[1] = 65;
						c.mining[2] = 125;
						c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
					break;
					
					case 2106:
					case 2107:
					case 14859:
					case 14860: //rune ore
						c.mining[0] = 451;
						c.mining[1] = 75;
						c.mining[2] = 190;
						c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
					break;

					case 2110: //blurite
						c.mining[0] = 668;
						c.mining[1] = 86;
						c.mining[2] = 320;
						c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
					break;

					case 3403: //elemental
						c.mining[0] = 2892;
						c.mining[1] = 93;
						c.mining[2] = 700;
						c.getMining().startMining(c.mining[0], c.mining[1], c.mining[2]);
					break;
		}
	}
}
