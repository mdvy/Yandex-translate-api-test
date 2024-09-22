package ru.medov.yandextranslateapitest;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import ru.medov.yandextranslateapitest.consumer.YandexTranslator;

@SpringBootApplication
public class YandexTranslateApiTestApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(YandexTranslateApiTestApplication.class, args);

		YandexTranslator bean = run.getBean(YandexTranslator.class);
        try {
            System.out.println(bean.translate("привет мир"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}



}
