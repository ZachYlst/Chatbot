package chat.view;

import chat.controller.ChatbotController;
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
		private ChatbotController appController;
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
		private JLabel sanicLabel;
		
		/**
		 * Creates/establishes the panel used to chat with Chatbot
		 * @param appController
		 */
		public ChatPanel(ChatbotController appController)
		{
			super();
			this.appController = appController;
				
			chatButton = new JButton("Chat", new ImageIcon(getClass().getResource("/chat/view/images/chat.png")));
		    loadButton = new JButton("Load", new ImageIcon(getClass().getResource("/chat/view/images/load.png")));
		    saveButton = new JButton("Save", new ImageIcon(getClass().getResource("/chat/view/images/save.png")));
		    	tweetButton = new JButton("Tweet", new ImageIcon(getClass().getResource("/chat/view/images/tweet.png")));
		    	searchButton = new JButton("Search", new ImageIcon(getClass().getResource("/chat/view/images/search.png")));
		    	infoLabel = new JLabel("Type to chat with the chatbot");
		    	sanicLabel = new JLabel(new ImageIcon(getClass().getResource("/chat/view/images/sanic.png")));
			appLayout = new SpringLayout();
			appLayout.putConstraint(SpringLayout.NORTH, sanicLabel, 86, SpringLayout.NORTH, this);
			appLayout.putConstraint(SpringLayout.SOUTH, sanicLabel, -61, SpringLayout.NORTH, searchButton);
			appLayout.putConstraint(SpringLayout.EAST, sanicLabel, -18, SpringLayout.EAST, chatButton);
			appLayout.putConstraint(SpringLayout.NORTH, loadButton, 6, SpringLayout.SOUTH, chatButton);
			appLayout.putConstraint(SpringLayout.NORTH, infoLabel, 0, SpringLayout.NORTH, chatButton);
			appLayout.putConstraint(SpringLayout.EAST, infoLabel, -63, SpringLayout.WEST, tweetButton);
			appLayout.putConstraint(SpringLayout.WEST, chatButton, 15, SpringLayout.EAST, tweetButton);
			appLayout.putConstraint(SpringLayout.EAST, chatButton, -23, SpringLayout.EAST, this);
			appLayout.putConstraint(SpringLayout.NORTH, tweetButton, 325, SpringLayout.NORTH, this);
			appLayout.putConstraint(SpringLayout.NORTH, searchButton, 247, SpringLayout.NORTH, this);
			appLayout.putConstraint(SpringLayout.WEST, searchButton, 453, SpringLayout.WEST, this);
			appLayout.putConstraint(SpringLayout.SOUTH, searchButton, -6, SpringLayout.NORTH, chatButton);
			appLayout.putConstraint(SpringLayout.EAST, searchButton, 0, SpringLayout.EAST, chatButton);
			appLayout.putConstraint(SpringLayout.NORTH, chatButton, 0, SpringLayout.NORTH, tweetButton);
			appLayout.putConstraint(SpringLayout.EAST, saveButton, 0, SpringLayout.EAST, tweetButton);
			appLayout.putConstraint(SpringLayout.EAST, tweetButton, -162, SpringLayout.EAST, this);
			appLayout.putConstraint(SpringLayout.WEST, loadButton, 453, SpringLayout.WEST, this);
			appLayout.putConstraint(SpringLayout.EAST, loadButton, -23, SpringLayout.EAST, this);
//			chatScrollPane = new JScrollPane();
			checkerButton = new JButton("Check contents");
			inputField = new JTextField(20);
			appLayout.putConstraint(SpringLayout.NORTH, inputField, 357, SpringLayout.NORTH, this);
			appLayout.putConstraint(SpringLayout.SOUTH, inputField, -25, SpringLayout.SOUTH, this);
			appLayout.putConstraint(SpringLayout.SOUTH, infoLabel, -6, SpringLayout.NORTH, inputField);
			appLayout.putConstraint(SpringLayout.WEST, saveButton, 21, SpringLayout.EAST, inputField);
			appLayout.putConstraint(SpringLayout.SOUTH, saveButton, 0, SpringLayout.SOUTH, inputField);
			appLayout.putConstraint(SpringLayout.WEST, tweetButton, 21, SpringLayout.EAST, inputField);
			appLayout.putConstraint(SpringLayout.SOUTH, loadButton, 0, SpringLayout.SOUTH, inputField);
			appLayout.putConstraint(SpringLayout.WEST, inputField, 23, SpringLayout.WEST, this);
			appLayout.putConstraint(SpringLayout.EAST, inputField, -307, SpringLayout.EAST, this);
			
//			setupScrollPane();
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
//			this.add(chatScrollPane);
			this.add(infoLabel);
			this.add(sanicLabel);
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
			appLayout.putConstraint(SpringLayout.WEST, sanicLabel, 28, SpringLayout.EAST, chatArea);
			appLayout.putConstraint(SpringLayout.SOUTH, chatArea, -12, SpringLayout.NORTH, tweetButton);
			appLayout.putConstraint(SpringLayout.EAST, chatArea, 0, SpringLayout.EAST, tweetButton);
			appLayout.putConstraint(SpringLayout.NORTH, chatArea, 28, SpringLayout.NORTH, this);
			appLayout.putConstraint(SpringLayout.WEST, chatArea, 30, SpringLayout.WEST, this);
			add(chatArea);
			chatArea.setEnabled(false);
			chatArea.setEditable(false);
		}
		
		/**
		 * Sets up the text field Chatbot uses to communicate
		 */
//		private void setupScrollPane()
//		{
//			chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//			chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//		}
		
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
					appController.tweet(inputField.getText());
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
					String usernameToSearch = inputField.getText();
					
					chatArea.setText(appController.search(inputField.getText()));
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

