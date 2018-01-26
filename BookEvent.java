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
DateTime eventDateTime = null;
DateTime dueDate;
Boolean isOverDue = false;
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
	this.eventDateTime = DateTime.now();
	this.dueDate = eventDateTime.plusDays(NO_OF_DAYS);
	this.eventType = eventType;
}

public void setBookEvent(Book book, EventType eventType, DateTime dueDate)
{
	this.eventDateTime = DateTime.now();
	this.eventType = eventType;
	this.dueDate = dueDate;
}

public Boolean isOverdue()
{
	if(eventDateTime == null)
		return false;
	if(this.eventType.equals(EventType.CHECKOUT)){
		if(this.dueDate.isBefore(eventDateTime.plusDays(NO_OF_DAYS))){
			isOverDue = true;
		}
	}
	return isOverDue;
	

}

/**
 * @return the dueDate
 */
public DateTime getDueDate() {
	return dueDate;
}

/**
 * @param dueDate the dueDate to set
 */
public void setDueDate(DateTime dueDate) {
	this.dueDate = dueDate;
}

/**
 * @param eventDateTime the eventDateTime to set
 */
public void setEventDateTime(DateTime eventDateTime) {
	this.eventDateTime = eventDateTime;
}
}
