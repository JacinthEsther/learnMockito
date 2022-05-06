package testDoubles.behaviour.verification;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import testDoubles.fake.Book;
import testDoubles.stub.BookRequest;
import testDoubles.stub.StubBookRepository;
import testDoubles.stub.StubBookService;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class verificationBookServiceTest {
    @InjectMocks
    private StubBookService bookService;

    @Mock
    private StubBookRepository bookRepository;

    @Test
    void testAddBook(){
        Book book= new Book(null,"Mockito in action",600,
                LocalDate.now());
        bookService.addBook(book);
        verify(bookRepository).save(book);
    }

    @Test
    void testSaveBookWithBookRequest(){
        BookRequest bookRequest = new BookRequest("Mockito in action",500,
                LocalDate.now());
        Book book= new Book(null,"Mockito in action",500,
                LocalDate.now());
        bookService.addBook(bookRequest);
        verify(bookRepository,Mockito.times(0)).save(book);
    }


 @Test
    void testSaveBookWithBookRequestNever(){
        BookRequest bookRequest = new BookRequest("Mockito in action",500,
                LocalDate.now());
        Book book= new Book(null,"Mockito in action",500,
                LocalDate.now());
        bookService.addBook(bookRequest);
        verify(bookRepository,Mockito.never()).save(book);
    }


     @Test
    void testSaveBookWithBookRequestOnce(){
        BookRequest bookRequest = new BookRequest("Mockito in action",600,
                LocalDate.now());
        Book book= new Book(null,"Mockito in action",600,
                LocalDate.now());
        bookService.addBook(bookRequest);
        verify(bookRepository,Mockito.times(1)).save(book);
    }

    @Test
    void testUpdatePrice(){
        bookService.updatePrice(null, 900);
        verifyNoInteractions(bookRepository);
    }

    @Test
    void testUpdatePrice2(){
      Book book= new Book("1234","Mockito in action",600,
              LocalDate.now());
        when(bookRepository.findBookByBookId("1234")).thenReturn(book);
              bookService.updatePrice("1234", 600);
        verify(bookRepository).findBookByBookId("1234");
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    void testUpdatePrice3(){
      Book book= new Book("1234","Mockito in action",600,
              LocalDate.now());
        when(bookRepository.findBookByBookId("1234")).thenReturn(book);
              bookService.updatePrice("1234", 700);
        verify(bookRepository).findBookByBookId("1234");
        verify(bookRepository).save(book);
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    void testUpdatePrice4(){
      Book book= new Book("1234","Mockito in action",600,
              LocalDate.now());
        when(bookRepository.findBookByBookId("1234")).thenReturn(book);
              bookService.updatePrice("1234", 700);

        InOrder inOrder= Mockito.inOrder(bookRepository);
       inOrder.verify(bookRepository).findBookByBookId("1234");
       inOrder.verify(bookRepository, atLeast(1)).save(book);
    }

}
