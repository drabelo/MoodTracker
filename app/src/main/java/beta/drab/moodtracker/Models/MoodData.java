package beta.drab.moodtracker.Models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by dailtonrabelo on 4/26/15.
 */

@Table(name = "Items")
public class MoodData extends Model {
    // If name is omitted, then the field name is used.
    @Column(name = "Name")
    public String name;

    public MoodData() {
        super();
    }

    public MoodData(String name) {
        super();
        this.name = name;
    }
}