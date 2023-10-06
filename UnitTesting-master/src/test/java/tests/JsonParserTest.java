package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import parser.JsonParser;
import parser.NoSuchFileException;
import shop.Cart;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.testng.Assert.*;

public class JsonParserTest {
    private JsonParser jsonParser;
    private Cart cart;

    @BeforeMethod
    public void setUp() {
        jsonParser = new JsonParser();
    }

    @AfterMethod
    public void tearDown() {
        //Delete temporary JSON files created during testing
        String[] tempFileNames = {
                "temp1.json",
                "temp2.json",
                // Add more file names if needed
        };

        for (String fileName : tempFileNames) {
            File tempFile = new File(fileName);
            if (tempFile.exists()) {
                boolean deleted = tempFile.delete();
                if (!deleted) {
                    System.err.println("Failed to delete " + fileName);
                }
            }
        }
    }

    @Test(expectedExceptions = NoSuchFileException.class, groups = { "jsonParserTests" })
    public void testParseNonexistentFile() {
        String fileName = "nonexistent-file.json";
        File file = new File(fileName);

        Cart parsedCart = jsonParser.readFromFile(file);

        assertNull(parsedCart);
    }

    @Test (enabled = false, groups = { "jsonParserTests" })
    public void testParseMultipleDatasets() {
        // Create an array of JSON datasets with five or more elements
        String[] jsonDatasets = {
                "{\"cartName\":\"Cart1\",\"realItems\":[],\"virtualItems\":[],\"total\":0.0}",
                "{\"cartName\":\"Cart2\",\"realItems\":[],\"virtualItems\":[],\"total\":0.0}",
                "{\"cartName\":\"Cart3\",\"realItems\":[],\"virtualItems\":[],\"total\":0.0}",
                "{\"cartName\":\"Cart4\",\"realItems\":[],\"virtualItems\":[],\"total\":0.0}",
                "{\"cartName\":\"Cart5\",\"realItems\":[],\"virtualItems\":[],\"total\":0.0}"
                // Add more datasets here
        };

        // Loop through the datasets and attempt to parse them
        for (String json : jsonDatasets) {
            try {
                File file = createTempFileWithContent(json);
                Cart parsedCart = jsonParser.readFromFile(file);
                assertNotNull(parsedCart);
            } catch (IOException e) {
                fail("IOException occurred while creating a test file.");
            }
        }
    }
    private File createTempFileWithContent(String content) throws IOException {
        // Create a temporary file with the provided content
        File tempFile = File.createTempFile("temp", ".json");
        Files.write(Paths.get(tempFile.getAbsolutePath()), content.getBytes());
        return tempFile;
    }

    @Test (groups = { "jsonParserTests" })
    public void testReadAndrewCartFromFile() {
        // Specify the file path for andrew-cart.json
        String filePath = "src/test/resources/andrew-cart.json";

        // Read the Cart object from the file
        Cart parsedCart = jsonParser.readFromFile(new File(filePath));

        // Create the expected Cart object based on the sample JSON cart
        Cart expectedCart = new Cart("andrew-cart");


        // Assertions to verify that the parsedCart matches the expectedCart
        assertNotNull(parsedCart, "The parsedCart is null.");
        assertEquals(parsedCart.getCartName(), expectedCart.getCartName(), "Cart names do not match.");

    }

    @Test (groups = { "jsonParserTests" })
    public void testReadEugenCartFromFile() {
        // Specify the file path for eugen-cart.json
        String filePath = "src/test/resources/eugen-cart.json";

        // Read the Cart object from the file
        Cart parsedCart = jsonParser.readFromFile(new File(filePath));

        // Create the expected Cart object based on the sample JSON cart
        Cart expectedCart = new Cart("eugen-cart");


        // Assertions to verify that the parsedCart matches the expectedCart
        assertNotNull(parsedCart, "The parsedCart is null.");
        assertEquals(parsedCart.getCartName(), expectedCart.getCartName(), "Cart names do not match.");

    }


}
