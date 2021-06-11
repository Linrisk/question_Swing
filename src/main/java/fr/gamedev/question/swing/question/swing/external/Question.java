package fr.gamedev.question.swing.question.swing.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Server Side representation of a question.
 * @author djer13
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {

    private String content;

    @Override
    public String toString() {
        return "Question [content=" + content + "]";
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

}
