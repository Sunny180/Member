package com.fju.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    boolean logon = false;
    private static final int RC_LOGIN=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!logon){
            Intent login = new Intent(this , NicknameActivity.class);
            getIntent().putExtra("Nickname",-1);
            startActivityForResult(login ,RC_LOGIN );
        }
    }
    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_LOGIN) {
            if (resultCode == RESULT_OK) {
                String uid = data.getStringExtra("MEMBER_NICNAME");
                String age = data.getStringExtra("MEMBER_AGE");
            } else {
                finish();
            }
        }
    }
    }

