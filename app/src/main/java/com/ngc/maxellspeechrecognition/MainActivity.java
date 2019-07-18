package com.ngc.maxellspeechrecognition;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.maxwell.speechrecognition.OnSpeechRecognitionListener;
import com.maxwell.speechrecognition.OnSpeechRecognitionPermissionListener;
import com.maxwell.speechrecognition.SpeechRecognition;

public class MainActivity extends AppCompatActivity implements OnSpeechRecognitionPermissionListener, OnSpeechRecognitionListener {

    private View fabView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final SpeechRecognition speechRecognition = new SpeechRecognition(this);
        speechRecognition.setSpeechRecognitionPermissionListener(this);
        speechRecognition.setSpeechRecognitionListener(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speechRecognition.startSpeechRecognition();
            }
        });
        fabView = fab;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPermissionGranted() {

    }

    @Override
    public void onPermissionDenied() {

    }

    @Override
    public void OnSpeechRecognitionStarted() {

    }

    @Override
    public void OnSpeechRecognitionStopped() {

    }

    @Override
    public void OnSpeechRecognitionFinalResult(String s) {
        Snackbar.make(fabView, s, Snackbar.LENGTH_LONG)
                .setAction("Recognized Speech", null).show();
    }

    @Override
    public void OnSpeechRecognitionCurrentResult(String s) {

    }

    @Override
    public void OnSpeechRecognitionError(int i, String s) {

    }
}
