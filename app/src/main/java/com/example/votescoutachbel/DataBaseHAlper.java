package com.example.votescoutachbel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHAlper extends SQLiteOpenHelper {
    public static final String CUSTOM_TABLE = "CUSTOM_TABLE";
    public static final String COLUMN_CUSTOM_NAME = "CUSTOM_NAME";
    public static final String COLUMN_CUSTOM_VOTE = "CUSTOM_VOTE";
    public static final String COLUMN_ID = "ID";

    public DataBaseHAlper(@Nullable Context context) {
        super(context,"customor.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStattement = "CREATE TABLE " + CUSTOM_TABLE + "(" + COLUMN_ID + " TEXT PRIMARY KEY, " + COLUMN_CUSTOM_NAME + " TEXT, " + COLUMN_CUSTOM_VOTE + " TEXT)";
        db.execSQL(createTableStattement);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addOne(user user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues vs = new ContentValues();
        vs.put(COLUMN_ID,user.getId_user());
        vs.put(COLUMN_CUSTOM_NAME,user.getName());
        vs.put(COLUMN_CUSTOM_VOTE,user.getVote_rep());
        long insert = db.insert(CUSTOM_TABLE, null, vs);
        return insert != -1;
    }
    public List<user> getTousLaListe()
    {
        List<user> listreturn = new ArrayList<>();
        String querystring = " SELECT * FROM " + CUSTOM_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(querystring,null);
        if (cursor.moveToFirst())
        {
            do{
                String id_leader= cursor.getString(0);
                String name_leader = cursor.getString(1);
                String vote_rep = cursor.getString(2);
                user dalilet = new user(id_leader,name_leader,vote_rep);
                listreturn.add(dalilet);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listreturn;
    }

    public boolean deleteOne(user user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryupdate = "DELETE FROM " + CUSTOM_TABLE + " WHERE " + COLUMN_ID + " = " + user.getId_user();
        Cursor cursor;
        cursor = db.rawQuery(queryupdate,null);
        cursor.close();
        db.close();
        return cursor.moveToFirst();
    }

}
