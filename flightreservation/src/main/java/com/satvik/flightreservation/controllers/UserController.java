package com.satvik.flightreservation.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.satvik.flightreservation.entities.User;
import com.satvik.flightreservation.repos.UserRepository;
import com.satvik.flightreservation.services.SecurityService;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityService securityService;



    @Autowired
    private BCryptPasswordEncoder encoder;

    @RequestMapping("/showReg")
    public String showRegistrationPage() {

        return "login/registerUser";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user) {

        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "login/login";

    }

    @RequestMapping("/showLogin")
    public String showLoginPage() {

        return "login/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password,
                        ModelMap modelMap) {
        boolean loginResponse = securityService.login(email, password);

        if (loginResponse) {
            return "findFlights";
        } else {
            modelMap.addAttribute("msg", "Invalid user name or password .Please try again.");
        }

        return "login/login";

    }
}
