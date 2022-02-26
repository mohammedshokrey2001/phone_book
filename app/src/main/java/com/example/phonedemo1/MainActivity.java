package com.example.phonedemo1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {


    FloatingActionButton go_newt_view1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        go_newt_view1 = findViewById(R.id.floatingActionButton_go_next);
        /*
        VideoView videoView = findViewById(R.id.videoView001);
        String path_video = "android.resource://" +getPackageName() +"/" + R.raw.vid7;
        Uri uri = Uri.parse(path_video);
        videoView.setVideoURI(uri);
        videoView.start();

*/
        go_newt_view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AdminView1.class);
                startActivity(intent);
            }
        });

    }
}