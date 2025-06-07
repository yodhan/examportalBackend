package com.projects.examproject.controller;

import com.projects.examproject.entity.Quiz;
import com.projects.examproject.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService QuizService;

    @PostMapping("/")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz Quiz){
        return ResponseEntity.ok(this.QuizService.addQuiz(Quiz));
    }

    @GetMapping("/{quizId}")
    public Quiz getQuiz(@PathVariable("quizId") Long quizId){
        return this.QuizService.getQuiz(quizId);
    }

    @GetMapping("/")
    public ResponseEntity<?> getQuizes(){
        return ResponseEntity.ok(this.QuizService.getQuizzes());
    }

    @PutMapping("/")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz Quiz){
        return  ResponseEntity.ok(this.QuizService.addQuiz(Quiz));
    }

    @DeleteMapping("/{QuizId}")
    public ResponseEntity<?> deleteQuiz(@PathVariable("QuizId") Long QuizId){
        this.QuizService.deleteQuiz(QuizId);
        return ResponseEntity.ok("deleted");
    }
}
