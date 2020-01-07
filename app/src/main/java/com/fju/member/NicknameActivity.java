package com.fju.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class NicknameActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
        ImageView right =findViewById(R.id.right_arrow);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent member = new Intent(this,AgeActivity.class);
                startActivity(member);
            }
        });
        Intent intent = getIntent();
        String nickname = intent.getStringExtra("Nickname" ,-1);
        TextView name =findViewById(R.id.nickname);
        name.setText(nickname);
    }
    public void login(View view) {
        EditText edUserid = findViewById(R.id.nickname);
        String uid = edUserid.getText().toString();
        if (uid.length()>0) { //登入成功
            SharedPreferences setting = getSharedPreferences("Member", MODE_PRIVATE);
            setting.edit()
                    .putString("PREF_USERID", uid)
                    .apply();
            getIntent().putExtra("MEMBER_NICNAME", uid);
            setResult(RESULT_OK, getIntent());
            finish();
        }
    }
    }
