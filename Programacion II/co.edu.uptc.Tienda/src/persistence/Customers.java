package persistence;

import model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Customers {

    private final List<User> users;

    public Customers() throws IOException {
        this.users = new ArrayList<>();
        obtainUsersFromTxt();
    }

    public void obtainUsersFromTxt() throws IOException {
        FileReader reader = new FileReader("Resourses\\UsersFerreteriaIdeal.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] parts = line.split(",");
            String nameUser = parts[0];
            String emailUser = parts[1];
            String passwordUser = parts[2];
            String adressUser = parts[3];
            User user = new User(nameUser, emailUser, passwordUser,adressUser);
            users.add(user);
        }
        bufferedReader.close();
    }

    public void addUsersToTxt() throws IOException {
        FileWriter writer = new FileWriter("Resourses\\UsersFerreteriaIdeal.txt", false);
        for (User user : users) {
            writer.write(user.toString() + "\n");
        }
        writer.close();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void eraseUser(User user) {
        this.users.remove(user);
    }

    public List<User> getUsers() {
        return users;
    }
}