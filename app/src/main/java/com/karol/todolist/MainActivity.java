package com.karol.todolist;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends Activity {

    List<ToDoItem> todoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createList();
        createSwipeAnimations();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void createList(){

        RecyclerView rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm=new LinearLayoutManager(MainActivity.this);
        rv.setLayoutManager(llm);

        todoList=new ArrayList<ToDoItem>();
       todoList.add(new ToDoItem("first", new Date(), R.drawable.icon));
        todoList.add(new ToDoItem("as", new Date(), R.drawable.icon));
        todoList.add(new ToDoItem("das", new Date(), R.drawable.icon));
        todoList.add(new ToDoItem("asd", new Date(), R.drawable.icon));
        todoList.add(new ToDoItem("asdas", new Date(), R.drawable.icon));
        todoList.add(new ToDoItem("fff", new Date(), R.drawable.icon));
        todoList.add(new ToDoItem("affgsd", new Date(), R.drawable.icon));
        todoList.add(new ToDoItem("adfgs", new Date(), R.drawable.icon));
        todoList.add(new ToDoItem("dhhas", new Date(), R.drawable.icon));
        todoList.add(new ToDoItem("afhgsd", new Date(), R.drawable.icon));


        ToDoAdapter adapter=new ToDoAdapter(todoList);

        rv.setAdapter(adapter);
    }


    public void createSwipeAnimations(){
        final RecyclerView rv=(RecyclerView)findViewById(R.id.rv);

        ItemTouchHelper.SimpleCallback simpleCallback= new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT){
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                if(direction==ItemTouchHelper.LEFT){
                    ToDoViewHolder vh=(ToDoViewHolder)viewHolder;
                    ToDoAdapter adapter=(ToDoAdapter)rv.getAdapter();
                    int position=vh.getAdapterPosition();
                    int idColor= ContextCompat.getColor(MainActivity.this, R.color.darkgreen);
                    vh.todoLayout.setBackgroundColor(idColor);
                    adapter.notifyItemChanged(position);
                }
                else if (direction==ItemTouchHelper.RIGHT){
                    ToDoAdapter adapter=(ToDoAdapter)rv.getAdapter();
                    int position=viewHolder.getAdapterPosition();
                    adapter.onItemDismiss(position);
                }
            }
        };

        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rv);

    }
}
