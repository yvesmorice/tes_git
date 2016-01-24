package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ch.makery.address.model.Event;
import ch.makery.address.util.DateUtil;

public class EventEditDialogController {

    @FXML
    private TextField eventNameField;
    @FXML
    private TextField eventDateField;


    private Stage dialogStage;
    private Event event;
    private boolean okClicked = false;
/*efdzeefzefzefzef*/
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the event to be edited in the dialog.
     *
     * @param event
     */
    public void setEvent(Event event) {
        this.event = event;

        eventNameField.setText(event.getEventName());
        eventDateField.setText(DateUtil.format(event.getEventDate()));
        eventDateField.setPromptText("dd.mm.yyyy");
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            event.setEventName(eventNameField.getText());
            event.setEventDate(DateUtil.parse(eventDateField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (eventNameField.getText() == null || eventNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }

        if (eventDateField.getText() == null || eventDateField.getText().length() == 0) {
            errorMessage += "No valid eventDate!\n";
        } else {
            if (!DateUtil.validDate(eventDateField.getText())) {
                errorMessage += "No valid eventDate. Use the format dd.mm.yyyy!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
