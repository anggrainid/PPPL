import org.example.Wallet;
import org.junit.Assert;
import org.junit.Test;

public class WalletTest {

    @Test
    public void testSetOwner(){

        Wallet enji = new Wallet();
        enji.setOwner("padi", "enji");
        Assert.assertEquals(null, enji.getOwner());
        enji.setOwner("paid", "enji");
        Assert.assertEquals("enji", enji.getOwner());
    }

    @Test
    public void testAddCard(){
        Wallet enji1 = new Wallet();
        enji1.addCard("KTP");
        Assert.assertNotNull(enji1.getCards());
        enji1.addCard("STNK");
        enji1.addCard("SIM");
        Assert.assertEquals(3, enji1.getCards().size());
    }

    @Test
    public void testTakeCard(){
        Wallet enji2 = new Wallet();
        enji2.addCard("KTP");
        enji2.addCard("STNK");
        enji2.takeCard("SIM");
        enji2.takeCard("KTP");
        Assert.assertEquals(1, enji2.getCards().size());
    }

    @Test
    public void testAddMoney(){
        Wallet dina = new Wallet();
        dina.addMoney(200.0);
        dina.addMoney(300.0);
        Assert.assertFalse(dina.getMoneys().isEmpty());
    }

    @Test
    public void testTakeMoney(){
        Wallet nina = new Wallet();
        nina.addMoney(1000.0);
        nina.takeMoney(1000.0);
        Assert.assertTrue(nina.getMoneys().isEmpty());
    }

    @Test
    public void testTotal(){
        Wallet enji3 = new Wallet();
        enji3.addMoney(50000.0);
        enji3.addMoney(500.0);
        Assert.assertEquals(50500.0, enji3.getMoney());

    }
}