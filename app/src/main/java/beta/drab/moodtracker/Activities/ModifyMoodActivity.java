package beta.drab.moodtracker.Activities;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import beta.drab.moodtracker.MainActivity;
import beta.drab.moodtracker.Models.MoodData;
import beta.drab.moodtracker.R;

public class ModifyMoodActivity extends ListActivity {

    private MoodData moodData;
    private ListView moods;
    private Button button;
    final List<String[]> List = new LinkedList<String[]>();
    private String timestamp = "";
    private String mood = "";
    private String intensity = "";
    private String trigger = "";
    private String belief = "";
    private String behavior = "";
    private String triggerChanged;
    private String beliefChanged;
    private String behaviorChanged;
    private String dateChanged;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_mood);

        int counter = 0;
        while(true){
            try{
                moodData = new Select()
                        .from(MoodData.class)
                        .where("Id = ?", counter)
                        .orderBy("RANDOM()")
                        .executeSingle();
                timestamp = Long.toString(moodData.getDate());
                mood = moodData.getMood();
                intensity = Integer.toString(moodData.getIntensity());
                trigger = moodData.getTrigger();
                belief = moodData.getBelief();
                behavior = moodData.getBehavior();
                if(timestamp == null){timestamp = "";}
                if(mood == null){mood = "";}
                if(intensity == null){intensity = "";}
                if(trigger == null){trigger = "";}
                if(belief == null)
                if(behavior == null){behavior = "";}

                List.add(new String[] {timestamp, mood, intensity,
                        trigger,  belief,  behavior});
            }catch(Exception e){
                e.printStackTrace();
                break;
            }
            counter++;
        }
        System.out.println(List.size());

        Bundle extras = getIntent().getExtras();
        try {
            //Change information
            dateChanged = extras.getSerializable("date1").toString();
            triggerChanged = extras.getSerializable("trigger1").toString();
            beliefChanged = extras.getSerializable("belief1").toString();
            behaviorChanged = extras.getSerializable("behavior1").toString();
            int index = Arrays.asList(timestamp).indexOf(dateChanged);
            List.get(index)[3] = triggerChanged;
            List.get(index)[4] = beliefChanged;
            List.get(index)[5] = behaviorChanged;
            System.out.println("Trigger Edited: " + triggerChanged +
                    ", Belief Edited: " + beliefChanged +
                    ", Behavior Edited: " + behaviorChanged);
        }catch(Exception e){
            e.printStackTrace();
        }

        ArrayAdapter<String[]> adapter = new ArrayAdapter<String[]>(this, android.R.layout.simple_list_item_2, android.R.id.text1, List){

            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View view = super.getView(position, convertView, parent);

                String[] entry = List.get(position);
                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);
                text1.setText(entry[0]);
                text2.setText("Mood: " + entry[1] + "\nIntensity: " + entry[2]);

                return view;
            }
        };
        setListAdapter(adapter);
        initMoods();
        // Populate with previously made moods.
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = new Intent(this, ModifyTextActivity.class);
        i.putExtra("date", List.get(position)[0]);
        i.putExtra("trigger", List.get(position)[3]);
        i.putExtra("belief", List.get(position)[4]);
        i.putExtra("behavior", List.get(position)[5]);
        startActivity(i);
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

//    public static MoodData getMoodData(){
//        return moodData;
//    }

    public void initMoods(){

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}
