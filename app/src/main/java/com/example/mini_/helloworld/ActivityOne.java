package com.example.mini_.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends Activity {


    private final static String TAG="Activity_1";

    private int countCreate=0;
    private int countRestart=0;
    private int countStart=0;
    private int countResume=0;

    private TextView mTvCreate;
    private TextView mTvRestart;
    private TextView mTvResume;
    private TextView mTvStart;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        Log.i(TAG, "CREATING THE APP " + getClass().getSimpleName());
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_activity_one);

        mTvCreate=(TextView)findViewById(R.id.mTv_Create);
        mTvRestart=(TextView)findViewById(R.id.mTv_Restart);
        mTvStart=(TextView)findViewById(R.id.mTv_Start);
        mTvResume=(TextView)findViewById(R.id.mTv_Resume);

        countCreate++;
        displayCounts();
    }

    @Override
    public void onResume() {
        Log.i(TAG, "RESUMING THE APP");
        super.onResume();
        countResume++;

        displayCounts();

    }
    @Override
    public void onStop() {
        Log.i(TAG, "STOPPING THE APP");
        super.onStop();
    }


    @Override
    public void onDestroy() {
        Log.i(TAG,"APP DESTROYED");
        super.onDestroy();
    }

    @Override
    public void onPause() {
        Log.i(TAG, "APP PAUZED");
        super.onPause();
    }




    @Override
    protected void onStart() {
        Log.i(TAG, "STARTING THE APP");
        super.onStart();  // Always call the superclass method first
        countStart++;
        displayCounts();


    }

    @Override
    protected void onRestart() {
        Log.i(TAG, "RESTARTING THE APP");
        super.onRestart();  // Always call the superclass method first
        countRestart++;
        displayCounts();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("mCreate", countCreate);
        savedInstanceState.putInt("mRestart",countRestart);
        savedInstanceState.putInt("mResume", countResume);
        savedInstanceState.putInt("mStart", countStart);
    }

    public void startActivityTwo(View v)
    {
        startActivity(new Intent(this,ActivityTwo.class));
    }

    public void closeApp(View V)
    {
        this.finish();
    }



    public void displayCounts(){
        mTvCreate.setText("onCreate() calls "+countCreate);
        mTvStart.setText("onStart() calls "+countStart);
        mTvResume.setText("onResume() calls "+countResume);
        mTvRestart.setText("onRestart() calls "+countRestart);
    }

}
