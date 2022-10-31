import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StoreManagerTest {

    @Test
    void manualTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        System.out.println(title);
        driver.quit();
    }
    @Test
    void testRestockProduct() {
        StoreRepository repo = mock(StoreRepository.class);
        StoreManager store = new StoreManager(repo);

        List<Product> dummyProduct = new ArrayList<>();
        Product product1 = new Product(1, "Susu", 3, 12000, 10);

        dummyProduct.add(product1);

        when(repo.getProducts()).thenReturn(dummyProduct);
        store.restockProduct(1,7);
        verify(repo).setProductStocks(1,10);

    }

//    @Test
//    void testGetStock(){
//        StoreRepository repo = mock(StoreRepository.class);
//        StoreManager store = new StoreManager(repo);
//
//        List<Product> dummyProduct = new ArrayList<>();
//        Product product1 = new Product(1, "Susu", 3, 12000, 10);
//
//        dummyProduct.add(product1);
//
//        when(repo.getProducts()).thenReturn(dummyProduct);
//        store.restockProduct(1,7);
//        verify(repo).setProductStocks(1,11);
//
//        //Assert.assertEquals(10, product1.getStock());
//    }

    @Test
    void testGetDiscountedPrice() {
        StoreRepository repo = mock(StoreRepository.class);
        StoreManager store = new StoreManager(repo);

        Product product2 = new Product(2, "Beras", 5, 30000, 10);
        when(repo.findProduct(2)).thenReturn(product2);
        Assert.assertEquals(27000,store.getDiscountedPrice(2));

    }

    @Test
    void testCalculatePrice() {

        StoreRepository repo = mock(StoreRepository.class);
        StoreManager store = new StoreManager(repo);

        Product product1 = new Product(1, "Susu", 3, 12000, 0);
        Product product2 = new Product(2, "Beras", 2, 30000, 0);

        when(repo.findProduct(1)).thenReturn(product1);
        when(repo.findProduct(2)).thenReturn(product2);


        HashMap<Integer, Integer> products = new HashMap<>();
        products.put(1, 3);
        products.put(2, 1);

        Assert.assertEquals(66000, store.calculatePrice(products));

    }

    @Test
    void testBuyProduct() {

        StoreRepository repo = mock(StoreRepository.class);
        StoreManager store = new StoreManager(repo);

        Product product1 = new Product(1, "Susu", 3, 12000, 10);


        HashMap<Integer, Integer> products = new HashMap<>();
        products.put(1, 1);

        when(repo.findProduct(1)).thenReturn(product1);
        store.buyProduct(products);
        verify(repo).setProductStocks(1,2);

    }

    @Test
    void testHasExpired() {

        StoreRepository repo = mock(StoreRepository.class);
        StoreManager store = new StoreManager(repo);

        Product product1 = new Product("2022-10-11", true);
        assertTrue(store.hasExpired(product1));

    }
}