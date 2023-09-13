/***************************************************************************
 * Author: Adam Walters
 * Date: May 8, 2023
 *
 * This program is MakeTweetsArray without a few functions being called
 * (so the GUI loads properly without any interaction with the console).
 *
 * This class is responsible for loading data from a CSV file, parsing it, and
 * creating Tweet objects. It also calculates various statistics related to the
 * loaded data.
 ***************************************************************************/
package TweetsProj;

public class MakeTweetsArray {
    // Array to store Tweet objects
    public static Tweets[] TweetObjects = new Tweets[10];
    
    // Counters for different types of Tweets
    public static int goodCount = 0;
    public static int recCount = 0; // Total rows
    public static int errCount = 0; // Rows with errors
    public static int sumFollows = 0; // Sum of userFollowers
    public static int sumFriends = 0; // Sum of userFriends
    public static int maxLikesPosition = 0; // Position of the Tweet with the most likes
    public static int maxRetweetPosition = 0; // Position of the Tweet with the most retweets

    /**
     * Load data from a CSV file and create Tweet objects from it.
     */
    public static void load() {
        String line;
        String[] lineArray;

        int userFollowers = 0, userFriends = 0, retweets = 0, likes = 0,
            maxLikes = 0, maxRetweet = 0;
        boolean userVerified;

        try {
            TextIO.readFile("shortchatgpt.txt");
        } catch (IllegalArgumentException e) {
            // Unable to read from the file, exit the program
            TextIO.putln("Unable to read from the file");
            System.exit(0);
        }
        
        TextIO.getln(); // Skip the first line (headers)

        while (!TextIO.eof()) {
            line = TextIO.getln(); // Read the next line
            recCount++;

            lineArray = line.split(","); // Split the line into columns

            if (lineArray.length != 13) {
                // If there are not 13 columns, it's an error
                errCount++;
                continue;
            }

            if (!lineArray[5].equals("TRUE") && !lineArray[5].equals("FALSE")) {
                // If userVerified is not "TRUE" or "FALSE", it's an error
                errCount++;
                continue;
            } else if (lineArray[5].equals("TRUE")) {
                userVerified = true;
            } else {
                userVerified = false;
            }

            // Transform string values into integers or doubles
            try {
                userFollowers = Integer.parseInt(lineArray[6]);
                userFriends = Integer.parseInt(lineArray[7]);
                retweets = Integer.parseInt(lineArray[8]);
                likes = Integer.parseInt(lineArray[9]);
            } catch (NumberFormatException e) {
                // If the values in those locations aren't numbers, it's an error
                errCount++;
                continue;
            }

            if (userFollowers < 0 || userFriends < 0 || retweets < 0 || likes < 0) {
                // If any of these values are negative, it's an error
                errCount++;
                continue;
            }

            // Create a new Tweet object and add it to the array
            TweetObjects[goodCount] = new Tweets(lineArray[0], lineArray[1], lineArray[2], lineArray[3],
                    lineArray[4], userVerified, userFollowers, userFriends,
                    retweets, likes, lineArray[10], lineArray[11], lineArray[12]
            );

            // Update sumFollows and sumFriends
            sumFollows += userFollowers;
            sumFriends += userFriends;

            // Update maxLikesPosition and maxRetweetPosition if needed
            if (likes >= maxLikes) {
                maxLikesPosition = goodCount;
                maxLikes = likes;
            }
            if (retweets >= maxRetweet) {
                maxRetweetPosition = goodCount;
                maxRetweet = retweets;
            }

            goodCount++;
        }

        // Comment out the following line since it interacts with the console
        // TextIO.readStandardInput();
    }
}
