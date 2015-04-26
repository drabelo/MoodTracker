package beta.drab.moodtracker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;

import beta.drab.moodtracker.Fragments.AppHelpFragment;
import beta.drab.moodtracker.Fragments.GetHelpFragment;
import beta.drab.moodtracker.Fragments.MoodFragment;
import beta.drab.moodtracker.Fragments.PatternFragment;


public class MainActivity extends ActionBarActivity {

    PagerSlidingTabStrip tabsStrip = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Comment
        int x = 0;


        // Get the ViewPager and set it's PagerAdapter so that it can display items
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(3);
        // Give the PagerSlidingTabStrip the ViewPager
        tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        // Attach the view pager to the tab strip
        tabsStrip.setViewPager(viewPager);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    //creating the inner class adapter for setting the fragments into the tabs
    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 4;


        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment

                    return MoodFragment.newInstance(0, "Mood");
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return PatternFragment.newInstance(1, "Pattern");
                case 2: // Fragment # 0 - This will show FirstFragment different title
                    return GetHelpFragment.newInstance(2, "GetHelp");
                case 3: // Fragment # 0 - This will show FirstFragment different title
                    return AppHelpFragment.newInstance(3, "AppHelp");
//                case 4: // Fragment # 0 - This will show FirstFragment different title
//                    return UserFragment.newInstance(4, "SETTINGS");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            String title = "";
            if (position == 0)
                title = "Mood Track";
            if (position == 1)
                title = "Get Pattern";
            if (position == 2)
                title = "Get Help";
//                title = "Discover";
            if(position == 3)
                title = "App Help";
//            if(position == 4)
//                title = "Settings";

            return title;
        }

    }
}
