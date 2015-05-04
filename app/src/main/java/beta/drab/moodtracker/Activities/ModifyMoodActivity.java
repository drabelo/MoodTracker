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

import java.util.LinkedList;
import java.util.List;

import beta.drab.moodtracker.MainActivity;
import beta.drab.moodtracker.Models.MoodData;
import beta.drab.moodtracker.R;

public class ModifyMoodActivity extends ListActivity {

    private ListView moods;
    private Button button;
    private static MoodData moodData;
    final List<String[]> List = new LinkedList<String[]>();
    private String[] timestamp = {"April 21, 2015, 2:30PM EST", "April 22, 2015, 1:19PM EST",
            "April 24, 2015, 3:39AM EST", "April 25, 2015, 5:30PM EST"};
    private String[] mood = {"Happy", "Happy", "Sad", "Excited"};
    private String[] intensity = {"8", "9", "4", "7"};
    private String[] trigger = {"Blah", "Blu", "Ble", "Bli"};
    private String[] belief = {"Muah", "Mui", "Muo", "Mua"};
    private String[] behavior = {"", "asdf", "hjkl", "qwerty"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_mood);
        addListFromDatabase();
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

    public void addListFromDatabase() {
        //Mock data
        for(int i = 0; i < timestamp.length; i++){
            List.add(new String[] {timestamp[i], mood[i], intensity[i], trigger[i], belief[i], behavior[i]});
        }
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        //ModifyTextActivity m = new ModifyTextActivity();
        Intent i = new Intent(this, ModifyTextActivity.class);
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

    public static MoodData getMoodData(){
        return moodData;
    }

    public void initMoods(){

    }

}
