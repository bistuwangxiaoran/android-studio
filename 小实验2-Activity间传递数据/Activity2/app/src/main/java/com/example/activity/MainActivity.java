package com.example.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText parameter1;
    EditText parameter2;
    EditText parameter3;
    TextView result_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("parameter1",parameter1.getText().toString());
                intent.putExtra("parameter2",parameter2.getText().toString());
                intent.putExtra("parameter3",parameter3.getText().toString());
                startActivityForResult(intent,0);//请求码0
            }
        });

        parameter1=findViewById(R.id.parameter1);
        parameter2=findViewById(R.id.parameter2);
        parameter3=findViewById(R.id.parameter3);

        result_show=findViewById(R.id.show);

        parameter1.setOnFocusChangeListener(new clear_when_focus());
        parameter3.setOnFocusChangeListener(new clear_when_focus());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0&&resultCode==100){
            if(data==null)
                result_show.setText("取得结果失败");
            else {
                String result=data.getStringExtra("result");
                result_show.setText(("取得结果："+result));
            }
        }
    }
    class clear_when_focus implements EditText.OnFocusChangeListener{
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            result_show.setText("");
        }
    }
}