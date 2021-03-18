package edu.quinnipiac.ser210.triviaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.os.Bundle;
import androidx.appcompat.widget.ShareActionProvider;

public class MainActivity extends AppCompatActivity {

    private ShareActionProvider provider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setSupportActionBar(findViewById(R.id.toolbar));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.question_options,menu);
        provider = (ShareActionProvider) MenuItemCompat.getActionProvider(findViewById(R.id.menu_share));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.change_color:
                //options to change the background color
                Utils.changeToTheme(this, 3);
                break;
            case R.id.info:
                Intent intent = new Intent(MainActivity.this,AboutPage.class);
                startActivity(intent);
                //information about the developer
                break;
            case R.id.menu_share:
                Intent intent2 = new Intent(Intent.ACTION_SEND);
                intent2.setType("text/plain");
                intent2.putExtra(Intent.EXTRA_TEXT, "This is a message for you");
                provider.setShareIntent(intent2);
                startActivity(intent2);
                break;
            default: return super.onOptionsItemSelected(item);

        }
        return super.onOptionsItemSelected(item);
    }

    public void startGame(View view) {
        Intent intent = new Intent(MainActivity.this,GameScreen.class);
        startActivity(intent);
    }
}