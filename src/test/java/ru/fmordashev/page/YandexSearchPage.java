package ru.fmordashev.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexSearchPage {

    public WebDriver driver;

    public YandexSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "")
    private WebElement pageHeader;

    @FindBy(xpath = "//button[@aria-label='Поиск по картинке']")
    private WebElement searchByImageButton;

    @FindBy(xpath = "//form[@class='cbir-panel__input']//input[@name='cbir-url']")
    private WebElement imageUrlTextField;

    @FindBy(xpath = "//form[@class='cbir-panel__input']//button[@type='submit']")
    private WebElement beginSearchButton;

    public void clickSearchByImageButton() {
        searchByImageButton.click();
    }

    public void insertTextInImageUrl(String text) {
        imageUrlTextField.sendKeys(text);
    }

    public void clickBeginSearchButton() {
        beginSearchButton.click();
    }



}
