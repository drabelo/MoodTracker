package beta.drab.moodtracker.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import beta.drab.moodtracker.R;

public class ModifyTextActivity extends ActionBarActivity {

    private EditText editTextTrigger;
    private EditText editTextBelief;
    private EditText editTextBehavior;
    ModifyMoodActivity m = new ModifyMoodActivity();
    public String triggerClicked;
    public String beliefClicked;
    public String behaviorClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_text);
        Bundle extras = getIntent().getExtras();
        triggerClicked = extras.getSerializable("trigger").toString();
        beliefClicked = extras.getSerializable("belief").toString();
        behaviorClicked = extras.getSerializable("behavior").toString();
        predefinedTexts();
    }

    public void predefinedTexts() {
        editTextTrigger = (EditText) findViewById(R.id.textView7);
        editTextTrigger.setText(triggerClicked); //Trigger given clicked mood
        editTextBelief = (EditText) findViewById(R.id.textView9);
        editTextBelief.setText(beliefClicked); //Belief given clicked mood
        editTextBehavior = (EditText) findViewById(R.id.textView11);
        editTextBehavior.setText(behaviorClicked); //Behavior given clicked mood
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

    public void onClickCancel(View v){
        Intent i = new Intent(this, ModifyMoodActivity.class);
        startActivity(i);
    }
}
