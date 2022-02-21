package com.expertsoft.jobs;

import com.expertsoft.questions.model.QuestionModel;
import com.expertsoft.questions.model.QuestionNotifyCronJobModel;
import com.expertsoft.questions.model.QuestionNotifyProcessModel;
import com.expertsoft.services.QuestionService;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class QuestionNotifyJob extends AbstractJobPerformable<QuestionNotifyCronJobModel> {
    private BusinessProcessService businessProcessService;
    private QuestionService questionService;
    private ModelService modelService;

    @Override
    public PerformResult perform(QuestionNotifyCronJobModel questionNotifyCronJobModel) {
        Date startJobTime = new Date();
        final QuestionNotifyProcessModel questionNotifyProcessModel = (QuestionNotifyProcessModel)
                businessProcessService.createProcess("questionNotifyEmailProcess" + System.currentTimeMillis(),
                        "questionNotifyEmailProcess");
        List<QuestionModel> questions;
        if (questionNotifyCronJobModel.getLastNotifyDate() != null) {
            questions = questionService.getQuestionsAfter(questionNotifyCronJobModel.getLastNotifyDate());
        } else {
            questions = questionService.getQuestionsAfter(new Date());
        }
        questionNotifyCronJobModel.setLastNotifyDate(startJobTime);
        questionNotifyProcessModel.setQuestions(Set.copyOf(questions));
        modelService.save(questionNotifyCronJobModel);
        modelService.save(questionNotifyProcessModel);
        businessProcessService.startProcess(questionNotifyProcessModel);
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }

    public BusinessProcessService getBusinessProcessService() {
        return businessProcessService;
    }

    public void setBusinessProcessService(BusinessProcessService businessProcessService) {
        this.businessProcessService = businessProcessService;
    }

    public ModelService getModelService() {
        return modelService;
    }

    @Override
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    public QuestionService getQuestionService() {
        return questionService;
    }

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }
}
