/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package service;

import java.util.List;
import model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import request.LoginRequest;
import request.UserRequest;
import response.UserResponse;

/**
 *
 * @author PC
 */
public class UserServiceImplTest {
    
    public UserServiceImplTest() {
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
     * Test of save method, of class UserServiceImpl.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        UserRequest request = null;
        UserServiceImpl instance = null;
        UserResponse expResult = null;
        UserResponse result = instance.save(request);
        assertEquals(expResult, result);
    }

    /**
     * Test of login method, of class UserServiceImpl.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        LoginRequest request = null;
        UserServiceImpl instance = null;
        UserResponse expResult = null;
        UserResponse result = instance.login(request);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSecurityQuestion method, of class UserServiceImpl.
     */
    @Test
    public void testGetSecurityQuestion() {
        System.out.println("getSecurityQuestion");
        String email = "";
        UserServiceImpl instance = null;
        String expResult = "";
        String result = instance.getSecurityQuestion(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class UserServiceImpl.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        String email = "";
        String newPassword = "";
        UserServiceImpl instance = null;
        User expResult = null;
        User result = instance.update(email, newPassword);
        assertEquals(expResult, result);
    }

    /**
     * Test of changeStatus method, of class UserServiceImpl.
     */
    @Test
    public void testChangeStatus() {
        System.out.println("changeStatus");
        String email = "";
        String status = "";
        UserServiceImpl instance = null;
        User expResult = null;
        User result = instance.changeStatus(email, status);
        assertEquals(expResult, result);
    }

    /**
     * Test of changePassword method, of class UserServiceImpl.
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        String email = "";
        String oldPassword = "";
        String newPassword = "";
        UserServiceImpl instance = null;
        User expResult = null;
        User result = instance.changePassword(email, oldPassword, newPassword);
        assertEquals(expResult, result);
    }

    /**
     * Test of changeSecurityQuestion method, of class UserServiceImpl.
     */
    @Test
    public void testChangeSecurityQuestion() {
        System.out.println("changeSecurityQuestion");
        String email = "";
        String password = "";
        String securityQuestion = "";
        String answer = "";
        UserServiceImpl instance = null;
        User expResult = null;
        User result = instance.changeSecurityQuestion(email, password, securityQuestion, answer);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUserByEmail method, of class UserServiceImpl.
     */
    @Test
    public void testGetUserByEmail() {
        System.out.println("getUserByEmail");
        String email = "";
        UserServiceImpl instance = null;
        User expResult = null;
        User result = instance.getUserByEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllUsers method, of class UserServiceImpl.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        UserServiceImpl instance = null;
        List<UserResponse> expResult = null;
        List<UserResponse> result = instance.getAllUsers();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllUsersExceptAdmin method, of class UserServiceImpl.
     */
    @Test
    public void testGetAllUsersExceptAdmin() {
        System.out.println("getAllUsersExceptAdmin");
        UserServiceImpl instance = null;
        List<UserResponse> expResult = null;
        List<UserResponse> result = instance.getAllUsersExceptAdmin();
        assertEquals(expResult, result);
    }
}
