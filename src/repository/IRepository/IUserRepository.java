/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.IRepository;

import java.util.List;
import model.User;

/**
 *
 * @author PC
 */
public interface IUserRepository {
    public User save(User user);
    public User findByEmailAndPassword(String email,String password);
    public User findByEmail(String email);
    public User update(User user);
    public List<User> findAll();
    public void clear();
}
