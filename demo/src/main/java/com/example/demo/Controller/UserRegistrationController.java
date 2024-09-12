// package com.example.demo.Controller;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.servlet.ModelAndView;

// @Controller
// public class UserRegistrationController {

//     @Autowired
//     private UserService userService;

//     @GetMapping("/register")
//     public String showRegistrationForm() {
//         return "register"; // register.html（Thymeleafテンプレートファイル）を表示
//     }

//     @PostMapping("/register")
//     public ModelAndView registerUser(@RequestParam("username") String username,
//                                      @RequestParam("password") String password) {
//         userService.registerUser(username, password);
//         return new ModelAndView("redirect:/login");
//     }
// }
