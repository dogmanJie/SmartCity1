package com.nbpt.smartcity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2020/9/23.
 */

public class AccountDBHelper extends SQLiteOpenHelper {
    private Context mcontext;
    private static final String DB_NAME="user.db";
    private static final String DB_NAME_1="account.db";
    private int ziduan;
    static final
    String TABLE_Name = "tb_accounts";
    String TABLE_Name_1 = "tb_users";
    static final int VERSION_1 = 1;
    public AccountDBHelper(Context context,int version) {
        super(context, DB_NAME, null, version);
        this.mcontext = context;
    }
    public Cursor select(String where, String orderby){
        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM " + TABLE_Name);
        if (where != null){
            stringBuilder.append(" WHERE ");
            stringBuilder.append(where);
        }
        if (orderby != null){
            stringBuilder.append(" ORDER BY ");
            stringBuilder.append(orderby);
        }
        return getWritableDatabase().rawQuery(stringBuilder.toString(), null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public String getUsername(Cursor cursor){
        return cursor.getString(1);
    }
    public String getPassword(Cursor cursor){
        return cursor.getString(2);
    }
    public String gender(Cursor cursor){
        return cursor.getString(3);
    }
    public String phone(Cursor cursor){
        return cursor.getString(4);
    }
}
