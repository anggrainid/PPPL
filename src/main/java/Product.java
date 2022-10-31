import java.util.Date;

public class Product {
    private int id;
    private int price;
    private int stock;
    private int discount;
    private String name;

    private Boolean isDecayable;

    public Product(String s, boolean b) {
    }


    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    private Date expiredDate;

    public Product() {

    }

    public Product(int productID, String productName, int stock, int price, int discount) {
        this.id = productID;
        this.stock = stock;
        this.discount = discount;
        this.price = price;
        this.name = productName;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDecayable() {
        return isDecayable;
    }

    public void setDecayable(Boolean decayable) {
        isDecayable = decayable;
    }
}
