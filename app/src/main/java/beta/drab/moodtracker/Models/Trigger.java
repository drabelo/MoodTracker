package beta.drab.moodtracker.Models;

import android.widget.EditText;

import com.activeandroid.Model;

/**
 * Created by user on 4/26/2015.
 */
public class Trigger extends Model {


    public String trigger;
    public String text;

    public Trigger(String trigger){
        super();
        this.trigger = trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }
    public void setText(String text) {this.text = text;}
}
