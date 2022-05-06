//package testDoubles;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import testDoubles.fake.Book;
//import testDoubles.stub.StubBookRepository;
//import testDoubles.stub.StubBookService;
//
//import java.sql.SQLException;
//import java.time.LocalDate;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.doThrow;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//
//public class ExceptionHandling {
//
//    @InjectMocks
//    private StubBookService bookService;
//
//    @Mock
//    private StubBookRepository bookRepository;
//
//    @Test
//    void testAddBook() throws SQLException{
//        Book book= new Book(null,"Mockito in action",600,
//                LocalDate.now());
//        //when(bookRepository.findAllBooks()).thenThrow(SQLException.class);
//        doThrow(SQLException.class).when(bookRepository).save(book);
//        assertThrows(SQLException.class,()->bookService.addBook(book));
//    }
//}
