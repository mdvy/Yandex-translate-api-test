package ru.medov.yandextranslateapitest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Translation {
      private String text;
      private String detectedLanguageCode;
}
