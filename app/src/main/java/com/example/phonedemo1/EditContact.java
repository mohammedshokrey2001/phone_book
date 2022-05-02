package com.example.phonedemo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SearchView;

public class EditContact extends AppCompatActivity {



    RadioGroup edit_field ;
    EditText input;
    Button done;
    RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        edit_field = findViewById(R.id.radioGroup2);
        done = findViewById(R.id.button_done_edit);
        input = findViewById(R.id.editTextTextPersonName2);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selected = edit_field.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selected);
                DBHelper helper = new DBHelper(getApplicationContext());

                helper.EditUser(radioButton.getText().toString(),input.getText().toString(),id);

             startActivity(new Intent(getApplicationContext(),ViewALL.class));
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        com.example.phonedemo1.Menu.menuSelection(item,getApplicationContext());
        return super.onOptionsItemSelected(item);

    }


}