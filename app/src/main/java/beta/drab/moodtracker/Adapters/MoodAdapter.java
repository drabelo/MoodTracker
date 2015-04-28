package beta.drab.moodtracker.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import beta.drab.moodtracker.R;

public class MoodAdapter extends BaseAdapter {

    public ArrayList<String> employeeData;
    private Context mContext;
    private LayoutInflater mInflater;

    public MoodAdapter(Context context, int textViewResourceId,
                           ArrayList<String> objects) {
        this.employeeData = objects;
        this.mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();

            convertView = mInflater.inflate(R.layout.row_main, null);

            holder.txtName = (TextView) convertView.findViewById(R.id.textView1);
            holder.chkTick = (CheckBox) convertView.findViewById(R.id.checkBox1);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final int pos = position;
        holder.txtName.setText(employeeData.get(position));



        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
        CheckBox chkTick;
    }

    public int getCount() {
        return employeeData.size();
    }

    public String getItem(int position) {
        return employeeData.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }
}