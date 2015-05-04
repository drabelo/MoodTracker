package beta.drab.moodtracker.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import beta.drab.moodtracker.R;


public class GetHelpFragment extends Fragment {

    private ListView strategies;
    private ArrayList<String> strategyList;
    //private String strategy;

    public GetHelpFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_get_help);
        initStrategies();

<<<<<<< HEAD

=======
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, strategyList);
//        strategies.setAdapter(adapter);
>>>>>>> origin/master
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_get_help, container, false);
        strategies = (ListView) v.findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, strategyList);
        strategies.setAdapter(adapter);

        return v;
    }

    public static GetHelpFragment newInstance(int page, String title) {
        GetHelpFragment fragment = new GetHelpFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment.setArguments(args);
        return fragment;
    }


    private void initStrategies() {
        strategyList = new ArrayList<String>();
        strategyList.add("Read a Book");
        strategyList.add("Take a Nap");
        strategyList.add("Exercise");

    }


}
