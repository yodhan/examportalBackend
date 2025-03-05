package com.projects.examproject.service;

import com.projects.examproject.entity.Question;
import com.projects.examproject.entity.Quiz;

import java.util.Set;

public interface QuestionService {

    public Question addQuestion(Question question);

    public Question update(Question question);

    public Set<Question> getQuestions();

    public Question getQuestion(Long questionId);

    public void deleteQuestion(Long questionId);

    public Set<Question> getQuestionsOfQuiz(Quiz quiz);


}
