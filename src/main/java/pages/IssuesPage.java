package pages;

import controls.ButtonControl;
import controls.LinkControl;
import core.Driver;
import core.PropertiesContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class IssuesPage extends BasePage {
    private WebElement searchResult;

    public WebElement getSearchResult() {
        return searchResult;
    }

    public IssuesPage() {
    }

    public IssuesPage(WebElement element) {
        searchResult = element;
    }
    public ButtonControl getNewIssue() {
        return ButtonControl.findButtonByCss(".subnav a[href='/glaaadis/Gladiko/issues/new']");
//        return ButtonControl.findButtonByCss("a[href='/"+ PropertiesContainer.get("test.login")+"/"+PropertiesContainer.get("test.repositoryName")+"/issues/new']");
    }

    public IssueCreationPage goToIssueCreation() {
        getNewIssue().click();
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
