package com.expertsoft.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.search.converters.populator.SearchResultVariantProductPopulator;
import de.hybris.platform.commerceservices.search.resultdata.SearchResultValueData;

public class SearchProductQuestionsPopulator extends SearchResultVariantProductPopulator {
    @Override
    public void populate(SearchResultValueData source, ProductData target) {
        super.populate(source, target);
        final Object obj = this.getValue(source, "numberOfQuestions");
        if (obj != null) {
            if (obj instanceof Integer){
                target.setNumberOfQuestions(this.<Integer>getValue(source, "numberOfQuestions"));
            } else {
                target.setNumberOfQuestions(Integer.valueOf(this.<String>getValue(source, "numberOfQuestions")));
            }
        } else {
            target.setNumberOfQuestions(0);
        }
    }
}
