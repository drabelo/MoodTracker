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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_text);
        editTextTrigger = (EditText) findViewById(R.id.textViewTrigger);
        editTextTrigger.setText("Predefined Trigger Text");
        editTextBelief = (EditText) findViewById(R.id.textViewBelief);
        editTextBelief.setText("Predefined Belief Text");
        editTextBehavior = (EditText) findViewById(R.id.textViewBehavior);
        editTextBehavior.setText("Predefined Behavior Text");
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
