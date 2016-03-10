package com.karol.todolist;

import java.util.Date;

/**
 * Created by student on 2016-03-10.
 */
public class ToDoItem {

    String content;
    Date date;
    int typeId;

    public ToDoItem(String content, Date date, int typeId) {
        this.content = content;
        this.date = date;
        this.typeId = typeId;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }

    public int getTypeId() {
        return typeId;
    }
}
