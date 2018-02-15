package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * The knowledge of the Chatbot
 * @author Zachary Ylst
 * @version 11/21/17
 */
public class Chatbot
{
	private List<String> movieList;
	private List<String> shoppingList;
	private String [] cute;
	private String [] verbs;
	private List<String> topics;
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
		this.cute = new String [3];
		this.currentTime = LocalTime.now();
		this.questions = new String [10];
		this.username = username;
		this.content = null;
		this.intro = null;
		this.topics = new ArrayList<String>();
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
		verbs[2] = "am neutral about";
		verbs[3] = "am in love with";
	}
	
	/**
	 * Movies the Chatbot actively recognizes
	 */
	private void buildMovieList()
	{
		movieList.add("Shrek");
		movieList.add("Shrek 2");
		movieList.add("Shrek 3");
		movieList.add("Veggie Tales");
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
	
	/**
	 * Phrases the Chatbot can use to follow up responses
	 */
	private void buildFollowups()
	{
		followUps[0] = "(got2goFast)";
	}
	
	/**
	 * Topics the Chatbot can access to talk about
	 */
	private void buildTopics()
	{
		topics.add("school");
		topics.add("family");
		topics.add("friends");
		topics.add("doing things");
		topics.add("sports");
		topics.add("love");
		topics.add("death");
		topics.add("movies");
		topics.add("video games");
		topics.add("satanic rituals");
	}
	
	/**
	 * List of animals that are used in cute animal memes
	 */
	private void buildCuteAnimals()
	{
		cute[0] = ("otter");
		cute[1] = ("FLOOFER");
		cute[2] = ("kittie");
		
		int otterCount = 1;
		int flooferCount = 2;
		int kittieCount = 4;
		
		if (cute[0 | 1 | 2].contains("otter"))
		{
			otterCount += 1;
		}
		
		if (cute[0 | 1 | 2].contains("FLOOFER"))
		{
			flooferCount += 1;
		}
		if (cute[0 | 1 | 2].contains("kittie"))
		{
			kittieCount += 1;
		}
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
		chatbotResponse += currentTime.getHour() + ":" + currentTime.getMinute() + " ";
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
		
		random = (int) (Math.random() * topics.size());
		response += " " + topics.get(random) + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		random = (int) (Math.random() * 2);
		
		if (random % 2 == 0)
		{
		random = (int) (Math.random() * movieList.size());
		response += "\n" + movieList.get(random) + " is a great movie!";
		}
		
		int followup = (int) (Math.random() * 5);
		response += "\n" + followUps[0] + "\n\n";
		
//		switch (followup)
//		{
//		case 0:
//			response += "\n" + followUps[0] + "\n";
//			break;
//		case 3:
//			response += "\n" + followUps[1] + "\n";
//		case 1:
//			response += "\n" + followUps[2] + "\n";
//			break;
//		default:
//			response += "\n" + followUps[4] + "\n";
//			response += "\n" + followUps[3] + "\n";
//			break;
//		}
		
		return response;
	}
	
	//Makes sure Chatbot follows certain parameters for each method
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
		boolean containsHTML = false;
		if (input == null || !input.contains("<"))
		{
			return containsHTML;
		}
		int firstOpen = input.indexOf("<");
		int firstClose = input.indexOf(">",firstOpen);
		int secondOpen = -9;
		int secondClose = -9;
		String tagText = "";
		
		//Check bad tags
		if (input.contains("<>") || input.indexOf("< >") > -1)
		{
			containsHTML = false;
		}
		//Check singleton
		if (input.toUpperCase().contains("<P>") || input.toLowerCase().contains("<br>"))
		{
			containsHTML = true;
		}
		//Check others
		else if (firstClose > firstOpen)
		{
			//Others
			tagText = input.substring(firstOpen + 1, firstClose).toLowerCase();
			secondOpen = input.toLowerCase().indexOf("</" + tagText, firstClose);
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
	
	//Gives the Chatbot access to various methods/Arrays
	public List<String> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public String[] getCuteAnimalMemes()
	{
		return cute;
	}

	public String[] getQuestions()
	{
		return questions;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public List<String> getTopics()
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
