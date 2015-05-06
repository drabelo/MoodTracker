package beta.drab.moodtracker.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.query.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import beta.drab.moodtracker.Models.MoodData;
import beta.drab.moodtracker.R;

public class ModifyTextActivity extends ActionBarActivity {

    private TextView editTextDate;
    private EditText editTextTrigger;
    private EditText editTextBelief;
    private EditText editTextBehavior;
    private String triggerClicked;
    private String beliefClicked;
    private String behaviorClicked;
    private String dateClicked;
    private MoodData moodData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_text);
        Bundle extras = getIntent().getExtras();
        dateClicked = extras.getSerializable("date").toString();
        triggerClicked = extras.getSerializable("trigger").toString();
        beliefClicked = extras.getSerializable("belief").toString();
        behaviorClicked = extras.getSerializable("behavior").toString();
        predefinedTexts();
    }

    public void predefinedTexts() {
        editTextDate = (TextView) findViewById(R.id.textView13);
        editTextDate.setText(ModifyMoodActivity.getDate(Long.parseLong(dateClicked), "dd/MM/yyyy hh:mm:ss.SSS")); //Date given clicked mood
        editTextTrigger = (EditText) findViewById(R.id.textView7);
        editTextTrigger.setText(triggerClicked); //Trigger given clicked mood
        editTextBelief = (EditText) findViewById(R.id.textView9);
        editTextBelief.setText(beliefClicked); //Belief given clicked mood
        editTextBehavior = (EditText) findViewById(R.id.textView11);
        editTextBehavior.setText(behaviorClicked); //Behavior given clicked mood
    }

    public void updateText() {
        triggerClicked = editTextTrigger.getText().toString();
        beliefClicked = editTextBelief.getText().toString();
        behaviorClicked = editTextBehavior.getText().toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modify_text, menu);
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

    public void onModifyMood(View v){
        updateText();
        Toast.makeText(getApplicationContext(), "Mood Modified", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, ModifyMoodActivity.class);

        long dateClickedLong = Long.valueOf(dateClicked).longValue();

        moodData = new Select()
                .from(MoodData.class)
                .where("date = ?", dateClickedLong)
                .orderBy("RANDOM()")
                .executeSingle();

        moodData.setTrigger(triggerClicked);
        moodData.setBelief(beliefClicked);
        moodData.setBehavior(behaviorClicked);
        moodData.save();
        System.out.println("Trigger Edited: " + triggerClicked +
                ", Belief Edited: " + beliefClicked +
                ", Behavior Edited: " + behaviorClicked);

        startActivity(i);
    }

    public void onBackPressed() {
        Intent i = new Intent(this, ModifyMoodActivity.class);
        Toast.makeText(getApplicationContext(), "Modify Cancelled", Toast.LENGTH_SHORT).show();
        startActivity(i);
    }

}
