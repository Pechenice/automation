package pages;

import controls.Button;
import core.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class IssuesPage extends BasePage {
    private WebElement searchResult;
    private Button button_NewIssue() {return Button.byCss(".subnav a[href$='/issues/new']");}

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
        return new IssueCreationPage();
    }

    public List<IssuesPage> getCreatedIssues() {
        List<WebElement> webElements = Driver.get().findElements(By.cssSelector("div[class^='float-left'] a[href^='/glaaadis/Gladiko/issues/']"));
        List<IssuesPage> issuesPages = new ArrayList<>();
        for (WebElement element: webElements) {
            IssuesPage issuesPage = new IssuesPage(element);
            issuesPages.add(issuesPage);
        }
        return issuesPages;
    }

}
