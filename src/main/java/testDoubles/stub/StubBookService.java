package testDoubles.stub;

import testDoubles.fake.Book;

import java.util.List;

public class StubBookService {

    private StubBookRepository stubBookRepository;

    public StubBookService(StubBookRepository stubBookRepository) {
        this.stubBookRepository = stubBookRepository;
    }
    public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int days){
       List<Book> newBooks= stubBookRepository.findNewBooks(days);

       for(Book book: newBooks){
          int price = book.getPrice();
          int newPrice =price - (discountRate * price/100);
          book.setPrice(newPrice);
       }
       return newBooks;

    }

    public int calculateTotalCost(List<String> bookIds){
        int total=0;
        for(String bookId:bookIds){
          Book book=  stubBookRepository.findBokByBookId(bookId);

          total= total+ book.getPrice();
        }
        return total;
    }

    public void addBook(Book book){
        stubBookRepository.save(book);
    }
}
