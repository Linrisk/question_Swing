package fr.gamedev.question.swing.question.swing;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
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

    /** Retrieve the next Question for UserId from the backEndServer. */
    public Question getQuestion(String userId) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(USER_GET_ONE_QUESTION_URL)
                .queryParam("userLogin", userId).queryParam("projection", "askedQuestion");

        Question question = new Question();
        Map<String, String> possibleAnswers = new HashMap<>();
        try {
            AskedQuestion askedQuestion = questionRestTemplate.getForObject(builder.toUriString(), AskedQuestion.class);
            question.setQuestion(askedQuestion.getQuestion().getContent());
            question.setQuestionId(askedQuestion.getId());

            possibleAnswers.put("true", "Vrai");
            possibleAnswers.put("false", "Faux");

        } catch (ResourceAccessException rae) {
            question.setQuestion("ERROR : no connection to server !");
        }

        question.setPossibleAnswers(possibleAnswers);

        return question;
    }

}
