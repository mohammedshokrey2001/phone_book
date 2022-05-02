package com.example.phonedemo1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AdminView1 extends AppCompatActivity {

    Button add;
    Button view_all;
    EditText name;
    EditText phone;
    EditText mail;
    EditText age;

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch aSwitch_state ;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view1);

        add = findViewById(R.id.ADD_USER);
        view_all = findViewById(R.id.VIEW_ALL_USERS);
        aSwitch_state = findViewById(R.id.USER_State);
        name = findViewById(R.id.editTextTextPersonName);
        phone = findViewById(R.id.editTextPhone);
        mail = findViewById(R.id.editTextTextEmailAddress);
        age = findViewById(R.id.editTextNumberDecimal);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {


                    DBHelper dbHelper = new DBHelper(AdminView1.this);

                    if (name.getText().toString().equals("") ||
                            phone.getText().toString().equals("") ||
                            age.getText().toString().equals("") ||
                            mail.getText().toString().equals("") ){
                        Toast.makeText(getApplicationContext(), "you must fill all fileds", Toast.LENGTH_SHORT).show();

                    }

                    else
                        {
                        DataModel1 dataModel1 = new DataModel1(0, name.getText().toString(), phone.getText().toString(), age.getText().toString(), mail.getText().toString(), aSwitch_state.isChecked());

                        boolean addUser = dbHelper.addUser(dataModel1);
                        Toast.makeText(AdminView1.this, "the state is" + addUser, Toast.LENGTH_LONG).show();
                        name.setText("");
                        phone.setText("");
                        mail.setText("");
                        age.setText("");

                    }
                }catch (Exception e){
                    Toast.makeText(AdminView1.this, "error in database entry", Toast.LENGTH_LONG).show();

                }

            }
        });



        view_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(AdminView1.this, ViewALL.class);
                startActivity(intent);
             //   Toast.makeText(AdminView1.this, all_users.toString(), Toast.LENGTH_LONG).show();


            }
        });
    }


/*
    void adapter(){
        DBHelper db = new DBHelper(AdminView1.this);
        ArrayList<DataModel1> all_users = (ArrayList<DataModel1>) db.getAllUsers();
        ViewAdapter adapter = new ViewAdapter(all_users);
        RecyclerView.LayoutManager layoutManager =  new LinearLayoutManager(getApplication());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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