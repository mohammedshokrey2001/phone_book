package com.example.phonedemo1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static final String USER_TABLE = "USER_TABLE";
    public static final String ID1 = "id";
    public static final String ID = ID1;
    public static final String NAME = "NAME";
    public static final String PHONE1 = "PHONE";
    public static final String PHONE = PHONE1;
    public static final String ACTIVE_CUSTOMER = "ACTIVE_CUSTOMER";
    public static final String USER_DATA_TABLE = "USER_DATA_TABLE";
    public static final String FULL_NAME = "fullName";
    public static final String EMAIL = "EMAIL";
    public static final String PASS = "PASS";
    public static final String AGE = "AGE";
    private  final Context context;
    private static final String DATABASE_NAME = "mysqldb.db";
    private static final int DATABASE_VERISON = 1;




    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERISON);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
         String create_Statment = "Create Table " + USER_TABLE + " ( " + ID + "  INTEGER PRIMARY KEY AUTOINCREMENT,  "
                 + NAME + "  VARCHAR(40),  "
                 + PHONE + "  VARCHAR(14),  " +
                 ACTIVE_CUSTOMER + "  BOOL  , " +
                  EMAIL + "  VARCHAR(14) , " +
                 AGE + " VARCHAR(2) "+
                 " ); "      ;




         sqLiteDatabase.execSQL(create_Statment);

    }


    public  boolean addUser(DataModel1 dataModel1){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(NAME ,dataModel1.getName());
        cv.put(PHONE,dataModel1.getPhone_number());
        cv.put(ACTIVE_CUSTOMER,dataModel1.isIs_Active());
        cv.put(EMAIL,dataModel1.getMail());
        cv.put(AGE, dataModel1.getAge());

         long insert = db.insert(USER_TABLE ,null,cv);

         if ( insert==-1){

             return  false;
         }else {
             return true;
         }

    }



    public List<DataModel1> getAllUsers(){
        List<DataModel1> returnList = new ArrayList<DataModel1>();
        String query = "SELECT * FROM "+USER_TABLE +"  ; ";

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select *  from  " +
                        USER_TABLE ,
                new String[]{ });
        if (cursor.moveToFirst()){
            do{
                String name = cursor.getString(1);
                int id = cursor.getInt(0);
                String phone = cursor.getString(2);
                boolean active_state = cursor.getInt(3)==1 ? true :false ;
                String mail = cursor.getString(4);
                String age = cursor.getString(5);



                DataModel1 dataModel1 = new DataModel1(id,name,phone, age, mail, active_state);

                returnList.add(dataModel1);
            }while (cursor.moveToNext());

        }else {
            /////

        }
         return  returnList;
    }


    void EditUser(String filed , String data, String id){
        //name n
        //phone p
        //age a
        //mail m
        SQLiteDatabase database = getWritableDatabase();
        String query = null;

       int  id_int = Integer.parseInt(id);
        if (filed.equals("Age")){
            query = "update "+USER_TABLE + " set  "+ AGE + " = " + " '"  + data+  "' " +" where " + ID  +" = " +id_int+" ;" ;
        }
        else if (filed.equals("Phone")){
            query = "update "+USER_TABLE + " set  "+ PHONE + " = " + " '"  + data+  "' " +" where " + ID  +" = " +id_int+" ;" ;

        }

        else if (filed.equals("Mail")){
            query = "update "+USER_TABLE + " set  "+ EMAIL + " = " + " '"  + data+  "' " +" where " + ID  +" = " +id_int+" ;" ;

        }
        else if (filed.equals("Name")){
            query = "update "+USER_TABLE + " set  "+ NAME + " = " + " '"  + data+  "' " +" where " + ID  +" = " +id_int+" ;" ;

        }

        try (Cursor cursor = database.rawQuery(query, null)) {

            if (cursor.moveToFirst()){
                Log.i("edit user", "EditUser: "+id);

            }
            else {
                Log.i(" un edit user", "EditUser: "+id);

            }
        }



    }


    public  List<DataModel1> searchUser(String name){
        SQLiteDatabase database = getReadableDatabase();
        List<DataModel1> returnList = new ArrayList<DataModel1>();

        String query = " SELECT * FROM "+USER_TABLE +" WHERE "+NAME +" like '%"+ name +"%';";
        Cursor cursor = database.rawQuery(query,new String[]{});
        if (cursor.moveToFirst()){
            do{
                String namee = cursor.getString(1);
                int id = cursor.getInt(0);
                String phone = cursor.getString(2);
                boolean active_state = cursor.getInt(3)==1 ? true :false ;
                String mail = cursor.getString(4);
                String age = cursor.getString(5);



                DataModel1 dataModel1 = new DataModel1(id,namee,phone, age, mail, active_state);

                returnList.add(dataModel1);
            }while (cursor.moveToNext());

        }else {
            /////

        }
        return  returnList;


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
