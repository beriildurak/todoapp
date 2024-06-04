package com.example.todoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class DbHelper {

    private Context con;
    private SQLiteDatabase db;

    public DbHelper(Context con) {this.con=con;}

    public DbHelper OpenDB(){
        DbConnector dbCon = new DbConnector(con);
        db =dbCon.getWritableDatabase();
        return this;
    }

    public boolean RegisterUser(User user){
        try {
            ContentValues cv = new ContentValues();
            cv.put("UserName",user.getUserName());
            cv.put("Password",user.getPassword());

            db.insert("register",null,cv);
            return true;
        }catch (Exception e){
            Toast.makeText(con,e.getMessage(),Toast.LENGTH_LONG).show();
            return false;
        }

    }
}
