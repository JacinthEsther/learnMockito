package testDoubles.stub;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import testDoubles.fake.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(MockitoJUnitRunner.class)->for junit4
@ExtendWith(MockitoExtension.class)
public class MockitoStubBookTest {

//    for Junit4
//    @Rule
//    public MockitoRule mockRule = MockitoJUnit.rule();

//    @Before
//    public void beforeEach(){
//        MockitoAnnotations.initMocks(this);
//    }


    @InjectMocks
    private StubBookService bookService;

    @Mock
    private StubBookRepository bookRepository;

    @Test
    void testCalculateTotalCostOfBooks(){
        List<String > bookIds = new ArrayList<String>();
        bookIds.add("1234");
        bookIds.add("1235");

        Book book1= new Book("1234","Mockito in action",500,
                LocalDate.now());

        Book book2=new Book("1235","Junit5 in action",400,
                LocalDate.now());

//        Mockito.when(bookRepository.findBokByBookId("1234")).thenReturn(book1);
//        Mockito.when(bookRepository.findBokByBookId("1235")).thenReturn(book2);
//
     Mockito.doReturn(book1).when(bookRepository).findBokByBookId("1234");
     Mockito.doReturn(book2).when(bookRepository).findBokByBookId("1235");

      int actualCost =  bookService.calculateTotalCost(bookIds);

      assertEquals(900, actualCost);
    }

    @Test
    void testSaveBook(){
        Book book1= new Book("1234","Mockito in action",500,
                LocalDate.now());
        Mockito.doNothing().when(bookRepository).save(book1);
        bookService.addBook(book1);
    }
}
