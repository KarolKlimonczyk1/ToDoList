package com.karol.todolist;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by student on 2016-03-10.
 */
public class ToDoViewHolder extends RecyclerView.ViewHolder {

    CardView cv;
    TextView todoText;
    TextView todoDate;
    ImageView todoImage;
    RelativeLayout todoLayout;


    public ToDoViewHolder(View itemView) {
        super(itemView);

        cv=(CardView)itemView.findViewById(R.id.cv);
        todoText=(TextView)itemView.findViewById(R.id.todo_title);
        todoDate=(TextView)itemView.findViewById(R.id.todo_date);
        todoImage=(ImageView)itemView.findViewById(R.id.todo_image);
        todoLayout=(RelativeLayout)itemView.findViewById(R.id.todo_layout);
    }
}
