package com.sprint.mission.discodeit.service.file;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.UserService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FileUserService implements UserService {
    public static void saveUsers(List<User> users) {
        try (FileOutputStream fos = new FileOutputStream("user.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<User> loadUsers() {
        File file = new File("user.ser");

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (FileInputStream fis = new FileInputStream("user.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public User create(String name) {
        List<User> users = loadUsers();
        User user = new User(name);
        users.add(user);
        saveUsers(users);
        return user;
    }

    @Override
    public User findById(UUID id) {
        return loadUsers().stream()
                .filter(user -> user.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<User> findAll() {
        return loadUsers();
    }

    @Override
    public void update(UUID id, String name) {
        List<User> users = loadUsers();
        for (User user : users) {
            if(user.getId().equals(id)) {
                user.updata(name);
                break;
            }
        }
        saveUsers(users);
    }

    @Override
    public void delete(UUID id) {
        List<User> users = loadUsers();
        users.removeIf(user -> user.getId().equals(id));
        saveUsers(users);
    }
}
