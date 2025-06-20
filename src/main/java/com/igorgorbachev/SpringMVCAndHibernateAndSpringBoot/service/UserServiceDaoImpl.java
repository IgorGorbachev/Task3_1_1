package com.igorgorbachev.SpringMVCAndHibernateAndSpringBoot.service;


import com.igorgorbachev.SpringMVCAndHibernateAndSpringBoot.dao.UserDao;
import com.igorgorbachev.SpringMVCAndHibernateAndSpringBoot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

@Component
public class UserServiceDaoImpl implements UserServiceDao {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void addUser(User user) {
        if (user.getName() != null && !user.getName().isEmpty() && user.getName().matches("[a-zA-Zа-яА-ЯёЁ ]+") && user.getAge() != null && user.getAge() > 0 && user.getAge() < 150) {
            userDao.addUser(user);
        } else {
            throw new IllegalArgumentException("Имя пользователя обязательно (только буквы)" + "\n" +
                                               "Возраст от 0 до 150");
        }
    }

    @Transactional
    @Override
    public void changeUser(User user) {
        if (user.getAge() > 0 && user.getAge() < 150) {
            userDao.changeUser(user);
        }
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        List<User> users = userDao.getAllUsers();
        users.sort(Comparator.comparing(User::getAge).reversed());
        return users;
    }
}
