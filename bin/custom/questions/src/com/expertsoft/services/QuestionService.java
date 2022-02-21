package com.expertsoft.services;

import com.expertsoft.questions.model.QuestionModel;

import java.util.Date;
import java.util.List;

public interface QuestionService {
    List<QuestionModel> getQuestionsAfter(Date date);
}
