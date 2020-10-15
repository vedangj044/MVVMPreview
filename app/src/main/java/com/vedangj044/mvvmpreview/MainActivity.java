package com.vedangj044.mvvmpreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.vedangj044.mvvmpreview.loginCollection.LoginActivity;
import com.vedangj044.mvvmpreview.recycleCollection.RecycleActivity;
import com.vedangj044.mvvmpreview.registerCollection.RegisterActivity;
import com.vedangj044.mvvmpreview.roomCollection.BookActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = null;

                if(v.getId() == R.id.login_screen){
                    intent = new Intent(MainActivity.this, LoginActivity.class);
                }

                if(v.getId() == R.id.register_screen){
                    intent = new Intent(MainActivity.this, RegisterActivity.class);
                }

                if(v.getId() == R.id.recycler_screen){
                    intent = new Intent(MainActivity.this, RecycleActivity.class);
                }

                if(v.getId() == R.id.book_screen){
                    intent = new Intent(MainActivity.this, BookActivity.class);
                }

                startActivity(intent);
            }
        };

        Button b1 = findViewById(R.id.login_screen);
        b1.setOnClickListener(clickListener);

        Button b2 = findViewById(R.id.register_screen);
        b2.setOnClickListener(clickListener);

        Button b3 = findViewById(R.id.recycler_screen);
        b3.setOnClickListener(clickListener);

        Button b4 = findViewById(R.id.book_screen);
        b4.setOnClickListener(clickListener);


    }
}