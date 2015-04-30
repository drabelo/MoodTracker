package beta.drab.moodtracker.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import beta.drab.moodtracker.MainActivity;
import beta.drab.moodtracker.Models.Trigger;

import beta.drab.moodtracker.Models.MoodData;

import beta.drab.moodtracker.R;

public class SelectTriggerActivity extends ActionBarActivity {
    private static MoodData moodData;
    private ListView triggerList;
    private ArrayList<String> triggers;
    private String trigger;
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_trigger);
        setMood();
        initTriggers();
        triggerList = (ListView) findViewById(R.id.trigList);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, triggers);
        triggerList.setAdapter(adapter);
        triggerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                trigger = (String) parent.getAdapter().getItem(position);
            }
        });
    }

    private void initTriggers(){
        triggers = new ArrayList<String>();
        triggers.add("Test1");
        triggers.add("Test2");
        triggers.add("Test3");
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

    public void onClickEnterBehavior(View v){
        if(trigger != null){
           System.out.println("TRIGGER: " + trigger);
           Trigger trig = new Trigger(trigger);
           if(text != null){
              trig.setText(text);
           }
           moodData.setTrigger(trig);
        }
        Intent i = new Intent(getApplicationContext(), EnterBehaviorActivity.class);
        startActivity(i);
    }

    public void onClickDoneTrigger(View v){
        if(trigger != null){
            Trigger trig = new Trigger(trigger);
            if(text != null){
                trig.setText(text);
            }
            moodData.setTrigger(trig);
        }
        moodData.save();
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    public void setMood(){
       moodData = MoodAdderActivity.getMoodData();
    }

    public static MoodData getMoodData(){
        return moodData;
    }
}
