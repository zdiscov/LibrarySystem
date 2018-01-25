/*
 * 
 * This is the User Class in the Library System.
 * A User is a person who uses the Library System.
 * 
 */
public class User {
String name;
Long libraryId;

/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**h
 * @return the libraryId
 */
public Long getLibraryId() {
	return libraryId;
}
/**
 * @param libraryId the libraryId to set
 */
public void setLibraryId(Long libraryId) {
	this.libraryId = libraryId;
}

}
