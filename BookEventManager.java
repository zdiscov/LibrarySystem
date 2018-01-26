import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
/**
 * 
 * @author pradeep
 * Manages events (Checking out and checking in) of books..
 * Possibly more events in future
 */
public class BookEventManager {
	
Map<Book,BookEvent> bookEventManagerMap;


public BookEventManager()
{
	bookEventManagerMap = new HashMap<>();
}

public void setBookEvent(Book book, BookEvent eventType)
{
	// book is in the event map.. meaning it has to be checked out only
	if(this.bookEventManagerMap.containsKey(book)){
		bookEventManagerMap.remove(book);
	}else{
		// book is not in the event map.. meaning it is checked out. 
		bookEventManagerMap.put(book,eventType);
	}
}

public Set<Book> getAllBooksCheckedOut()
{		
	return this.bookEventManagerMap.keySet();		
}

public Set<Book> getBooksDueForUser(User user)
{
	
}

}
