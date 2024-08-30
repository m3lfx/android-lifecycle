package com.example.lifecycle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText name;
    Button button1, button2;
    int counter = 0;
    EditText userMessage;
    CheckBox remember;
    String userName, message,count;
    Boolean isChecked;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        name = findViewById(R.id.editText);
        remember = findViewById(R.id.checkBox);
        userMessage = findViewById(R.id.userMessage);
        retrieveData();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter += 1;
                textView.setText("" + counter);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = name.getText().toString();
                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                i.putExtra("user", userName);
                startActivity(i);
            }
        });

        Log.d("message", "on create");

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        Log.d("message", "first activity ondestroy");
    }

    @Override
    protected void onPause() {
        saveData();
        super.onPause();

        Log.d("message", "first activity onPause");
    }

    @Override
    protected void onStop() {

        super.onStop();
        Log.d("message", "first activity onStop");
    }

    @Override
    protected void onStart() {

        super.onStart();
        Log.d("message", "first activity onStart");
    }

    @Override
    protected void onResume() {

        super.onResume();
        Log.d("message", "first activity onResume");
    }

    @Override
    protected void onRestart() {

        super.onRestart();
        Log.d("message", "first activity onRestart");
    }

    public void saveData() {
        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        userName = name.getText().toString();
        message = userMessage.getText().toString();
        count =  textView.getText().toString();
        if (remember.isChecked()) {
            isChecked = true;
        } else {
            isChecked = false;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", userName);
        editor.putString("message", message);
        editor.putString("count", count);
        editor.putBoolean("remember", isChecked);
        editor.commit();

        Toast.makeText(getApplicationContext(), "your data is saved", Toast.LENGTH_SHORT).show();

    }

    public void retrieveData() {
        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        userName = sharedPreferences.getString("name", null);
        message = sharedPreferences.getString("message", null);
        counter = sharedPreferences.getInt("count", 0);
        isChecked = sharedPreferences.getBoolean("remember", false);
        name.setText(userName);
        userMessage.setText(message);
        textView.setText(count);

        if (isChecked) {
            remember.setChecked(true);
        }
        else {
            remember.setChecked(false);
        }

    }
}