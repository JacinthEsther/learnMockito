package testDoubles.stub;

import testDoubles.fake.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryStub implements StubBookRepository {
    @Override
    public List<Book> findNewBooks(int days) {
        List<Book> newBooks = new ArrayList<Book>();

        Book book1= new Book("1234","Mockito in action",500,
                LocalDate.now());

        Book book2=new Book("1235","Junit5 in action",400,
                LocalDate.now());
        newBooks.add(book1);
        newBooks.add(book2);


        return newBooks;
    }

    @Override
    public Book findBookByBookId(String bookId) {
        return null;
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public List<Book> findAllBooks() {
        return null;
    }
}
