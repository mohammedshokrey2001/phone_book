package com.example.phonedemo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

public class AboutApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        MenuItem menuItem;

        menuItem = findViewById( R.id.app_bar_search2);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setVisibility(View.INVISIBLE);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        com.example.phonedemo1.Menu.menuSelection(item,getApplicationContext());
        return super.onOptionsItemSelected(item);

    }
}