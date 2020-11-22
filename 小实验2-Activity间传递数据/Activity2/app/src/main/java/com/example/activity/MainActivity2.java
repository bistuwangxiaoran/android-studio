package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Intent intent;
    double result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        intent=getIntent();
        String parameter1=intent.getStringExtra("parameter1");
        String parameter2=intent.getStringExtra("parameter2");
        String parameter3=intent.getStringExtra("parameter3");

        int num1,num2;
        if(parameter1==null) num1=0;
        else if(parameter1.equals("")) num1=1;
        else num1=Integer.parseInt(parameter1);

        if(parameter3==null) num2=0;
        else if(parameter3.equals("")) num2=1;
        else num2=Integer.parseInt(parameter3);

        if (parameter2==null) result=0;
        else switch (parameter2){
            case "-":
                result=num1-num2;
                break;
            case "*":
                result=num1*num2;
                break;
            case "/":
                result=num1/(double)num2;
                break;
            default:
                result=num1+num2;
                break;
        }

        TextView show=(TextView)findViewById(R.id.show);
        show.setText(("运算结果："+result));

        findViewById(R.id.send_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("result",""+result);
                setResult(100,intent);
                finish();
            }
        });
    }

}