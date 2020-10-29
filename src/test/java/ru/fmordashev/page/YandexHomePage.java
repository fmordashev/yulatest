package ru.fmordashev.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexHomePage {

    public WebDriver driver;

    public YandexHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='services-new__item-title'][text()='Картинки']")
    private WebElement imageSearchModuleButton;

    public void clickImageSearchModuleButton() {
        imageSearchModuleButton.click();
    }
}
