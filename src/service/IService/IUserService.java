/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.IService;

import java.util.List;
import model.User;
import request.LoginRequest;
import request.UserRequest;
import response.UserResponse;

/**
 *
 * @author PC
 */
public interface IUserService {
    public UserResponse save(UserRequest user);
    public UserResponse login(LoginRequest request);
    public String getSecurityQuestion(String email);
    public User update(String email, String newPassword);
    public User changeStatus(String email, String status);
    public User changePassword(String email, String oldPassword, String newPassword);
    public User changeSecurityQuestion(String email, String password, String securityQuestion, String answer);
    public User getUserByEmail(String email);
    public List<UserResponse> getAllUsers();
    public List<UserResponse> getAllUsersExceptAdmin();
}
