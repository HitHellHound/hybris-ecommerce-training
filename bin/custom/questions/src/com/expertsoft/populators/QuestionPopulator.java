package com.expertsoft.populators;

import com.expertsoft.questions.model.QuestionModel;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import questions.data.QuestionData;

public class QuestionPopulator implements Populator<QuestionModel, QuestionData> {
    @Override
    public void populate(QuestionModel questionModel, QuestionData questionData) throws ConversionException {
        questionData.setQuestion(questionModel.getQuestion());
        questionData.setQuestionCustomerName(questionModel.getQuestionCustomer().getName());
        questionData.setAnswer(questionModel.getAnswer());
        if (questionModel.getAnswerCustomer() != null) {
            questionData.setAnswerCustomerName(questionModel.getAnswerCustomer().getName());
        }
    }
}
