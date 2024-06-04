package com.example.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class register extends AppCompatActivity {

    EditText EdittextUserName,EditTextPassword;
    private DbHelper dbHelper;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);


        dbHelper = new DbHelper(this);
        dbHelper.OpenDB();


        EdittextUserName = findViewById(R.id.appCompactEditText);
        EditTextPassword = findViewById(R.id.appCompactEditText2);
        button = findViewById(R.id.appCompactButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(EdittextUserName.getText().toString().isEmpty() || EditTextPassword.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Fields Can't be Blank",Toast.LENGTH_LONG).show();
                } else {
                    User user = new User(EdittextUserName.getText().toString(),EditTextPassword.getText().toString());
                    if (dbHelper.RegisterUser(user)){
                        Toast.makeText(getApplicationContext(),"Registiration Succesfully",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(register.this,todo.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"User registration failed!",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }
    public void Login(View view){
        Intent intent = new Intent(this,loginActivity.class);
        startActivity(intent);
    }

}