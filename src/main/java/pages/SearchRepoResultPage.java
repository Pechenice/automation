package pages;

import controls.Link;
import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchRepoResultPage extends BasePage {
    private List<WebElement> element_ListOfSearchedElements() {
        return Driver.get().findElements(By.cssSelector("div[class^='repo-list-item'] a"));
    }
    private WebElement searches;
    private Link link_AdvancedSearch() {return Link.byCss(".muted-link");}

    public SearchRepoResultPage() {}

    public SearchRepoResultPage(WebElement element) {
            searches = element;
    }

    public WebElement getSearches() {
        return searches;
    }


    public List<SearchRepoResultPage> resultsOfSearch() {
         List<SearchRepoResultPage> searchResultPages = new ArrayList<>();
         for (WebElement elements: element_ListOfSearchedElements()) {
             SearchRepoResultPage searchResult = new SearchRepoResultPage(elements);
             searchResultPages.add(searchResult);
         }
         return searchResultPages;
     }

    protected void verifySearchRepoResults() throws Exception {
        if (!link_AdvancedSearch().isElementClickable()) {
            throw new Exception("Advanced search link is not clickable on Repository Searched Results.");
        }
    }
}
