package com.jativa.ramiro.circleprogressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ProgressBar;
import android.widget.TextView;

/*
    The source code for this example is taken from:
    http://mycodingworld1.blogspot.com/2015/02/crating-circle-android-custom-progress.html

    The App create Circle Progress Bar by customizing horizontal default android
    progress bar.
 */
public class MainActivity extends AppCompatActivity {

    private ProgressBar progBar;
    private TextView text;
    private Handler mHandler = new Handler();
    private int mProgressStatus=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progBar= (ProgressBar)findViewById(R.id.progressBar);
        text = (TextView)findViewById(R.id.textView1);

        dosomething();
    }

    public void dosomething() {

        new Thread(new Runnable() {
            public void run() {
                final int presentage=0;
                while (mProgressStatus < 100) {
                    mProgressStatus += 1;
                    // Update the progress bar
                    mHandler.post(new Runnable() {
                        public void run() {
                            progBar.setProgress(mProgressStatus);
                            text.setText(""+mProgressStatus+"%");

                        }
                    });
                    try {



                        Thread.sleep(50);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
