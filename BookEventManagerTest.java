import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Set;
import java.util.HashSet;

public class BookEventManagerTest {

	@Test
	public void testGetAllBooksCheckedOut() {
		BookEvent bookEvent = new BookEvent();
		BookEvent bookEvent2 = new BookEvent();

		BookEventManager bookEventManager = new BookEventManager();
		Book book, book2;
		book = new Book();
		book.setId(1L);
		book.setName("War and Peace");
		book.setIsbn("ABC001");
		

		book2 = new Book();
		book2.setId(2L);
		book2.setName("Cloud Atlas");
		book2.setIsbn("ABC002");
		
		Set<Book> expectedBookSet = new HashSet<Book>();
		
		expectedBookSet.add(book);
		expectedBookSet.add(book2);
		
		bookEvent.setBookEvent(book, EventType.CHECKOUT);
		bookEvent2.setBookEvent(book2, EventType.CHECKOUT);
		
		bookEventManager.setBookEvent(book, bookEvent);
		bookEventManager.setBookEvent(book2, bookEvent2);
		
		Set<Book> chkdOutBooks = bookEventManager.getAllBooksCheckedOut();
		
		assertEquals(expectedBookSet, chkdOutBooks);
	}
	
	@Test
	public void testGetBooksCheckInFunction()
	{
		BookEvent bookEvent = new BookEvent();
		BookEvent bookEvent2 = new BookEvent();

		BookEventManager bookEventManager = new BookEventManager();
		Book book, book2;
		book = new Book();
		book.setId(1L);
		book.setName("War and Peace");
		book.setIsbn("ABC001");
		

		book2 = new Book();
		book2.setId(2L);
		book2.setName("Cloud Atlas");
		book2.setIsbn("ABC002");
		
		Set<Book> expectedBookSet = new HashSet<Book>();

		bookEvent.setBookEvent(book, EventType.CHECKOUT);
		bookEvent2.setBookEvent(book2, EventType.CHECKOUT);
		
		bookEventManager.setBookEvent(book, bookEvent);
		bookEventManager.setBookEvent(book2, bookEvent2);
	
		expectedBookSet.add(book);
		bookEvent2.setBookEvent(book2, EventType.CHECKIN);
		bookEventManager.setBookEvent(book2, bookEvent2);

		Set<Book> chkdOutBooks = bookEventManager.getAllBooksCheckedOut();

		// Check In works
		assertEquals(expectedBookSet, chkdOutBooks);

		bookEvent.setBookEvent(book, EventType.CHECKIN);
		bookEventManager.setBookEvent(book, bookEvent);
		
		expectedBookSet.clear();
		chkdOutBooks = bookEventManager.getAllBooksCheckedOut();

		assertEquals(expectedBookSet,chkdOutBooks);
		
	}

	@Test
	public void testBookOverdue() {
		BookEvent bookEvent = new BookEvent();
		BookEvent bookEvent2 = new BookEvent();

		BookEventManager bookEventManager = new BookEventManager();
		Book book, book2;
		book = new Book();
		book.setId(1L);
		book.setName("War and Peace");
		book.setIsbn("ABC001");
		

		book2 = new Book();
		book2.setId(2L);
		book2.setName("Cloud Atlas");
		book2.setIsbn("ABC002");
		

		bookEvent.setBookEvent(book, EventType.CHECKOUT);
		
		bookEvent.setEventDateTime(DateTime.now());
		bookEvent.setDueDate(DateTime.now().minusDays(100));

		bookEvent2.setBookEvent(book2, EventType.CHECKOUT);

		//Book is overdue!
		assertTrue(bookEvent.isOverdue());
		

		
	}

}
