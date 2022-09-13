import java.util.List;

public interface LibraryService {

    public List<Book> getAllBooks();
    public void returnBookToShelf(String barcode);

    //void returnBookToShelf(Book book);

    public void borrowBook(String barcode);
    public Book findBook(String barcode);
    public void sendMessageToStudent(String studentID);

}
