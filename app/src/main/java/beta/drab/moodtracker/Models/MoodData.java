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

    @Column(name = "date", index = true)
    public long date;

    @Column(name = "trigger")
    public String trigger;

    @Column(name = "behavior")
    public String behavior;

    @Column(name = "belief")
    public String belief;

    @Column(name = "comment")
    public String comment;

    @Column(name = "intensity")
    public int intensity;

    public String triggerComment;

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

    public void setTrigger(String trigger){
        this.trigger = trigger;
    }

    public String getTrigger() {
        return trigger;
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

    public String getTriggerComment() {return triggerComment;}

    public void setTriggerComment(String comment) {this.triggerComment = comment;}

    @Override
    public String toString() {
        return "MoodData{" +
                "mood='" + mood + '\'' +
                ", date=" + date +
                ", trigger=" + trigger + '\'' +
                ", behavior='" + behavior + '\'' +
                ", belief='" + belief + '\'' +
                ", comment='" + comment + '\'' +
                ", intensity=" + intensity +
                '}';
    }
}