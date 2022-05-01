package com.example.phonedemo1;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public  final  class Menu  {

         static Context mContext ;
         public final static  void close(){
             android.os.Process.killProcess(android.os.Process.myPid());
             System.exit(1);

         }

         public final static void aboutApp(Context context){
             mContext = context;
             Intent i = new Intent(mContext, AboutApp.class);
             i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
             context.startActivity(i);
         }
    public final static void setting(Context context){
        mContext = context;
        Intent i = new Intent(mContext, SettingsActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);


    }


    public final static void menuSelection(MenuItem item ,Context context){

        int id = item.getItemId();
        if (id==R.id.Close){
           close();
        }
        else if (id ==R.id.About_App){
            aboutApp(context);
        }
        else if (id ==R.id.Setting){
            com.example.phonedemo1.Menu.setting(context);
        }

    }

}
