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

	public class ChatPanel extends JPanel
	{
		private ChatController appController;
		private JButton chatButton;
		private SpringLayout appLayout;
		private JTextField inputField;
		private JTextArea chatArea;
		private JTextField textField;
		
		public ChatPanel(ChatController appController)
		{
			super();
			this.appController = appController;
			chatButton = new JButton("Chat");
			appLayout = new SpringLayout();
			
			
			setupPanel();
			setupLayout();
			setupListeners();
		}
		
		private void setupPanel()
		{
			this.setBackground(Color.ORANGE);
			this.setLayout(appLayout);
			this.add(chatButton);
			
			textField = new JTextField();
			appLayout.putConstraint(SpringLayout.WEST, textField, 24, SpringLayout.WEST, this);
			appLayout.putConstraint(SpringLayout.EAST, textField, -124, SpringLayout.EAST, this);
			appLayout.putConstraint(SpringLayout.NORTH, chatButton, 0, SpringLayout.NORTH, textField);
			appLayout.putConstraint(SpringLayout.WEST, chatButton, 24, SpringLayout.EAST, textField);
			appLayout.putConstraint(SpringLayout.SOUTH, textField, -27, SpringLayout.SOUTH, this);
			add(textField);
			textField.setColumns(10);
			
			JScrollPane scrollPane = new JScrollPane();
			appLayout.putConstraint(SpringLayout.NORTH, scrollPane, 22, SpringLayout.NORTH, this);
			appLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, textField);
			appLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 221, SpringLayout.NORTH, this);
			appLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, chatButton);
			add(scrollPane);
		}
		
		private void setupLayout()
		{
			
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
		}	
		
		private void changeBackgroundColor()
		{
			int red = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			
			this.setBackground(new Color(red, green, blue));
		}
	}

