package chat.model;

public class CTECTwitter
{
	public void handleErrors(Exception error)
	{
		display.displayText(error.getMessage());
	}
	
	public void sendTweet(String tweet)
	{
		if (tweet.length() < 280)
		{
			
		}
	}
}
