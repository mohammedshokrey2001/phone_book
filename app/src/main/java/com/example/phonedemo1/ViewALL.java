package com.example.phonedemo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.phonedemo1.RecycleView.ViewAdapter;

import java.util.ArrayList;

public class ViewALL extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<DataModel1> all_users;
    private ViewAdapter.RecycleViewListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_view_all);
        recyclerView= findViewById(R.id.Recycle_view_user);


      adapter();





    }


    void adapter(){
        setOnClickListener();
        DBHelper db = new DBHelper(ViewALL.this);
         all_users = (ArrayList<DataModel1>) db.getAllUsers();
        ViewAdapter adapter = new ViewAdapter( all_users,listener);
        RecyclerView.LayoutManager layoutManager =  new LinearLayoutManager(getApplication());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        DividerItemDecoration dividerItemDecoration  = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);




    }

    private void setOnClickListener() {
        listener = new ViewAdapter.RecycleViewListener() {
            @Override
            public void onClick(View v, int postion) {
                Intent intent = new Intent(getApplicationContext(),User_Profile.class);
                String idd = String.valueOf(all_users.get(postion).getId());

                intent.putExtra("name", all_users.get(postion).getName());
                intent.putExtra("age", all_users.get(postion).getAge());
                intent.putExtra("mail", all_users.get(postion).getMail());
                intent.putExtra("phone", all_users.get(postion).getPhone_number());
                intent.putExtra("id", idd);


               // Toast.makeText(getApplicationContext(), "id 111 = "+all_users.get(postion).getId(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        };
    }


}