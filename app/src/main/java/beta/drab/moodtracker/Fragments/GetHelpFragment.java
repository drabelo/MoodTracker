package beta.drab.moodtracker.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import beta.drab.moodtracker.R;


public class GetHelpFragment extends Fragment {

    private ListView strategies;
    private ArrayList<String> strategyList;
    //private String strategies;

    public GetHelpFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initStrategies();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_get_help, container, false);
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
