package com.projects.examproject.service.implementation;

import com.projects.examproject.entity.Question;
import com.projects.examproject.entity.Quiz;
import com.projects.examproject.repository.QuestionRepository;
import com.projects.examproject.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
@Service
public class QuestionServiceImplementation implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question update(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new LinkedHashSet<>(this.questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long questionId) {
        return this.questionRepository.findById(questionId).get();
    }

    @Override
    public void deleteQuestion(Long questionId) {
        this.questionRepository.deleteById(questionId);
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
        return new LinkedHashSet<>(this.questionRepository.findByQuiz(quiz));
    }
}
