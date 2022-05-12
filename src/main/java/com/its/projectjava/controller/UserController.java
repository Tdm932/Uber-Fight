package com.its.projectjava.controller;

import com.its.projectjava.domain.User;
import com.its.projectjava.exception.InvalidLoginException;
import com.its.projectjava.exception.InvalidPasswordException;
import com.its.projectjava.exception.LoginAlreadyExistsException;
import com.its.projectjava.service.UserService;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value="/signup")
    public String signup(@RequestParam(name = "login") String login, @RequestParam(name="password") String password, HttpServletRequest request ) {
        User user = new User(login, password);
        Map errors = new HashMap<String, String>();
        try {
            userService.addUser(user);
        } catch (LoginAlreadyExistsException e) {
            errors.put("login", e.getMessage());
        }
        catch (InvalidPasswordException e) {
            errors.put("password",e.getMessage());
        }
        catch(InvalidLoginException e){
            errors.put("login", e.getMessage());
        }
        finally {
            request.setAttribute("error", errors);
            String result = errors.isEmpty()?"You account have been created":"Error during the registration";
            request.setAttribute("result",result);
            return "signup";
        }
    }
    @GetMapping("/signup")
    public String getRegister(HttpServletRequest request) {
        request.setAttribute("result",null);
        request.setAttribute("error",null);
        return "signup";

    }
    @GetMapping("/signin")
    public String getLogin(HttpServletRequest request) {
        request.setAttribute("error",null);
        return "signin";
    }

    @PostMapping(value="/signin")
    public String login(@RequestParam(name = "login") String login, @RequestParam(name="password") String password, HttpServletRequest request ) {
        userService.login(login,password,request);
        Map errors = (Map)request.getAttribute("errors");
        if(errors.isEmpty())
            return "subscriber_area";
        return "signin";
    }

    @PostMapping("/changepassword")
    public String changePassword(@RequestParam(name = "oldPassword") String oldPassword, @RequestParam(name="newPassword") String newPassword, HttpServletRequest request ) {
        userService.changePassword(oldPassword,newPassword,request);
        return "subscriber_area";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        userService.logout(request);
        return "signin";
    }
    @GetMapping("/delete")
    public String delete(HttpServletRequest request){
        userService.delete(request);
        return "signin";
    }
    @GetMapping("/subscriber_area")
    public String subscriberArea(HttpServletRequest request){
        return userService.isUserConnected(request)? "subscriber_area":"signin";
    }
}
