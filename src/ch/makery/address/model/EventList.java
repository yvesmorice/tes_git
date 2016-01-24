package ch.makery.address.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EventList {
	public ObservableList<Event> eventList = FXCollections.observableArrayList();


	public EventList() {
	}
	
    /**
     * Returns the event as an observable list of Events. 
     * @return
     */
    public ObservableList<Event> getEventData() {
        return eventList;
    }
}
