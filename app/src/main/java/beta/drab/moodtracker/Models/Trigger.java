package beta.drab.moodtracker.Models;

import com.activeandroid.Model;

/**
 * Created by user on 4/26/2015.
 */
public class Trigger extends Model {


    public String trigger;


    public Trigger(String trigger){
        super();
        this.trigger = trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }


}
