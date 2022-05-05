package testDoubles.dummy;


import testDoubles.fake.Book;
import testDoubles.fake.BookRepository;

public class DummyBookService {
    private BookRepository bookRepository;
    private EmailService emailService;

    public DummyBookService(BookRepository bookRepository, EmailService emailService) {
        this.bookRepository = bookRepository;
        this.emailService = emailService;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public int findNumberOfBooks(){
        return bookRepository.findAll().size();
    }
}
