package com.example.database_recy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.database_recy.Preference.MySharePreferences;
import com.example.database_recy.danhsachthuchi.DanhSachThuChi;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private String TABLE_USERS = "TABLE_USERS";
    private String COLUMN_USER_ID = "USER_ID";
    private String COLUMN_USERNAME = "USERNAME";
    private String COLUMN_PASSWORD = "PASSWORD";
    private String COLUMN_NUMBER = "NUMBER";
    private String COLUMN_EMAIL = "EMAIL";
    private String COLUMN_NOTE = "NOTE";
    private String COLUMN_MONEY = "MONEY";
    private String COLUMN_THU_CHI = "THU_CHI";
    private String COLUMN_DATE = "COLUMN_DATE";
    private String TABLE_USER_INFOR = "TABLE_USER_INFOR";
    private String COLUMN_USER_INFOR_ID = "USER_INFOR_ID";
    MySharePreferences mySharePreferences;

    public DatabaseHelper(@Nullable Context context) {
        super(context, "QuanLy.db", null, 1);

    }
    // query data
    String query = "CREATE TABLE TABLE_USER_INFOR  (  USER_INFOR_ID  int primary key AUTOINCREMENT, USER_ID   int ,   NOTE  TEXT, COLUMN_MONEY  TEXT, DATE  DATE, THU_CHI TEXT, foreign key ( USER_ID ) REFERENCES TABLE_USERS( USER_INFOR_ID ));";
    public void queryData(String sqlQuery) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sqlQuery);
    }

    public Cursor getData(String sqlQuery) {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sqlQuery, null);
    }
    // em sửa lại db nên xóa bỏ cái db cũ
    @Override
    public void onCreate(SQLiteDatabase myDb) {
        String queryCreate = "CREATE TABLE " + TABLE_USERS + "(" + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                COLUMN_USERNAME + " TEXT UNIQUE , " + COLUMN_PASSWORD + " TEXT , " + COLUMN_NUMBER + " VARCHAR(12) , " + COLUMN_EMAIL + " TEXT );";

        queryData(queryCreate);
       queryData(query);
    }
// helo đợi em sửa cái nó ra lỗi
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean addUser (UsersModel usersModel) {
        SQLiteDatabase mydb = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME , usersModel.getUsername());
        values.put(COLUMN_PASSWORD , usersModel.getPassword() );
        values.put(COLUMN_NUMBER , usersModel.getNumber());
        values.put(COLUMN_EMAIL , usersModel.getEmail());
        long insert = mydb.insert(TABLE_USERS, null, values);
        if(insert == -1){
            return false;
        }else {
            return true;
        }
    }
    public boolean addUserInfor(UsersModel usersModel , String userID){


        SQLiteDatabase mydb = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_ID , userID);
        values.put(COLUMN_NOTE , usersModel.getNote());
        values.put(COLUMN_MONEY , usersModel.getMoney());
        values.put(COLUMN_DATE , String.valueOf(usersModel.getDate()));
        values.put(COLUMN_THU_CHI , usersModel.getThu_chi());
        long insert = mydb.insert(TABLE_USER_INFOR, null , values);
        if(insert == -1) {
            return false;
        }else{
            return true;
        }
    }


    public Boolean checkUser(UsersModel usersModel) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_USERS + " where " +  COLUMN_USERNAME + " = ?", new String[]{usersModel.getUsername()});
        if (cursor.getCount() > 0) {
            return false;
        } else {
            return true;
        }
    }
    public Boolean checkUsernamePassword ( UsersModel usersModel) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db. rawQuery("select * from " + TABLE_USERS + " where " + COLUMN_USERNAME +" = ?  and " + COLUMN_PASSWORD + " = ? " , new String[] {usersModel.getUsername() , usersModel.getPassword()});
        if(cursor.getCount() > 0) {
            return true;
        }else{
            return false;
        }
    }
    public List<UsersModel> getEveryOne() {
        List<UsersModel> returnlist = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_USER_INFOR;
        Cursor cursor = db.rawQuery(query , null);
        if(cursor.moveToFirst()) {
            do {
                String date = cursor.getString(1);
                String note = cursor.getString(2);
                String money = (cursor.getString(3));
                String thuchi = cursor.getString(4);
                UsersModel newCustomer = new UsersModel(note , Integer.parseInt(money), thuchi);
                returnlist.add(newCustomer);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return returnlist;
    }
    public List<DanhSachThuChi> dsThuChi() {
        List<DanhSachThuChi> returnlist = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_USER_INFOR;
        Cursor cursor = db.rawQuery(query , null);
        if(cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String note = cursor.getString(2);
                String money = cursor.getString(3);
                DanhSachThuChi ds = new DanhSachThuChi(id , note , Integer.parseInt(money) , "16/2/2002");
                returnlist.add(ds);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return returnlist;
    }
//    private String column_id = "COLUMN_ID";
//    private String column_customer_name = "COLUMN_CUSTOMER_NAME";
//    private String column_customer_age = "COLUMN_CUSTOMER_AGE";
//    private String column_ative_customer = "COLUMN_ATIVE_CUSTOMER";
//    private String customers_table = "CUSTOMERS";
//
//    public DatabaseHelper(@Nullable Context context) {
//        super(context, "customer.db", null, 1);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase mydb) {
//        String query = "CREATE TABLE " + customers_table + " (" + column_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + column_customer_name + " TEXT, " + column_customer_age + " INT, " + column_ative_customer + " BOOL)";
//        mydb.execSQL(query);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//
//    }
//    public Boolean addCustomer (UsersModel customerModel) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(column_customer_name, customerModel.getName());
//        values.put(column_customer_age, customerModel.getAge());
//        values.put(column_ative_customer, customerModel.isActive());
//        long insert = db.insert(customers_table, null, values);
//        if (insert == -1) {
//            return false;
//        } else {
//            return true;
//        }
//    }

//    public boolean deleteCustomer () {
//        // find customer model in the database . if it found , delete it if return true
//        // if it is not found return false
//        return true;
//    }
}
