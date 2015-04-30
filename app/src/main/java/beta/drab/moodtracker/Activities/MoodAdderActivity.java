package beta.drab.moodtracker.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import beta.drab.moodtracker.MainActivity;
import beta.drab.moodtracker.Models.MoodData;
import beta.drab.moodtracker.R;

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

//        MoodAdapter arrayAdapter = new MoodAdapter(
//                this,
//                android.R.layout.simple_list_item_1,
//                moodList
//                );

       ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, moodList);
        moods.setAdapter(adapter);
        moods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                mood = (String) parent.getAdapter().getItem(position);
            }
        });
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

    public void onClickNextTrigger(View v){
        //add mood and go to next.;
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
            moodData = new MoodData();
            moodData.setMood(mood);
            Intent i = new Intent(getApplicationContext(), SelectTriggerActivity.class);
            startActivity(i);
        }
    }

    public void onClickDoneMoodAdder(View v){
        if(mood != null) {
            moodData = new MoodData();
            moodData.setMood(mood);
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

//    public void onClickDone(View v){
//
//    }

//    public void OnClickAddTrigger(View v){
//        Intent i = new Intent(this, ModifyMoodActivity.class);
//        startActivity(i);
//    }

}
