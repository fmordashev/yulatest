package ru.fmordashev.tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.fmordashev.domain.YandexDataset;
import ru.fmordashev.domain.YandexDatasetFactory;
import ru.fmordashev.env.TestEnvProperties;
import ru.fmordashev.page.YandexHomePage;
import ru.fmordashev.page.YandexResultPage;
import ru.fmordashev.page.YandexSearchPage;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static ru.fmordashev.util.StringUtils.listContainsString;

public class YandexTest {

    public static YandexHomePage yandexHomePage;
    public static YandexSearchPage yandexSearchPage;
    public static YandexResultPage yandexResultPage;
    public static YandexDataset yandexDataset;
    public static WebDriver driver;
    public static String imageUrl;
    public static String imageResult;

    @BeforeClass
    public static void setup() throws UnsupportedEncodingException {
        //создание экземпляра драйвера
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        URL path = loader.getResource("chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", path.getPath());
        driver = new ChromeDriver();

        //инициализация страниц
        yandexHomePage = new YandexHomePage(driver);
        yandexSearchPage = new YandexSearchPage(driver);
        yandexResultPage = new YandexResultPage(driver);

        //инициализация данных теста
        yandexDataset = YandexDatasetFactory.getImageSearchDataset();
        imageUrl = yandexDataset.urlAndNameHashMap.get("url");
        imageResult = yandexDataset.urlAndNameHashMap.get("result");

        //конфиги запуска
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(TestEnvProperties.getProperty("homePage"));
    }

    @Test
    public void searchByImageTest() {
        //Открываем модуль "Картинки"
        yandexHomePage.clickImageSearchModuleButton();
        //Открываем поиск по картинке и вводим URL
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        yandexSearchPage.clickSearchByImageButton();
        yandexSearchPage.insertTextInImageUrl(imageUrl);
        //Осуществляем поиск по картинке
        yandexSearchPage.clickBeginSearchButton();
        //Получаем инфу по буллетам-предположениям яндекса
        List<String> predictionTextList = new ArrayList<String>();
        List<WebElement> predictionBulletList = yandexResultPage.getPredictionBulletList();
        predictionBulletList.forEach(webElement -> predictionTextList.add(webElement.getText()));
        //Проверяем, что в них содержится искомый текст
        Assert.assertTrue(listContainsString(predictionTextList, imageResult));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
