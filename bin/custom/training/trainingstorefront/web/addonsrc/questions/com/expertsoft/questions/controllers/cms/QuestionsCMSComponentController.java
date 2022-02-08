package com.expertsoft.questions.controllers.cms;

import com.expertsoft.model.cms2.components.QuestionsCMSComponentModel;
import com.expertsoft.questions.model.QuestionModel;
import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import de.hybris.platform.converters.impl.AbstractConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import questions.data.QuestionData;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller("QuestionsCMSComponentController")
@RequestMapping(value = "/view/QuestionsCMSComponentController")
public class QuestionsCMSComponentController extends AbstractCMSAddOnComponentController<QuestionsCMSComponentModel> {
    @Resource(name = "questionModel2DataConverter")
    private AbstractConverter<QuestionModel, QuestionData> questionConverter;

    @Override
    protected void fillModel(HttpServletRequest request, Model model, QuestionsCMSComponentModel component) {
        Set<QuestionModel> questionModels = getRequestContextData(request).getProduct().getQuestions();
        List<QuestionData> questions = questionModels.stream()
                .limit(component.getCountOfQuestionsToBeShown())
                .map(questionModel -> questionConverter.convert(questionModel))
                .collect(Collectors.toList());
        model.addAttribute("questions", questions);
    }

    public AbstractConverter<QuestionModel, QuestionData> getQuestionConverter() {
        return questionConverter;
    }

    public void setQuestionConverter(AbstractConverter<QuestionModel, QuestionData> questionConverter) {
        this.questionConverter = questionConverter;
    }
}
