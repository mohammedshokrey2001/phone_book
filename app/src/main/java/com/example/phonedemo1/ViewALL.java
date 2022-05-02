package com.example.phonedemo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.phonedemo1.RecycleView.ViewAdapter;

import java.util.ArrayList;

public class ViewALL extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<DataModel1> all_users;
    private ViewAdapter.RecycleViewListener listener;
    private ViewAdapter mAdapter;
    private DBHelper mDb;
    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_view_all);
        recyclerView= findViewById(R.id.Recycle_view_user);




    }


    void adapter(){
        setOnClickListener();

        mAdapter = new ViewAdapter( all_users,listener);
        RecyclerView.LayoutManager layoutManager =  new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

       /* DividerItemDecoration dividerItemDecoration  = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        */recyclerView.setAdapter(mAdapter);




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


               Toast.makeText(getApplicationContext(), "id 111 = "+all_users.get(postion).getId(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        };
    }


    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onResume() {
        super.onResume();
        mDb = new DBHelper(ViewALL.this);
        all_users = (ArrayList<DataModel1>) mDb.getAllUsers();

        adapter();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        menuItem = menu.findItem(R.id.app_bar_search2);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
               all_users = (ArrayList<DataModel1>) mDb.searchUser(s);

               adapter();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                all_users = (ArrayList<DataModel1>) mDb.searchUser(s);

                adapter();
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        com.example.phonedemo1.Menu.menuSelection(item,getApplicationContext());
        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       mDb.close();
    }
}