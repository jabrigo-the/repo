/*
 * Huseyin Aygun
 * CMSC 204
 * Jonderick Abrigo 
 * 9/8/25
 */
//package Labs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesTrackerTest {
    private ProductSalesTracker tracker1;
    private ProductSalesTracker tracker2;

    @BeforeEach
    public void setUp() {
    	tracker1 = new ProductSalesTracker(5);
    	tracker1.addSale(2.50);
    	tracker1.addSale(2.50);
    	tracker1.addSale(2.50);
    	
    	tracker2 = new ProductSalesTracker(5);
    	tracker2.addSale(1.00);
    	tracker2.addSale(.79);
    }

    @AfterEach
    public void tearDown() {
    	tracker1 = null;
    	tracker2 = null;
    }

    @Test
    public void testAddSale() {
    	assertTrue(tracker1.addSale(2.50));
    	assertEquals(tracker1.totalSales(), 10.00);
    	assertTrue(tracker2.addSale(.21));
    	assertEquals(tracker2.totalSales(), 2.00);
    	
    	//Testing the "Full Tracker" Clause
    	assertTrue(tracker1.addSale(2.50));
    	assertTrue(!tracker1.addSale(9000.00));
    }

    @Test
    public void testTotalSales() {
    	assertEquals(tracker1.totalSales(), 7.50);
    	assertEquals(tracker2.totalSales(), 1.79);
    }

    @Test
    public void testLowestSale() {
    	assertEquals(tracker1.lowestSale(), 2.50);
    	assertEquals(tracker2.lowestSale(), 0.79);
    	
    	//Testing the "No Sales" Clause
    	tracker2 = null;
    	tracker2 = new ProductSalesTracker(5);
    	assertEquals(tracker2.lowestSale(), 0);
    }

    @Test
    public void testFinalSalesTotal() {
    	assertEquals(tracker1.finalSalesTotal(), 5.00);
    	assertEquals(tracker2.finalSalesTotal(), 1);
    	
    	//Testing the "Less Than Two" Clause
    	tracker2 = null;
    	tracker2 = new ProductSalesTracker(5);
    	tracker2.addSale(4.56);
    	assertEquals(tracker2.finalSalesTotal(), 0);
    }

    @Test
    public void testToString() {
    	assertEquals(tracker1.toString(), "2.5 2.5 2.5 ");
    	assertEquals(tracker2.toString(), "1.0 0.79 ");
    }
}

