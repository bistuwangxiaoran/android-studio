package com.example.dialog_box;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alert=new AlertDialog.Builder(MainActivity.this);

        Button bn=(Button) findViewById(R.id.button);
        bn.setOnClickListener(new land_OnClickListener());
    }
    class land_OnClickListener implements Button.OnClickListener{
        @Override
        public void onClick(View v) {
            EditText username=(EditText)findViewById(R.id.username);
            EditText password=(EditText)findViewById(R.id.password);
            if(username.getText().toString().equals("abc") &&password.getText().toString().equals("123"))
                alert.setMessage("登录成功");
            else alert.setMessage("登录失败");

            alert.show();
        }
    }
}