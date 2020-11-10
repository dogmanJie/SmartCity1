package com.nbpt.smartcity;

import android.app.Activity;
import android.os.Bundle;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    public void onStop() {
        super.onStop();
        finish();
    }
}
