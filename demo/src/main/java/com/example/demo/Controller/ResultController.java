// package com.example.demo.Controller;

// import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.servlet.ModelAndView;

// @Controller
// public class ResultController {

//     @Autowired
//     private UserService userService;
    
//     @PostMapping("/submit-answers")
//     public ModelAndView submitAnswers(@RequestParam Map<String, String> answers) {
//         // 正誤判定と正解数カウントの処理
//         int score; // 正解数をカウント

//         User currentUser; // 現在のユーザーを取得
//         userService.saveScore(currentUser, score);

//         ModelAndView modelAndView = new ModelAndView("result");
//         modelAndView.addObject("score", score);
//         modelAndView.addObject("ranking", userService.getRanking());
//         return modelAndView;
//     }
// }

