package com.res.controller;

import com.res.config.WebSecurityConfig;
import com.res.form.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String loginVerify(@Valid UserForm user, BindingResult bindingResult, HttpSession session){
        if(bindingResult.hasErrors()){
            return "redirect:/login";
        }
        boolean verify = user.getUsername().equals("admin") && user.getPassword().equals("123456");
        if (verify) {
            session.setAttribute(WebSecurityConfig.SESSION_KEY, user.getUsername());
            return "redirect:/home";
        }
        return "redirect:/login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }
}