package beta.drab.moodtracker.Models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by dailtonrabelo on 4/26/15.
 */

@Table(name = "Mood Table")
public class MoodData extends Model {
    // If name is omitted, then the field name is used.
    @Column(name = "Name")
    public String mood;
    public Trigger trigger;
    public String behavior;
    public String belief;
    public String comment;

    public MoodData() {
        super();
    }

    public MoodData(String name) {
        super();
        this.mood = name;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getMood() {
        return mood;
    }

    public void setTrigger(Trigger trigger){
        this.trigger = trigger;

    }

    public String getTrigger() {
        return this.trigger.trigger;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBelief(String belief) {
        this.belief = belief;
    }

    public String getBelief() {
        return belief;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}