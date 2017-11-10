package pages;

import controls.Button;
import controls.Link;
import controls.Text;
import core.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class IssuesPage extends BasePage {
    private WebElement searchResult;
    private Button button_NewIssue() {return Button.byCss(".subnav a[href$='/issues/new']");}
    private Button button_IssueTabIsActive() {return Button.byCss("span a[href$='/issues'][class~='selected']");}
    private List<WebElement> element_AllSearchedResults(String userName, String repoName) {return Driver.get().findElements(By.cssSelector("div[class^='float-left'] a[href^='/"+userName+"/"+repoName+"/issues/']"));}

    public WebElement getSearchResult() {
        return searchResult;
    }

    public IssuesPage() {
    }

    public IssuesPage(WebElement element) {
        searchResult = element;
    }


    public IssueCreationPage goToIssueCreation() {
        button_NewIssue().click();
        IssueCreationPage issueCreationPage = new IssueCreationPage();
        try {
            issueCreationPage.verifyIssueCreation();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
        return issueCreationPage;
    }

    public List<IssuesPage> getCreatedIssue(String userName, String repoName) {
        List<IssuesPage> issuesPages = new ArrayList<>();
        for (WebElement element: element_AllSearchedResults(userName, repoName)) {
            IssuesPage issuesPage = new IssuesPage(element);
            issuesPages.add(issuesPage);
        }
        return issuesPages;
    }

    protected void verifyIssuePage() throws Exception {
        if (!button_IssueTabIsActive().isElementClickable()) {
            throw new Exception("Button New Issue is not clickable on Issue Page.");
        }
    }

}
