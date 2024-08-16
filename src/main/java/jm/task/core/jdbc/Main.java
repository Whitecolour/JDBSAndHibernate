package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        String name = "John";
        String lastName = "Coffee";
        byte age = 43;
        int id = 1;
        UserService userService = new UserServiceImpl();
       // userService.saveUser(name, lastName, age);
       // userService.dropUsersTable();
        userService.createUsersTable();

    }
}
