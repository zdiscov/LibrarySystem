import org.joda.time.DateTime;

/**
 * Book Event models activities on a book when using the library system.
 * Like check out dates, due dates, is overdue and what type of activity -- checkout or checkin etc.,
 * Each Book gets a BookEvent object during checkout / checkin
 * BookEventManager manages the books and events in bulk
 * @author pradeep
 *
 */
public class BookEvent {
int NO_OF_DAYS = 30;
DateTime eventDateTime;
DateTime dueDate;
Boolean isOverDue;
EventType eventType;

/**
 * @return the eventDateTime
 */
public DateTime getEventDateTime() {
	return eventDateTime;
}

/**
 * @return the eventType
 */
public EventType getEventType() {
	return eventType;
}


public void setBookEvent(Book book, EventType eventType)
{
	eventDateTime = DateTime.now();
	this.eventType = eventType;
}

public void setBookEvent(Book book, EventType eventType, DateTime dueDate)
{
	eventDateTime = DateTime.now();
	this.eventType = eventType;
	this.dueDate = dueDate;
}

public Boolean isOverdue()
{
	DateTime dateTime = new DateTime();
	if(this.eventType.equals(EventType.CHECKOUT)){
		if(this.dueDate.isBefore(eventDateTime.plusDays(NO_OF_DAYS))){
			isOverDue = true;
		}
	}
	

}
