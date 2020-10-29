package ru.fmordashev.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YandexResultPage {

    public WebDriver driver;

    public YandexResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "")
    private WebElement seemsLikeTextHeader;

    @FindBy(xpath = "/html/body/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/div/div/div[2]/a")
    private List<WebElement> predictionBulletList;

    public boolean isSeemsLikeTextHeaderDisplayed() {
        return seemsLikeTextHeader.isDisplayed();
    }

    public List<WebElement> getPredictionBulletList() {
        return predictionBulletList;
    }

}
