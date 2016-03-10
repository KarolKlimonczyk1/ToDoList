package com.karol.todolist;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by student on 2016-03-10.
 */
public class ToDoAdapter extends RecyclerView.Adapter<ToDoViewHolder> {

    List<ToDoItem> items;

    public ToDoAdapter(List<ToDoItem> items) {
        this.items = items;
    }


    @Override
    public ToDoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        ToDoViewHolder tdvh=new ToDoViewHolder(v);

        return tdvh;
    }

    @Override
    public void onBindViewHolder(ToDoViewHolder holder, int i) {
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");

        holder.todoText.setText(items.get(i).getContent());
        holder.todoDate.setText(dateFormat.format(items.get(i).getDate()));
        holder.todoImage.setImageResource(items.get(i).getTypeId());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void onItemDismiss(int position){
        items.remove(position);
        notifyItemRemoved(position);
    }
}
