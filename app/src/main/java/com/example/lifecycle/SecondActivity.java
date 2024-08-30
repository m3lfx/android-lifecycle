package com.example.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    Button button;
TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        button = findViewById(R.id.button3);
        name = findViewById(R.id.textView2);
        Intent intent = getIntent();

        String userName = intent.getStringExtra("user");
        name.setText(userName);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
        Log.d("message", "second activity oncrate");
    }
    @Override
    protected void onDestroy() {

        super.onDestroy();
        Log.d("message", "second activity ondestroy");
    }

    @Override
    protected void onPause() {

        super.onPause();
        Log.d("message", "second activity onPause");
    }

    @Override
    protected void onStop() {

        super.onStop();
        Log.d("message", "second activity onStop");
    }

    @Override
    protected void onStart() {

        super.onStart();
        Log.d("message", "second activity onStart");
    }

    @Override
    protected void onResume() {

        super.onResume();
        Log.d("message", "second activity onResume");
    }

    @Override
    protected void onRestart() {

        super.onRestart();
        Log.d("message", "second activity onRestart");
    }
}