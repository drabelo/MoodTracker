package beta.drab.moodtracker.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import beta.drab.moodtracker.MainActivity;
import beta.drab.moodtracker.Models.MoodData;
import beta.drab.moodtracker.Models.TriggerData;
import beta.drab.moodtracker.R;

public class TriggerAdderActivity extends ActionBarActivity {
    private ListView triggers;
    private static MoodData moodData;
    private String trigger;
    private EditText text;
    private ArrayList<String> triggerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_trigger);
        initTriggers();
        triggers = (ListView) findViewById(R.id.lst);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, triggerList);
        triggers.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_trigger, menu);
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

    public void onClickNextBehavior(View v){
        if(trigger != null){
            TriggerData trig = new TriggerData(trigger);
            if(text != null){
                trig.setText(text.toString());
            }
            //moodData.setTrigger(trig);
        }
        Intent i = new Intent(getApplicationContext(), EnterBehaviorActivity.class);
        startActivity(i);
    }

    public void onClickDoneTrigger(View v){
        if(trigger != null){
            TriggerData trig = new TriggerData(trigger);
            if(text != null){
                trig.setText(text.toString());
            }
            //moodData.setTrigger(trig);
        }
        moodData.save();
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    public static MoodData getMoodData(){
        return moodData;
    }

    private void initTriggers() {
        triggerList = new ArrayList<String>();
        triggerList.add("Work/School - Deadline, test, etc.");
        triggerList.add("Personal Loss");
        triggerList.add("Social Interaction: Friend");
        triggerList.add("Social Interaction: Family");
        triggerList.add("Social Interaction: Co-worker");
        triggerList.add("Social Interaction: Partner");
    }
}
