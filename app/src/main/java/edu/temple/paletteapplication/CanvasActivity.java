package edu.temple.paletteapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        Intent intent = getIntent();
        String color = intent.getStringExtra("color");

        ConstraintLayout canvas = findViewById(R.id.layoutback);
        canvas.setBackgroundColor(Color.parseColor(color));
    }
}
