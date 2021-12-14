package com.example.test.controller;

import com.example.test.bean.UserBean;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/tomain")
    public String tomain() {
        return "login";
    }

    @RequestMapping("/tologin")
    public String tologin() {
        return "index";
    }

    @RequestMapping("/toregister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String login(String name, String password, Model model) {
        UserBean userBean = userService.loginIn(name, password);
        if (userBean != null) {
            return "login";
        } else {
            model.addAttribute("msg", "error");
            return "index";
        }
    }

    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public String register(int id, String name, String password, Model model) {
        if (userService.findid(id) == null && userService.findname(name) == null) {
            userService.register(id, name, password);
            return "index";
        } else {
            model.addAttribute("msg", "错误");
            return "register";
        }


    }
}
