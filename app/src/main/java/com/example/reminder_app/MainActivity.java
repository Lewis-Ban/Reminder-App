package com.example.reminder_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    EditText title, memo, date, time;
    Button button;
    String titleStr, memoStr, dateStr, timeStr;
    SharedPreferences sp;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToAddActivity(View view) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
        
        
        title = findViewById(R.id.textInputEditText2);
        memo = findViewById(R.id.textInputEditText);
        date = findViewById(R.id.editTextDate);
        time = findViewById(R.id.editTextTime);
        button = findViewById(R.id.button);

        sp = getSharedPreferences("Pref", Context.MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titleStr = title.getText().toString();
                memoStr = memo.getText().toString();
                dateStr = date.getText().toString();
                timeStr = time.getText().toString();

                SharedPreferences.Editor editor = sp.edit();
                editor.putString("title", titleStr);
                editor.putString("memo", memoStr);
                editor.putString("date", dateStr);
                editor.putString("time", timeStr);

            }
        });
    }

    public void goToReminderActivity(View view) {
        Intent intent = new Intent(this, ReminderActivity.class);
        startActivity(intent);
    }

}
