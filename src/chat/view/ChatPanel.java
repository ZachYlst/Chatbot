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

	public class ChatPanel extends JPanel
	{
		private ChatController appController;
		private JButton chatButton;
		private SpringLayout appLayout;
		private JTextField inputField;
		private JTextArea chatArea;
		private JTextField textField;
		private JButton checkerButton;
		private JScrollPane chatScrollPane;
		private JLabel infoLabel;
		
		public ChatPanel(ChatController appController)
		{
			super();
			this.appController = appController;
			
			chatButton = new JButton("Chat");
			appLayout = new SpringLayout();
			chatArea = new JTextArea(10, 25);
			chatScrollPane = new JScrollPane();
			infoLabel = new JLabel("Type to chat with the Chatbot");
			textField = new JTextField(20);
			checkerButton = new JButton("Check contents");
			
			setupScrollPane();
			setupPanel();
			setupLayout();
			setupListeners();
		}
		
		private void setupPanel()
		{
			this.setBackground(Color.ORANGE);
			this.setLayout(appLayout);
			this.add(chatButton);
			this.add(textField);
			this.add(chatScrollPane);
			this.add(infoLabel);
			chatArea.setEnabled(false);
			chatArea.setEditable(false);
		}
		
		private void setupScrollPane()
		{
			chatScrollPane.setViewportView(chatArea);
			chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		}
		
		private void setupLayout()
		{
			appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 25, SpringLayout.NORTH, this);
			appLayout.putConstraint(SpringLayout.SOUTH, chatScrollPane, -29, SpringLayout.NORTH, chatButton);
			appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, 0, SpringLayout.EAST, chatButton);
			
			appLayout.putConstraint(SpringLayout.WEST, infoLabel, 0, SpringLayout.WEST, textField);
			appLayout.putConstraint(SpringLayout.SOUTH, infoLabel, -6, SpringLayout.NORTH, textField);
			appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 0, SpringLayout.WEST, textField);
			appLayout.putConstraint(SpringLayout.WEST, textField, 25, SpringLayout.WEST, this);
			appLayout.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, chatButton);
			appLayout.putConstraint(SpringLayout.EAST, textField, -14, SpringLayout.WEST, chatButton);
			appLayout.putConstraint(SpringLayout.WEST, chatButton, 350, SpringLayout.WEST, this);
			appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -24, SpringLayout.SOUTH, this);
		}
		
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
		
		private void changeBackgroundColor()
		{
			int red = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			
			this.setBackground(new Color(red, green, blue));
		}
	}

