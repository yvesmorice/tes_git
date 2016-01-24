package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import ch.makery.address.MainCalendar;

public class RootLayoutController {


    // Reference to the main application.
    private MainCalendar mainCalendar;

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
     * Called when the user clicks about in help menubar.
     */
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.initOwner(mainCalendar.getPrimaryStage());
        alert.setTitle("About");
        alert.setHeaderText("Copyright 2016");
        alert.setContentText("Mathieu Caron,  \n\rTarik Haimar, \n\rSteven Coz,  \n\rYves Morice, \n\rCyrille Kinsky");

        alert.showAndWait();
    }
}
