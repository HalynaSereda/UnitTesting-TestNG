package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import shop.RealItem;

import static org.testng.Assert.*;

public class RealItemTest {
    private RealItem realItem;

    @BeforeMethod
    public void setUp() {
        // Create a new RealItem instance before each test
        realItem = new RealItem();
        realItem.setName("Sample Item");
        realItem.setPrice(19.99);
        realItem.setWeight(500.0);
    }

    @AfterMethod
    public void tearDown() {
        // Clean up resources if needed
        realItem = null;
    }

    @Test
    public void testGetWeight() {
        double expectedWeight = 500.0;
        double actualWeight = realItem.getWeight();

        assertEquals(actualWeight, expectedWeight, 0.01);
    }

    @Test
    public void testToString() {
        String expectedToString = "Class: class shop.RealItem; Name: Sample Item; Price: 19.99; Weight: 500.0";

        String actualToString = realItem.toString();

        assertEquals(actualToString, expectedToString);
    }
}

