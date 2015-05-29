package com.battlenex.utils;

import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author thaBoom
 *
 */

public class Jarvis extends PrintStream {

	/**
	 * Name of the bot.
	 */
	private final static String NAME = "Jarvis";

	/**
	 * Greeting text.
	 */
	public final static String GREETING = "Hello, "+ System.getProperty("user.name") +"!";

	/**
	 * Instances
	 */
	private DateFormat dateFormat = new SimpleDateFormat();
	private Date cachedDate = new Date();
	private SimpleTimer refreshTimer = new SimpleTimer();
	
	/**
	 * Constructor of the class.
	 * @param out
	 */
	public Jarvis(PrintStream out) {
		super(out);
	}
	
	/**
	 * Sends the greeting message.
	 * @param text
	 */
	public static void init() {
		printText(GREETING);
	}
	
	/**
	 * Gets the prefix.
	 * @return
	 */
	private String getPrefix() {
		if (refreshTimer.elapsed() > 1000) {
			refreshTimer.reset();
			cachedDate = new Date();
		}
		return dateFormat.format(cachedDate);
	}
	
	/**
	 * Handles the printing of the text.
	 * @param text
	 */
	public void print(String text) {
		if (text.startsWith("debug:"))
			super.print("[" + getPrefix() + "] DEBUG: " + text.substring(6));
		else
			super.print("[" + getPrefix() + "]: " + text);
	}
	
	/**
	 * Prints the text.
	 * @param text
	 */
	public static void printText(String text) {
		System.out.println(text);
	}
	
	/**
	 * Prints text 1 and text 2.
	 * @param text1
	 * @param text2
	 */
	public static void printText2(String text1, String text2) {
		System.out.printf(text1, text2);
	}
}
