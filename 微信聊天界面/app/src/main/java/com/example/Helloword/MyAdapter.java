package com.example.Helloword;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyHolder>{
    List<String[]> list;//String[]{布局,内容}
    public MyAdapter(List<String[]> list1){ list=list1; }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//设置布局
        View inf;
        if (viewType==1) inf=LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_left_layout,parent,false);
        else inf=LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_right_layout,parent,false);
        return new MyHolder(inf);
    }
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {//置入内容
        TextView tv=(TextView)holder.itemView.findViewById(R.id.text);
        tv.setText(list.get(position)[1]);
    }
    @Override
    public int getItemCount() {//总数
        return list.size();
    }
    @Override
    public int getItemViewType(int position) {//判定布局
        if(list.get(position)[0].equals("l")) return 1;
        else if(list.get(position)[0].equals("r")) return 2;
        else return 0;
    }
}
class MyHolder extends RecyclerView.ViewHolder{
    public MyHolder(@NonNull View itemView) {
        super(itemView);
    }
}
