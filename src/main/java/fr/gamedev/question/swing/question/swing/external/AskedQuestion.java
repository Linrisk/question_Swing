package fr.gamedev.question.swing.question.swing.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Domain object to represent the **server** side of a question asked to a specific user.
 * @author djer13
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class AskedQuestion {

    private long id;

    private Integer points;

    private Question question;

    @Override
    public String toString() {
        return "AskedQuestion [id=" + id + ", points=" + points + ", question=" + question + "]";
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the points
     */
    public Integer getPoints() {
        return points;
    }

    /**
     * @return the question
     */
    public Question getQuestion() {
        return question;
    }

}
