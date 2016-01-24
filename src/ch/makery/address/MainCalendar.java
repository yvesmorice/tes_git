package ch.makery.address;

import java.io.IOException;

import ch.makery.address.model.Event;
import ch.makery.address.model.EventList;
import ch.makery.address.view.CalendarViewController;
import ch.makery.address.view.EventEditDialogController;
import ch.makery.address.view.RootLayoutController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainCalendar extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;

    //private ObservableList<Event> eventData = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("CalendarApp");

        initRootLayout();

        showCalendarView();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainCalendar.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();


            RootLayoutController controller = loader.getController();
            controller.setMainCalendar(this);
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Shows the person overview inside the root layout.
     */
    public void showCalendarView() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainCalendar.class.getResource("view/CalendarView.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);

            // Give the controller access to the main app.
            CalendarViewController controller = loader.getController();
            controller.setMainCalendar(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Opens a dialog to edit details for the specified event. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     *
     * @param event the event object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showEventEditDialog(Event event) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainCalendar.class.getResource("view/EventEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Event");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            EventEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setEvent(event);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
	public static void main(String[] args) {
		launch(args);
	}
}
