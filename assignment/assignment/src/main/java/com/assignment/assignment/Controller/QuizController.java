package com.assignment.assignment.Controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.assignment.Entity.Quiz;
import com.assignment.assignment.Service.quizService;

@RestController
@RequestMapping("/quizzes")
public class QuizController {
    @Autowired
    private quizService quizService;
    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz UserQuiz) {
        Quiz quiz = quizService.crateQuiz(UserQuiz);
        return new ResponseEntity<>(quiz, HttpStatus.CREATED);
    }
    @GetMapping("/active")
    public ResponseEntity<Quiz> getActiveQuiz() {
        Quiz activeQuiz = (Quiz) quizService.FindActiveQuiz();
        if(activeQuiz==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(activeQuiz, HttpStatus.OK);
        }
      
    }
    @GetMapping("/{id}/result")
    public ResponseEntity<String> getQuizResult(@PathVariable("id") int id) {
        try{
            String quizResult = quizService.getQuizResult(id);
            return new ResponseEntity<>(quizResult, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e+" ", HttpStatus.NOT_FOUND);
           
        }
        
       
    }
    @GetMapping("/all")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizes();
        if(quizzes.size()==0){
            return  new ResponseEntity<>(quizzes, HttpStatus.NOT_FOUND); 
        }else{
            return new ResponseEntity<>(quizzes, HttpStatus.OK);
        }
        
    }
}
