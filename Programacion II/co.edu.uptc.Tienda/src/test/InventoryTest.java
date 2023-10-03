package test;

import model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.Inventory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

    private Inventory inventory;

    @BeforeEach
    void setUp() throws IOException {
        inventory = new Inventory();
        File testFile = new File("Resourses\\ProductsFerreteriaIdeal.txt");
    }

    @Test
    void obtainProductToTxt() throws IOException {
        List<Product> products = inventory.getProducts();
        assertEquals(10, products.size());

        Product product1 = products.get(0);
        assertEquals(1, product1.getId());
        assertEquals("Aerosol negro mate", product1.getNameProduct());
        assertEquals("300ml", product1.getDescription());
        assertEquals(14000, product1.getPrice());
        assertEquals(11, product1.getStock());

        Product product2 = products.get(1);
        assertEquals(2, product2.getId());
        assertEquals("Chazo Plastico", product2.getNameProduct());
        assertEquals("3_8vos", product2.getDescription());
        assertEquals(100, product2.getPrice());
        assertEquals(22, product2.getStock());
    }

    @Test
    void obtainProductToTxt_returnsCorrectNumberOfLines() throws IOException {
        FileReader reader = new FileReader("Resourses\\ProductsFerreteriaIdeal.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        int lineCount = 0;
        while (bufferedReader.readLine() != null) {
            lineCount++;
        }
        bufferedReader.close();

        List<Product> products = inventory.getProducts();
        assertEquals(lineCount, products.size());
    }

    @Test
    void obtainProductToTxt_handlesNonExistingFile() {
        File nonExistingFile = new File("Resourses\\NonExistingFile.txt");
        assertFalse(nonExistingFile.exists());
        assertThrows(IOException.class, () -> inventory.obtainProductToTxt());
    }

    @Test
    void obtainProductToTxt_performanceTest() throws IOException {
        long startTime = System.currentTimeMillis();

        inventory.obtainProductToTxt();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Execution time: " + executionTime + " milliseconds");
    }

    @AfterEach
    void tearDown() {
    }
}
