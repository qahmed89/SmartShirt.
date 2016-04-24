package com.example.freewaresys.smartshirt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBhelper extends SQLiteOpenHelper {
    public static final String TAG = "DBhelper";
    private static final int DATABASE_VERSION =1;
    //coloumn creat accout
    private static final String DATABASE_NAME = "DBsmart.db";
    private static final String TABLE_CREATE_ACC = "create_acc";
    private static final String COLUMN_Patient_ID = "patient_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_CASE = "case";
    //coloumn doctor_information
    private static final String TABLE_DOCTOR_INFO = "doctor_info";
    private static final String COLUMN_DOCTOR_ID = "doctor_id";
    private static final String COLUMN_DOCTOR_NAME = "doctor_name";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_EMAIL_DOC = "email_doc";
    //coloumn history
    private static final String TABLE_HISTORY = "history";
    private static final String COLUMN_HISTORY_ID = "history_id";
    private static final String COLUMN_TEMPERATURE = "temperature";
    private static final String COLUMN_HEART_RATE = "heart_rate";
    private static final String COLUMN_MUSCLE = "muscle";
    private static final String COLUMN_HEARTE_PULUSE = "heart_pluse";
    //SQL CREATE TABLE
    private static final String COLUMN_SQL_CREATE_TABLE_CREATE_ACC = "CREATE TABLE " + TABLE_CREATE_ACC + "("
            +  COLUMN_Patient_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_USER_NAME + " TEXT NOT NULL, "
            + COLUMN_EMAIL + " TEXT NOT NULL, "
            + COLUMN_PASSWORD + " TEXT NOT NULL, "
            + COLUMN_CASE + " TEXT NOT NULL, "
            + COLUMN_DOCTOR_ID + " INTEGER FOREIGN KEY AUTOINCREMENT , "
            + COLUMN_HISTORY_ID + " INTEGER FOREIGN KEY AUTOINCREMENT, "

            +");";
    private static final String COLUMN_SQL_CREATE_TABLE_HISTORY = "CREATE TABLE " + TABLE_DOCTOR_INFO + "("
            +  COLUMN_DOCTOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_DOCTOR_NAME + " TEXT NOT NULL, "
            + COLUMN_EMAIL_DOC + " TEXT NOT NULL, "
            + COLUMN_PHONE + " INTEGER  , "
            +");";
    private static final String COLUMN_SQL_CREATE_TABLE_DOCTOR_INFO = "CREATE TABLE " + TABLE_HISTORY + "("
            +  COLUMN_HISTORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_TEMPERATURE + " TEXT NOT NULL, "
            + COLUMN_HEART_RATE + " TEXT NOT NULL, "
            + COLUMN_HEARTE_PULUSE + " INTEGER  , "
            +");";
    SQLiteDatabase db;





    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(COLUMN_SQL_CREATE_TABLE_CREATE_ACC);
        db.execSQL(COLUMN_SQL_CREATE_TABLE_DOCTOR_INFO);
        db.execSQL(COLUMN_SQL_CREATE_TABLE_HISTORY);


    }
    public void insertContact(Contact c) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query , null);
        int count = cursor.getCount();

        values.put(COLUMN_Patient_ID , count);
        values.put(COLUMN_USER_NAME, c.getUsername());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_PASSWORD, c.getPassword());
        values.put(COLUMN_DOCTOR_NAME, c.getDoctorname());
        values.put(COLUMN_CASE, c.getCase_patient());

        db.insert(TABLE_CREATE_ACC, null, values);
        db.close();
    }

    public String searchpass(String user_name )
    {
        db = this.getReadableDatabase();
        String query = "select user_name, password from "+TABLE_CREATE_ACC;
        Cursor cursor = db.rawQuery(query , null);
        String a, b;
        b = "not found";
        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0);

                if(a.equals(user_name))
                {
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }

        return b;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG,
                "Upgrading the database from version " + oldVersion + " to " + newVersion);
        // clear all data
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CREATE_ACC);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DOCTOR_INFO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTORY);


        // recreate the tables
        onCreate(db);
    }
    public void createUser(Contact user)
    {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_USER_NAME, user.getUsername());
        values.put(COLUMN_PASSWORD, user.getPassword());

        db.insert(TABLE_CREATE_ACC, null, values);
        db.close();
    }
    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from create_acc where id="+id+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_CREATE_ACC);
        return numRows;
    }

}
