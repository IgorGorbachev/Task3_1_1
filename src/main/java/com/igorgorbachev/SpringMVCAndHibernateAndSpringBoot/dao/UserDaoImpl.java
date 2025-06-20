package com.igorgorbachev.SpringMVCAndHibernateAndSpringBoot.dao;


import com.igorgorbachev.SpringMVCAndHibernateAndSpringBoot.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void changeUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
}
