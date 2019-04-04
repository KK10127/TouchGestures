package edu.miracostacollege.cs134.touchgestures;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ScrollView gesturesScrollView;

    private TextView gesturesLogTextView;
    private TextView singleTapTextView;
    private TextView doubleTapTextView;
    private TextView longPressTextView;
    private TextView scrollTextView;
    private TextView flingTextView;

    private int singleTaps = 0, doubleTaps = 0, longPresses = 0, scrolls = 0, flings = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connect all components
        gesturesScrollView = findViewById(R.id.gesturesScrollView);
        singleTapTextView = findViewById(R.id.singleTapTextView);
        doubleTapTextView = findViewById(R.id.doubleTapTextView);
        longPressTextView = findViewById(R.id.longPressTextView);
        scrollTextView = findViewById(R.id.scrollTextView);
        flingTextView = findViewById(R.id.flingTextView);

    }

}
