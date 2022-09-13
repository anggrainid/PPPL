import java.util.List;

public class LibraryServiceImpl implements LibraryService {

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public void returnBookToShelf(String barcode) {
        //save to db
    }


    @Override
    public void borrowBook(String barcode) {

    }

    @Override
    public Book findBook(String barcode) {
        return null;
    }

    @Override
    public void sendMessageToStudent(String studentID) {

    }
}
