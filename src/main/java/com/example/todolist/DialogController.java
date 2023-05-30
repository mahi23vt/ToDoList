package com.example.todolist;

import com.example.todolist.dataModel.ToDoData;
import com.example.todolist.dataModel.ToDoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {
    @FXML
    private TextField myShortDescriptionField;
    @FXML
    private TextArea detailsAreaField;
    @FXML
    private DatePicker deadLinePickerField;

    public ToDoItem processResults()
    {
        String shortDescription = myShortDescriptionField.getText().trim();
        String details = detailsAreaField.getText().trim();
        LocalDate deadLineValue = deadLinePickerField.getValue();
        ToDoItem newItem = new ToDoItem(shortDescription,details,deadLineValue);
        ToDoData.getInstance().addToDoItem(newItem);
        return newItem;
    }

}
