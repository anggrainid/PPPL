import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class StoreManager {

    //ini mirip LibraryHelpernya
    StoreRepository store;

    public StoreManager() {

    }
    public StoreManager(StoreRepository repo) {
        this.store = repo;
    }

//    Method ini berfungsi untuk menambah stock produk apabila ada proses restock
//    Parameter berupa id produk dan jumlah barang
    public void restockProduct(int productID, int total) {
        List <Product> products = store.getProducts();
        for(int i=0; i < products.size(); i++) {
            Product currentProduct = products.get(i);
            if (currentProduct.getId() == productID) {
                int totalStocks = currentProduct.getStock() + total;
                store.setProductStocks(productID, totalStocks);
            }
        }
    }

//    Method ini berfungsi untuk menghitung harga setelah diskon
//    Parameter berupa id produk
    public double getDiscountedPrice(int productID) {
        Product product = store.findProduct(productID);
        int discount = product.getDiscount();
        int price = product.getPrice();
        double discountedPrice = price - ((discount/100)*price);
        return discountedPrice;
    }

//Method ini berfungsi untuk menghitung total harga dari produk-produk yang dibeli
//Parameter berupa hashmap dengan key product id yang dibeli dan value berupa jumlah produk yang dibeli
//Apabila terdapat diskon, maka harga akan berubah sesuai diskonnya
//Apabila stok barang kurang dari jumlah produk yang ingin dibeli, maka harga tidak ikut dihitung
    public int calculatePrice(HashMap<Integer, Integer> products) {
        int total = 0;
        for(Integer productID:products.keySet() ) {
            Product product = store.findProduct(productID);
            double price = product.getPrice();
            int totalPerItem = products.get(productID);
            double discount = product.getDiscount();
            int stock = product.getStock();
            if (discount > 0) {
                price = price - ((discount/100)*price);
            }
            if (stock > totalPerItem) {
                total += totalPerItem * price;
            }
        }
        return total;
    }

// Method ini berfungsi untuk mengurangi stock produk apabila ada pembelian yang terjadi
// Parameter berupa hashmap dengan key product id yang dibeli dan value berupa jumlah produk yang dibeli
// Apabila stoknya masih ada, maka stok produk akan dikurangi sesuai jumlah pembelian produk
    public void buyProduct( HashMap<Integer, Integer> boughtProducts) {
        for(Integer productID:boughtProducts.keySet() ) {
            Product product = store.findProduct(productID);
            int stock = product.getStock();
            int totalPerItem = boughtProducts.get(productID);
            if (stock > totalPerItem) {
                int totalStocks = stock - totalPerItem;
                store.setProductStocks(productID, totalStocks);
            }
        }
    }

//    Method ini berfungsi untuk mengecek apakah suatu produk sudah expired apakah belum
//    Parameter berupa object produk
//    Barang yang tidak bisa busuk tidak akan expired
    public Boolean hasExpired(Product product) {
        LocalDate dateLocal = LocalDate.now();
        ZoneId systemTimeZone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = dateLocal.atStartOfDay(systemTimeZone);

        Date today = Date.from(zonedDateTime.toInstant());

        return product.getExpiredDate().before(today) && product.getDecayable();
    }
}