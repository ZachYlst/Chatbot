package chat.controller;

import chat.view.PopupDisplay;

/**
 * Runs the application
 * @author Zachary Ylst
 * @version 12/8/17
 */
public class ChatRunner
{
	public static void main(String [] args)
	{
		ChatbotController myApp = new ChatbotController();
		myApp.start();
	}
}
