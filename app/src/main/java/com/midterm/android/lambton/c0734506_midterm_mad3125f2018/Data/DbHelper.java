package com.midterm.android.lambton.c0734506_midterm_mad3125f2018.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper
{
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Database.db";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE electricity_bill (" +
                    " customerId TEXT PRIMARY KEY, " +
                    " customerName TEXT," +
                    " customerEmail TEXT," +
                    " gender TEXT," +
                    " billDate NUMERIC," +
                    " unitConsumed REAL)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS electricity_bill";

    public DbHelper (Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        onUpgrade(db, oldVersion, newVersion);
    }
}
