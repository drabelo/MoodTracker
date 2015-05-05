package beta.drab.moodtracker.Models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by dailtonrabelo on 4/26/15.
 */

@Table(name = "Mood_Table")
public class MoodData extends Model{
    // If name is omitted, then the field name is used.
    @Column(name = "Name")
    public String mood;

    @Column(name = "date", index= true)
    public long date;

    @Column(name = "triggerr")
    public TriggerData trigger;

    @Column(name = "behavior")
    public String behavior;

    @Column(name = "belief")
    public String belief;

    @Column(name = "comment")
    public String comment;

    @Column(name = "intensity")
    public int intensity;

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

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

    public void setTrigger(TriggerData trigger){
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


    @Override
    public String toString() {
        return "MoodData{" +
                "mood='" + mood + '\'' +
                ", date=" + date +
               // ", trigger=" + triggerr +
                ", behavior='" + behavior + '\'' +
                ", belief='" + belief + '\'' +
                ", comment='" + comment + '\'' +
                ", intensity=" + intensity +
                '}';
    }
}