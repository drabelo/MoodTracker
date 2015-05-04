package beta.drab.moodtracker.Models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by user on 4/26/2015.
 */
@Table(name = "Trigger_Table")
public class TriggerData extends Model {

    @Column(name = "Name")
    public String trigger;
    @Column(name = "Comment")
    public String text;

    public TriggerData(String trigger){
        super();
        this.trigger = trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }
    public void setText(String text) {this.text = text;}
}
