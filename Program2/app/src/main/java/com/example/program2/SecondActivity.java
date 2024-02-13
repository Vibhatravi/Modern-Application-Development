package com.example.program2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button btn;
    ProgressBar pbar;
    TextView tview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn.findViewById(R.id.btn_alrt);
        pbar.findViewById(R.id.progressBar);
        tview.findViewById(R.id.textView2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(SecondActivity.this);
                builder.setTitle("Alert");
                builder.setPositiveButton("Accept",((dialog, which) ->
                {
                    Intent intent=new Intent(SecondActivity.this, MainActivity.class);
                    startActivity(intent);
                }));
                builder.setNegativeButton("Reject",(dialog, which) ->
                {
                    finish();
                });
                builder.setNeutralButton("Cancel",(dialog, which) ->
                {
                    dialog.cancel();
                });
            }
        });
    }
}