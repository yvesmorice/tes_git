package ch.makery.address.model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Event {
    private final StringProperty eventName;
    private final ObjectProperty<LocalDate> eventDate;

    /**
     * Default constructor.
     */
    public Event() {
        this(null, null);
    }

    /**
     * Constructor with some initial data.
     * 
     * @param firstName
     * @param lastName
     */
    public Event(String eventName, LocalDate eventDate) {
        this.eventName = new SimpleStringProperty(eventName);
        this.eventDate = new SimpleObjectProperty<LocalDate>(eventDate);
    }

    public String getEventName() {
        return eventName.get();
    }

    public void setEventName(String eventName) {
        this.eventName.set(eventName);
    }

    public StringProperty eventNameProperty() {
        return eventName;
    }

    public LocalDate getEventDate() {
        return eventDate.get();
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate.set(eventDate);
    }

    public ObjectProperty<LocalDate> eventDateProperty() {
        return eventDate;
    }
}
