import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Book {
    int bookId;
    String title;
    String barcode;
    boolean isBorrowed;
    int loanPeriod;
    String studentID;
    String shelfId;
    int fine;

    public Date getDateBorrowed() {
        return dateBorrowed;
    }

    public void setDateBorrowed(Date dateBorrowed) {
        this.dateBorrowed = dateBorrowed;
    }

    Date dateBorrowed;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(int loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getShelfId() {
        return shelfId;
    }

    public void setShelfId(String shelfId) {
        this.shelfId = shelfId;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public Date deadline() throws Exception{

        if (isBorrowed){

            Calendar cal = Calendar.getInstance();
            cal.setTime(dateBorrowed);
            cal.add(Calendar.DATE, loanPeriod);
            Date deadline = cal.getTime();

            return deadline;
        }else {
            Date nolimit = new SimpleDateFormat("dd/mm/yyyy").parse("00/00/0000");
            return nolimit;
        }
    }

    public Book(int bookId, String title, String barcode){
//        this.setBookId(bookId);
//        this.setTitle(title);
//        this.setBarcode(barcode);
        this.bookId = bookId;
        this.title = title;
        this.barcode = barcode;
    }
}
