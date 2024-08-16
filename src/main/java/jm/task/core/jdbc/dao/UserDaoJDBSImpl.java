package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBSImpl implements UserDao {
    private static final String CREATE_TABLE_USERS_SQL = "CREATE TABLE IF NOT EXISTS users (" +
            "id SERIAL PRIMARY KEY, " +
            "username VARCHAR(50) NOT NULL, " +
            "password VARCHAR(50) NOT NULL, " +
            "age SMALLINT" +
            ")";
    private static final String DROP_TABLE_USERS_SQL = "DROP TABLE IF EXISTS users";

    private static final String INSERT_USER_SQL = "INSERT INTO users (username, password, age) VALUES (?, ?, ?)";

    private static final String SELECT_ALL_USERS_SQL = "SELECT username, password, age FROM users";

    private static final String REMOVE_USER_BY_ID_SQL = "DELETE FROM users WHERE id = ?";

    private static final String DROP_ALL_USERS_SQL = "DELETE FROM users";


    public void createUsersTable(){
        try(Connection connection = Util.createConnection();
            Statement statement = connection.createStatement()) {

            statement.execute(CREATE_TABLE_USERS_SQL);
            System.out.println("Table users created");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable(){
        try (Connection connection = Util.createConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(DROP_TABLE_USERS_SQL);
            System.out.println("Table users deleted.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void saveUser(String name, String lastName, byte age) {
        try(Connection connection = Util.createConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_USER_SQL)) {

            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            //Сохранить юзера
            statement.executeUpdate();
            System.out.println("User with name " + name + " inserted successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void removeUserById(long id) {
        try(Connection connection = Util.createConnection();
            PreparedStatement statement = connection.prepareStatement(REMOVE_USER_BY_ID_SQL)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<User> getAllUsers() {
        try(Connection connection = Util.createConnection();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS_SQL);
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("username"));
                user.setLastName(resultSet.getString("password"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
                System.out.println(user);
            }
            return users;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void cleanUsersTable() {
        try(Connection connection = Util.createConnection();
            Statement statement = connection.createStatement()) {
            statement.execute(DROP_ALL_USERS_SQL);
            System.out.println("Users deleted from table users.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
