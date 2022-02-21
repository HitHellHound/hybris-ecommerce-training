package com.expertsoft.emailcontexts;

import com.expertsoft.questions.model.QuestionNotifyProcessModel;
import de.hybris.platform.acceleratorservices.model.cms2.pages.EmailPageModel;
import de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.user.CustomerModel;

public class QuestionNotifyEmailContext extends AbstractEmailContext<QuestionNotifyProcessModel> {
    private static final String NUMBER_OF_NEW_QUESTIONS = "numberOfQuestions";
    private Integer number;

    @Override
    public void init(QuestionNotifyProcessModel businessProcessModel, EmailPageModel emailPageModel) {
        super.init(businessProcessModel, emailPageModel);
        put(NUMBER_OF_NEW_QUESTIONS, businessProcessModel.getQuestions().size());
        setNumber(businessProcessModel.getQuestions().size());
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    protected BaseSiteModel getSite(QuestionNotifyProcessModel businessProcessModel) {
        return null;
    }

    @Override
    protected CustomerModel getCustomer(QuestionNotifyProcessModel businessProcessModel) {
        return null;
    }

    @Override
    protected LanguageModel getEmailLanguage(QuestionNotifyProcessModel businessProcessModel) {
        return null;
    }
}
