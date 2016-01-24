package ch.makery.address.view;

import java.util.ArrayList;
import java.util.Calendar;

import ch.makery.address.MainCalendar;
import ch.makery.address.model.Event;
import ch.makery.address.model.EventList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class CalendarViewController {

    @FXML
    private TableView<Event> eventTable;
    @FXML
    private Label currentMonthLabel;
    @FXML
    private Label currentYearLabel;

    @FXML
    private Label eventNameLabel;
    private int monthIndex;
    @FXML
    private Label eventDateLabel;
    private int year;

    @FXML
    private GridPane calendarGrid;// = new GridPane();

    @FXML
    private Label labelDay1 = new Label("1");
    @FXML
    private Label labelDay2 = new Label("2");
    @FXML
    private Label labelDay3 = new Label("3");
    @FXML
    private Label labelDay4 = new Label("4");
    @FXML
    private Label labelDay5 = new Label("5");
    @FXML
    private Label labelDay6 = new Label("6");
    @FXML
    private Label labelDay7 = new Label("7");
    @FXML
    private Label labelDay8 = new Label("8");
    @FXML
    private Label labelDay9 = new Label("9");
    @FXML
    private Label labelDay10 = new Label("10");
    @FXML
    private Label labelDay11 = new Label("11");
    @FXML
    private Label labelDay12 = new Label("12");
    @FXML
    private Label labelDay13 = new Label("13");
    @FXML
    private Label labelDay14 = new Label("14");
    @FXML
    private Label labelDay15 = new Label("15");
    @FXML
    private Label labelDay16 = new Label("16");
    @FXML
    private Label labelDay17 = new Label("17");
    @FXML
    private Label labelDay18 = new Label("18");
    @FXML
    private Label labelDay19 = new Label("19");
    @FXML
    private Label labelDay20 = new Label("20");
    @FXML
    private Label labelDay21 = new Label("21");
    @FXML
    private Label labelDay22 = new Label("22");
    @FXML
    private Label labelDay23 = new Label("23");
    @FXML
    private Label labelDay24 = new Label("24");
    @FXML
    private Label labelDay25 = new Label("25");
    @FXML
    private Label labelDay26 = new Label("26");
    @FXML
    private Label labelDay27 = new Label("27");
    @FXML
    private Label labelDay28 = new Label("28");
    @FXML
    private Label labelDay29 = new Label("29");
    @FXML
    private Label labelDay30 = new Label("30");
    @FXML
    private Label labelDay31 = new Label("31");

    public ArrayList<Label> labelList= new ArrayList<Label>();

    RowConstraints row1 = new RowConstraints();
    RowConstraints row2 = new RowConstraints();
    RowConstraints row3 = new RowConstraints();
    RowConstraints row4 = new RowConstraints();
    RowConstraints row5 = new RowConstraints();
    RowConstraints row6 = new RowConstraints();

    ArrayList<RowConstraints> rowConstraintsList = new ArrayList<RowConstraints>();

    public EventList eventList = new EventList();

    // Reference to the main application.
    private MainCalendar mainCalendar;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public CalendarViewController() {
    	labelList.add(labelDay1);
    	labelList.add(labelDay2);
    	labelList.add(labelDay3);
    	labelList.add(labelDay4);
    	labelList.add(labelDay5);
    	labelList.add(labelDay6);
    	labelList.add(labelDay7);
    	labelList.add(labelDay8);
    	labelList.add(labelDay9);
    	labelList.add(labelDay10);
    	labelList.add(labelDay11);
    	labelList.add(labelDay12);
    	labelList.add(labelDay13);
    	labelList.add(labelDay14);
    	labelList.add(labelDay15);
    	labelList.add(labelDay16);
    	labelList.add(labelDay17);
    	labelList.add(labelDay18);
    	labelList.add(labelDay19);
    	labelList.add(labelDay20);
    	labelList.add(labelDay21);
    	labelList.add(labelDay22);
    	labelList.add(labelDay23);
    	labelList.add(labelDay24);
    	labelList.add(labelDay25);
    	labelList.add(labelDay26);
    	labelList.add(labelDay27);
    	labelList.add(labelDay28);
    	labelList.add(labelDay29);
    	labelList.add(labelDay30);
    	labelList.add(labelDay31);
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	Calendar cal = Calendar.getInstance();
    	displayCalendar(cal);
    }

    private void displayCalendar(Calendar cal) {

		calendarGrid.getChildren().removeAll(labelList);
		calendarGrid.getRowConstraints().removeAll(rowConstraintsList);

        monthIndex = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR);

        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int weeksInMonth = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
        float rowsHeight = 100/weeksInMonth;
        int firstDayOfMonth= cal.get(Calendar.DAY_OF_WEEK) - 1;
        boolean flag = true;
        int k = 0;

        row1.setPercentHeight(rowsHeight);
        row2.setPercentHeight(rowsHeight);
        row3.setPercentHeight(rowsHeight);
        row4.setPercentHeight(rowsHeight);
        row5.setPercentHeight(rowsHeight);
        row6.setPercentHeight(rowsHeight);

        rowConstraintsList.add(row1);
        rowConstraintsList.add(row2);
        rowConstraintsList.add(row3);
        rowConstraintsList.add(row4);
        rowConstraintsList.add(row5);
        rowConstraintsList.add(row6);

        if(weeksInMonth == 4){
        	calendarGrid.getRowConstraints().addAll(row1,row2,row3,row4);
        } else if (weeksInMonth == 5){
        	calendarGrid.getRowConstraints().addAll(row1,row2,row3,row4,row5);
        } else if (weeksInMonth == 6){
        	calendarGrid.getRowConstraints().addAll(row1,row2,row3,row4,row5,row6);
        }

        currentYearLabel.setText(String.valueOf(year));

        switch (monthIndex) {
	        case 0: currentMonthLabel.setText("Janvier");
	        break;
	        case 1: currentMonthLabel.setText("Février");
	        break;
	        case 2: currentMonthLabel.setText("Mars");
	        break;
	        case 3: currentMonthLabel.setText("Avril");
	        break;
	        case 4: currentMonthLabel.setText("Mai");
	        break;
	        case 5: currentMonthLabel.setText("Juin");
	        break;
	        case 6: currentMonthLabel.setText("Juillet");
	        break;
	        case 7: currentMonthLabel.setText("Août");
	        break;
	        case 8: currentMonthLabel.setText("Septembre");
	        break;
	        case 9: currentMonthLabel.setText("Octobre");
	        break;
	        case 10: currentMonthLabel.setText("Novembre");
	        break;
	        case 11: currentMonthLabel.setText("Décembre");
	        break;
        }

        for(int i=1;i<8;i++){
        	for(int j=0;j<7;j++){
        		if(flag == true){
        			j = firstDayOfMonth;
        			flag = false;
        		}
        		if(k<daysInMonth){
        			GridPane.setConstraints(labelList.get(k), j, i);
        			calendarGrid.getChildren().addAll(labelList.get(k));
        			k += 1;
        		} else {
        			break;
        		}
        	}

    		if(k<daysInMonth){

    		} else {
    			break;
    		}
        }
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainCalendar
     */
    public void setMainCalendar(MainCalendar mainCalendar) {
        this.mainCalendar = mainCalendar;

        // Add observable list data to the table
 //       eventTable.setItems(mainCalendar.getEventData());
    }

    /**
     * Fills all text fields to show details about the event.
     * If the specified event is null, all text fields are cleared.
     *
     * @param event the event or null
     */
    private void showEventDetails(Event event) {
        if (event != null) {
            // Fill the labels with info from the event object.
            eventNameLabel.setText(event.getEventName());

            // TODO: We need a way to convert the birthday into a String!
            // birthdayLabel.setText(...);
        } else {
            // Event is null, remove all the text.
            eventNameLabel.setText("");
            eventDateLabel.setText("");
        }
    }

    @FXML
    private void handleNextMonth() {
    	Calendar cal = Calendar.getInstance();
        monthIndex += 1;
    	cal.set(year, monthIndex, 01);
    	year  = cal.get(Calendar.YEAR);
    	displayCalendar(cal);
    }

    @FXML
    private void handlePreviousMonth() {
    	Calendar cal = Calendar.getInstance();
        monthIndex -= 1;
    	cal.set(year, monthIndex, 01);
    	year  = cal.get(Calendar.YEAR);
    	displayCalendar(cal);
    }

    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteEvent() {
        int selectedIndex = eventTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            eventTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainCalendar.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Event Selected");
            alert.setContentText("Please select a event in the table.");

            alert.showAndWait();
        }
    }

    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new event.
     */
    @FXML
    private void handleNewEvent() {
        Event tempEvent = new Event();
        boolean okClicked = mainCalendar.showEventEditDialog(tempEvent);
        if (okClicked) {
            eventList.getEventData().add(tempEvent);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected event.
     */
    @FXML
    private void handleEditEvent() {
        Event selectedEvent = eventTable.getSelectionModel().getSelectedItem();
        if (selectedEvent != null) {
            boolean okClicked = mainCalendar.showEventEditDialog(selectedEvent);
            if (okClicked) {
                showEventDetails(selectedEvent);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainCalendar.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Event Selected");
            alert.setContentText("Please select a event in the table.");

            alert.showAndWait();
        }
    }
}
