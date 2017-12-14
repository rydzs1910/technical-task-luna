package pages.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.CareersPage;
import pages.CareersResultsPage;

import java.util.List;

public abstract class CareersBasePage extends AkamaiBasePage
{
    @FindBy(id = "keyword")
    private WebElement keywordInput;

    @FindBy(id = "jLocInputHldr")
    private WebElement locationInput;

    @FindBy(id = "jSearchSubmit")
    private WebElement submitBtn;

    @FindBy(xpath = "//ul[@class='chzn-results']/li")
    private List<WebElement> listElements;

    private Logger log = LoggerFactory.getLogger(CareersPage.class);

    public CareersBasePage(WebDriver webDriver) {
        super(webDriver);
    }

    protected WebElement getPageElement()
    {
        return submitBtn;
    }

    public void enterKeyword(String keyword)
    {
        if(keywordInput.isDisplayed())
        {
            keywordInput.sendKeys(keyword);
        }
    }

    public WebElement getLocationElement()
    {
        if(locationInput.isDisplayed())
        {
            return locationInput;
        }
        log.warn("Element location is not present");
        return  null;
    }

    public void clickLocationElement()
    {
        logClick(getLocationElement());
    }

    public WebElement getSearchButton()
    {
        if(locationInput.isDisplayed())
        {
            return submitBtn;
        }
        log.warn("Search button is not present");
        return  null;
    }

    public CareersResultsPage clickSearchButton()
    {
        if(submitBtn.isDisplayed())
        {
            logClick(getSearchButton());
            CareersResultsPage page = new CareersResultsPage(webDriver);
            page.verifyPageIsLoaded();
            return new CareersResultsPage(webDriver);
        }
        log.warn("Search button not found!");
        return null;
    }
    public void selectLocation (String location)
    {
        for (WebElement element : listElements)
        {
            if(element.getText().equals(location))
            {
                ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
                logClick(element);
            }
        }
    }
}
