package chat.view;

import chat.controller.ChatController;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SpringLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

	/**
	 * The GUI (interface) for Chatbot
	 * @author Zachary Ylst
	 * @version 12/8/17
	 */
	public class ChatPanel extends JPanel
	{
		private ChatController appController;
		private JButton chatButton;
		private JButton searchButton;
		private JButton saveButton;
		private JButton loadButton;
		private JButton tweetButton;
		private SpringLayout appLayout;
		private JTextField inputField;
		private JTextArea chatArea;
		private JButton checkerButton;
		private JScrollPane chatScrollPane;
		private JLabel infoLabel;
		
		/**
		 * Creates/establishes the panel used to chat with Chatbot
		 * @param appController
		 */
		public ChatPanel(ChatController appController)
		{
			super();
			this.appController = appController;
			
			chatButton = new JButton("Chat", new ImageIcon(getClass().getResource("/chat/view/images/chat.png")));
		    loadButton = new JButton("Load", new ImageIcon(getClass().getResource("/chat/view/images/load.png")));
		    saveButton = new JButton("Save", new ImageIcon(getClass().getResource("/chat/view/images/save.png")));
		    	tweetButton = new JButton("Tweet", new ImageIcon(getClass().getResource("/chat/view/images/tweet.png")));
		    	searchButton = new JButton("Search", new ImageIcon(getClass().getResource("/chat/view/images/search.png")));
		    	infoLabel = new JLabel("Type tochat with the chatbot");
			appLayout = new SpringLayout();
			appLayout.putConstraint(SpringLayout.NORTH, chatButton, -30, SpringLayout.NORTH, tweetButton);
			appLayout.putConstraint(SpringLayout.WEST, chatButton, 43, SpringLayout.EAST, tweetButton);
			appLayout.putConstraint(SpringLayout.SOUTH, searchButton, -22, SpringLayout.SOUTH, this);
			appLayout.putConstraint(SpringLayout.WEST, searchButton, 74, SpringLayout.WEST, this);
			appLayout.putConstraint(SpringLayout.WEST, tweetButton, 22, SpringLayout.EAST, saveButton);
			appLayout.putConstraint(SpringLayout.SOUTH, loadButton, -61, SpringLayout.SOUTH, this);
			appLayout.putConstraint(SpringLayout.SOUTH, saveButton, -57, SpringLayout.SOUTH, this);
			appLayout.putConstraint(SpringLayout.WEST, saveButton, 6, SpringLayout.EAST, loadButton);
			appLayout.putConstraint(SpringLayout.WEST, loadButton, 10, SpringLayout.WEST, this);
			chatScrollPane = new JScrollPane();
			appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 25, SpringLayout.NORTH, this);
			appLayout.putConstraint(SpringLayout.SOUTH, chatScrollPane, -82, SpringLayout.SOUTH, this);
			appLayout.putConstraint(SpringLayout.WEST, infoLabel, 27, SpringLayout.EAST, chatScrollPane);
			checkerButton = new JButton("Check contents");
			inputField = new JTextField(20);
			appLayout.putConstraint(SpringLayout.NORTH, tweetButton, 36, SpringLayout.SOUTH, inputField);
			appLayout.putConstraint(SpringLayout.WEST, inputField, 19, SpringLayout.EAST, chatScrollPane);
			appLayout.putConstraint(SpringLayout.EAST, inputField, -23, SpringLayout.EAST, this);
			
			setupScrollPane();
			setupPanel();
			setupLayout();
			setupListeners();
			changeBackgroundColor();
		}
		
		/**
		 * Adds various components to the Chatbot panel
		 */
		private void setupPanel()
		{
			this.setBackground(Color.ORANGE);
			this.setLayout(appLayout);
			this.add(chatButton);
			this.add(inputField);
			this.add(chatScrollPane);
			this.add(infoLabel);
			this.add(tweetButton);
			this.add(saveButton);
			this.add(loadButton);
			this.add(searchButton);
			
			JLabel lblNewLabel = new JLabel("New label");
			appLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 24, SpringLayout.SOUTH, infoLabel);
			appLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 6, SpringLayout.EAST, chatScrollPane);
			appLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -38, SpringLayout.NORTH, tweetButton);
			appLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -10, SpringLayout.EAST, this);
			chatArea = new JTextArea(10, 25);
			appLayout.putConstraint(SpringLayout.NORTH, inputField, 6, SpringLayout.SOUTH, chatArea);
			appLayout.putConstraint(SpringLayout.SOUTH, infoLabel, -9, SpringLayout.NORTH, chatArea);
			appLayout.putConstraint(SpringLayout.NORTH, chatArea, 35, SpringLayout.NORTH, this);
			appLayout.putConstraint(SpringLayout.WEST, chatArea, 19, SpringLayout.EAST, chatScrollPane);
			appLayout.putConstraint(SpringLayout.SOUTH, chatArea, -149, SpringLayout.SOUTH, this);
			appLayout.putConstraint(SpringLayout.EAST, chatArea, -22, SpringLayout.EAST, this);
			add(chatArea);
			chatArea.setEnabled(false);
			chatArea.setEditable(false);
		}
		
		/**
		 * Sets up the text field Chatbot uses to communicate
		 */
		private void setupScrollPane()
		{
			chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		}
		
		/**
		 * Sets up the ScrollPane and button within the panel
		 */
		private void setupLayout()
		{
			
		}
		
		/**
		 * "Listens" for an action, then acts upon it
		 */
		private void setupListeners()
		{
			chatButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{
					String userText = inputField.getText();
					String displayText = appController.interactWithChatbot(userText);
					chatArea.append(displayText);
					inputField.setText("");
				}
			});
			
			checkerButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{
					String userText = inputField.getText();
					String displayText = appController.useCheckers(userText);
					chatArea.append(displayText);
					inputField.setText("");
				}
			});
			
			tweetButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{
					
				}				
			});
			
			saveButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{
					
				}			
			});
			
			loadButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{
					
				}				
			});
			
			searchButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{
					
				}				
			});
	}
		
		/**
		 * Changes the background color of the panel 
		 */
		private void changeBackgroundColor()
		{
			int red = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			
			this.setBackground(new Color(red, green, blue));
		}
	}

