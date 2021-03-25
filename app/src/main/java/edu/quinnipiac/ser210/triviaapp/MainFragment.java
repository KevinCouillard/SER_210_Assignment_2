package edu.quinnipiac.ser210.triviaapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.widget.ShareActionProvider;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainFragment extends Fragment implements View.OnClickListener {
    Button bPressed;
    PlayerHandler pHandler = new PlayerHandler();
    private String url1 = "https://free-nba.p.rapidapi.com/players/";
    private String LOG_TAG = MainActivity.class.getSimpleName();
    private MainActivity mainActivity = new MainActivity();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_main, container, false);
        Button playerButton = (Button) layout.findViewById(R.id.Players);
        playerButton.setOnClickListener(this);
        TextView gameMessage = (TextView) layout.findViewById(R.id.Game_Message);
        return layout;
    }

    @Override
    public void onClick(View v) {
        //only one button
        bPressed = (Button) v;
        new FetchPlayer().execute(this.getPlayer());
    }

    public String getPlayer() {
        //gets a random id to index player from api
        int playerNum = (int) (Math.random() * 450 + 1);
        String playerId = String.valueOf(playerNum);
        return playerId;
    }

    class FetchPlayer extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            String player;
            String playerTeam;

            try {
                //opens url connection
                URL url = new URL(url1 + strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setRequestProperty("X-RapidAPI-Key","b1f8396a9emsh5ba48decef16568p1e9b05jsn04b9cde32e60");
                urlConnection.connect();


                InputStream in = urlConnection.getInputStream();

                if (in == null) {
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(in));
                player = getStringFromBuffer(reader);


            } catch (Exception e) {
                Log.e(LOG_TAG, "Error" + e.getMessage());
                return null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        Log.e(LOG_TAG, "Error" + e.getMessage());
                        return null;
                    }
                }

            }
            return player;
        }
        protected void onPostExecute(String result) {
            if (result != null)
                Log.d(LOG_TAG,"Result is null");

            //creates an intent to gameScreen and sends api values
            Intent intent = new Intent(mainActivity, GameScreen.class);
            intent.putExtra("player",result);
            intent.putExtra("player team",PlayerHandler.playerTeam);
            intent.putExtra("player height",PlayerHandler.playerHeight);
            intent.putExtra("player position",PlayerHandler.playerPosition);
            intent.putExtra("category", bPressed.getText());
            startActivity(intent);
        }
    }
    private String getStringFromBuffer(BufferedReader bufferedReader) {
        StringBuffer buffer = new StringBuffer();
        String line;

        if (bufferedReader != null) {
            try {
                while((line = bufferedReader.readLine()) != null) {
                    buffer.append(line + '\n');
                }
                bufferedReader.close();
                return pHandler.getPlayer(buffer.toString());
            } catch (Exception e) {
                Log.e("MainActivity","Error" + e.getMessage());
                return null;
            }
        }
        return null;
    }
}