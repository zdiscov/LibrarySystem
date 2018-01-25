/*
 * This is the Book Class. 
 * Assumption #1 - Two books are duplicates only if their ISBN codes are the same
 * 
 */

public class Book {
String name;
String isbn;
Long id;

/**
 * @return the name
 */
public String getName() {
	return name;
}
/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
	return result;
}
/* (non-Javadoc)
 * @see java.lang.Object#equals(java.lang.Object)
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (!(obj instanceof Book))
		return false;
	Book other = (Book) obj;
	if (isbn == null) {
		if (other.isbn != null)
			return false;
	} else if (!isbn.equals(other.isbn))
		return false;
	return true;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the isbn
 */
public String getIsbn() {
	return isbn;
}
/**
 * @param isbn the isbn to set
 */
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
/**
 * @return the id
 */
public Long getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(Long id) {
	this.id = id;
}

}
