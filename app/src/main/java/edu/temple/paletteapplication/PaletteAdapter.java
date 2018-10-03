package edu.temple.paletteapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class PaletteAdapter extends ArrayAdapter<String>{

    private int resourceLayout;
    private Context context;
    private String[] colorstrings;
    private LayoutInflater mInflater;

    public PaletteAdapter(Context context, int resource, String[] items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.context = context;
        this.colorstrings = items;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public View getDropDownView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    @Override
    public @NonNull View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent){

        final View view = mInflater.inflate(resourceLayout, parent, false);

        TextView text = (TextView) view.findViewById(R.id.colortext);
        text.setText(colorstrings[position]);

        view.findViewById(R.id.colorbase).setBackgroundColor(Color.parseColor(colorstrings[position]));


        return view;
    }
}
