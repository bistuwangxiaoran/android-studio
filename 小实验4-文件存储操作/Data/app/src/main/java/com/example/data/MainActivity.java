package com.example.data;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {
    SharedPreferences pre;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pre=getSharedPreferences("text", MODE_PRIVATE);
        Button save=findViewById(R.id.Save);
        Button read=findViewById(R.id.Read);
        save.setOnClickListener(new save_click());
        read.setOnClickListener(new read_click());
    }
    class save_click implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            EditText Id=findViewById(R.id.sid);
            EditText Name=findViewById(R.id.name);
            String id=Id.getText().toString();
            String name=Name.getText().toString();

            /*editor=pre.edit();
            editor.putString("id",id);
            editor.putString("name",name);
            editor.apply();*/

            OutputStream out=null;
            try {
                FileOutputStream fos=openFileOutput("text",MODE_PRIVATE);
                out=new BufferedOutputStream(fos);
                String str=id+" "+name;
                out.write(str.getBytes(StandardCharsets.UTF_8));
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Toast t = Toast.makeText(MainActivity.this, "保存\n学号:"+id+"\n姓名:"+name, Toast.LENGTH_LONG);
            t.setGravity(Gravity.CENTER,0,0);
            t.show();
        }
    }
    class read_click implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            /*String id=pre.getString("id","null");
            String name=pre.getString("name","null");*/
            StringBuilder str=new StringBuilder("");
            InputStream in=null;
            try {
                FileInputStream fis=openFileInput("text");
                in=new BufferedInputStream(fis);
                int c;
                while ((c=in.read())!=-1){
                    str.append((char)c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] strl =str.toString().split(" ");
            Toast t = Toast.makeText(MainActivity.this, "提取数据\n学号:"+strl[0]+"\n姓名:"+strl[1], Toast.LENGTH_LONG);
            t.setGravity(Gravity.CENTER,0,0);
            t.show();
        }
    }
}