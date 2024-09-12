package com.example.demo.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.Domain.quiz_questions;

@Repository
public class quizRepository {
    
    @Autowired
    private NamedParameterJdbcTemplate NamedParameterJdbcTemplate;

    private JdbcTemplate jdbcTemplate;


    private static final RowMapper<quiz_questions> quizRowMapper = (rs, i) ->{
        quiz_questions quiz = new quiz_questions();
        quiz.setId(rs.getInt("id")); 
        quiz.setQuestion(rs.getString("question"));
        quiz.setCorrectAnswer(rs.getString("correct_answer"));
        quiz.setOption1(rs.getString("option1"));
        quiz.setOption2(rs.getString("option2"));
        quiz.setOption3(rs.getString("option3"));
        quiz.setOption4(rs.getString("option4"));
        return quiz;
    };

    public quiz_questions findQuestions(int id){
        String sql = "SELECT * FROM quiz_questions WHERE id = :id";
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        quiz_questions quiz_questions = NamedParameterJdbcTemplate.queryForObject(sql, param, quizRowMapper);
        return quiz_questions;
    }

    public List<quiz_questions> findAll() {
        String sql = "SELECT * FROM quiz_questions";
        List<quiz_questions> quiz_questions = NamedParameterJdbcTemplate.query(sql, quizRowMapper);
        return quiz_questions;
    }
    

}
