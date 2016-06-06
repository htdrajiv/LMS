package lms.dataAccess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lms.model.Address;
import lms.model.Author;
import lms.model.Book;
import lms.model.CheckoutRecord;
import lms.model.LibraryMember;

public class TestData {
	List<CheckoutRecord> allRecords = new ArrayList<CheckoutRecord>();
	@SuppressWarnings("serial")
	List<Address> addresses = new ArrayList<Address>() {
		{
			add(new Address("1000 nth", "Fairfield", "IA", "52557"));
			add(new Address("100 south", "Georgetown", "MI", "65434"));
			add(new Address("501 Central", "Davenport", "CA", "94707"));
		}
	};
	@SuppressWarnings("serial")
	public List<Author> allAuthors = new ArrayList<Author>() {
		{
			add(new Author("", "Joe", "Thomas", "641-445-2123",
					addresses.get(0), "A happy man is he."));
			add(new Author("", "Sandra", "Thomas", "641-445-2123",
					addresses.get(0), "A happy wife is she."));
		}
	};
	
	@SuppressWarnings("serial")
	List<LibraryMember> memberList = new ArrayList<LibraryMember>() {
		{
			add(new LibraryMember("Joe", "Thomas", "641-445-2123",
					addresses.get(0), "1"));
			add(new LibraryMember("Sndra", "Thomas", "641-445-2123",
					addresses.get(0), "2"));
			add(new LibraryMember("Nirmal", "Pugh", "641-919-3223",
					addresses.get(1), "3"));

		}
	};

	@SuppressWarnings("serial")
	List<Book> allBooks = new ArrayList<Book>() {
		{
			add(new Book("23-11451", "The Big Fish", 21, Arrays.asList(
					allAuthors.get(0), allAuthors.get(1))));
			add(new Book("28-12331", "Antartica", 7, Arrays.asList(allAuthors
					.get(1))));
			add(new Book("99-22223", "Thinking Java", 21,
					Arrays.asList(allAuthors.get(1))));
			add(new Book("48-56882", "Jimmy's First Day of School", 7,
					Arrays.asList(allAuthors.get(1))));

		}
	};

	@SuppressWarnings("serial")
	List<User> allUsers = new ArrayList<User>() {
		{
			add(new User("lib", "lib", Auth.LIBRARIAN));
			add(new User("admin", "admin", Auth.ADMIN));
			add(new User("adlib", "adlib", Auth.BOTH));
		}
	};

	public static void main(String[] args) {
		TestData td = new TestData();
		td.bookData();
		td.libraryMemberData();
		td.userData();
		IDataAccess da = DataAccess.getDataAccessObject();
		System.out.println(da.readBooksMap());
		System.out.println(da.readUserMap());
	}

	// /create books
	public void bookData() {
		allBooks.get(0).addCopy();
		allBooks.get(0).addCopy();
		allBooks.get(1).addCopy();
		allBooks.get(3).addCopy();
		allBooks.get(2).addCopy();
		allBooks.get(2).addCopy();
		DataAccess.loadBookMap(allBooks);
	}

	public void userData() {
		DataAccess.loadUserMap(allUsers);
	}

	public void libraryMemberData() {
		DataAccess.loadMemberMap(memberList);
	}

}
