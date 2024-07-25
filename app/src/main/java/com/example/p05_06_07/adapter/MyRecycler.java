package com.example.p05_06_07.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.p05_06_07.R;
import com.example.p05_06_07.bookService.response.Main;

import java.util.List;

public class MyRecycler extends RecyclerView.Adapter<MyRecycler.MyViewHolder> {
    private List<Main> itemList;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public MyViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.item_text);
        }
    }

    public MyRecycler(List<Main> itemList) {
        this.itemList = itemList;
    }

    @Override
    public MyRecycler.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Main item = itemList.get(position);
        holder.textView.setText(item.toString());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
