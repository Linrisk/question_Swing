package fr.gamedev.question.swing.question.swing;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import fr.gamedev.question.swing.question.swing.external.AskedQuestion;

/**
 * @author djer13
 *
 */
@Service
public class QuestionService {
    private RestTemplate questionRestTemplate;

    //http://localhost:8080/userAnswer/search/findFirstByUserLoginAndPointsIsNull?userLogin=test0&projection=askedQuestion
    private static final String USER_GET_ONE_QUESTION_URL = "http://localhost:8080/userAnswer/search/findFirstByUserLoginAndPointsIsNull";

    public QuestionService(@Autowired RestTemplate theQuestionRestTemplate) {
        this.questionRestTemplate = theQuestionRestTemplate;
    }

    public Question getQuestion(String userId) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(USER_GET_ONE_QUESTION_URL)
                .queryParam("userLogin", userId).queryParam("projection", "askedQuestion");

        AskedQuestion askedQuestion = questionRestTemplate.getForObject(builder.toUriString(), AskedQuestion.class);
        Question question = new Question();

        question.setQuestion(askedQuestion.getQuestion().getContent());
        question.setQuestionId(askedQuestion.getId());

        List<String> possibleAnswers = new ArrayList<String>();
        possibleAnswers.add("true");
        possibleAnswers.add("false");
        question.setPossibleAnswers(possibleAnswers);

        return question;
    }

}
