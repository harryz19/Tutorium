package com.example.tutorium;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText et_name,et_email,et_mn,et_password,et_dob,et_username;
    Button btn_register;
    TextView tv_login,tv_error2;
    DatePickerDialog picker;
    MyDBHelper dbHelper;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        intent  = new Intent(this,LoginActivity.class);

        et_name = findViewById(R.id.et_name);
        et_dob = findViewById(R.id.et_dob);
        et_email = findViewById(R.id.et_email);
        et_mn = findViewById(R.id.et_mn);
        et_password = findViewById( R.id.et_password);
        et_username = findViewById(R.id.et_username);

        btn_register = findViewById(R.id.btn_register);

        tv_login = findViewById(R.id.tv_login);
        tv_error2 = findViewById(R.id.tv_error2);

        tv_login.setOnClickListener(view -> {
            startActivity(intent);
        });

        et_dob.setOnClickListener(view -> {

            Calendar cal = Calendar.getInstance();
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int month = cal.get(Calendar.MONTH);
            int year = cal.get(Calendar.YEAR);

            picker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    et_dob.setText(i2 + "-" + (i1 + 1) + "-" + i);
                }
            }, year, month, day);
            picker.show();
        });

        dbHelper = new MyDBHelper(this);
        btn_register.setOnClickListener(view -> {
           if(!et_name.getText().toString().isEmpty() && !et_username.getText().toString().isEmpty() && !et_password.getText().toString().isEmpty()){
               boolean insertdata = dbHelper.insertdata(et_name.getText().toString(),et_dob.getText().toString(),et_email.getText().toString(),et_username.getText().toString(),et_password.getText().toString(),et_mn.getText().toString());
               if(insertdata){
                   Toast.makeText(this,"Registered!",Toast.LENGTH_SHORT).show();
                   startActivity(intent);
               }
               else {
                   Log.e("INSERT","Error!");
               }
           }
           else{
               tv_error2.setText("Kindly fill up your details to Register.");
           }
        });
    }
}