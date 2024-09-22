package ru.medov.yandextranslateapitest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Data
public class RequestBody {
    @Value("${yandex.TARGET_LANG_CODE}")
    private String targetLanguageCode;
    @Value("${yandex.FORMAT}")
    private String format;
    @Value("${yandex.FOLDER_ID}")
    private String folderId;
    private String[] texts;
}
