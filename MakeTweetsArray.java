/***************************************************************************
* Author: Adam Walters
* Date: May 8, 2023
*
* This program is MakeTweetsArray  without a few functions being called(so the GUI loads properly without any interaction with the console)
***************************************************************************/
package TweetsProj;



public class MakeTweetsArray {
    public static Tweets[] TweetObjects = new Tweets[10];
    public static int goodCount = 0;
    public static int recCount=0, errCount=0; //counters for all rows, bad rows, good rows
    public static int sumFollows = 0;
    public static int sumFriends = 0;
    public static int maxLikesPosition = 0;
    public static int maxRetweetPosition = 0;
    
    public static void load()
    {
        String line;
        String[] lineArray;
        
        int userFollowers = 0, userFriends = 0, retweets = 0, likes = 0,
                maxLikes =0, maxRetweet = 0;
        boolean userVerified;
        
        try
        {
            TextIO.readFile("shortchatgpt.txt");
        }
        catch (IllegalArgumentException e)
        {
            TextIO.putln("Unable to read from the file");//not sure if this needs to be commented out.Only if file not read
            System.exit(0);
        }
        TextIO.getln(); //skips first line and moves to the next to read since first line are headers
        while (!TextIO.eof())
        {
            line = TextIO.getln();//moves down one more line
            recCount++; 
            lineArray = line.split(","); //splits line by column
        
            if (lineArray.length != 13)
            {
                errCount++;
                continue;
            }
            
            if (!lineArray[5].equals("TRUE") && !lineArray[5].equals("FALSE"))
            {
                errCount++;
                continue;
            }
            else if (lineArray[5].equals("TRUE"))
            {
                userVerified = true;
            }
            else
            {
                userVerified = false;
            }
            
            
            
            //transform the following values from shortchatgpt to int or double
            try
            {
                    userFollowers = Integer.parseInt(lineArray[6]);
                    userFriends = Integer.parseInt(lineArray[7]);
                    retweets = Integer.parseInt(lineArray[8]);
                    likes = Integer.parseInt(lineArray[9]); 
            }
            catch(NumberFormatException e) //if the values in those locations arent a number then do the catch
            {
                errCount++;
                continue;
            }
            if (userFollowers < 0 || userFriends < 0 || retweets < 0 || likes < 0) 
            {
               errCount++;
               continue;
            }//match with my constructor from Tweets.java
            /*
            public Tweets(String inDate,String inText,String inUrl,String inUsername,String inUserCreated,
            boolean inUserVerified,int inUserFollowers,int inUserFriends,int inRetweets, int inLikes,
            String inLocation,String inLocation2,String inUserDescription)
            */
            TweetObjects[goodCount] = new Tweets(lineArray[0],lineArray[1],lineArray[2], lineArray[3], 
                    lineArray[4], userVerified, userFollowers, userFriends, 
                    retweets, likes, lineArray[10], lineArray[11], lineArray[12]
            );
            
            sumFollows +=userFollowers;
            sumFriends+=userFriends;
            if (likes >= maxLikes)
            {maxLikesPosition = goodCount;
            maxLikes = likes;
            
            }
            if (retweets >= maxRetweet)
            {maxRetweetPosition = goodCount;
            maxRetweet = retweets;
            }
            goodCount++;
        }//end while
        /*****
         * comment out printTotals and show methods being
         * called because it causes interaction with console that prevents GUI from popping up
         ******/
         
         TextIO.readStandardInput();
         
    }//end main method
     

}
   