package chat.view;

import chat.controller.ChatController;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	
	private ChatController appController;
	
	public ChatFrame(ChatController appController)
	{
		super();
		this.appController = appController;
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setVisible(true);
	}
}
