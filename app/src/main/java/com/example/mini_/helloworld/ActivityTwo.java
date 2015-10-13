package com.example.mini_.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ActivityTwo extends Activity {


    private final static String TAG="Activity_2";

    private int countCreate=0;
    private int countRestart=0;
    private int countStart=0;
    private int countResume=0;

    private TextView mTvCreate;
    private TextView mTvRestart;
    private TextView mTvResume;
    private TextView mTvStart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "CREATING THE APP " + getClass().getSimpleName());
        setContentView(R.layout.activity_activity_two);

        mTvCreate=(TextView)findViewById(R.id.mTv_Create);
        mTvRestart=(TextView)findViewById(R.id.mTv_Restart);
        mTvStart=(TextView)findViewById(R.id.mTv_Start);
        mTvResume=(TextView)findViewById(R.id.mTv_Resume);

        countCreate++;

        displayCounts();
    }

    @Override
    public void onResume() {
        super.onResume();
        countResume++;
        Log.i(TAG, "RESUMING THE " + getClass().getSimpleName());

        displayCounts();

    }
    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "STOPPING THE " + getClass().getSimpleName());

    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i(TAG,getClass().getSimpleName()+" DESTROYED");
    }



    @Override
    protected void onStart() {
        super.onStart();  // Always call the superclass method first
        countStart++;
        Log.i(TAG, "STARTING THE " + getClass().getSimpleName());

        displayCounts();


    }

    @Override
    protected void onRestart() {
        super.onRestart();  // Always call the superclass method first
        Log.i(TAG, "RESTARTING THE " + getClass().getSimpleName());

        countRestart++;
        displayCounts();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("mCreate", countCreate);
        savedInstanceState.putInt("mRestart", countRestart);
        savedInstanceState.putInt("mResume",countResume);
        savedInstanceState.putInt("mStart", countStart);
    }

    public void returnToActivityOne(View v)
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
