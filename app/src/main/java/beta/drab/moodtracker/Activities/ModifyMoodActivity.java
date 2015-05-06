package beta.drab.moodtracker.Activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import beta.drab.moodtracker.MainActivity;
import beta.drab.moodtracker.Models.MoodData;
import beta.drab.moodtracker.R;

public class ModifyMoodActivity extends ListActivity {

    private ArrayList<MoodData> moodDataList = new ArrayList<MoodData>();

    private ListView moods;
    private Button button;
    final List<String[]> List = new LinkedList<String[]>();
    private String timestamp = "";
    private String mood = "";
    private String intensity = "";
    private String trigger = "";
    private String belief = "";
    private String behavior = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_mood);



                List<MoodData> moodDatalst = new Select()
                        .from(MoodData.class)
                        .execute();

                System.out.println("" + moodDatalst.size());
                moodDataList.addAll(moodDatalst);


        for(MoodData moodData : moodDataList){
            try{
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
                if(belief == null){belief = "";}
                if(behavior == null){behavior = "";}

                List.add(new String[] {timestamp, mood, intensity,
                        trigger,  belief,  behavior});
            }catch(Exception e){
                e.printStackTrace();
                break;
            }
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
