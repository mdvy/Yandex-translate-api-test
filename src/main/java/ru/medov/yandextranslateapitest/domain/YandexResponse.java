package ru.medov.yandextranslateapitest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YandexResponse {
    private ArrayList<Translation> translations;

    public String getTranslation(){
        return getTranslations().get(0).getText();
    }
}
