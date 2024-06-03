/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import java.util.List;
import model.Bill;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PC
 */
public class BillServiceImplTest {
    
    public BillServiceImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of saveBill method, of class BillServiceImpl.
     */
    @Test
    public void testSaveBill() {
        System.out.println("saveBill");
        Bill bill = null;
        BillServiceImpl instance = null;
        Bill expResult = null;
        Bill result = instance.saveBill(bill);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllBillRecordsByINC method, of class BillServiceImpl.
     */
    @Test
    public void testGetAllBillRecordsByINC() {
        System.out.println("getAllBillRecordsByINC");
        String date = "";
        BillServiceImpl instance = null;
        List<Bill> expResult = null;
        List<Bill> result = instance.getAllBillRecordsByINC(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllBillRecordsByDESC method, of class BillServiceImpl.
     */
    @Test
    public void testGetAllBillRecordsByDESC() {
        System.out.println("getAllBillRecordsByDESC");
        String date = "";
        BillServiceImpl instance = null;
        List<Bill> expResult = null;
        List<Bill> result = instance.getAllBillRecordsByDESC(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllBillRecords method, of class BillServiceImpl.
     */
    @Test
    public void testGetAllBillRecords() {
        System.out.println("getAllBillRecords");
        BillServiceImpl instance = null;
        List<Bill> expResult = null;
        List<Bill> result = instance.getAllBillRecords();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNextBillId method, of class BillServiceImpl.
     */
    @Test
    public void testGetNextBillId() {
        System.out.println("getNextBillId");
        BillServiceImpl instance = null;
        Integer expResult = null;
        Integer result = instance.getNextBillId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateMonthlyRevenue method, of class BillServiceImpl.
     */
    @Test
    public void testCalculateMonthlyRevenue() {
        System.out.println("calculateMonthlyRevenue");
        Integer month = null;
        String year = "";
        BillServiceImpl instance = null;
        Double expResult = null;
        Double result = instance.calculateMonthlyRevenue(month, year);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRevenue method, of class BillServiceImpl.
     */
    @Test
    public void testGetRevenue() {
        System.out.println("getRevenue");
        BillServiceImpl instance = null;
        List<Double> expResult = null;
        List<Double> result = instance.getRevenue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
