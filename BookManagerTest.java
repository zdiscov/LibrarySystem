import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;


public class BookManagerTest {

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
	public void testBookManagerAdd(){
		
		book = new Book();
		book.setId(1L);
		book.setName("War and Peace");
		book.setIsbn("ABC001");
		
		
		book2 = new Book();
		book2.setId(2L);
		book2.setName("Cloud Atlas");
		book2.setIsbn("ABC002");
		
		Set<Book> bookSet = new HashSet<>();
		bookSet.add(book); 
		bookSet.add(book2);
		
		Set<Book> booksFromCache = bm.getBooksSetFromUsers();
		assertEquals(bookSet,booksFromCache);
	}
	@Test
	public void testGetBooksSetFromUsers(){
		bm.addUserToBook(null, book);
		Set<Book> userFromCache = bm.getBooksSetFromUsers();
		assertEquals(userFromCache,SetOfBooksWithUser);
	
	}
	
	@Test
	public void testRemoveBook(){
		bm.addUserToBook(user, book);
		bm.addUserToBook(user2, book2);
		
		assertEquals(bm.getAllBooks().size(),2);
		assertEquals(bm.getBooksSetFromUsers().size(),2);
		
		bm.removeUserFromBook(user, book);
		bm.removeUserFromBook(user2, book2);
		
		assertEquals(bm.getAllBooks().size(),2);
		assertEquals(bm.getBooksSetFromUsers().size(),0);
	}
}
