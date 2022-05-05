package testDoubles.stub;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import testDoubles.fake.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class StubBookServiceTest {

    @Test
    void dummyStub(){
        StubBookRepository stubBookRepository= new BookRepositoryStub();
        StubBookService bookService = new StubBookService(stubBookRepository);

     List<Book> newBooksWithAppliedDiscount=   bookService.getNewBooksWithAppliedDiscount(10, 7);

     assertEquals(2, newBooksWithAppliedDiscount.size());
     assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
     assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());

    }

    @Test
    void demoStubWithMockito(){
        StubBookRepository bookRepository = mock(StubBookRepository.class);
        StubBookService bookService = new StubBookService(bookRepository);

        Book book1= new Book("1234","Mockito in action",500,
                LocalDate.now());

        Book book2=new Book("1235","Junit5 in action",400,
                LocalDate.now());

        List<Book> newBooks = new ArrayList<Book>();
        newBooks.add(book1);
        newBooks.add(book2);

        Mockito.when(bookRepository.findNewBooks(7)).thenReturn(newBooks);

        List<Book> newBooksWithAppliedDiscount=   bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());


    }

}