package com.example.light;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout b1,b2,b3;
    private boolean startstop = false;
    private Button button;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.bult1);
        b2=findViewById(R.id.bult2);
        b3=findViewById(R.id.bult3);
        button=findViewById(R.id.button);
    }

    public void onClickStart(View view) {
        if (!startstop) {
            button.setText("Stop");
            startstop=true;

            new Thread( new Runnable () {
                @Override
                public void run() {
                    while (startstop) {
                        counter++;
                        switch(counter){
                            case 1:
                                b1.setBackgroundColor(getResources().getColor(R.color.green));
                                b2.setBackgroundColor(getResources().getColor(R.color.grey));
                                b3.setBackgroundColor(getResources().getColor(R.color.grey));
                                break;
                            case 2:
                                b1.setBackgroundColor(getResources().getColor(R.color.grey));
                                b2.setBackgroundColor(getResources().getColor(R.color.yellow));
                                b3.setBackgroundColor(getResources().getColor(R.color.grey));
                                break;
                            case 3:
                                b1.setBackgroundColor(getResources().getColor(R.color.grey));
                                b2.setBackgroundColor(getResources().getColor(R.color.grey));
                                b3.setBackgroundColor(getResources().getColor(R.color.red));
                                counter=0;
                                break;
                        }
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }).start();
        }
        else{
            button.setText("Start");
            startstop=false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        startstop=false;
    }
}
