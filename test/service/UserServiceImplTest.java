package service;

import FileConnector.ReloadData;
import exception.ExistUserException;
import exception.NotFoundUserException;
import java.util.List;
import model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mindrot.jbcrypt.BCrypt;
import repository.IRepository.IUserRepository;
import repository.UserRepositoryImpl;
import request.LoginRequest;
import request.UserRequest;
import response.UserResponse;
import service.IService.IUserService;

public class UserServiceImplTest {

    private final IUserRepository userRepository = new UserRepositoryImpl();
    private final IUserService instance = new UserServiceImpl(userRepository);

    public UserServiceImplTest() {
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
        userRepository.clear();

        instance.save(new UserRequest("Le Hong Anh", "hle646698@gmail.com", "0909123456", "123 Đường ABC", "lehonganh", "Tên thú cưng của bạn?", "Miu"));
        instance.save(new UserRequest("Vu Thi Hong Nhung", "vthn303@gmail.com", "0909876543", "456 Đường DEF", "vuthihongnhung", "Tên trường tiểu học của bạn?", "Trường XYZ"));
        instance.save(new UserRequest("Nguyen Huy Hoang", "hoangnh4204gmail.com", "0909876543", "456 Đường DEF", "nguyenhuyhoang", "Tên trường tiểu học của bạn?", "Hehehe"));
        instance.save(new UserRequest("Khong xac dinh", "test@gmail.com", "0909876543", "456 Đường DEF", "test", "Tên trường tiểu học của bạn?", "Hehehe"));
        instance.save(new UserRequest("Admin", "admin@gmail.com", "0123456789", "Ha Noi", "$2a$12$xmbnSr6Di5FN3zrFqfNz3uw/.6lMhmJ77IKoLOkUdYOSEXT9jZrFa", "Tên bạn là gì?", "admin"));
    }

    @After
    public void tearDown() {
        System.out.println("After - Cleanup after each test");
        userRepository.clear();
    }

    @Test
    public void testSave() {
        System.out.println("save");
        UserRequest request = new UserRequest("test", "abc@gmail.com", "0123456789", "ABC", "test", "test", "test");
        UserResponse expResult = new UserResponse(0, "test", "abc@gmail.com", "0123456789", "ABC", "test", "false");
        try {
            UserResponse result = instance.save(request);
            assertEquals(expResult.getName(), result.getName());
            assertEquals(expResult.getEmail(), result.getEmail());
            assertEquals(expResult.getPhoneNumber(), result.getPhoneNumber());
            assertEquals(expResult.getAddress(), result.getAddress());
            assertEquals(expResult.getSecurityQuestion(), result.getSecurityQuestion());
            assertEquals(expResult.getStatus(), result.getStatus());
        } catch (ExistUserException ex) {
            assertEquals("Your email is already existing", ex.getMessage());
        }

    }

    @Test
    public void testLogin() {
        System.out.println("login");
        LoginRequest request = new LoginRequest("test@gmail.com", "test");
        UserResponse expResult = new UserResponse(0, "Khong xac dinh", "test@gmail.com", "0909876543", "456 Đường DEF", "Tên trường tiểu học của bạn?", "false");
        try {
            UserResponse result = instance.login(request);
            assertEquals(expResult.getName(), result.getName());
            assertEquals(expResult.getName(), result.getName());
            assertEquals(expResult.getEmail(), result.getEmail());
            assertEquals(expResult.getPhoneNumber(), result.getPhoneNumber());
            assertEquals(expResult.getAddress(), result.getAddress());
            assertEquals(expResult.getSecurityQuestion(), result.getSecurityQuestion());
            assertEquals(expResult.getStatus(), result.getStatus());
        } catch (NotFoundUserException e) {
            assertEquals("Incorrect username or password", e.getMessage());
        }
    }

    @Test
    public void testGetSecurityQuestion() {
        System.out.println("getSecurityQuestion");
        String email = "test@gmail.com";
        String expResult = "Tên trường tiểu học của bạn?";
        try {
            String result = instance.getSecurityQuestion(email);
            assertEquals(expResult, result);
        } catch (NotFoundUserException e) {
            assertEquals("Cannot found any user with : " + email, e.getMessage());
        }
    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        String email = "test@gmail.com";
        String newPassword = "newPassword";
        User expResult = new User("test@gmail.com", newPassword);
        try {
            User result = instance.update(email, newPassword);
            assertEquals(expResult.getEmail(), result.getEmail());
        } catch (NotFoundUserException ex) {
            assertEquals("Cannot found any user with : " + email, ex.getMessage());
        }
    }

    @Test
    public void testChangeStatus() {
        System.out.println("changeStatus");
        String email = "test@gmail.com";
        String status = "true";
        User expResult = new User(0, "Khong xac dinh", "test@gmail.com", "0909876543", "456 Đường DEF", "test", "Tên trường tiểu học của bạn?", "Hehehe", "true");
        try{
            User result = instance.changeStatus(email, status);
            assertEquals(expResult.getEmail(), result.getEmail());
            assertEquals(expResult.getStatus(), result.getStatus());
        } catch (NotFoundUserException ex) {
            assertEquals("Cannot found any user with : " + email, ex.getMessage());
        }
    }

    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        String email = "test@gmail.com";
        String oldPassword = "test";
        String newPassword = "newPassword";
        User expResult = new User(email, newPassword);
        try{
            User result = instance.changePassword(email, oldPassword, newPassword);
            assertEquals(expResult.getEmail(), result.getEmail());
            assertTrue(BCrypt.checkpw(newPassword, result.getPassword()));
        } catch (NotFoundUserException ex) {
            assertEquals("Cannot found any user with : " + email, ex.getMessage());
        }
    }

    @Test
    public void testChangeSecurityQuestion() {
        System.out.println("changeSecurityQuestion");
        String email = "test@gmail.com";
        String password = "test";
        String securityQuestion = "Chua biet";
        String answer = "test";
        User expResult = new User("Khong xac dinh", email, "0909876543", "ABC", password, securityQuestion, answer);
        try {
            User result = instance.changeSecurityQuestion(email, password, securityQuestion, answer);
            assertEquals(expResult.getEmail(), result.getEmail());
            assertEquals(expResult.getSecurityQuestion(), result.getSecurityQuestion());
            assertEquals(expResult.getAnswer(), result.getAnswer());
        } catch (NotFoundUserException ex) {
            assertEquals("Cannot found any user with : " + email, ex.getMessage());
        }
    }

    @Test
    public void testGetUserByEmail() {
        System.out.println("getUserByEmail");
        String email = "test@gmail.com";
        User expResult = new User(0, "Khong xac dinh", "test@gmail.com", "0909876543", "456 Đường DEF", "test", "Tên trường tiểu học của bạn?", "Hehehe", "true");
        User result = instance.getUserByEmail(email);
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getEmail(), result.getEmail());
    }

    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        int size = 5;
        List<UserResponse> result = instance.getAllUsers();
        assertEquals(size, result.size());
    }

    @Test
    public void testGetAllUsersExceptAdmin() {
        System.out.println("getAllUsersExceptAdmin");
        int size = 4;
        List<UserResponse> result = instance.getAllUsersExceptAdmin();
        assertEquals(size, result.size());
    }
}
