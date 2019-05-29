package com.skillup.automation.pages;

import com.skillup.automation.configuration.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//класс предок для всех страниц
//в этом классе мы создаем общие методы которые будут полезные для работы с элементами на всех страницах
public class CommonPage {
    protected WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    //метод который вводит текст
    public void enterText(String locator, String text) {
        WebElement input = driver.findElement(find(locator));
        input.clear();
        input.sendKeys(text);
    }

    public void click(String locator) {
        driver.findElement(find(locator)).click();
    }

    //общий метод который говорит присутсвует элемент на странице или нет
    //используется explicit wait
    //если выбрасывается исключение - то при перехвати исключения - влзвращаем false
    // значит элемент не был найден за условленное время
    protected boolean isElementPresent(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Wait.TEN_SECONDS);

        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(find(locator)));
        } catch (TimeoutException e) {
            return false;
        }

        return true;
    }

    //метод который определяет как находятся элементы
    //такая реализация возможно ибо принято решение писать локаторы только через XPATH or CSS
    protected By find(String locator) {
        if (locator.contains("//") || locator.startsWith("./")){
            return By.xpath(locator);
        }

        return By.cssSelector(locator);
    }
}
