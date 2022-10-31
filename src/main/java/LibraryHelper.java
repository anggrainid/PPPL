import java.util.ArrayList;
import java.util.Date;
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

    public int totalAvailBook(int bookId){

        List<Book> allBooks = service.getAllBooks();
        List<Book> total = new ArrayList<Book>();

        for (int i = 0; i< allBooks.size(); i++){
            Book book = allBooks.get(i);
            if (book.bookId == bookId){
                total.add(book);
            }
        }

        return total.size();

    }

    public Boolean isOverdue (String barcode, Date dateReturn)
            throws Exception {
        Book book = this.service.findBook(barcode);

        if (book.deadline().before(dateReturn)){
            return true;
        }
        else {
            return false;
        }
    }

    public int totalFine (String barcode, int dayOverdue){
        Book book = this.service.findBook(barcode);

        int fine = book.fine;
        int totalFine = fine * dayOverdue;
        return totalFine;
    }

    public boolean HasToBuy(int bookId){
        List<Book> allBooks = service.getAllBooks();
        List<Book> SelectedBooks = new ArrayList<Book>();
        List<Book> BorrowedSelectedBooks = new ArrayList<Book>();

        for (int i = 0; i< allBooks.size(); i++){
            Book book = allBooks.get(i);
            if (book.bookId == bookId){
                SelectedBooks.add(book);
            }
        }

        for (Book selectBook : SelectedBooks) {
            if (selectBook.isBorrowed == true){
                BorrowedSelectedBooks.add(selectBook);
            }
        }

        if (BorrowedSelectedBooks.size() == SelectedBooks.size()){
            return true;
        }else {
            return false;
        }

    }
    public void borrowBook(int bookId){
        List<Book> allBooks = service.getAllBooks();

        for (int i = 0; i< allBooks.size(); i++){
            Book book = allBooks.get(i);
            if (book.bookId == bookId){
                this.service.borrowBook(book.barcode);
                break;
            }
        }
    }

    public void reminder(Date today) throws Exception {
        List<Book> allBooks = service.getAllBooks();


        for (int i = 0; i< allBooks.size(); i++){
            Book book = allBooks.get(i);
                if (today.equals(book.deadline())){
                    this.service.sendMessageToStudent(book.studentID);
                }
            }
        }

    }
