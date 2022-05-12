package com.its.projectjava.service;

import com.its.projectjava.dao.UserDao;
import com.its.projectjava.domain.User;
import com.its.projectjava.exception.InvalidLoginException;
import com.its.projectjava.exception.InvalidPasswordException;
import com.its.projectjava.exception.LoginAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Transactional
    public User addUser (User user) throws InvalidPasswordException, InvalidLoginException, LoginAlreadyExistsException {
        if(user.getPassword().length()<3)
            throw new InvalidPasswordException();
        if(user.getLogin().length()<3)
            throw new InvalidLoginException();
        if(userDao.doesUserExists(user.getLogin()))
            throw new LoginAlreadyExistsException();
        userDao.addUser(user);
        return user;
    }

    @Transactional
    public void login(String login, String password, HttpServletRequest request){
        Map errors = new HashMap<String, String>();
        try{
            User user = userDao.getUserByLogin(login);
            if(user.getPassword().equals(password) & user.getLogin().equals(login)){
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
            }
            else{
                errors.put("login","Login or password incorrect");
            }

        }
        catch(NoResultException e){
            errors.put("login","Login or password incorrect");
        }
        finally {
            request.setAttribute("errors",errors);
        }
    }
    @Transactional
    public void changePassword(String oldPassword, String newPassword, HttpServletRequest request){
        Map changePassword = new HashMap<String, String>();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(newPassword.length()<3)
            changePassword.put("error","The new password must have at least 3 characters");
        else if(user.getPassword().equals(oldPassword)) {
            userDao.changePassword(user.getId(), newPassword);
            changePassword.put("success","Your password have been changed");
        }
        else changePassword.put("error","The old password is incorrect");
        request.setAttribute("changePassword",changePassword);
    }

    public void logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
    }

    @Transactional
    public void delete(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        userDao.deleteUser(user.getId());
    }
    public boolean isUserConnected(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user==null)
            return false;
        return true;
    }
}
