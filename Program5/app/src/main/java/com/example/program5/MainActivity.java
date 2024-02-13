package com.example.program5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText uname,pswd;
    Button login,cancel;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname = findViewById(R.id.editText);
        pswd = findViewById(R.id.editText2);
        login = findViewById(R.id.button2);
        cancel = findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = uname.getText().toString();
                String password = pswd.getText().toString();

                int id = checkUser(new User(name,password));
                if(id == -1){
                    Snackbar.make(v,"User "+name+" does not exist",Snackbar.LENGTH_LONG).show();
                }
                else {
                    Snackbar.make(v,"User "+name+" exist",Snackbar.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(i);
                }
            }
        });

        db = new DBHandler(MainActivity.this);
        db.addUser(new User("Vibha","12345"));
        db.addUser(new User("GNU","linux"));
    }

    public int checkUser(User user)
    {
        return db.CheckUser(user);
    }
}