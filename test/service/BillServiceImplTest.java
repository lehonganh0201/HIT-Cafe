package service;

import FileConnector.ReloadData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Bill;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import repository.BillRepositoryImpl;

public class BillServiceImplTest {
    private final BillRepositoryImpl billRepositoryImpl = new BillRepositoryImpl();
    private final BillServiceImpl instance = new BillServiceImpl(billRepositoryImpl);

    
    public BillServiceImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("BeforeClass - Setup for all tests");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("AfterClass - Cleanup after all tests");
        ReloadData.main(null);
    }

    @Before
    public void setUp() {
        System.out.println("Before - Setup for each test");
        billRepositoryImpl.clear();

        instance.saveBill(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-01-2024", "100000", "admin@gmail.com"));
        instance.saveBill(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-02-2024", "200000", "admin@gmail.com"));
        instance.saveBill(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-03-2024", "300000", "admin@gmail.com"));
        instance.saveBill(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-04-2024", "400000", "admin@gmail.com"));
        instance.saveBill(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-05-2024", "500000", "admin@gmail.com"));
        instance.saveBill(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-06-2024", "600000", "admin@gmail.com"));
        instance.saveBill(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-07-2024", "700000", "admin@gmail.com"));
        instance.saveBill(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-08-2024", "800000", "admin@gmail.com"));
        instance.saveBill(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-09-2024", "900000", "admin@gmail.com"));
        instance.saveBill(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-10-2024", "1000000", "admin@gmail.com"));
        instance.saveBill(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-11-2024", "1100000", "admin@gmail.com"));
        instance.saveBill(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-12-2024", "1200000", "admin@gmail.com"));
    }

    @After
    public void tearDown() {
        System.out.println("After - Cleanup after each test");
        billRepositoryImpl.clear();
    }

    @Test
    public void testSaveBill() {
        System.out.println("saveBill");
        Bill bill = new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-13-2024", "1300000", "admin@gmail.com");
        Bill result = instance.saveBill(bill);

        Bill expResult = new Bill(result.getId(), "Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-13-2024", "1300000", "admin@gmail.com");

        assertTrue(result.equalsWithoutId(expResult));
    }

    @Test
    public void testGetAllBillRecordsByINC() {
        System.out.println("getAllBillRecordsByINC");
        String date = "01-01-2024";
        List<Bill> expResult = List.of(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-01-2024", "100000", "admin@gmail.com"));
        List<Bill> result = instance.getAllBillRecordsByINC(date);
        assertEquals(expResult.size(), result.size());
    }

    @Test
    public void testGetAllBillRecordsByDESC() {
        System.out.println("getAllBillRecordsByDESC");
        String date = "01-01-2024";
        List<Bill> expResult = List.of(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-01-2024", "100000", "admin@gmail.com"));
        List<Bill> result = instance.getAllBillRecordsByDESC(date);
        assertEquals(expResult.size(), result.size());
    }

    @Test
    public void testGetAllBillRecords() {
        System.out.println("getAllBillRecords");
        List<Bill> expResult = new ArrayList<>();
        expResult.add(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-01-2024", "100000", "admin@gmail.com"));
        expResult.add(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-02-2024", "200000", "admin@gmail.com"));
        expResult.add(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-03-2024", "300000", "admin@gmail.com"));
        expResult.add(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-04-2024", "400000", "admin@gmail.com"));
        expResult.add(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-05-2024", "500000", "admin@gmail.com"));
        expResult.add(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-06-2024", "600000", "admin@gmail.com"));
        expResult.add(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-07-2024", "700000", "admin@gmail.com"));
        expResult.add(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-08-2024", "800000", "admin@gmail.com"));
        expResult.add(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-09-2024", "900000", "admin@gmail.com"));
        expResult.add(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-10-2024", "1000000", "admin@gmail.com"));
        expResult.add(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-11-2024", "1100000", "admin@gmail.com"));
        expResult.add(new Bill("Le Hong Anh", "0132456789", "le2960620@gmail.com", "01-12-2024", "1200000", "admin@gmail.com"));
        
        List<Bill> result = instance.getAllBillRecords();
        assertEquals(expResult.size(), result.size());
        for (int i = 0; i < expResult.size(); i++) {
            assertTrue(result.get(i).equalsWithoutId(expResult.get(i)));
        }
    }

    @Test
    public void testGetNextBillId() {
        System.out.println("getNextBillId");
        Integer expResult = 13;
        Integer result = instance.getNextBillId();
        assertEquals(expResult, result);
    }

    @Test
    public void testCalculateMonthlyRevenue() {
        System.out.println("calculateMonthlyRevenue");
        Integer month = 6;
        String year = "2024";
        Double expResult = 600000.0;
        Double result = instance.calculateMonthlyRevenue(month, year);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetRevenue() {
        System.out.println("getRevenue");
        
        List<Double> expResult = Arrays.asList(
            100000.0, 200000.0, 300000.0, 400000.0, 500000.0, 600000.0, 
            700000.0, 800000.0, 900000.0, 1000000.0, 1100000.0, 1200000.0
        );
        
        List<Double> result = instance.getRevenue();
        assertEquals(expResult, result);
    }
}