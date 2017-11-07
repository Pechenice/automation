package pages;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends BasePage {
    private WebElement searches;

    public SearchResultPage() {

    }

    public SearchResultPage(WebElement element) {
        searches = element;
    }

    public WebElement getSearches() {
        return searches;
    }

    public List<SearchResultPage> resultsOfSearch() {
         List<WebElement> allSearchResults = Driver.get().findElements(By.cssSelector("div[class^='repo-list-item'] a"));
         List<SearchResultPage> searchResultPages = new ArrayList<>();
         for (WebElement elements: allSearchResults) {
             SearchResultPage searchResult = new SearchResultPage(elements);
             searchResultPages.add(searchResult);
         }
         return searchResultPages;
     }
}
