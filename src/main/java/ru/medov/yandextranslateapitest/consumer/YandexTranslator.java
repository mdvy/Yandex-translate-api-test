package ru.medov.yandextranslateapitest.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.medov.yandextranslateapitest.domain.RequestBody;
import ru.medov.yandextranslateapitest.domain.YandexResponse;

@Component
public class YandexTranslator {

    @Value("${yandex.API_KEY}")
    private String API_KEY;
    @Value("${yandex.URL}")
    private String URL;

    private final RestTemplate restTemplate;
    private final RequestBody requestBody;

    public YandexTranslator(RestTemplate restTemplate, RequestBody requestBody) {
        this.restTemplate = restTemplate;
        this.requestBody = requestBody;
    }

    public String translate(String sourceText) throws JsonProcessingException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Authorization", "Api-Key " + API_KEY);

        requestBody.setTexts(new String[]{sourceText});

        HttpEntity<RequestBody> httpEntity = new HttpEntity<>(requestBody, httpHeaders);

        YandexResponse translations = restTemplate.postForObject(
                URL,
                httpEntity,
                YandexResponse.class
        );

        assert translations != null;
        return translations.getTranslation();

    }
}
