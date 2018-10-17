package edu.temple.paletteapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ColorAdapter extends BaseAdapter{

    private int resourceLayout;
    private String[] colors;
    Context context;

    public ColorAdapter(Context context,int resource,String[] colors) {
        this.context = context;
        this.resourceLayout = resource;
        this.colors = colors;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = new View(context);

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(context);
            v = vi.inflate(resourceLayout, null);
        }

        TextView colorname = (TextView) v.findViewById(R.id.colortext);
        ConstraintLayout background = (ConstraintLayout) v.findViewById(R.id.colorbase);

        if (!colors[position].equals("clear")){
            colorname.setText(colors[position]);
            background.setBackgroundColor(Color.parseColor(colors[position]));
        }




        return v;
    }
}
