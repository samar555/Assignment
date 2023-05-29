package com.assignment.assignment.Entity;

import java.time.LocalDateTime;
import java.util.List;

import com.assignment.assignment.enums.QuizStatus;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String question;
    @Column
    @ElementCollection
    private List<String> optionsOfAnswer;
    @Column
    private int indexofCorrectAnswer;
    @Column
    private LocalDateTime  startDate;
    @Column
    private LocalDateTime endDate;
    
    private QuizStatus status;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public List<String> getOptionsOfAnswer() {
        return optionsOfAnswer;
    }
    public void setOptionsOfAnswer(List<String> optionsOfAnswer) {
        this.optionsOfAnswer = optionsOfAnswer;
    }
    public int getIndexofCorrectAnswer() {
        return indexofCorrectAnswer;
    }
    public void setIndexofCorrectAnswer(int indexofCorrectAnswer) {
        this.indexofCorrectAnswer = indexofCorrectAnswer;
    }
   
    public LocalDateTime getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    
    public Quiz() {
    }
    
    public QuizStatus getStatus() {
        return status;
    }
    public void setStatus(QuizStatus status) {
        this.status = status;
    }
    public Quiz(int id, String question, List<String> optionsOfAnswer, int indexofCorrectAnswer,
            LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.question = question;
        this.optionsOfAnswer = optionsOfAnswer;
        this.indexofCorrectAnswer = indexofCorrectAnswer;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @PrePersist
    public void updateStatus() {
        LocalDateTime now = LocalDateTime.now();
        if (now.isBefore(startDate)) {
            status = QuizStatus.INACTIVE;
        } else if (now.isAfter(endDate)) {
            status = QuizStatus.FINISHED;
        } else {
            status = QuizStatus.ACTIVE;
        }
    }
    @Override
    public String toString() {
        return "QuizQuestion [id=" + id + ", Question=" + question + ", optionsOfAnswer=" + optionsOfAnswer
                + ", indexofCorrectAnswer=" + indexofCorrectAnswer + ", startDate=" + startDate + ", EndDate=" +endDate
                + "]";
    }

   

    
}
