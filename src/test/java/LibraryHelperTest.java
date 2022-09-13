import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LibraryHelperTest {

    @Test
    void testSearchBook() {

        LibraryServiceImpl service = mock(LibraryServiceImpl.class);
        LibraryHelper helper = new LibraryHelper(service);

        List<Book> dummyBooks = new ArrayList<>();
        Book book1 = new Book(1, "Testing 1", "01");
        Book book2 = new Book(2, "Seni Tari", "02");
        Book book3 = new Book(3, "Seni Rupa", "03");

        dummyBooks.add(book1);
        dummyBooks.add(book2);
        dummyBooks.add(book3);

        when(service.getAllBooks()).thenReturn(dummyBooks);

        Assert.assertEquals(2, helper.searchBook("Seni").size());
    }

    @Test
    void testReturnToShelf() {

        LibraryServiceImpl service = mock(LibraryServiceImpl.class);
        LibraryHelper helper = new LibraryHelper(service);

        Book book = new Book(1, "Laskar Pelangi", "");
        book.setShelfId("1");
        book.setBarcode("Barcode1");

        helper.returnBookToShelf(book, "1");
        verify(service).returnBookToShelf("Barcode1");

    }
}