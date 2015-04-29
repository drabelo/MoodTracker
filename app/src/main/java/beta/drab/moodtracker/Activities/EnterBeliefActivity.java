package beta.drab.moodtracker.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import beta.drab.moodtracker.MainActivity;
import beta.drab.moodtracker.Models.MoodData;

import beta.drab.moodtracker.R;

public class EnterBeliefActivity extends ActionBarActivity {
    private static MoodData moodData;
    private EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_belief);
        setMood();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_enter_belief, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setMood(){
        moodData = EnterBehaviorActivity.getMoodData();
    }

    public static MoodData getMoodData(){
        return moodData;
    }

    public void onClickEnterBehavior(View v){
        if(!text.toString().isEmpty())
            moodData.setBehavior(text.toString());
        Intent i = new Intent(getApplicationContext(), EnterBehaviorActivity.class);
        startActivity(i);
    }

    public void onClickDone(View v){
        if(!text.toString().isEmpty())
            moodData.setBehavior(text.toString());
        moodData.save();
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}
