import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

/*
 * This is the BookManager Class.
 * Book Manager class is responsible for all Books in the library system.
 * Book Manager will provide a set of all books in a library, set of all books that are 
 * associated with Users etc.,
 * It can also be queried for a User given a Book object
 * and
 * can also be used to remove a User who is previously associated with a Book.
 * These are handy when we get to implement an actual CHECKOUT event
 * YASMINE-
 * 1. What other methods should we add here?
 * 2. I have provided 3 method stubs. Please try to fill them out.
 * 
 */
public class BookManager {
Map<Book,User> bookUserMap = new HashMap<>();

public User getUser(Book book)
{		
	if(bookUserMap.containsKey(book)){
		return bookUserMap.get(book);
	}else{
		return new User();
	}

}

public void addUserToBook(User user, Book book){
		bookUserMap.put(book, user);
}

public Boolean removeUserFromBook(User user, Book book){
	if(bookUserMap.containsKey(book)){
		User userFromCache  = bookUserMap.get(book);
		if(userFromCache != null){
			bookUserMap.put(book,null);
		}
	}else{
		return false;
	}
	return true;
	
}

public Set<Book> getAllBooks()
{
	return bookUserMap.keySet();
}

public Set<Book> getBooksSetFromUsers()
{
	HashMap<Book,User> booksWithUserMap = new HashMap<>();
	for(Book book : bookUserMap.keySet()){
		User user = bookUserMap.get(book);
		if(user == null)
			continue;
		else{
			booksWithUserMap.put(book, user);
		}	
	}
	return booksWithUserMap.keySet();
}
/*
public Long getUniversalBookCount()
{
	return null;
	//To be implemented by Yasmine
	
}

public Long getBooksCountAcrossAllUsers()
{
	return null;
	//To be implemented by Yasmine
}

public Long getBooksCountNotAssociatedWithUsers()
{
	return null;
	//To be implemented by Yasmine
}

*/
}
