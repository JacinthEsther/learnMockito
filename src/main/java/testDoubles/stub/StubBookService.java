package testDoubles.stub;

import testDoubles.fake.Book;

import java.sql.SQLException;
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
          Book book=  stubBookRepository.findBookByBookId(bookId);

          total= total+ book.getPrice();
        }
        return total;
    }

    public void addBook(Book book){
        if(book.getPrice()==500){
            return;
        }
        stubBookRepository.save(book);
    }

    public void addBook(BookRequest bookRequest){
        if(bookRequest.getPrice()==500){
            return;
        }
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setPrice(bookRequest.getPrice());
        book.setPublishedDate(bookRequest.getPublishedDate());

        stubBookRepository.save(book);
    }


    public void updatePrice(String bookId, int updatedPrice){
        if(bookId == null){
            return;
        }

       Book book= stubBookRepository.findBookByBookId(bookId);

        if(book.getPrice()==updatedPrice)return;
       book.setPrice(updatedPrice);
       stubBookRepository.save(book);
    }

    public int getTotalPriceOfBooks(){
        List<Book> books = null;
            try {
                stubBookRepository.findAllBooks();
            }catch(SQLException e){
                e.printStackTrace();
            }
        int totalPrice = 0;
        for(Book book: books){
            totalPrice += book.getPrice();
        }
        return totalPrice;
    }
}
