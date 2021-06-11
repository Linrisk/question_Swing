package fr.gamedev.question.swing.question.swing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author djer1
 *
 */
@SpringBootApplication
public class QuestionIHM_Launcher {

    @Autowired
    MainFrame main;

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext contexto = new SpringApplicationBuilder(QuestionIHM_Launcher.class)
                .web(WebApplicationType.NONE).headless(false).bannerMode(Banner.Mode.OFF).run(args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            main.setVisible(true);
        };
    }

}
