package beta.drab.moodtracker.Activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.app.AlertDialog;
import android.content.DialogInterface;

import beta.drab.moodtracker.MainActivity;
import beta.drab.moodtracker.R;
import beta.drab.moodtracker.Models.MoodData;
import android.content.Intent;

import java.util.ArrayList;

public class MoodAdderActivity extends ActionBarActivity {

    private ListView moods;
    private Button button;
    private String mood;
    private static MoodData moodData;
    private ArrayList<String> moodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_adder);
        initMoods();
        moods = (ListView) findViewById(R.id.lst);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                moodList
                );
        moods.setAdapter(arrayAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mood_adder, menu);
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

    public void onNextClick(View v){
        //add mood and go to next.
        if(mood == null){ //Create Dialog for entering mood
            new AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Please Select a Mood to continue")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            return;
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
        else {
            //Go to Trigger Screen and pass in the mood.
            moodData = new MoodData(mood);
            Intent i = new Intent(getApplicationContext(), SelectTriggerActivity.class);
            startActivity(i);
        }
    }

    public void onDoneClick(View v){
        if(mood != null) {
            moodData = new MoodData(mood);
            moodData.save();
        }
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    public static MoodData getMoodData(){
        return moodData;
    }

    private void initMoods() {
        moodList = new ArrayList<String>();
        moodList.add("Excited");
        moodList.add("Giddy");
        moodList.add("Calm");
        moodList.add("Happy");
        moodList.add("Hopeful");
        moodList.add("Playful");
        moodList.add("Satisfied");
        moodList.add("Ecstatic");
        moodList.add("Panicky");
        moodList.add("Afraid");
        moodList.add("Scared");
        moodList.add("Jealous");
        moodList.add("Apprehensive");
        moodList.add("Nervous");
        moodList.add("Confused");
        moodList.add("Distressed");
        moodList.add("Terrified");
        moodList.add("Sad");
        moodList.add("Hopeless");
        moodList.add("Depressed");
        moodList.add("Regretful");
        moodList.add("Brooding");
        moodList.add("Numb");
        moodList.add("Embarrassed");
        moodList.add("Ashamed");
        moodList.add("Furious");
        moodList.add("Angry");
        moodList.add("Frustrated");
        moodList.add("Annoyed");
    }

}
