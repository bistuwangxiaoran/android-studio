package com.example.Helloword;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.sql.StatementEvent;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler;
    List<String[]> list;
    int choose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);//竖直线性布局
        recycler.setLayoutManager(layoutManager);
        list=new ArrayList<>();

        RadioButton bn1=(RadioButton) findViewById(R.id.bn1);
        bn1.setChecked(true);
        choose=1;

        RadioGroup bngroup=(RadioGroup) findViewById(R.id.bngroup);
        bngroup.setOnCheckedChangeListener(new RadioGroup_ClickListener());

        Button bn=(Button) findViewById(R.id.bn);
        bn.setOnClickListener(new Button_ClickListener());
    }
    class RadioGroup_ClickListener implements RadioGroup.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId==R.id.bn1) choose=1;
            else if(checkedId==R.id.bn2) choose=2;
        }
    }
    class Button_ClickListener implements Button.OnClickListener{
        @Override
        public void onClick(View v) {
            String str[]=new String[2];
            if(choose==1) str[0]="r";
            else if(choose==2) str[0]="l";

            EditText edit=(EditText) findViewById(R.id.edit);
            str[1]=edit.getText().toString();
            edit.setText("");

            list.add(str);
            MyAdapter adapter=new MyAdapter(list);
            recycler.setAdapter(adapter);//重新配置适配器
        }
    }
}