package testDoubles.dummy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import testDoubles.fake.Book;
import testDoubles.fake.BookRepository;
import testDoubles.fake.BookService;
import testDoubles.fake.FakeBookRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class DummyBookServiceTest {

    @Test
    void demoDummy(){
        //dummy is just to make the code compile
        BookRepository bookRepository= new FakeBookRepository();
        EmailService emailService= new EmailServiceRepository();
       DummyBookService bookService = new DummyBookService(bookRepository,emailService);


        bookService.addBook(new Book("1234","Mockito in action",250,
                LocalDate.now()));
        bookService.addBook(new Book("1235","Junit5 in action",500,
                LocalDate.now()));

        assertEquals(2, bookService.findNumberOfBooks());
    }

    @Test
    void demoDummyWithMockito(){
        BookRepository bookRepository= Mockito.mock(BookRepository.class);
        EmailService emailService = Mockito.mock(EmailService.class);
        DummyBookService bookService = new DummyBookService(bookRepository,emailService);


        Book book1=new Book("1234","Mockito in action",250,
                LocalDate.now());
        Book book2=new Book("1235","Junit5 in action",500,
                LocalDate.now());

        Collection<Book> books = new ArrayList<Book>();
        books.add(book1);
        books.add(book2);

        Mockito.when(bookRepository.findAll()).thenReturn(books);

        assertEquals(2, bookService.findNumberOfBooks());
    }

}