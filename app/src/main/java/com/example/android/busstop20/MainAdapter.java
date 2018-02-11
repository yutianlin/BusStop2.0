package com.example.android.busstop20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MainAdapter extends BaseAdapter {

    Context context;
    String[][] data;
    private static LayoutInflater inflater = null;

    // MODIFIES: this
    // EFFECTS: loads context, data and then inflates
    public MainAdapter(Context context, String[][] data) {
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // EFFECTS: returns number of items in data
    @Override
    public int getCount() {
        return data.length;
    }

    // REQUIRES: valid position, 0 <= position < data.length
    // EFFECTS: returns the data at given position
    @Override
    public Object getItem(int position) {
        return data[position];
    }

    // REQUIRES: valid position, 0 <= position < data.length
    // EFFECTS: returns item id which is given position
    @Override
    public long getItemId(int position) {
        return position;
    }

    // REQUIRES: valid position, 0 <= position < data.length
    // EFFECTS: inflates given row XML with default routes_row, change text of TextViews
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.routes_row, null);
        TextView text = (TextView) vi.findViewById(R.id.txtvBusNum);
        text.setText(data[position][0]);
        text = (TextView) vi.findViewById(R.id.txtvNicknameFrom);
        text.setText(data[position][1]);
        text = (TextView) vi.findViewById(R.id.txtvNicknameTo);
        text.setText(data[position][2]);
        text = (TextView) vi.findViewById(R.id.txtvFormalFrom);
        text.setText(data[position][3]);
        text = (TextView) vi.findViewById(R.id.txtvFormalTo);
        text.setText(data[position][4]);
        return vi;
    }
}
