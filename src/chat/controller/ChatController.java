package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;

public class ChatController
{
	private Chatbot chatbot;
	private PopupDisplay display;
	
	public ChatController()
	{
		chatbot = new Chatbot("Zachary Ylst");
		display = new PopupDisplay();
	}
	
	public void start()
	{
		String response = display.collectResponse("What do you want to talk about?");
		
		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
		{
			response = popupChat(response);
			response = display.collectResponse(response);
		}
	}
	
	public String interactWithChatbot(String input)
	{
		
	}
	
	private String popupChat(String chat)
	{
		String chatbotSays = "";		//assigns a valid value for the returned variable of the method
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
}
