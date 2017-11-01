package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	private List<String> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<String>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = null;
		this.currentTime = null;
		this.questions = new String [10];
		this.username = username;
		this.content = null;
		this.intro = null;
		this.topics = new String [7];
		this.verbs = new String [4];
		this.followUps = new String [5];
		
		buildVerbs();
		buildFollowups();
		buildShoppingList();
		buildMovieList();
		buildQuestions();
	}

	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}
	
	private void buildMovieList()
	{
		movieList.add("Shrek");
		movieList.add("Shrek 2");
		movieList.add("Shrek 3");
		movieList.add("Shrek 4");
		movieList.add("The Bee Movie");
		movieList.add("The Emoji Movie");
	}
	
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("fruits");
		shoppingList.add("slug bait");
		shoppingList.add("dairy");
		shoppingList.add("corn");
		shoppingList.add("peas");
		shoppingList.add("cheese");
		shoppingList.add("apples");
		shoppingList.add("soup");
	}
	
	private void buildCuteAnimals()
	{
		
	}
	
	private void buildQuestions()
	{
		questions[0] = "What is your name?";
		questions[1] = "How old are you?";
		questions[2] = "Where do you live?";
		questions[3] = "What do you like to do?";
		questions[4] = "Do you have any pets?";
		questions[5] = "Are you a boy or a girl?";
		questions[6] = "How many siblings do you have?";
		questions[7] = "What grade are you in?";
		questions[8] = "What ethnicity are you?";
		questions[9] = "What is your favorite movie?";
	}
	
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "You said: " + "\n" + input + "\n";
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	private String buildChatbotResponse()
	{
		String response = "";
		
		return response;
	}
	
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if (input != null)		//if (input != null && input.length() > 2)
		{
			if (input.length() > 2)
			{
				validLength = true;
			}
		}
		return validLength;
	}
	
	public boolean htmlTagChecker(String input)
	{
		return false;
	}
	
	public boolean userNameChecker(String input)
	
	{
		if (input.length -1)
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		return false;
	}

	public boolean keyboardMashChecker(String sample)
	{
		return false;
	}
	
	public List<String> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return questions;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return null;
	}
	
	public LocalTime getCurrentTime()
	{
		return null;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
