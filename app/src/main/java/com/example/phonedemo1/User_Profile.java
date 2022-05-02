package com.example.phonedemo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class User_Profile extends AppCompatActivity {

    public  static final String EMAIL="name";
    public  static final  String First_NAME="name";
    public  static final  String SEC_NAME="name";
    public  static final  String PASS="name";
    public  static final  String AGE="name";
    public  static final  String PHONR_NUMBER="name";
    public  static final  String ID="name";

    TextView first_name;
    TextView last_name;
    TextView phone;
    TextView email;
    TextView age;
    String id_;
    FloatingActionButton next_bt;
    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        setContentView(R.layout.activity_user_profile);
        first_name = findViewById(R.id.et_number_emp);
        last_name = findViewById(R.id.et_number_clients);
        phone = findViewById(R.id.et_number_loans);
        email = findViewById(R.id.et_total_balancee);
        age = findViewById(R.id.et_total_salaries);
        next_bt = findViewById(R.id.floatingActionButton);
        Intent intent = getIntent();

        /*id_ = intent.getStringExtra("id");

        Toast.makeText(getApplicationContext(), "the id is "+ id_, Toast.LENGTH_SHORT).show();
*/


        String [] full = intent.getStringExtra("name").split(" ");
        String ephone = intent.getStringExtra("phone");
        String eeemail = intent.getStringExtra("mail");
        String eage = intent.getStringExtra("age");
        String ide = intent.getStringExtra("id");
        first_name.setText(full[0]);
        last_name.setText(full[1]);
        phone.setText(ephone);
        email.setText(eeemail);
        age.setText(eage);


        next_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_edit = new Intent(getApplicationContext(),EditContact.class);
                go_edit.putExtra("id",ide);
             //   Toast.makeText(getApplicationContext(),"THE ID NOW IN USERPROFILE IS "+ide,Toast.LENGTH_LONG).show();

                startActivity(go_edit);

            }
        });


    }






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