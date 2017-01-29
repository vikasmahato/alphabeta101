package com.example.naman.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.StringBuilderPrinter;

/**
 * Created by Vishal on 27-Jan-17.
 */
public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "tracker.db";
    public static final String TABLE_DAYS = "performance_tracker";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_WORKOUT = "_work";
    public static final String COLUMN_PERFORMANCE = "_perf";

    public MyDBHandler(Context context, int version) {
        super(context, DATABASE_NAME,null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE "+TABLE_DAYS+" ("+
                COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_PERFORMANCE+" TEXT, "+
                COLUMN_WORKOUT+" TEXT);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_DAYS);
        onCreate(db);

    }
/*
    public void addDay(Days days){

        ContentValues values = new ContentValues();
        values.put(COLUMN_WORKOUT,days.get_workout());
        values.put(COLUMN_PERFORMANCE,days.get_performance());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_DAYS,null,values);
        db.close();

    }
*/
public String databasetoString() {
        /*
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM "+TABLE_DAYS+" WHERE 1";

        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();
        int i=1;
        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("_work"))!=null){
                dbString+= "Day ";
                dbString+= i+" : ";
                i++;
                dbString+= c.getString(c.getColumnIndex("_work"));
                dbString+=" ";
                dbString+= c.getString(c.getColumnIndex("_perf"));
                dbString+="\n";
            }
        }
        db.close();
        return dbString;
        */
    String dbString = "";
    SQLiteDatabase db = getWritableDatabase();
    Cursor allRows = db.rawQuery("SELECT * FROM " + TABLE_DAYS, null);
    if (allRows.moveToFirst()) {
        String[] columnNames = allRows.getColumnNames();
        do {
            for (String name : columnNames) {
                dbString += String.format("%s: %s ", name,
                        allRows.getString(allRows.getColumnIndex(name)));
            }
            dbString += " ";

        } while (allRows.moveToNext());
    }

    return dbString;
}


}
