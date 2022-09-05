import org.junit.Assert;
import org.junit.Test;


//import java.lang.reflect.Array;
import java.util.Arrays;
//import java.util.HashMap;

//import static org.junit.Assert.*;

public class WalletTest {

    @Test
    public void testSetOwner(){

        Wallet wallet1 = new Wallet();
        wallet1.setOwner("enji");
        Assert.assertEquals("enji", wallet1.getOwner());

    }

    @Test
    public void testAddCard(){

        Wallet enji = new Wallet();
        enji.addCard("KTP");
        enji.addCard("SIM");
        Assert.assertEquals(Arrays.asList("KTP", "SIM"), enji.getCards());

    }

    @Test
    public void testTakeCard(){

        Wallet enji = new Wallet();
        enji.addCard("KTP");
        enji.addCard("SIM");
        enji.takeCard("SIM");
        Assert.assertEquals(Arrays.asList("KTP"), enji.getCards());

    }

    @Test
    public void testInsertCoin(){

        Wallet enji = new Wallet();
        enji.insertCoin(1000);
        enji.insertCoin(1000);
        enji.insertCoin(1000);
        Assert.assertSame(3,enji.coins.get(1000));
        //Assert.assertTrue(enji.coins.get(1000) != null); //tidak valid karena <0> bukan null

    }

    @Test
    public void testTakeCoin(){
        Wallet enji = new Wallet();
        enji.insertCoin(500);
        enji.insertCoin(1000);
        enji.insertCoin(500);
        enji.insertCoin(100);
        //enji.insertCoin(500);
        enji.takeCoin(500);
        Assert.assertSame(1, enji.coins.get(500));

    }

    @Test
    public void testCalculateCoins(){

        Wallet enji = new Wallet();
        enji.insertCoin(100);
        enji.insertCoin(500);
        enji.insertCoin(1000);
        enji.insertCoin(100);
        enji.takeCoin(100);
        Assert.assertEquals(1600, enji.calculateCoins());


    }


}