package com.example.todolist;

import com.example.todolist.dataModel.ToDoItem;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<ToDoItem> toDoItems;
    @FXML
    private ListView toDoListView;
    public void initialize()
    {
        ToDoItem item1 = new ToDoItem("Send a Mail","Please send a mail to Mr. Raghavan from Bosch regarding the Oryggi Manager software", LocalDate.of(2023, Month.MAY,9));
        ToDoItem item2 = new ToDoItem("Wish Rishabh's Sister","Please call Rishabh's sister and wish her a happy married life", LocalDate.of(2023, Month.MAY,10));
        ToDoItem item3 = new ToDoItem("Buy Shona a powerbank","Order a powerbank for jaan", LocalDate.of(2023, Month.MAY,9));
        ToDoItem item4 = new ToDoItem("Complete Todo List Application","Please send a mail to Mr. Raghavan from Bosch regarding the Oryggi Manager software", LocalDate.of(2023, Month.MAY,9));
        toDoItems = new ArrayList<ToDoItem>();
        toDoItems.add(item1);
        toDoItems.add(item2);
        toDoItems.add(item3);
        toDoItems.add(item4);
        toDoListView.getItems().setAll(toDoItems);
        toDoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
}