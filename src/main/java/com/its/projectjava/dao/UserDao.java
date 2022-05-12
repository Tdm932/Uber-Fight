package com.its.projectjava.dao;

import com.its.projectjava.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class UserDao {

    @PersistenceContext
    EntityManager em;

    public User addUser(User user){
        em.persist(user);
        return user;
    }
    public User getUserByLogin(String login) throws NoResultException {
       return em.createQuery("SELECT u FROM User u WHERE u.login=:login",User.class)
                .setParameter("login",login)
                .getSingleResult();
    }

    public boolean doesUserExists(String login){
        try{
         User user = em.createQuery("SELECT u FROM User u WHERE u.login=:login",User.class)
                .setParameter("login",login)
                .getSingleResult();
        return true;
        }
        catch(NoResultException e)
        {
            return false;
        }
    }
    public void changePassword(long id, String password){
        User user = em.find(User.class,id);
        user.setPassword(password);
        em.merge(user);
    }
    public void deleteUser(long id){
        User user = em.find(User.class,id);
         em.remove(user);
    }
}
