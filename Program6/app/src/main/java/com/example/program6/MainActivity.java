package com.example.program6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText msg_txt, mob_no;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msg_txt = findViewById(R.id.txt_msg);
        mob_no = findViewById(R.id.mbl_num);
        send = findViewById(R.id.btn);
    }

    public void onClick(View view){
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(mob_no.getText().toString(),null,msg_txt.getText().toString(),null,null);
            Snackbar.make(view,"SMS sent successfully", Snackbar.LENGTH_LONG).show();
        }
        catch (Exception e){
            Snackbar.make(view,"SMS is not sent", Snackbar.LENGTH_LONG).show();
        }
    }
}