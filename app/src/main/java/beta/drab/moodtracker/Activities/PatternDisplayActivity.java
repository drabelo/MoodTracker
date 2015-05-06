package beta.drab.moodtracker.Activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.activeandroid.query.Select;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

import beta.drab.moodtracker.Models.MoodData;
import beta.drab.moodtracker.R;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;

public class PatternDisplayActivity extends ActionBarActivity {
    LineChartView chart;
    List<MoodData> moodDatalst;
    String trigger;
    List<AxisValue> axisValues = new ArrayList<AxisValue>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern_display);
        trigger = getIntent().getStringExtra("trigger");
        moodDatalst = new Select()
                .from(MoodData.class)
                .where("triggerData = ?", trigger)
                .execute();

        //creating chard
        chart = (LineChartView) findViewById(R.id.chart);

        LineChartData data = new LineChartData();

        //creating axisValues




        //adding poitns to line
        List<PointValue> values = new ArrayList<PointValue>();
        int count = 0;
        DateTimeFormatter format = DateTimeFormat.forPattern("MM-dd-yyyy");

        for(MoodData mdata : moodDatalst){
            values.add(new PointValue(count, mdata.intensity));
            AxisValue value = new AxisValue(count, format.print(mdata.date).toCharArray());
            axisValues.add(value);
            count ++;
        }

        //creating x axis
        Axis axisX = new Axis();
        axisX.setValues(axisValues);
        axisX.setMaxLabelChars(4);
        axisX.setHasSeparationLine(true);

        //creating line from points
        Line line = new Line(values).setColor(Color.BLUE).setCubic(true);
        List<Line> lines = new ArrayList<Line>();
        lines.add(line);

        //setting line
        data.setLines(lines);
        data.setAxisXBottom(axisX);

        chart.setLineChartData(data);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pattern_display, menu);
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
}
