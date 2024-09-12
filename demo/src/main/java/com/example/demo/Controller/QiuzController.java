package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

import com.example.demo.Domain.quiz_questions;
import com.example.demo.Service.QuizQuestionService;

@Controller
public class QiuzController {

    @Autowired
    private QuizQuestionService quizQuestionService;

    @RequestMapping("/main")
    public String showMainPage() {
        return "HTML/main";
    }

    @GetMapping("/start-quiz")
    public String startQuiz(Model model) {
        List<quiz_questions> quizList = quizQuestionService.findAllQuestions();
    // モデルに追加
    model.addAttribute("questions", quizList);
    // クイズのHTMLページに遷移
        return "HTML/quiz";
    }

    @PostMapping("/submit-answers")
    public String submitQuizAnswers(@RequestParam Map<String, String> answers, Model model) {
    // 全てのクイズを取得
        List<quiz_questions> quizList = quizQuestionService.findAllQuestions();

        int correctCount = 0;  // 正解数カウント

    // 回答をループで処理
        for (int i = 0; i < quizList.size(); i++) {
            quiz_questions question = quizList.get(i);
            String userAnswer = answers.get("q" + i);  // q0, q1, q2...の形式でリクエストパラメータを取得

        // ユーザーの回答と正解を比較
            if (userAnswer != null && userAnswer.equals(getCorrectOptionNumber(question))) {
                correctCount++;  // 正解の場合カウントアップ
        }
    }

    // 結果をモデルに追加
            model.addAttribute("correctCount", correctCount);
            model.addAttribute("totalQuestions", quizList.size());

    // 結果ページへ
            return "HTML/result";
}

    private String getCorrectOptionNumber(quiz_questions question) {
        if (question.getCorrectAnswer().equals(question.getOption1())) {
            return "1";
        } else if (question.getCorrectAnswer().equals(question.getOption2())) {
            return "2";
        } else if (question.getCorrectAnswer().equals(question.getOption3())) {
            return "3";
        } else if (question.getCorrectAnswer().equals(question.getOption4())) {
            return "4";
        }
            return null;  // 万が一正解が見つからない場合はnullを返す
}



}
