package chat.controller;

import chat.view.PopupDisplay;

public class ChatRunner
{
	public static void main(String [] args)
	{
		PopupDisplay sample = new PopupDisplay();
		sample.displayText("got 2 go fast");
		sample.collectResponse("do you got 2 go fast?");
		
		ChatController myApp = new ChatController();
		myApp.start();
	}
}
