import engine.BaseEngine;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.CareersPage;
import pages.CareersResultsPage;
import pages.JobDetailsPage;


public class AkamaiJobsSearchTest extends AkamaiBaseTestCase
{
    private static WebDriver driver;
    private String searchText;
    private String location;
    private String expectedTotalResults;
    private String expectedResultsWithPhrase;
    private String searchedTitle;
    private String searchedJob;
    private String postDate;
    private Logger logger = LoggerFactory.getLogger(AkamaiJobsSearchTest.class);

    @BeforeClass
    public static void setUp() throws Exception
    {
        driver = BaseEngine.getWebDriver();
    }
    @Test
    public void searchJobInKrakowTest() throws Exception
    {
        expectedTotalResults = "9";
        expectedResultsWithPhrase = "1";
        searchText = "test";
        location = "Krakow, Poland";
        searchedTitle = "Software Development Engineer in Test";
        searchedJob = "Senior Software Development Engineer in Test II";
        postDate = "Mar 01, 2017";

        logger.info("Enter keyword " + searchText +" and location " + location);
        CareersPage careersPage = new CareersPage(driver);
        careersPage.verifyPageIsLoaded();
        careersPage.enterKeyword(searchText);
        careersPage.getLocationElement().click();
        careersPage.selectLocation(location);

        logger.info("Search for the results");
        CareersResultsPage careersResultsPage  = careersPage.clickSearchButton();
        Assert.assertTrue("Total results number is wrong.Actual:" + careersResultsPage.getTotalResults() + ".Expected:" + expectedTotalResults + "."
                , careersResultsPage.getTotalResults().equals(expectedTotalResults));
        int numberOfJobs = careersResultsPage.getResultsByPhrase(searchedTitle).size();
        Assert.assertTrue("Number of jobs with title " + searchedTitle + " is wrong.Actual:" + Integer.toString(numberOfJobs) + ".Expected:" + expectedResultsWithPhrase,
                Integer.toString(numberOfJobs).equals(expectedResultsWithPhrase));

        logger.info("Opening job " + searchedJob);
        JobDetailsPage jobDetails = careersResultsPage.openJobDetailsByTitle(searchedJob);
        Assert.assertTrue("Job title is wrong.Actual:" + jobDetails.getJobTitle() + ".Expected: " + searchedJob,
                jobDetails.getJobTitle().equals(searchedJob));
        Assert.assertTrue("Post date in not as expected.Actual:" + jobDetails.getPostDate() + ".Expected:" + postDate,
                jobDetails.getPostDate().equals(postDate));
    }
}
