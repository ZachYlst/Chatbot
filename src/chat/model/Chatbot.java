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
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = null;
		this.questions = new String [10];
		this.username = username;
		this.content = null;
		this.intro = null;
		this.topics = new String [7];
		this.verbs = new String [4];
		this.followUps = new String [5];
		
		buildVerbs();
		buildTopics();
		buildFollowups();
		buildShoppingList();
		buildMovieList();
		buildQuestions();
	}

	/**
	 * Verbs the Chatbot can access to display feelings
	 */
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}
	
	/**
	 * Movies the Chatbot actively recognizes
	 */
	private void buildMovieList()
	{
		movieList.add("Shrek");
		movieList.add("Shrek 2");
		movieList.add("Shrek 3");
		movieList.add("Shrek 4");
		movieList.add("The Bee Movie");
		movieList.add("The Emoji Movie");
	}
	
	/**
	 * Items the Chatbot recognizes as part of a shopping list
	 */
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
	
	private void buildFollowups()
	{
		
	}
	
	private void buildTopics()
	{
		
	}
	
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("FLOOFER");
		cuteAnimalMemes.add("kittie");
	}
	
	/**
	 * Questions the Chatbot is given access to ask
	 */
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
	
	/**
	 * Takes the user's text input; processes and returns a string
	 * @param input The user's supplied text
	 * @return The combined user input and chatbot response
	 */
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "You said: " + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	/**
	 * Builds random responses using chatbot's sentence part arrays
	 * @return The random chatbot response
	 */
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		random = (int) (Math.random() * 2);
		
		if (random % 2 == 0)
		{
		random = (int) (Math.random() * movieList.size());
		response += "\n" + movieList.get(random).getTitle() + " is a great movie!";
		}
		
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
		if (input.contains("<>") | input.contains("< >") | input.contains("<B> ") | input.contains("<A HREF> </a>"))
		{
			return false;
		}
		if (input.contains("<B> </B>") | input.contains("<I> sdadas </i>") | input.contains("<P>") | input.contains("<A HREF=\"sdfs.html\" </a>"))
		{
			return true;
		}
		return true;
	}
	
	public boolean userNameChecker(String input)
	{
		if (input.equals(""))
		{
			return false;
		}
		if (input != "@" + "")
		{
			return false;
		}
		if (input.contentEquals(null))
		{
			return false;
		}
		if (input.contains("@@"))
		{
			return false;
		}
		if (input.contains(".com"))
		{
			return false;
		}
		return true;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return true;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		if (input.contains("pepe"))
		{
			return false;
		}
		if (input.contains("pupper"))
		{
			return true;
		}
		if (input.contains("otter"))
		{
			return true;
		}
		if (input.contains("kittie"))
		{
			return true;
		}
		
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		if (shoppingItem.contains("protein") | shoppingItem.contains("veggies") | shoppingItem.contains("snacks"))
		{
			return true;
		}
		if (shoppingItem.contains("slug bait"))
		{
			return false;
		}
//		if (shoppingItem.contains("veggies"))
//		{
//			return true;
//		}
//		if (shoppingItem.contains("snacks"))
//		{
//			return true;
//		}
		
		return true;
	}
	
	public boolean movieTitleChecker(String title)
	{
		if (title.contentEquals(""))
		{
			return false;
		}
		if (title.contains("Spiderman"))
		{
			return true;
		}
		if (title.contains("Hidden Figures"))
		{
			return true;
		}
		
		return true;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		if (genre.contentEquals(""))
		{
			return false;
		}
		if (genre.contains("Documentary"))
		{
			return true;
		}
		if (genre.contains("Thriller"))
		{
			return true;
		}
		
		return true;
	}

	public boolean quitChecker(String exitString)
	{
		if (exitString != null && exitString.equalsIgnoreCase("quit"))
		{
			return true;
		}
		return false;
	}

	public boolean keyboardMashChecker(String sample)
	{
		if (sample.equals("S.D.F."))
		{
			return false;
		}
		if (sample.equals("derf"))
		{
			return false;
		}
		return true;
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
		return intro;
	}
	
	public LocalTime getCurrentTime()
	{
		return currentTime;
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
