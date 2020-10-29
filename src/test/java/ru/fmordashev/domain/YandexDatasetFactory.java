package ru.fmordashev.domain;

import ru.fmordashev.env.TestEnvProperties;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class YandexDatasetFactory {

    public static YandexDataset getImageSearchDataset() throws UnsupportedEncodingException {
        YandexDataset yandexDataset = new YandexDataset();
        yandexDataset.urlAndNameHashMap.put(
                "url",
                TestEnvProperties.getProperty("imageSearchUrl")
        );
        yandexDataset.urlAndNameHashMap.put(
                "result",
                new String(TestEnvProperties.getProperty("expectedImageSearchResult").getBytes("ISO8859-1"))
        );
        return yandexDataset;
    }
}
