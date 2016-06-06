package lms.dataAccess;

import java.util.HashMap;

import lms.model.*;





public interface IDataAccess {
	public LibraryMember searchMember(String memberId);
	public Book searchBook(String isbn);
	
	
	public void saveNewMember(LibraryMember member);

	public void saveNewBook(Book book);
	
	public HashMap<String,Book> readBooksMap();
	public HashMap<String,User> readUserMap();
	public HashMap<String, LibraryMember> readMemberMap();
}
