/***************************************************************************
* Author: Adam Walters
* Date: May 8, 2023
*
* This program is the blueprint class for MakeTweetsArray. It includes a constructors, 
* getters and setters for the different instance variables, and toString method to properly
* display information when an object is called within MakeTweetsArray
***************************************************************************/
package TweetsProj;


public class Tweets {
    
    private String date, text, url, username,userCreated;
    private boolean userVerified;
    private int userFollowers, userFriends, retweets, likes;
    private String location,location2, userDescription;
    private static int numTweets = 0;
    
    //constructor method
    public Tweets(String inDate,String inText,String inUrl,String inUsername,String inUserCreated,
            boolean inUserVerified,int inUserFollowers,int inUserFriends,int inRetweets, int inLikes,
            String inLocation,String inLocation2,String inUserDescription)
    {
        date = inDate;
        text = inText;
        url = inUrl; 
        username = inUsername;
        userCreated = inUserCreated;
        userVerified = inUserVerified;
        userFollowers = inUserFollowers; 
        userFriends = inUserFriends; 
        retweets = inRetweets; 
        location = inLocation; 
        location2 = inLocation2;
        userDescription = inUserDescription;
        likes = inLikes;
        
        numTweets++;
    }
    
    //set methods
    public void setDate(String inDate) {
        date = inDate;
    }

    public void setTweet(String inText) {
        text = inText;
    }

    public void setUrl(String inUrl) {
        url = inUrl;
    }

    public void setUser(String inUsername) {
        username = inUsername;
    }

    public void setUserCreated(String inUserCreated) {
        userCreated = inUserCreated;
    }

    public void setUserVerified(boolean inUserVerified) {
        userVerified = inUserVerified;
    }

    public void setUserFollowers(int inUserFollowers) {
        userFollowers = inUserFollowers;
    }

    public void setUserFriends(int InUserFriends) {
        userFriends = InUserFriends;
    }

    public void setRetweets(int inRetweets) {
        retweets = inRetweets;
    }

    public void setLikes(int inLikes) {
        likes = inLikes;
    }

    public void setLocation(String inLocation) {
        location = inLocation;
    }
    
    public void setLocation2(String inLocation2) {
        location2 = inLocation2;
    }

    public void setUserDescription(String inUserDescription) {
        userDescription = inUserDescription;
    }
    

    //get methods
    public String getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return username;
    }

    public String getUserCreated() {
        return userCreated;
    }

    public boolean isUserVerified() {
        return userVerified;
    }

    public int getUserFollowers() {
        return userFollowers;
    }

    public int getUserFriends() {
        return userFriends;
    }

    public int getRetweets() {
        return retweets;
    }

    public int getLikes() {
        return likes;
    }

    public String getLocation() {
        return location;
    }
    
    public String getLocation2() {
        return location2;
    }

    public String getUserDescription() 
    {
        return userDescription;
    }
    
    /***
    *toString methods
    *changes the output of certain information from tweets when displayed in GUI of TweetWindow
    ****/
    public String getMonthDateString(String dateString) {
        String[] parts = dateString.split("-");
        String year = parts[0];
        String month = parts [1];
        switch (parts[1]) {
            case "01": month = "January"; break;
            case "02": month = "February"; break;
            case "03": month = "March"; break;
            case "04": month = "April"; break;
            case "05": month = "May"; break;
            case "06": month = "June"; break;
            case "07": month = "July"; break;
            case "08": month = "August"; break;
            case "09": month = "September"; break;
            case "10": month = "October"; break;
            case "11": month = "November"; break;
            case "12": month = "December"; break;
        }
        return month + " " + year;
    }

    public String socialAnalyzer(int userFollowers) {
        if (userFollowers >= 1000000) {
            return "Extreme";
        } else if (userFollowers >= 100000) {
            return "High";
        } else if (userFollowers >= 1000) {
            return "Medium";
        } else {
            return "Low Income";
        }
    }
    
    @Override
    public String toString() {//to String that allows information to be in text and not display of memory location back in MakeTweetsArray when object is called
        String result = "Date: " + getMonthDateString(date) + "\n" +
                "Tweet: " + text + "\n" +
                "URL: " + url + "\n" +
                "User: " + username + "\n" +
                "User Created: " + userCreated + "\n" +
                "User Verified: " + userVerified + "\n" +
                "User Followers: " + userFollowers + " (" + socialAnalyzer(userFollowers) + ")\n" +
                "User Friends: " + userFriends + " (" + socialAnalyzer(userFriends) + ")\n" +
                "Retweets: " + retweets + "\n" +
                "Likes: " + likes + "\n" +
                "Location1: " + location + " " + location2 + "\n" +
                "User Description: " + userDescription + "\n";
        return result;
    }
    
}