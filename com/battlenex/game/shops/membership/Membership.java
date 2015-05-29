package com.battlenex.game.shops.membership;

import java.util.Calendar;

import com.battlenex.Server;
import com.battlenex.game.Client;
import com.battlenex.game.players.Player;

public class Membership {

	public static final int MEMBERSHIP_LENGTH = 29;
	
	static Server Server = new Server();
	
	private static Client c;
	private static Player player;
	private static int startDate;
	private static boolean membershipActive;
	
	public Membership(Player player) {
		this.player = player;
	}
	
	public int getMembershipDays() {
		return (MEMBERSHIP_LENGTH - (getDate() - startDate));
	}
	
	private static int getDate() {
		int day = Server.getCalendar().get(Calendar.DAY_OF_MONTH);
		int month = Server.getCalendar().get(Calendar.MONTH);
		return (month * 100 + day);
	}
	
	public void checkDate() {
		if(membershipActive && startDate <= 0) {
			startDate = getDate();
		} else if(getMembershipDays() <= 0) {
			membershipActive = false;
			startDate = -1;
		}
	}
	
	public static void startMembership() {
		startDate = getDate();
		membershipActive = true;
		c.sendMessage("@blu@You have just subscribed for a "+MEMBERSHIP_LENGTH+" days membership!");
	}
	
	public void setMembershipActive(boolean memebershipActive) {
		this.membershipActive = memebershipActive;
	}
	
	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}
	
	public static boolean getMembershipActive() {
		return membershipActive;
	}
	
	public int getStartDate() {
		return startDate;
	}

}
