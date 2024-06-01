/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import common.PasswordEncryptor;
import exception.ExistUserException;
import exception.NotFoundUserException;
import java.util.List;
import model.User;
import org.mindrot.jbcrypt.BCrypt;
import repository.IRepository.IUserRepository;
import request.LoginRequest;
import request.UserRequest;
import response.UserResponse;
import service.IService.IUserService;

/**
 *
 * @author PC
 */
public class UserServiceImpl implements IUserService{
    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    } 

    @Override
    public UserResponse save(UserRequest request) {
        User saveUser = convertToUser(request);
        User checkUser = getUserByEmail(saveUser.getEmail());
        if(checkUser == null){
            saveUser.setStatus("false");
            saveUser = userRepository.save(saveUser);
            return convertToResponse(saveUser);
        }
        throw new ExistUserException("Your email is already existing");
    }

    @Override
    public UserResponse login(LoginRequest request) {
       User user = userRepository.findByEmail(request.getEmail());
       if(user!=null && BCrypt.checkpw(request.getPassword(), user.getPassword())){
           return convertToResponse(user);
       }
       throw new NotFoundUserException("Incorrect username or password");
    }

    @Override
    public String getSecurityQuestion(String email) {
        User user = userRepository.findByEmail(email);
        if(user!=null){
            return user.getSecurityQuestion();
        }
        throw new NotFoundUserException("Cannot found any user with : " + email);
    }

    @Override
    public User update(String email, String newPassword) {
       User user = userRepository.findByEmail(email);
       if(user != null){
           user.setPassword(PasswordEncryptor.hashPassword(newPassword));
           userRepository.update(user);
           return user;
       }
       throw new NotFoundUserException("Cannot found any user with : " +email);
    }

    @Override
    public User changeStatus(String email, String status) {
        User user = userRepository.findByEmail(email);
       if(user != null){
           user.setStatus(status);
           userRepository.update(user);
           return user;
       }
       throw new NotFoundUserException("Cannot found any user with : " +email);
    }

    @Override
    public User changePassword(String email, String oldPassword, String newPassword) {
        User user = userRepository.findByEmail(email);
       if(user != null && BCrypt.checkpw(oldPassword, user.getPassword())){
           user.setPassword(PasswordEncryptor.hashPassword(newPassword));
           userRepository.update(user);
           return user;
       }
       throw new NotFoundUserException("Cannot found any user with : " +email);
    }

    @Override
    public User changeSecurityQuestion(String email, String password, String securityQuestion, String answer) {
        User user = userRepository.findByEmail(email);
       if(user != null && BCrypt.checkpw(password, user.getPassword())){
           user.setSecurityQuestion(securityQuestion);
           user.setAnswer(answer);
           userRepository.update(user);
           return user;
       }
       throw new NotFoundUserException("Cannot found any user with : " +email);
    }

    private User convertToUser(UserRequest request) {
       return new User(
               request.getName(),
               request.getEmail(),
               request.getPhoneNumber(),
               request.getAddress(),
               PasswordEncryptor.hashPassword(request.getPassword()),
               request.getSecurityQuestion(),
               request.getAnswer()
       );
    }

    private UserResponse convertToResponse(User saveUser) {
       return new UserResponse(
               saveUser.getId(),
               saveUser.getName(),
               saveUser.getEmail(),
               saveUser.getPhoneNumber(),
               saveUser.getAddress(),
               saveUser.getSecurityQuestion(),
               saveUser.getStatus());
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserResponse> getAllUsers() {
       List<User> users = userRepository.findAll();
       return users.stream().map(user -> convertToResponse(user)).toList();
    }

    @Override
    public List<UserResponse> getAllUsersExceptAdmin() {
        return userRepository.findAll().stream()
                .filter(user -> !user.getEmail().equalsIgnoreCase("admin@gmail.com"))
                .map(user -> convertToResponse(user))
                .toList();
    }
}