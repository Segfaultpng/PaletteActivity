package edu.temple.paletteapplication;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);


        Spinner colorspinner = (Spinner) findViewById(R.id.colorpalette);

        String[] viewcolors = {"red","blue","yellow","magenta","cyan","GRAY"};

        PaletteAdapter colorAdapter = new PaletteAdapter(this,R.layout.color_adapter,viewcolors);

        colorspinner.setAdapter(colorAdapter);



        final Intent myIntent = new Intent(this, CanvasActivity.class);



        colorspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView color = (TextView) view.findViewById(R.id.colortext);


                myIntent.putExtra("color",color.getText().toString());
                PaletteActivity.this.startActivity(myIntent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
