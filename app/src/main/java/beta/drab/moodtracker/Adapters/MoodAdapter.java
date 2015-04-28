package beta.drab.moodtracker.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;

import java.util.ArrayList;

import beta.drab.moodtracker.AdapterModel.MoodRow;
import beta.drab.moodtracker.R;

public class MoodAdapter extends BaseAdapter {

    public ArrayList<MoodRow> employeeData;
    private Context mContext;
    private LayoutInflater mInflater;

    public MoodAdapter(Context context, int textViewResourceId,
                           ArrayList<MoodRow> objects) {
        this.employeeData = objects;
        this.mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();

            convertView = mInflater.inflate(R.layout.row_main, null);

            holder.txtName = (CheckedTextView) convertView.findViewById(R.id.TextView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final int pos = position;
        holder.txtName.setText(employeeData.get(position).name);

        holder.txtName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.txtName.isChecked())
                    holder.txtName.setChecked(false);
                else
                    holder.txtName.setChecked(true);

            }
        });



        return convertView;
    }

    static class ViewHolder {
        CheckedTextView txtName;
    }

    public int getCount() {
        return employeeData.size();
    }

    public String getItem(int position) {
        return employeeData.get(position).name;
    }

    public long getItemId(int position) {
        return 0;
    }
}