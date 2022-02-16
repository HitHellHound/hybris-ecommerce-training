package com.expertsoft.populators;

import com.expertsoft.questions.model.QuestionModel;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import questions.data.QuestionData;

import java.util.stream.Collectors;

public class ProductQuestionsPopulator implements Populator<ProductModel, ProductData> {
    private Converter<QuestionModel, QuestionData> questionConverter;

    @Override
    public void populate(ProductModel productModel, ProductData productData) throws ConversionException {
        productData.setQuestions(productModel.getQuestions().stream()
                .map(questionModel -> questionConverter.convert(questionModel))
                .collect(Collectors.toList())
        );
        productData.setNumberOfQuestions(productData.getQuestions().size());
    }

    public Converter<QuestionModel, QuestionData> getQuestionConverter() {
        return questionConverter;
    }

    public void setQuestionConverter(Converter<QuestionModel, QuestionData> questionConverter) {
        this.questionConverter = questionConverter;
    }
}
