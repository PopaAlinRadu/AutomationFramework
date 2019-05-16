package ro.nila.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class CommonActions {

    private Wait<WebDriver> webDriverWait;

    public CommonActions(Wait<WebDriver> webDriverWait) {
        this.webDriverWait = webDriverWait;
    }

    public void validateText(WebElement webElement, String expected) {
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(webElement, expected));
        System.out.println("Validate text from: [" + processString(webElement.toString()) + " to be: " + expected);
    }

    public void click(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
        System.out.println("Clicking on: [" + processString(webElement.toString()));
    }

    public void type(WebElement webElement, String value) {
        WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        element.clear();
        element.sendKeys(value);
        System.out.println("Type into: [" + processString(webElement.toString()) + "value: " + value);
    }

    public void validateUrl(String url) {
        webDriverWait.until(ExpectedConditions.urlToBe(url));
        System.out.println("Validate URL to be: " + url);
    }

    public void validateElementPresent(WebElement webElement) {
        ExpectedConditions.visibilityOf(webElement);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        System.out.println("Validate element: [" + processString(webElement.toString()) + " to be present");
    }

    private String processString(String string) {
        String regex = "(^\\W{2}.{1,60}\\W{2})";
        return string.replaceAll(regex, "");
    }
}
