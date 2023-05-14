package com.example.todolist;

import com.example.todolist.dataModel.ToDoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private Label deadLineLabel;
    @FXML
    private TextArea itemDetailsTextArea;
    private List<ToDoItem> toDoItems;
    @FXML
    private ListView<ToDoItem> toDoListView;
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
        toDoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ToDoItem>() {
            @Override
            public void changed(ObservableValue<? extends ToDoItem> observableValue, ToDoItem oldValue, ToDoItem newValue) {
                if(newValue != null)
                {
                    ToDoItem item = toDoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    deadLineLabel.setText(df.format(item.getDeadLine()));
                }
            }
        });

        toDoListView.getItems().setAll(toDoItems);
        toDoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        toDoListView.getSelectionModel().selectFirst();
    }
    @FXML
    public void handleClickListView()
    {
        ToDoItem selectedItem =toDoListView.getSelectionModel().getSelectedItem();
//        System.out.println("The selected Item is: "+selectedItem);
        itemDetailsTextArea.setText(selectedItem.getDetails());
//        StringBuilder sb = new StringBuilder(selectedItem.getDetails());
//        sb.append("\n\n\n\n");
//        sb.append("Due: "+selectedItem.getDeadLine().toString());
//        itemDetailsTextArea.setText(sb.toString());
        deadLineLabel.setText(selectedItem.getDeadLine().toString());
    }
}