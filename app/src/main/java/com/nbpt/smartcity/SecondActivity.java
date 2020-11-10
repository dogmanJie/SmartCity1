package com.nbpt.smartcity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {
    EditText EDTname;
    EditText EDTpass;
    TextView text1;
    private LinearLayout Linear;
    private Button button_1, button_2, button_3,button_4,button_5;
    private String TAG = "SecondActivity";
    private String msg;
    private int ziduan;
    private CheckBox checkBox_1,checkBox_2;
    private Boolean isCheck = false;
    private Boolean isCheck2 = false;
    private SharedPreferences sp,sq,zhuce;
    private String SEDTname,SEDTpass;
    private String zhuce_name,zhuce_mima;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        EDTname = findViewById(R.id.EDTname);
        EDTpass = findViewById(R.id.EDTpass);
        Linear=findViewById(R.id.linear);
        Linear.setBackgroundColor(Color.BLUE);
        text1=findViewById(R.id.text_1);
//        EDTname.setText("admin");
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_4 = findViewById(R.id.button_4);
        button_5 = findViewById(R.id.button_5);
        button_1.setOnClickListener(listener_dis);
        button_2.setOnClickListener(listener_dis);
        button_3.setOnClickListener(listener_dis);
        button_4.setOnClickListener(listener_dis);
        button_5.setOnClickListener(listener_dis);

//        EDTname.setBackgroundColor(android.graphics.Color.RED);
//
//        EDTpass.setBackgroundColor(android.graphics.Color.RED);

        sp = SecondActivity.this.getSharedPreferences("user_info", Context.MODE_PRIVATE);
        sq = SecondActivity.this.getSharedPreferences("user_outfo", Context.MODE_PRIVATE);
        zhuce = SecondActivity.this.getSharedPreferences("zhuce_info", Context.MODE_PRIVATE);
        checkBox_1 = (CheckBox) findViewById(R.id.check_1);
        checkBox_2 = (CheckBox) findViewById(R.id.check_2);
        checkBox_1.setOnCheckedChangeListener(check_1_listener);
        checkBox_2.setOnCheckedChangeListener(check_2_listener);
        SEDTname = sp.getString("username","");
        SEDTpass = sp.getString("password","");
        zhuce_name = zhuce.getString("user","");
        zhuce_mima = zhuce.getString("pass","");

        if (sp.getBoolean(" isCheck", false)){

            EDTname.setText(SEDTname);
            EDTpass.setText(SEDTpass);
            checkBox_1.setChecked(true);
        }
        if (sq.getBoolean(" isCheck2", false)){

            checkBox_2.setChecked(true);
            Toast.makeText(SecondActivity.this, "登入成功!", Toast.LENGTH_LONG).show();
//            Intent intent = new Intent(SecondActivity.this, Main2Activity.class);
//            startActivity(intent);
        }


        EDTname.setHint("输入文本框");
        EDTpass.setHint("输入密码");
    }



    //    public void onClick (View view) {
//            String name = EDTname.getText().toString();
//            String msg = EDTpass.getText().toString();
//            if (name.equals("admin") && msg.equals("123456"))
//
//            {
//
//                Toast.makeText(SecondActivity.this, "登入成功!", Toast.LENGTH_LONG).show();
//            } else
//
//            {
//                Toast.makeText(SecondActivity.this, "登入失败!", Toast.LENGTH_LONG).show();
//            }
//        }
    CompoundButton.OnCheckedChangeListener check_2_listener =new
            CompoundButton.OnCheckedChangeListener(){

                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean a) {
                    isCheck = a;
                    sq.edit().putBoolean(" isCheck2", a).commit();
                }
            };
    CompoundButton.OnCheckedChangeListener check_1_listener =new
            CompoundButton.OnCheckedChangeListener(){

                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    isCheck = b;
                    sp.edit().putBoolean(" isCheck", b).commit();
                }
            };

    View.OnClickListener listener_dis = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {

                case R.id.button_1:
                    String name = EDTname.getText().toString();
                    String msg = EDTpass.getText().toString();
                    if ((!name.isEmpty())&&(!msg.isEmpty())) {
                        AccountDBHelper db;
                        db = new AccountDBHelper(SecondActivity.this, AccountDBHelper.VERSION_1);
                        Cursor cursor = db.select(null, null);
                        if (cursor.getCount() != 0) {
                            cursor.moveToFirst();
                            do {
                                if (name.equals(db.getUsername(cursor))){
                                    if (msg.equals(db.getPassword(cursor))) {
                                        Toast.makeText(SecondActivity.this, "登入成功!", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(SecondActivity.this, Main2Activity.class);
                                        startActivity(intent);
                                        if (isCheck){
                                            SharedPreferences.Editor editor = sp.edit();
                                            editor.putString("username", name);
                                            editor.putString("password", msg);
                                            editor.putBoolean(" isCheck", isCheck);
                                            editor.commit();
                                        }
                                        else
                                        {
                                            SharedPreferences.Editor editor = sp.edit();
                                            editor.clear();
                                        }

                                    } else
                                    {
                                        Toast.makeText(SecondActivity.this, "账号存在，密码错误!", Toast.LENGTH_LONG).show();

                                    }
                                    ziduan=1;
                                }
                            }while (cursor.moveToNext());
                            if(ziduan==0)
                            {
                                Toast.makeText(SecondActivity.this, "账号不存在!", Toast.LENGTH_LONG).show();
                                ziduan=0;
                            }
                            cursor.close();
                        }
                    }else{
                        Toast.makeText(SecondActivity.this, "账号密码未输入!", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.button_2:
                    text_1 db;
                    db = new text_1(SecondActivity.this, text_1.VERSION_1);
                    Cursor cursor = db.select(null, null);
                    if (cursor.getCount() != 0) {
                        cursor.moveToFirst();
                        do {

                            text1.setText(text1.getText()+db.getUsername(cursor)+db.getPassword(cursor)+db.gender(cursor)+db.phone(cursor)+'\n');

                        } while (cursor.moveToNext());
                        cursor.close();
                    }

                    break;
                case R.id.button_3:
                    finish();
                    Toast.makeText(SecondActivity.this, "退出成功!", Toast.LENGTH_LONG).show();
                    break;
                case R.id.button_4:
                    Intent intent = new Intent(SecondActivity.this, RegisterActivity.class);
                    startActivity(intent);
                    break;
                case R.id.button_5:
                    if(EDTname.equals(zhuce_name.trim())&&EDTpass.equals(zhuce_mima.trim())){
                        Toast.makeText(SecondActivity.this, "登入成功!", Toast.LENGTH_LONG).show();
                    }

                    break;
            }

        }
//
//
//};
//    View.OnClickListener listener_tui = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//           finish();
//            Toast.makeText(SecondActivity.this, "退出成功!", Toast.LENGTH_LONG).show();
//        }
//    };
//    View.OnClickListener listener_clear = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            String name = EDTname.getText().toString();
//            String msg = EDTpass.getText().toString();
//            if (name.equals("text") && msg.equals("123456"))
//
//            {
//
//                Toast.makeText(SecondActivity.this, "登入成功!", Toast.LENGTH_LONG).show();
//            } else
//
//            {
//                Toast.makeText(SecondActivity.this, "登入失败!", Toast.LENGTH_LONG).show();
//            }
//        }
//    };
    };
    public void onStop() {
        super.onStop();
        finish();
    }

}

