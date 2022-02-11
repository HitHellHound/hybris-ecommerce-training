package com.expertsoft.providers;

import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.provider.FieldNameProvider;
import de.hybris.platform.solrfacetsearch.provider.FieldValue;
import de.hybris.platform.solrfacetsearch.provider.FieldValueProvider;
import de.hybris.platform.solrfacetsearch.provider.impl.AbstractPropertyFieldValueProvider;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductNumberOfQuestionsProvider extends AbstractPropertyFieldValueProvider
        implements FieldValueProvider, Serializable {
    private FieldNameProvider fieldNameProvider;

    @Override
    public Collection<FieldValue> getFieldValues(IndexConfig indexConfig, IndexedProperty indexedProperty, Object object)
            throws FieldValueProviderException {
        if (object instanceof ProductModel) {
            final ProductModel product = (ProductModel) object;
            List<FieldValue> fieldValues = createFieldValue(product, indexConfig, indexedProperty);
            return fieldValues;
        } else {
            throw new FieldValueProviderException("Cannot get number of questions for a product mode");
        }
    }

    protected List<FieldValue> createFieldValue(final ProductModel productModel, final IndexConfig indexConfig,
                                                final IndexedProperty indexedProperty) {
        final List<FieldValue> fieldValues = new ArrayList<>();
        Integer numberOfQuestions = productModel.getQuestions().size();
        addFieldValues(fieldValues, indexedProperty, null, numberOfQuestions);
        return fieldValues;
    }

    protected void addFieldValues(final List<FieldValue> fieldValues, final IndexedProperty indexedProperty,
                                  final LanguageModel language, final Object value) {
        final Collection<String> fieldNames = fieldNameProvider.getFieldNames(indexedProperty,
                language == null ? null : language.getIsocode());
        for (final String fieldName : fieldNames) {
            fieldValues.add(new FieldValue(fieldName, value));
        }
    }

    public void setFieldNameProvider(FieldNameProvider fieldNameProvider) {
        this.fieldNameProvider = fieldNameProvider;
    }

    public FieldNameProvider getFieldNameProvider() {
        return fieldNameProvider;
    }
}
