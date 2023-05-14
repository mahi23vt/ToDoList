package com.example.todolist;

import com.example.todolist.dataModel.ToDoData;
import com.example.todolist.dataModel.ToDoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class Controller {
    @FXML
    private Label deadLineLabel;
    @FXML
    private TextArea itemDetailsTextArea;
    private List<ToDoItem> toDoItems;
    @FXML
    private ListView<ToDoItem> toDoListView;
    @FXML
    private BorderPane mainBorderPane;
    public void initialize()
    {
//        ToDoItem item1 = new ToDoItem("Send a Mail","Please send a mail to Mr. Raghavan from Bosch regarding the Oryggi Manager software", LocalDate.of(2023, Month.MAY,9));
//        ToDoItem item2 = new ToDoItem("Wish Rishabh's Sister","Please call Rishabh's sister and wish her a happy married life", LocalDate.of(2023, Month.MAY,10));
//        ToDoItem item3 = new ToDoItem("Buy Shona a powerbank","Order a powerbank for jaan", LocalDate.of(2023, Month.MAY,9));
//        ToDoItem item4 = new ToDoItem("Complete Todo List Application","Please send a mail to Mr. Raghavan from Bosch regarding the Oryggi Manager software", LocalDate.of(2023, Month.MAY,9));
//        toDoItems = new ArrayList<ToDoItem>();
//        toDoItems.add(item1);
//        toDoItems.add(item2);
//        toDoItems.add(item3);
//        toDoItems.add(item4);
//
//        ToDoData.getInstance().setToDoItems(toDoItems);
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

        toDoListView.getItems().setAll(ToDoData.getInstance().getToDoItems());
        toDoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        toDoListView.getSelectionModel().selectFirst();
    }
    @FXML
    public void showNewItemDialog()
    {
        // create instance of dialog class
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("toDoItemDialog.fxml"));
            dialog.getDialogPane().setContent(root);
        }
        catch (IOException e)
        {
            System.out.println("Dialog not loaded");
            e.printStackTrace();
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK)
            System.out.println("OK Pressed");
        else
            System.out.println("Cancel pressed");
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