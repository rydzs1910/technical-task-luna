package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.CareersBasePage;

import java.util.List;

public class CareersResultsPage extends CareersBasePage
{
    @FindBy(id = "job_results_list_hldr")
    private WebElement results;

    @FindBy(className = "total_results")
    private WebElement totalResults;

    private Logger log = LoggerFactory.getLogger(CareersResultsPage.class);

    public CareersResultsPage(WebDriver webDriver)
    {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    protected WebElement getPageElement()
    {
            return totalResults;
    }
    public String getTotalResults()
    {
        return totalResults.getText();
    }

    public List<WebElement> getResultsByPhrase(String phrase)
    {
        return results.findElements(By.partialLinkText(phrase));
    }

    private WebElement getLinkByTitle(String title)
    {
        return results.findElement(By.linkText(title));
    }

    public JobDetailsPage openJobDetailsByTitle(String title)
    {
        try
        {
            WebElement element = getLinkByTitle(title);
            logClick(element);
            JobDetailsPage page = new JobDetailsPage(webDriver);
            page.verifyPageIsLoaded();
            return new JobDetailsPage(webDriver);
        }
        catch(NoSuchElementException e)
        {
            log.warn("Link with title " + title + " is not present");
            throw e;
        }
    }


}
