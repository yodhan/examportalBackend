package com.projects.examproject.service.implementation;

import com.projects.examproject.entity.Quiz;
import com.projects.examproject.repository.QuizRepository;
import com.projects.examproject.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
@Service
public class QuizImplementation implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public void deleteQuiz(Long quizId) {
//        Quiz quiz =new Quiz();
//        quiz.setQid(quizId);
//        this.quizRepository.delete(quiz);
        this.quizRepository.deleteById(quizId);
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return this.quizRepository.findById(quizId).get();
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new LinkedHashSet<>(this.quizRepository.findAll());
    }
}
