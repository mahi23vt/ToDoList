package com.example.todolist.dataModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class ToDoData {
    private static ToDoData instance = new ToDoData();
    private static String fileName = "ToDoListItems";
    private ObservableList<ToDoItem> toDoItems;
    private DateTimeFormatter formatter;
    public static ToDoData getInstance()
    {
        return instance;
    }
    private ToDoData()
    {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }
    public ObservableList<ToDoItem> getToDoItems()
    {
        return toDoItems;
    }

    // Load Todo Items from files
    public void loadToDoItems() throws IOException {
        toDoItems = FXCollections.observableArrayList();
        Path path = Paths.get(fileName);
        BufferedReader br = Files.newBufferedReader(path);
        String input;
        try {
            while ((input = br.readLine()) != null) {
                String[] itemPieces = input.split("\t");
                String shortDescription = itemPieces[0];
                String details = itemPieces[1];
                String dateString = itemPieces[2];
                String status = itemPieces[3];
                LocalDate date = LocalDate.parse(dateString,formatter);
                ToDoItem item = new ToDoItem(shortDescription,details,date,status);
                toDoItems.add(item);

            }

        }
        finally {
            if(br !=null)
                br.close();
        }
    }
    // store ToDo Items to files
    public void storeToDoItems() throws IOException
    {
        Path path = Paths.get(fileName);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try{
            Iterator<ToDoItem> iter = toDoItems.iterator();
            while(iter.hasNext())
            {
                ToDoItem item = iter.next();
                bw.write(String.format("%s\t%s\t%s\t%s",
                        item.getShortDescription(),
                        item.getDetails(),
                        item.getDeadLine().format(formatter),
                        item.getStatus()));
                bw.newLine();
            }
        }
        finally {
            if(bw!=null)
                bw.close();
        }
    }
    public void addToDoItem(ToDoItem item)
    {
        toDoItems.add(item);
    }
    public void deleteToDoItem(ToDoItem item)
    {
        toDoItems.remove(item);
    }
    public boolean updateToDoItem(ToDoItem item,String status)
    {
        int position = toDoItems.indexOf(item);
        if(position>=0)
        {
            toDoItems.get(position).setStatus(status);
            return true;
        }
        return false;
    }

}
