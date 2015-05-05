package beta.drab.moodtracker.Models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.ArrayList;

/**
 * Created by Alex on 5/5/2015.
 */

@Table(name = "List_Table")
public class MoodList extends  Model{

    @Column(name = "number")
    public Integer number;

    public ArrayList<MoodData> list;

    public MoodList() { super(); }
    public MoodList(int number) {
        super();
        this.number = number;

        list = new ArrayList<MoodData>();
    }

    public ArrayList<Long> getAllDates(){
        ArrayList<Long> dates = new ArrayList<Long>();
        for(int i=0; i<list.size(); i++){
            dates.add(list.get(i).getDate());
        }
        return dates;
    }

    public ArrayList<MoodData> getAllMoods(){
        return list;
    }
}
