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
			
			chatButton = new JButton("Chat");
			appLayout = new SpringLayout();
			chatScrollPane = new JScrollPane();
			appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 25, SpringLayout.WEST, this);
			appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -121, SpringLayout.EAST, this);
			infoLabel = new JLabel("Type to chat with Sanic the Hedgedog");
			appLayout.putConstraint(SpringLayout.WEST, infoLabel, 25, SpringLayout.WEST, this);
			checkerButton = new JButton("Check contents");
			inputField = new JTextField(20);
			appLayout.putConstraint(SpringLayout.SOUTH, infoLabel, -6, SpringLayout.NORTH, inputField);
			appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
			appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatScrollPane);
			chatArea = new JTextArea(10, 25);
			chatScrollPane.setRowHeaderView(chatArea);
			chatArea.setEnabled(false);
			chatArea.setEditable(false);
			appLayout.putConstraint(SpringLayout.EAST, inputField, -14, SpringLayout.WEST, chatButton);
			
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
			
			JLabel lblNewLabel = new JLabel("New label");
			appLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 58, SpringLayout.NORTH, this);
			appLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 6, SpringLayout.EAST, chatScrollPane);
			appLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -57, SpringLayout.NORTH, chatButton);
			appLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -10, SpringLayout.EAST, this);
			lblNewLabel.setIcon(new ImageIcon(ChatPanel.class.getResource("/chat/view/images/sanic.png")));
			add(lblNewLabel);
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
			appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 25, SpringLayout.NORTH, this);
			appLayout.putConstraint(SpringLayout.SOUTH, chatScrollPane, -29, SpringLayout.NORTH, chatButton);
			appLayout.putConstraint(SpringLayout.WEST, chatButton, 350, SpringLayout.WEST, this);
			appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -24, SpringLayout.SOUTH, this);
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

