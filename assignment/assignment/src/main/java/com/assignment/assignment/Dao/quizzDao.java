package com.assignment.assignment.Dao;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assignment.assignment.Entity.Quiz;
import com.assignment.assignment.enums.QuizStatus;

@Repository
@EnableJpaRepositories
public interface quizzDao extends JpaRepository<Quiz ,Integer> {
    
      Quiz findById(int userId);

      Quiz findFirstByStartDateBeforeAndEndDateAfter(LocalDateTime start, LocalDateTime end);
      
      Quiz findByStatus(QuizStatus status);

}
