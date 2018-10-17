package edu.temple.paletteapplication;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class PaletteActivity extends AppCompatActivity {

    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);


        Spinner colorspinner = (Spinner) findViewById(R.id.colorpalette);


        PaletteAdapter colorAdapter = new PaletteAdapter(this,R.layout.color_adapter,getResources().getStringArray(R.array.grid_array));

        colorspinner.setAdapter(colorAdapter);



        final Intent myIntent = new Intent(this, CanvasActivity.class);



        colorspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String color = (String) parent.getItemAtPosition(position);
                //TextView color = (TextView) view.findViewById(R.id.colortext);

                //String colorString = color.getText().toString();
                if(!color.equals("clear")){

                    fm = getSupportFragmentManager();

                    fm.beginTransaction().replace(R.id.paletteBack, CanvasFragment.newInstance(color)).addToBackStack(null).commit();


                    //myIntent.putExtra("color",col);
                    //PaletteActivity.this.startActivity(myIntent);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
