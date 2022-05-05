package testDoubles.stub;

import testDoubles.fake.Book;

import java.util.List;

public interface StubBookRepository {
    List<Book> findNewBooks(int days);

    Book findBokByBookId(String bookId);

    void save(Book book);
}
