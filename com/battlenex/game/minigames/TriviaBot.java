package com.battlenex.game.minigames;

import com.battlenex.event.Event;
import com.battlenex.event.EventContainer;
import com.battlenex.event.EventManager;
import com.battlenex.game.players.Player;
import com.battlenex.game.players.PlayerHandler;
import com.battlenex.utils.Utils;
import com.battlenex.game.Client;

public class TriviaBot {
	
	public static Client c;
	
	//Called every cycle to begin the TriviaBot
	public static void startup() {
		EventManager.getSingleton().addEvent(new Event() {
			@Override
			public void execute(EventContainer e) {
				if (getPlayerCount() > 0) {
					askQuestion();
				}
			}
		}, 900000);
	}
	
	//Decides if the answer is correct or not
	public static void attemptAnswer(Player p, String attempt) {
		if (!currentQuestion.equals("") && attempt.replaceAll("_", " ").equalsIgnoreCase(currentAnswer)) {
			currentQuestion = "";
			//p.triviaPoints++;
			//rewardPlayer(p);
			sendServerMessage("Grats! "+p.playerName + " has guessed the question correctly and earned 1 Trivia Point!");
			
			int coinReward = Utils.random(50000);
			p.sendMessage("You've correctly guessed the answer! You recieve 1 Trivia Point & " + coinReward + " Coins!");
			c.getItems().addItem(995, coinReward);
			c.triviaPoints++;
			p.sendMessage("You now have " + c.triviaPoints + " Trivia Points!");
			
		}
	}
	public static boolean acceptingQuestion() {
		return !currentQuestion.equals("");
	}
	
	//Uses the sendServerMessage procedure to yell the question across the server
	public static void askQuestion() {
		final int random = Utils.random(TRIVIA_DATA.length - 1);

		currentQuestion = TRIVIA_DATA[random][0];
		currentAnswer = TRIVIA_DATA[random][1];

		sendServerMessage(currentQuestion);
	}
	
	
	//Called after the correct answer is entered
	/*public static void rewardPlayer(Player p) {
		int coinReward = Utils.random(50000);
		p.sendMessage("You've correctly guessed the answer! You recieve 1 Trivia Point & " + coinReward + " Coins!");
		c.getItems().addItem(995, coinReward);
		c.triviaPoints++;
		p.sendMessage("You now have " + c.triviaPoints + " Trivia Points!");
	}*/
	

	
	private static int getPlayerCount() {
		int players = 0;
		for (Player p : PlayerHandler.players) {
			if (p != null)
				players++;
		}
		return players;
	}
	
	//Used to yell question across the server
	private static void sendServerMessage(String message) {
		for (Player p : PlayerHandler.players) {
			if (p != null) {
				((Client)p).sendMessage(message);
			}
		}
	}
	
	//Add questions and answers here
	private static final String[][] TRIVIA_DATA = {
		{"@dre@[Trivia] Question 1, answer is :  lemon.", "lemon"},
		{"@dre@[Trivia] Question 2, answer is :  orange.", "orange"},
		{"@dre@[Trivia] Question 3, answer is :  pear.", "pear"},
	};
	
	private static String currentQuestion;
	private static String currentAnswer;
	
}
