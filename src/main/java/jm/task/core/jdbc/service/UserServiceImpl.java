package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBSImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static final UserDao userDaoJDBS = new UserDaoJDBSImpl();

    // private static final UserDao userDaoHibernate = new UserDaoHibernateImpl();



    public void createUsersTable() {
        userDaoJDBS.createUsersTable();
      //  userDaoHibernate.createUsersTable();
        
    }

    public void dropUsersTable() {
        userDaoJDBS.dropUsersTable();
     //   userDaoHibernate.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoJDBS.saveUser(name, lastName, age);
       // userDaoHibernate.saveUser(name, lastName, age);

    }

    public void removeUserById(long id) {
        userDaoJDBS.removeUserById(id);
       // userDaoHibernate.removeUserById(id);

    }

    public List<User> getAllUsers() {

       // return userDaoHibernate.getAllUsers();
        return userDaoJDBS.getAllUsers();
    }

    public void cleanUsersTable() {
      //  userDaoHibernate.cleanUsersTable();
        userDaoJDBS.cleanUsersTable();
    }

}
