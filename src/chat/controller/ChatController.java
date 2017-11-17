package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;
import chat.view.ChatFrame;

public class ChatController
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	
	public ChatController()
	{
		chatbot = new Chatbot("Zachary Ylst");
		display = new PopupDisplay();
	}
	
	public void start()
	{
		display.displayText("Welcome to Chatbot!");
		
//		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
//		{
//			response = popupChat(response);
//			response = display.collectResponse(response);
//		}
	}

	private String popupChat(String chat)
	{
		String chatbotSays = "";		//assigns a valid value for the returned variable of the method
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	private String interactWithChatbot(String input)
	{
		String chatbotSays = "";
		
		if(chatbot.quitChecker(input))
		{
			close();
		}
		
		chatbotSays += chatbot.processConversation(input);
		
		return chatbotSays;
	}
	
	private void close()
	{
		display.displayText("Goodbye!");
		System.exit(0);
	}
}
