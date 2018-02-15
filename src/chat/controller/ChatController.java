package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;
import chat.view.ChatFrame;
import chat.view.ChatPanel;

/**
 * The control center of Chatbot
 * @author Zachary Ylst
 * @version 12/8/17
 */
public class ChatController
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	
	/**
	 * Calls to the PopupDisplay and ChatFrame
	 */
	public ChatController()
	{
		chatbot = new Chatbot("Sanic");
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	
	/**
	 * Begins running Chatbot (with a "welcome" message)
	 */
	public void start()
	{
		display.displayText("Welcome to Chatbot!");
		
//		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
//		{
//			response = popupChat(response);
//			response = display.collectResponse(response);
//		}
	}

	/**
	 * The basic "chat" function of the Chatbot
	 * @param chat
	 * @return
	 */
	private String popupChat(String chat)
	{
		String chatbotSays = "";		//assigns a valid value for the returned variable of the method
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	/**
	 * Allows you to interact (talk) with the Chatbot
	 * @param input
	 * @return
	 */
	public String interactWithChatbot(String input)
	{
		String chatbotSays = "";
		
		if(chatbot.quitChecker(input))
		{
			close();
		}
		
		chatbotSays += chatbot.processConversation(input);
		
		return chatbotSays;
	}
	
	/**
	 * Calls access to Chatbot checker methods
	 * @param text
	 * @return
	 */
	public String useCheckers(String text)
	{
		String response = "";
		
		if(chatbot.contentChecker(text))
		{
			response += "This text matches the special content\n";
		}
		if(chatbot.cuteAnimalMemeChecker(text))
		{
			response += "";
		}
		if(chatbot.htmlTagChecker(text))
		{
			response += "";
		}
		if(chatbot.userNameChecker(text))
		{
			response += "";
		}
		if(chatbot.contentChecker(text))
		{
			response += "";
		}
		if(chatbot.shoppingListChecker(text))
		{
			response += "";
		}
		if(chatbot.movieTitleChecker(text))
		{
			response += "";
		}
		if(chatbot.movieGenreChecker(text))
		{
			response += "";
		}
		if(chatbot.keyboardMashChecker(text))
		{
			response += "";
		}
		
		//continue with all checkers except length and quit checker
		
		return response;
	}
	
	/**
	 * Closes the application
	 */
	private void close()
	{
		display.displayText("Goodbye!");
		System.exit(0);
	}
}
