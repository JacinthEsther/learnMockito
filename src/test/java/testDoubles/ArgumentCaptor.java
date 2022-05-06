package testDoubles;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import testDoubles.fake.Book;
import testDoubles.stub.BookRequest;
import testDoubles.stub.StubBookRepository;
import testDoubles.stub.StubBookService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ArgumentCaptor {


    @InjectMocks
    private StubBookService bookService;

    @Mock
    private StubBookRepository bookRepository;

    @Captor
    private org.mockito.ArgumentCaptor<Book> bookArgumentCaptor;

    @Test
    void testSaveBookWithBookRequestWithArgumentCaptor() {
        BookRequest bookRequest = new BookRequest("Mockito in action", 600,
                LocalDate.now());
//        org.mockito.ArgumentCaptor<Book> bookArgumentCaptor= org.mockito.ArgumentCaptor.forClass(Book.class);
        bookService.addBook(bookRequest);
        verify(bookRepository).save(bookArgumentCaptor.capture());
        Book book = bookArgumentCaptor.getValue();

        assertEquals("Mockito in action", book.getTitle());
    }
}
