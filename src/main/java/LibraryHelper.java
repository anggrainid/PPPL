import java.util.ArrayList;
import java.util.List;

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

    public List<Book> totalBook(int tujuanBookId){

        List<Book> allBooks = service.getAllBooks();
//        int count = 0;
//        for (int i = 0; i< allBooks.size(); i++){
//            Book book = allBooks.get(i);
//            if (book.bookId == tujuanBookId){
//                count++;
//            }
//        }
//        return count;//
        List<Book> total = new ArrayList<Book>();

        for (int i = 0; i< allBooks.size(); i++){
            Book book = allBooks.get(i);
            if (book.bookId == tujuanBookId){
                total.add(book);
            }
        }

        return total;



    }
}
