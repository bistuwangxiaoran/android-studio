package com.example.dialog_box;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toast successToast;
    Toast failToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        successToast=Toast.makeText(this,"登录成功",Toast.LENGTH_LONG);
        successToast.setGravity(Gravity.CENTER,0,0);
        failToast=Toast.makeText(this,"登录失败",Toast.LENGTH_LONG);
        failToast.setGravity(Gravity.CENTER,0,0);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username=(EditText)findViewById(R.id.username);
                EditText password=(EditText)findViewById(R.id.password);

                if(username.getText().toString().equals("abc") &&password.getText().toString().equals("123"))
                    successToast.show();
                else failToast.show();
            }
        });
    }
}