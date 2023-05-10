# ToDoList
This software is about creating the to do list items in day to day life. We can set a due date till which the task should be completed.
The software helps us write a topic to the task and write down the task in detail.
As per the due dates, the software highlights the users about which task should be given more priority.
# Steps of development
# v1.01
I am using BorderPane, at first only left portion will be populated by the list view containing the short description of the to do list.
<left>
  <ListView>
    
  </ListView>
</left>
This list view will be populated by ToDoItems. So, now create a data Model.
1. ToDoItem: It will have all the parameters a todoItem should have.
   private String shortDescription;
   private String details;
   private LocalDate deadLine;
   -> Create constructor
   -> getters & setters
   => Controllers helps in interection between user interface and dataModel
2. Controller
   private List<ToDoItems> todoItems; // Java.util
  // initialize the application with sample data
  public void initialize()
  {
    ToDoItem item1 = new ToDoItem("Birthday", "Buy a birthday Card", LocalDate.of(2016, Month.APRIL, 23);
    // Add four more
    // initialize the array list
    todoItems =  new ArrayList<ToDoItem>();
    toDoItems.add(item1);
    // Add all others
   }
3. Now let's populate the list view
  -> go to mainWindow.fxml
     <ListView fx:id="todoListView">
  -> Now, create a variable ListView in the controller whose variable name should be same as id.
  @FXML
  private ListView todoListView;
  -> Now, we can populate
  -> in initialize() after add()
     todoListView.getItems().setAll(todoItems);
     // select the list view selection mode to single items
     toDoListView.getSelectionModel().setSelectionMode.SINGLE;
  -> Run the program to check
     in the list view I got the reference of all the ToDoItem object reference
  -------------- In the list view, I got the reference of all the ToDoItem object reference ---------------
=> Resolution to this is overriding toString() method. In the listView, I need only the short description name.
       @override
       public String toString()
        {
          return shortDescription;
        }
       
