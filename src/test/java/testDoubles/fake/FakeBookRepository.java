package testDoubles.fake;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository{

    Map<String,Book> bookstore=new HashMap<>();
    @Override
    public void save(Book book) {
        bookstore.put(book.getBookId(),book);
    }

    @Override
    public Collection<Book> findAll() {
        return bookstore.values();
    }
}
