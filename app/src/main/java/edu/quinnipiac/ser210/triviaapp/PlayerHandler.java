package edu.quinnipiac.ser210.triviaapp;
/**
 * Kevin Couillard & Hephzibah Rajan
 * SER 210 Assignment 2 TriviaApp
 * 3/18/21
 * PlayerHandler handles retrieving api data
 */
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class PlayerHandler {

    private static final int START_PLAYER = 0;
    private static final int END_PLAYER= 450;
    final public static String [] players = new String[END_PLAYER - START_PLAYER +1];
    public static String playerName = null;
    public static String playerHeight = null;
    public static String playerPosition = null;
    public static String playerTeam = null;

    public PlayerHandler(){

        //populate the array
        int i = 0;
        for (int pr = START_PLAYER; pr <= END_PLAYER; pr++ )
            players[i++] = Integer.toString(pr);
    }

    public String getPlayer(String playerNameJsonStr) throws JSONException {
        //gets the playerName (returns this), team, height, and position and stores the later 3 as static variables
        String playerTeam = null;
        String playerHeight = null;
        String playerPosition = null;
        JSONObject playerNameJSONObj = new JSONObject(playerNameJsonStr);
        String[] strArray = playerNameJSONObj.getString("team").split(":");
        for (String a : strArray) {
            Log.v("TeamSplit", a);
            playerTeam = a;
        }

        playerHeight = playerNameJSONObj.getString("height_feet") + "'" + playerNameJSONObj.getString("height_inches") + "''";
        this.playerHeight = playerHeight;


        playerPosition = playerNameJSONObj.getString("position");
        this.playerPosition = playerPosition;

        this.playerTeam = playerTeam.replaceAll("\\p{P}", "");
        playerName = playerNameJSONObj.getString("first_name") + " " + playerNameJSONObj.getString("last_name");
        return playerName;
    }

}