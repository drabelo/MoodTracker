package beta.drab.moodtracker.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import beta.drab.moodtracker.Activities.PatternDisplayActivity;
import beta.drab.moodtracker.Models.MoodData;
import beta.drab.moodtracker.R;


public class PatternFragment extends Fragment {

    //using set so there is only one unique string for each trigger if it is used.
    Set<String> set = new HashSet<String>();
    ListView triggers;
    ArrayList<String> differentUsedTriggers;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);




    }

    public PatternFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pattern, container, false);

        List<MoodData> moodDatalst = new Select()
                .from(MoodData.class)
                .execute();

        for(MoodData mood : moodDatalst){
            set.add(mood.getTrigger());
        }
        System.out.println("set size" + set.size());

        differentUsedTriggers = new ArrayList<String>();
        differentUsedTriggers.addAll(set);

        triggers = (ListView) v.findViewById(R.id.listView2);

        ArrayAdapter adapter = new ArrayAdapter(this.getActivity(), android.R.layout.simple_list_item_1, differentUsedTriggers);
        triggers.setAdapter(adapter);

        triggers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), PatternDisplayActivity.class);
                i.putExtra("trigger",differentUsedTriggers.get(position));
                startActivity(i);
            }
        });





        return v;
    }
    public static PatternFragment newInstance(int page, String title) {
        PatternFragment fragment = new PatternFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment.setArguments(args);
        return fragment;
    }
}
