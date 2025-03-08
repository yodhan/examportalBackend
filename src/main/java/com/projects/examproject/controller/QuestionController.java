package com.projects.examproject.controller;

import com.projects.examproject.entity.Question;
import com.projects.examproject.entity.Quiz;
import com.projects.examproject.service.QuestionService;
import com.projects.examproject.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    private QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question Question){
        return ResponseEntity.ok(this.questionService.addQuestion(Question));
    }

    @GetMapping("/{QuestionId}")
    public Question getQuestion(@PathVariable("QuestionId") Long QuestionId){
        return this.questionService.getQuestion(QuestionId);
    }

    @GetMapping("/")
    public ResponseEntity<?> getQuestions(){
        return ResponseEntity.ok(this.questionService.getQuestions());
    }

    @PutMapping("/")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question Question){
        return  ResponseEntity.ok(this.questionService.addQuestion(Question));
    }

    @DeleteMapping("/{QuestionId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("QuestionId") Long QuestionId){
        this.questionService.deleteQuestion(QuestionId);
        return ResponseEntity.ok("deleted");
    }

    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") long qid){
//        canm furthetr  implement v25  no of questions
        Quiz quiz= this.quizService.getQuiz(qid);
        return ResponseEntity.ok(this.questionService.getQuestionsOfQuiz(quiz));

    }
}
