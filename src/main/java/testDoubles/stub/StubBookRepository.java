package testDoubles.stub;

import testDoubles.fake.Book;

import java.sql.SQLException;
import java.util.List;

public interface StubBookRepository {
    List<Book> findNewBooks(int days);

    Book findBookByBookId(String bookId);

    void save(Book book);

    List<Book> findAllBooks() throws SQLException;

}
