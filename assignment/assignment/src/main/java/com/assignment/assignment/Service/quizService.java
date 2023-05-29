package com.assignment.assignment.Service;


import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.assignment.assignment.Dao.quizzDao;
import com.assignment.assignment.Entity.Quiz;
import com.assignment.assignment.enums.QuizStatus;


@Service
public class quizService {
    @Autowired 
    private quizzDao dao;

    public Quiz crateQuiz(Quiz quiz){
  
        return dao.save(quiz);
    }
  
    public Quiz FindActiveQuiz(){
        
        return dao.findByStatus(QuizStatus.ACTIVE);
    }

    public String getQuizResult(int id){
       Quiz quizzes=dao.findById(id);
       
       if(quizzes==null){
        new IllegalArgumentException("Quiz not found with ID: " + id);
       }
       LocalDateTime currentDateTime = LocalDateTime.now();
       LocalDateTime quizEndDateTime =  ((Quiz) quizzes).getEndDate().plusMinutes(5);

       if (currentDateTime.isBefore(quizEndDateTime)) {
           throw new IllegalArgumentException("Quiz result not available yet for ID: " + id);
       }

       return String.valueOf(((Quiz) quizzes).getIndexofCorrectAnswer());
    }
     public Quiz findstatus(QuizStatus status){
return dao.findByStatus(status);
     }
    public List<Quiz> getAllQuizes(){
        return dao.findAll();
    }
}
