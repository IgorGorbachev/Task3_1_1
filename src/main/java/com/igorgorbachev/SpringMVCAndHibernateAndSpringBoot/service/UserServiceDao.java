package com.igorgorbachev.SpringMVCAndHibernateAndSpringBoot.service;



import com.igorgorbachev.SpringMVCAndHibernateAndSpringBoot.model.User;

import java.util.List;

public interface UserServiceDao {
    void addUser(User user);
    void changeUser(User user);
    void deleteUser(User user);
    List<User> getAllUsers();
}
