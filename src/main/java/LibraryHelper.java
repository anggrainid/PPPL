import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryHelper {

    LibraryServiceImpl service;

    public LibraryHelper(LibraryServiceImpl service){
        this.service = service;
    }

    public List<Book> searchBook(String keyword){
        List<Book> allBooks = service.getAllBooks();
        List<Book> result = new ArrayList<Book>();

        for (int i = 0; i< allBooks.size(); i++){
            Book book = allBooks.get(i);
            if (book.getTitle().contains(keyword)){
                result.add(book);
            }
        }

        return result;
    }

    public void returnBookToShelf(Book book, String tujuanShelfId){
        if (book.shelfId.equals(tujuanShelfId)){
            this.service.returnBookToShelf(book.barcode); //panggil returnBookToShelfnya LibraryServiceImpl
        }
    }
}
