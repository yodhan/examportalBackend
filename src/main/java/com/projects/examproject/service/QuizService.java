package com.projects.examproject.service;

import com.projects.examproject.entity.Category;
import com.projects.examproject.entity.Quiz;

import java.util.List;
import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public void deleteQuiz(Long quizId);
    public Quiz getQuiz(Long quizId);
    public Set<Quiz> getQuizzes();
    public List<Quiz> getQuizesofCategory(Long category);
    public List<Quiz> getActiveQuizes(Boolean active);
    public List<Quiz> getActiveQuizesOfCategory(Long category);

}
