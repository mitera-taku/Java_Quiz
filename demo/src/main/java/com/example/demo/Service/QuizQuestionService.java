package com.example.demo.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Domain.quiz_questions;
import com.example.demo.Repository.quizRepository;
import java.util.List;

@Service
public class QuizQuestionService {

       @Autowired
    private quizRepository quizRepository;

    public quiz_questions findQuestions(int id) {
        return quizRepository.findQuestions(id);
        
    }

    public List<quiz_questions> findAllQuestions() {
        return quizRepository.findAll();
    }
    
}
