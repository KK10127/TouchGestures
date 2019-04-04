package edu.miracostacollege.cs134.touchgestures;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
                                                        GestureDetector.OnDoubleTapListener {

    private static final int SWIPE_VELOCITY = 7000;

    private ScrollView gesturesScrollView;

    private TextView gesturesLogTextView;
    private TextView singleTapTextView;
    private TextView doubleTapTextView;
    private TextView longPressTextView;
    private TextView scrollTextView;
    private TextView flingTextView;

    private GestureDetector mGestureDetector;

    private int singleTaps = 0, doubleTaps = 0, longPresses = 0, scrolls = 0, flings = 0;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        super.dispatchTouchEvent(ev);
        return mGestureDetector.onTouchEvent(ev);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connect all components
        gesturesScrollView = findViewById(R.id.gesturesScrollView);
        gesturesLogTextView = findViewById(R.id.gesturesLogTextView);
        singleTapTextView = findViewById(R.id.singleTapTextView);
        doubleTapTextView = findViewById(R.id.doubleTapTextView);
        longPressTextView = findViewById(R.id.longPressTextView);
        scrollTextView = findViewById(R.id.scrollTextView);
        flingTextView = findViewById(R.id.flingTextView);

        // gesture detector to listen
        mGestureDetector = new GestureDetector(gesturesScrollView.getContext(), this);

        // now we need to dispatch the events to all children in the container
        // override 'dispatchTouchEvent()' as shown above
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        gesturesLogTextView.append("onSingleTapConfirmed\n");
        singleTapTextView.setText(String.valueOf(++singleTaps));
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        gesturesLogTextView.append("onDoubleTap touch event\n");
        doubleTapTextView.setText(String.valueOf(++doubleTaps));
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        gesturesLogTextView.append("EVENT OCCURED within onDoubleTap touch event\n");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        gesturesLogTextView.append("onDown touch event\n");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        gesturesLogTextView.append("onShowPress touch event\n");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        gesturesLogTextView.append("onSingleTapUp touch event\n");
        return true;

    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        gesturesLogTextView.append("onScroll: distanceX is " + distanceX
                                        + ", distanceY is " + distanceY  + "\n");
        scrollTextView.setText(String.valueOf(++scrolls));
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        gesturesLogTextView.append("onLongPress touch event\n");
        longPressTextView.setText(String.valueOf(++longPresses));
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        gesturesLogTextView.append("onFlind: velocityX is " + velocityX
                                        + ", velocityY is " + velocityY + "\n");
        flingTextView.setText(String.valueOf(++flings));



        if (Math.abs(velocityX) - Math.abs(velocityY) > SWIPE_VELOCITY) {
            // X is bigger than y
            if (velocityX < 0) {
                gesturesLogTextView.append("\nSWIPE LEFT\n\n");
            } else {
                gesturesLogTextView.append("\nSWIPE RIGHT\n\n");
            }

        } else if (Math.abs(velocityY) - Math.abs(velocityX) > SWIPE_VELOCITY){
            // Y is bigger than X
            if (velocityY < 0) {
                gesturesLogTextView.append("\nSWIPE UP\n\n");
            } else {
                gesturesLogTextView.append("\nSWIPE DOWN\n\n");
            }
        } else {
            // no discernible swipe
        }

        return true;
    }

    public void clearAll(View v) {
        // data clearing
        singleTaps = 0;
        doubleTaps = 0;
        longPresses = 0;
        scrolls = 0;
        flings = 0;

        // text view clearing
        flingTextView.setText("");
        scrollTextView.setText("");
        longPressTextView.setText("");
        doubleTapTextView.setText("");
        singleTapTextView.setText("");
    }

}
