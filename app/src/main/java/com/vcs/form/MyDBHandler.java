package com.vcs.form;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "form.db";
    public static final String TABLE_FORM = "form";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "_name";
    public static final String COLUMN_DOB = "_dob";
    public static final String COLUMN_ADDRESS = "_address";
    public static final String COLUMN_PHONE = "_phno";
    public static final String COLUMN_EMAIL = "_emailid";
    //public static final String COLUMN_OCCUPATION="_occuid";
    public static final String TABLE_OCCUPATION = "occupation";
    public static final String COLUMN_OCCUPATIONID = "_occuid";
    public static final String COLUMN_OCCUPATIONNAME = "_occuname";

    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_FORM + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " VARCHAR(20), " + COLUMN_DOB + " VARCHAR(10), " + COLUMN_ADDRESS + " VARCHAR(100), " +
                COLUMN_PHONE + " BIGINT, " + COLUMN_EMAIL + " VARCHAR(100) , " + COLUMN_OCCUPATIONID + " INTEGER);";
        db.execSQL(query);
        String query2 = "CREATE TABLE " + TABLE_OCCUPATION + " ( " + COLUMN_OCCUPATIONID + " INTEGER PRIMARY KEY INCREMENT BY 10, " +
                COLUMN_OCCUPATIONNAME + " VARCHAR(20));";
        db.execSQL(query2);
        String query3 = "INSERT INTO " + TABLE_OCCUPATION + " VALUES (10, 'salesman' );";
        db.execSQL(query3);
        String query4 = "INSERT INTO " + TABLE_OCCUPATION + " VALUES (20, 'Businessman' );";
        db.execSQL(query4);
        String query5 = "INSERT INTO " + TABLE_OCCUPATION + " VALUES (30, 'engineer' );";
        db.execSQL(query5);
        String query6 = "INSERT INTO " + TABLE_OCCUPATION + " VALUES (40, 'Artist' );";
        db.execSQL(query6);
        String query7 = "INSERT INTO " + TABLE_OCCUPATION + " VALUES (50, 'Teacher' );";
        db.execSQL(query7);
        String query8 = "INSERT INTO " + TABLE_OCCUPATION + " VALUES (60, 'Chartered Accountant' );";
        db.execSQL(query8);
        String query9 = "INSERT INTO " + TABLE_OCCUPATION + " VALUES (70, 'Comedian' );";
        db.execSQL(query9);
        String query10 = "INSERT INTO " + TABLE_OCCUPATION + " VALUES (80, 'Sportsman' );";
        db.execSQL(query10);
        /*String query3="SELECT * from " + TABLE_FORM + " t INNER JOIN " + TABLE_OCCUPATION + " o ON t. " + COLUMN_OCCUPATIONID +
                " = o. " + COLUMN_OCCUPATIONID + ".";*/
        //db.execSQL(query3);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int OldVersion, int NewVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FORM);
        onCreate(db);
    }


    //Add a new row to the db
    public void addProduct(com.vcs.form.transfer products) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, products.get_name());
        values.put(COLUMN_DOB, products.get_dob());
        values.put(COLUMN_ADDRESS, products.get_address());
        values.put(COLUMN_PHONE, products.get_phno());
        values.put(COLUMN_EMAIL, products.get_emailid());
        values.put(COLUMN_OCCUPATIONID, products.get_occuid());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_FORM, null, values);
        db.close();

    }

    //Getting a single record
    public String getdata(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        /*String query3="SELECT * from " + TABLE_FORM + " t INNER JOIN " + TABLE_OCCUPATION + " o ON t. " + COLUMN_OCCUPATIONID +
                " = o. " + COLUMN_OCCUPATIONID + ".";
        db.execSQL(query3);*/

        Cursor cursor = db.query(TABLE_FORM, new String[] { COLUMN_ID,
                        COLUMN_NAME, COLUMN_DOB, COLUMN_ADDRESS, COLUMN_PHONE, COLUMN_EMAIL, COLUMN_OCCUPATIONID}, COLUMN_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        String ans="Name : "+cursor.getString(cursor.getColumnIndex("_name"))+"\n"+"\n"+
                   "Date Of Birth : "+cursor.getString(cursor.getColumnIndex("_dob"))+"\n"+"\n"+
                   "Address : "+cursor.getString(cursor.getColumnIndex("_address"))+"\n"+"\n"+
                   "Phone no : "+cursor.getString(cursor.getColumnIndex("_phno"))+"\n"+"\n"+
                   "Email id : "+cursor.getString(cursor.getColumnIndex("_emailid"))+"\n";
        return ans;

    }

    //Delete a row
    public boolean deleteValues(int num)
    {
        SQLiteDatabase db=getWritableDatabase();
        return db.delete(TABLE_FORM, COLUMN_ID + "=" + num, null) > 0;
    }


    //Display DB records
    public List<String> getalldata()
    {
        List<String> l=new ArrayList<String>();
        SQLiteDatabase db=getWritableDatabase();
        String query = "SELECT * from " + TABLE_FORM;
        Cursor cursor = db.rawQuery(query,null);


        if (cursor.moveToFirst()) {
            do {
                String dbString=" ";
                dbString =cursor.getString(cursor.getColumnIndex("_id"))+"_"+cursor.getString(cursor.getColumnIndex("_name"));
                l.add(dbString);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return l;
    }

    public Cursor getAllTitles()
    {
        SQLiteDatabase db=getWritableDatabase();
        return db.query(TABLE_FORM, new String[] {
                        COLUMN_ID,
                        COLUMN_NAME,
                        COLUMN_DOB,
                        COLUMN_ADDRESS,
                        COLUMN_PHONE,COLUMN_EMAIL   },
                null,
                null,
                null,
                null,
                null);
    }



}





