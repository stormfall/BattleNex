package com.battlenex.game.players.packets;

import com.battlenex.game.Client;


/**
 * Interface button validation
 * @author Indrek
 *
 */
public class Interface {
	
	public static int BANK = 18788;
	public static int GRAND_EXCHANGE = 19032;
	public static int GRAND_EXCHANGE_SELL = 19126;
	public static int GRAND_EXCHANGE_COLLECT = 19181;
	public static int GRAND_EXCHANGE_SEARCH = 19189;
	public static int GRAND_EXCHANGE_BUY = 19256;
	
	public static int TRADE = 3323;
	public static int TRADE_2 = 3443;
	
	public static int DUEL = 6575;
	public static int DUEL_CONFIRM = 6412;
	public static int DUEL_CLAIM = 6733;
	
	public static int PARTYROOM_CHEST = 2156;
	public static int SHOP = 19342;
	public static int EQUIPMENT = 19451;
	
	private Client c;
	public Interface(Client c) {
		this.c = c;
	}
	
	enum Data {
		GRAND_EXCHANGE(19032, new int[]{74177, 74176, 74175, 74141, 74129, 74117, 74243, 74180}, true),
		GRAND_EXCHANGE_SEARCH(19189, new int[]{75051, 74250}, true),
		GRAND_EXCHANGE_BUY(19256, new int[]{75083, 75069, 75070, 75071, 75072, 75073, 75074, 75075, 75084}, true),
		GRAND_EXCHANGE_SELL(19126, new int[]{74195, 74194, 74202, 74208, 74209, 74210, 74211, 74197, 74196, 74212, 74213, 74214, 74215, 74231, 74232}, true),
		BANK(18788, new int[]{73112, 73116, 73117, 73119, 75139}, true),
		TRADE_MAIN(3323, new int[]{13092}, false),
		TRADE_CONFIRM(3443, new int[]{13218}, false),
		DUEL_MAIN(6575, new int[]{53245, 53246, 53247, 53248, 53249, 53250, 53251, 53252, 53253, 53254, 53255, 26066, 26048, 26069, 26042, 26070, 26043, 26071, 26041, 26072, 26045, 26073, 26046, 26074, 26047, 26076, 26075, 2157, 2158, 26018}, false),
		DUEL_CONFIRM(6412, new int[]{25120}, false);
		
	    int[] values;
	    int interfaceId;
	    boolean sendMessage;
	    
	    Data(int id, int[] values, boolean sendMessage) {
	    	this.interfaceId = id;
	        this.values = values;
	        this.sendMessage = sendMessage;
	    }
	    
	    public int getId() {
	    	return interfaceId;
	    }

	    public int[] getValues() {
	        return values;
	    }
	    
	    public boolean hasMessage() {
	    	return sendMessage;
	    }
		
	}
	
	public boolean hasMessage(int interfaceId) {
		for(Data d : Data.values()) {
			if(d.getId() == interfaceId && d.hasMessage())
				return true;
		}
		return false;
	}
	
	/**
	 * Checks if the specific id is equal to our currently open interface.
	 * @param id
	 * @return
	 */
	public boolean openInterface(int id) {
		if(c.openInterfaceId == id) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Checks if an interface is a part of our system.
	 * @param interfaceId
	 * @return
	 */
	public boolean isInterface(int interfaceId) {
		for(Data d : Data.values()) {
			if(d.getId() == interfaceId) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns true if the specific button is a part ouf our system.
	 * @param button
	 * @return
	 */
	public static boolean isInterfaceButton(int button) {
		for (Data d : Data.values()) {
			for(int i = 0; i<d.getValues().length; i++) {
				if(d.getValues()[i] == button) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Checks if an a button represents an interface button.
	 * @param interfaceId
	 * @param button
	 * @return
	 */
	public static boolean isInterfaceButton(int interfaceId, int button) {
		for (Data d : Data.values()) {
			if(d.getId() == interfaceId) {
				for(int i = 0; i<d.getValues().length; i++) {
					if(d.getValues()[i] == button) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
