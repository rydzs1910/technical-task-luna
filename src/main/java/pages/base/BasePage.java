package pages.base;


import engine.BaseEngine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage extends BaseEngine
{
    protected WebDriver webDriver;

    protected BasePage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    public String getTitle() {
        return webDriver.getTitle();
    }
    public void verifyPageIsLoaded()
    {
        waitForElement(30, getPageElement());

    }

    protected abstract WebElement getPageElement();

    protected void waitForElement(int timeout, WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void logClick(WebElement element)
    {
        String text = element.getText();
        System.out.println("Clicking:  " + text);
        element.click();
    }
}
