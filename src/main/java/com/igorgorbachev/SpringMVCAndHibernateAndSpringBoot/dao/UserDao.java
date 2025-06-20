package com.igorgorbachev.SpringMVCAndHibernateAndSpringBoot.dao;



import com.igorgorbachev.SpringMVCAndHibernateAndSpringBoot.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void changeUser(User user);
    void deleteUser(User user);
    List<User> getAllUsers();
}
