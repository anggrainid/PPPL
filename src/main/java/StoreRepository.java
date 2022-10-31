import java.util.List;

public class StoreRepository {

    private List<Product> products;
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setProductStocks(int id, int total) {
        this.products.get(id).setStock(total);
    }
    public Product findProduct(int id) {
        return products.get(id);
    }

}
