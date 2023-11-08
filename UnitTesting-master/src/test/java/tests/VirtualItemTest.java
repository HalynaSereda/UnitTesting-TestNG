package tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import shop.VirtualItem;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class VirtualItemTest {
    private VirtualItem virtualItem;

    @BeforeMethod
    public void setUp() {
        // Create a new VirtualItem instance before each test
        virtualItem = new VirtualItem();
        virtualItem.setName("Software");
        virtualItem.setPrice(49.99);
        virtualItem.setSizeOnDisk(1024.0);
    }

    @Test
    @Parameters({ "itemSizeOnDisk" })
    public void testGetSizeOnDisk() {
        double expectedSizeOnDisk = 1024.0;
        double actualSizeOnDisk = virtualItem.getSizeOnDisk();

        assertEquals(actualSizeOnDisk, expectedSizeOnDisk, 0.01);
    }

    @Test
    @Parameters({ "expectedToString" })
    public void testToString() {
        String expectedToString = "Class: class shop.VirtualItem; Name: Software; Price: 49.99; Size on disk: 1024.0";

        String actualToString = virtualItem.toString();

        assertNotNull(actualToString);
        assertEquals(actualToString, expectedToString);
    }
}
