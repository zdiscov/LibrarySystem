import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;


public class BookEventTest {
	BookManager bm;
	Book book, book2;
	User user, user2;
	Set<Book> SetOfBooksWithUser;

	  @Before
	    public void setUp() {
			  	SetOfBooksWithUser = new HashSet<>();
			  	bm = new BookManager();
				
				
				book = new Book();
				book.setId(1L);
				book.setName("War and Peace");
				book.setIsbn("ABC001");
				
				user = new User();
				user.setLibraryId(1L);
				user.setName("Yasmine");
				
				bm.addUserToBook(user, book);

				book2 = new Book();
				book2.setId(2L);
				book2.setName("Cloud Atlas");
				book2.setIsbn("ABC002");
				
						
				user2 = new User();
				user2.setLibraryId(2L);
				user2.setName("John");
				
				bm.addUserToBook(user2, book2);
				SetOfBooksWithUser.add(book2);
		  }

	@Test
	public void bookEventTest() {
		BookEvent bookEvent = new BookEvent();
		bookEvent.setBookEvent(book, EventType.CHECKOUT);
		assertFalse(bookEvent.isOverdue());
		
	}

	
}
