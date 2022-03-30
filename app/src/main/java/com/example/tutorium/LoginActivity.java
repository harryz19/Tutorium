package com.example.tutorium;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText et_userid,et_pass;
    Button btn_login;
    TextView tv_error;
    MyDBHelper ldbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        et_userid = findViewById(R.id.et_userid);
        et_pass = findViewById(R.id.et_pass);

        tv_error = findViewById(R.id.tv_error);

        btn_login = findViewById(R.id.btn_login);

        ldbHelper = new MyDBHelper(this);

        String uname = et_userid.getText().toString();
        String pass = et_pass.getText().toString();

        btn_login.setOnClickListener(view -> {

            if(!et_pass.getText().toString().isEmpty() && !et_userid.getText().toString().isEmpty()){
                boolean checkuserlogin = ldbHelper.checkuserpass(et_userid.getText().toString(),et_pass.getText().toString());
                if(checkuserlogin){
                    Intent loginIntent = new Intent(this,HomeActivity.class);
                    startActivity(loginIntent);
                }
                else{
                    tv_error.setText("Invalid Credentials!!");
                }
            }else{
                tv_error.setText("Kindly fill up credentials.");
            }
        });
    }
}