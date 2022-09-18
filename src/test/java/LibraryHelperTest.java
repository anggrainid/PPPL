import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

    @Test
    void testTotalBook(){

        LibraryServiceImpl service = mock(LibraryServiceImpl.class);
        LibraryHelper helper = new LibraryHelper(service);

        List<Book> dummyBooks = new ArrayList<>();
        Book book1 = new Book(1, "Laskar Pelangi", "LP-01");
        Book book2 = new Book(1, "Laskar Pelangi", "LP-02");
        Book book3 = new Book(1, "Laskar Pelangi", "LP-03");
        dummyBooks.add(book1);
        dummyBooks.add(book2);
        dummyBooks.add(book3);

        when(service.getAllBooks()).thenReturn(dummyBooks);
        Assert.assertEquals(3, helper.totalBook(1).size());
        //helper.totalBook(1);
    }

    @Test
    void testIsOverdue() throws Exception{
        LibraryServiceImpl service = mock(LibraryServiceImpl.class);
        LibraryHelper helper = new LibraryHelper(service);

        Book book1 = new Book(1, "Harry Potter", "");
        book1.setBarcode("HP-01");
        book1.loanPeriod = 5;

        Date dateBorrowed = new SimpleDateFormat("dd/mm/yyyy").parse("01/02/2020");
        book1.isBorrowed = true;
        book1.dateBorrowed = dateBorrowed;
        //book1.setDateBorrowed(dateFormat.parse(setTanggalPeminjaman));
        //book1.setLoanPeriod(7);

        when(service.findBook("HP-01")).thenReturn(book1);
        Date dateReturn = new SimpleDateFormat("dd/mm/yyy").parse("02/02/2021");
        Assert.assertTrue(helper.isOverdue("HP-01",dateReturn));

    }
    @Test
    void testDeadline() throws Exception {

        Book book = new Book(1, "Laskar Pelangi", "LP-01");
        book.loanPeriod = 1;
        book.isBorrowed = true;
        Date dateBorrowed = new SimpleDateFormat("dd/MM/yyyy").parse("19/09/2022");
        book.dateBorrowed = dateBorrowed;


        assertEquals(new SimpleDateFormat("dd/MM/yyyy").parse("20/09/2022"), book.deadline());

    }
    @Test
    void testTotalFine(){
        LibraryServiceImpl service = mock(LibraryServiceImpl.class);
        LibraryHelper helper = new LibraryHelper(service);

        Book book1 = new Book(1, "Harry Potter", "HP-01");
        book1.fine = 5000;
        when(service.findBook("HP-01")).thenReturn(book1);
        assertEquals(20000, helper.totalFine("HP-01", 4));

    }

    @Test
    void testHasToBuy(){
        LibraryServiceImpl service = mock(LibraryServiceImpl.class);
        LibraryHelper helper = new LibraryHelper(service);

        List<Book> dummyBooks = new ArrayList<>();
        Book book1 = new Book(1, "Laskar Pelangi", "LP-01");
        Book book2 = new Book(1, "Laskar Pelangi", "LP-02");
        Book book3 = new Book(1, "Laskar Pelangi", "LP-03");
        dummyBooks.add(book1);
        dummyBooks.add(book2);
        dummyBooks.add(book3);
        book1.isBorrowed = true;
        book2.isBorrowed = true;
        book3.isBorrowed = true;

        when(service.getAllBooks()).thenReturn(dummyBooks);
        assertTrue(helper.HasToBuy(1));
    }

    @Test
    void testBorrowBook(){

        LibraryServiceImpl service = mock(LibraryServiceImpl.class);
        LibraryHelper helper = new LibraryHelper(service);

        List<Book> dummyBooks = new ArrayList<>();
        Book book1 = new Book(1, "Laskar Pelangi", "LP-01");
        Book book2 = new Book(1, "Laskar Pelangi", "LP-02");
        dummyBooks.add(book1);
        dummyBooks.add(book2);

        when(service.getAllBooks()).thenReturn(dummyBooks);
        helper.borrowBook(1);
        verify(service).borrowBook("LP-01");

    }
    @Test
    void testReminder() throws Exception{

        LibraryServiceImpl service = mock(LibraryServiceImpl.class);
        LibraryHelper helper = new LibraryHelper(service);

        List<Book> dummyBooks = new ArrayList<>();
        Book book1 = new Book(1, "Laskar Pelangi", "LP-01");
        book1.loanPeriod = 1;
        book1.isBorrowed =true;
        Date dateBorrowed = new SimpleDateFormat("dd/MM/yyyy").parse("19/09/2022");
        book1.dateBorrowed = dateBorrowed;
        book1.studentID = "123";
        dummyBooks.add(book1);

        Date today = new SimpleDateFormat("dd/MM/yyyy").parse("20/09/2022");

        when(service.getAllBooks()).thenReturn(dummyBooks);
        helper.reminder(today);
        verify(service).sendMessageToStudent("123");

    }
}