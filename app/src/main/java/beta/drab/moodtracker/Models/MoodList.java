package beta.drab.moodtracker.Models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.ArrayList;

/**
 * Created by Alex on 5/5/2015.
 */

@Table(name = "Mood_Table")
public class MoodList extends  Model{

    @Column(name = "id")
    public int id;

    @Column(name = "list")
    public ArrayList<MoodData> list;

    public MoodList() {
        super();
        id = 0;
        list = new ArrayList<MoodData>();
    }

    public ArrayList<Long> getAllDates(){
        ArrayList<Long> dates = new ArrayList<Long>();
        for(int i=0; i<list.size(); i++){
            dates.add(list.get(i).getDate());
        }
        return dates;
    }
}
