package com.nbpt.smartcity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {

    EditText name , pass;
    Button zhuce;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        sp = RegisterActivity.this.getSharedPreferences("zhuce_info", Context.MODE_PRIVATE);
        name = findViewById(R.id.name);
        pass = findViewById(R.id.pass);
        zhuce = findViewById(R.id.zhuce);
        zhuce.setOnClickListener(zhuce_Listener);


    }

    View.OnClickListener zhuce_Listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String yonghu = name.getText().toString();
            String msg = pass.getText().toString();
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("user", yonghu);
            editor.putString("pass", msg);
            editor.commit();
            Toast.makeText(RegisterActivity.this, "注册成功!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(RegisterActivity.this, SecondActivity.class);
            startActivity(intent);
        }
    };

}
