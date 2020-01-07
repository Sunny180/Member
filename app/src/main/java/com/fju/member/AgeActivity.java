package com.fju.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
    }
    public void login(View view) {
        EditText edage = findViewById(R.id.age);
        String age = edage.getText().toString();
        if (age.length() > 0) { //登入成功
            SharedPreferences setting = getSharedPreferences("Member", MODE_PRIVATE);
            setting.edit()
                    .putString("PREF_USERID", age)
                    .apply();
            getIntent().putExtra("LOGIN_USERID", age);
            setResult(RESULT_OK, getIntent());
            finish();
        }
    }
    }