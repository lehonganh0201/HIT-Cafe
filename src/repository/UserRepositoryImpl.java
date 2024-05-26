/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import FileConnector.FileEngine;
import java.io.File;
import java.util.List;
import java.util.Map;
import model.User;
import repository.IRepository.IUserRepository;

/**
 *
 * @author PC
 */
public class UserRepositoryImpl implements IUserRepository{

    private final File file = new File("./Users.dat");
    private final FileEngine engine = new FileEngine();
    private Map<Integer, User> map;

    public UserRepositoryImpl() {
        map = (Map<Integer, User>) engine.readFile(file);
    }

    @Override
    public User save(User user) {
        user.setId(map.size() + 1);
        map.put(user.getId(), user);
        reloadFile();
        return map.get(user.getId());
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return map.values().stream()
                .filter(us -> us.getEmail().equalsIgnoreCase(email) && us.getPassword().equalsIgnoreCase(password))
                .findFirst().orElse(null);
    }

    @Override
    public User findByEmail(String email) {
        return map.values().stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User update(User user) {
        map.replace(user.getId(), user);
        reloadFile();
        return map.get(user.getId());
    }

    private void reloadFile() {
        engine.writeToFile(map, file);
        map.clear();
        map = (Map<Integer, User>) engine.readFile(file);
    }

    @Override
    public List<User> findAll() {
        return map.values().stream().toList();
    }
}
