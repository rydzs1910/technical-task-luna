package pages;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.AkamaiBasePage;


public class JobDetailsPage extends AkamaiBasePage
{
    @FindBy (tagName = "h1")
    @CacheLookup
    private WebElement jobDetailsTitle;

    @FindBy (className = "job_post_date")
    private WebElement postDate;

    private Logger log = LoggerFactory.getLogger(JobDetailsPage.class);

    protected JobDetailsPage(WebDriver webDriver)
    {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    protected WebElement getPageElement()
    {
        return jobDetailsTitle;
    }

    public String getPostDate()
    {
        try
        {
            return postDate.getText();
        }
        catch (NoSuchElementException e)
        {
            log.warn("Post date element not found");
            throw e;
        }
    }
    public String getJobTitle()
    {
        try
        {
            return jobDetailsTitle.getText();
        }
        catch (NoSuchElementException e)
        {
            log.warn("Job title element not present");
            throw e;
        }
    }
}
