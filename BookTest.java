import static org.junit.Assert.*;

import org.junit.Test;

/*
 * 
 * To Jasmine-
 * Please fill out methods that are empty in this class.
 * For help refer to testGetIdForBook() method.
 * 
 */
public class BookTest {


	@Test
	public void testGetIdForBook() {
		Book book = new Book();
		book.setId(1L);
		book.setName("Alice");
		book.setIsbn("ABC001");
		
	
		assertEquals((long)(book.getId()), 1);
		
	}
	
	public void testGetNameForBook() {
		// TO BE FILLED OUT BY YASMINE
	}
	
	public void testGetISBNForBook() {
		// TO BE FILLED OUT BY YASMINE
	}
	
	public void testForDuplicateBookEquality(){
		// TO BE FILLED OUT BY YASMINE
		// Create two identical books and see if book1.equals(book2) works!
	}
}
