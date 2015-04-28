package beta.drab.moodtracker.Activities;

import android.app.ListActivity;
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

public class ModifyMoodActivity extends ListActivity {

    private ListView moods;
    private Button button;
    private String mood;
    private static MoodData moodData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_mood);
        initMoods();
        String[] TIME = {"Monday 2:30PM EST", "Tuesday 5:30PM EST", "THURSDAY 3:39AM EST"};
        String[] MOOD = {"Happy", "Happy", "Sad"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getListView().getContext(), android.R.layout.simple_list_item_1, TIME);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getListView().getContext(), android.R.layout.simple_list_item_2, MOOD);
        getListView().setAdapter(adapter);
        getListView().setAdapter(adapter2);
        // Populate with previously made moods.
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modify_mood, menu);
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

    /*
     * Selects from a previous Mood.
     */
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
            Intent j = new Intent(getApplicationContext(), SelectTriggerActivity.class);
            startActivity(j);
        }
    }

    public void onDoneClick(View v){
        if(mood != null) {
            moodData = new MoodData(mood);
            moodData.save();
        }
        Intent j = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(j);
    }

    public static MoodData getMoodData(){
        return moodData;
    }

    public void initMoods(){

    }

    //TIMESTAMP
    //MOOD
    //INTENSITY

}
