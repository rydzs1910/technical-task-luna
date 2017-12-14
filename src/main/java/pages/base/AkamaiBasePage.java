package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AkamaiBasePage extends BasePage
{
    @FindBy(id = "header")
    private WebElement mainPanel;

    @FindBy(id = "tee_account_profile")
    private WebElement myProfile;

    @FindBy(id = "tee_account_submissions")
    private WebElement mySubmissions;

    public AkamaiBasePage(WebDriver webDriver)
    {
        super(webDriver);
    }
}
