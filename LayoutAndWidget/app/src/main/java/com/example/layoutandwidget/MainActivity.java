package com.example.layoutandwidget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
//    Button USN,USN1;
    Switch state;
    ImageButton imgbtn;
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        USN = findViewById(R.id.name);
//        USN1 = findViewById(R.id.AGE);
        state = findViewById(R.id.adc);
        imgbtn = findViewById(R.id.imageButton);
        layout = findViewById(R.id.clayout);

//        USN.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"Toast message",Toast.LENGTH_LONG).show();
//            }
//        });
//
//        USN1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Snackbar.make(v,"Snackbar message", Snackbar.LENGTH_LONG).show();
//            }
//        });

        state.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    imgbtn.setEnabled(true);
                    state.setText("Enabled");
                }
                else
                {
                    imgbtn.setEnabled(false);
                    state.setText("Disabled");
                }
            }
        });

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Button Clicked", Snackbar.LENGTH_LONG).show();
            }
        });

        CalendarView calendarView = new CalendarView(getApplicationContext());
        calendarView.setFirstDayOfWeek(2);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
        );

        layout.addView(calendarView,params);
    }
}