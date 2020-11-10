package com.nbpt.smartcity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class WelcomeActivity extends Activity {
    TextView Tvskip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Tvskip =  findViewById(R.id.tvskip);

        countDownTimer.start();
    }


    CountDownTimer countDownTimer = new CountDownTimer(3000, 1000) {
        @Override
        public void onTick(long l) {
            Tvskip.setText(getString(R.string.skip_wait, (1 / 1000)));
        }

        @Override
        public void onFinish() {
            Tvskip.setText("正在跳转");
            finish();
            Intent intent = new Intent(WelcomeActivity.this,SecondActivity.class);
            startActivity(intent);
        }
    };

        CountDownTimer timer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long sin) {
//                Toast.makeText(WelcomeActivity.this, "" + sin / 1000, Toast.LENGTH_SHORT).show();
                Tvskip.setText(getString(R.string.skip_wait,(1/1000)));
            }

            @Override
            public void onFinish() {
                Toast.makeText(WelcomeActivity.this, "倒计时完成", Toast.LENGTH_SHORT).show();
            }
        };


    public void onSkipClick(View view){
        if (countDownTimer!=null) {
            countDownTimer.cancel();
        }
        finish();
        Intent intent = new Intent(WelcomeActivity.this,SecondActivity.class);
        startActivity(intent);
    }

}
