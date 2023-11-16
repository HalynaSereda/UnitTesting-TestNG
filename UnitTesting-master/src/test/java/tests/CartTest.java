package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest {
    private Cart cart;
    private RealItem realItem;
    private VirtualItem virtualItem;

    @BeforeMethod
    public void setUp() {
        // Create a new Cart instance and some sample items before each test
        cart = new Cart("TestCart");

        realItem = new RealItem();
        realItem.setName("Laptop");
        realItem.setPrice(999.99);
        realItem.setWeight(2.5);

        virtualItem = new VirtualItem();
        virtualItem.setName("Software");
        virtualItem.setPrice(49.99);
        virtualItem.setSizeOnDisk(1024.0);
    }

    @Test
    public void testAddRealItem() {
        // Test adding a RealItem to the Cart

        // Add the RealItem to the Cart
        cart.addRealItem(realItem);

        // Calculate the expected total price, including a 20% tax
        double expectedTotalPrice = 999.99 * 1.2;

        // Get the actual total price from the Cart
        double actualTotalPrice = cart.getTotalPrice();

        // Assert that the actual total price matches the expected total price with a tolerance of 0.01
        assertEquals(actualTotalPrice, expectedTotalPrice, 0.01);
    }

    @Test
    public void testAddVirtualItem() {
        // Test adding a VirtualItem to the Cart

        // Add the VirtualItem to the Cart
        cart.addVirtualItem(virtualItem);

        // Calculate the expected total price, including a 20% tax
        double expectedTotalPrice = 49.99 * 1.2;

        // Get the actual total price from the Cart
        double actualTotalPrice = cart.getTotalPrice();

        // Assert that the actual total price matches the expected total price with a tolerance of 0.01
        assertEquals(actualTotalPrice, expectedTotalPrice, 0.01);
    }
}
