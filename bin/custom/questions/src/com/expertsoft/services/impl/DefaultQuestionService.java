package com.expertsoft.services.impl;

import com.expertsoft.questions.model.QuestionModel;
import com.expertsoft.services.QuestionService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultQuestionService implements QuestionService {
    private FlexibleSearchService flexibleSearchService;

    @Override
    public List<QuestionModel> getQuestionsAfter(Date date) {
        final Map<String, Object> params = new HashMap<>();

        final StringBuilder query = new StringBuilder();
        query.append("SELECT {").append(QuestionModel.PK).append("} ");
        query.append("FROM {").append(QuestionModel._TYPECODE).append(" AS q} ");
        query.append("WHERE {q.").append(QuestionModel.CREATIONTIME).append("} > ?date");

        params.put("date", date);

        final SearchResult<QuestionModel> result = flexibleSearchService.search(query.toString(), params);
        return result.getResult();
    }

    public FlexibleSearchService getFlexibleSearchService() {
        return flexibleSearchService;
    }

    public void setFlexibleSearchService(FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }
}
