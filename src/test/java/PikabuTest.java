import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import core.PropertiesContainer;
import core.TestBase;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoggedPage;
import pages.UnLoggedPage;
import pages.PostPage;

public class PikabuTest extends TestBase {

    @Test
    public void enterSiteFail() {
        UnLoggedPage homePage = new UnLoggedPage();
        homePage.login(PropertiesContainer.get("test.login"), "12345Password_Incorrect");
        Assert.assertTrue(homePage.getFailToLogin().waitForElementVisible().isElementVisible());
    }

    @Test
    public void enterSiteSuccess() {
        UnLoggedPage homePage = new UnLoggedPage();
        LoggedPage loginPage = homePage.login(PropertiesContainer.get("test.login"), PropertiesContainer.get("test.password"));
        Assert.assertTrue(loginPage.getLOGOUT().isElementVisible());
    }

    @Test
    public void searchPostInFavorite() {
        UnLoggedPage homePage = new UnLoggedPage();
        LoggedPage loggedPage = homePage.login(PropertiesContainer.get("test.login"), PropertiesContainer.get("test.password"));

        List<PostPage> postPageList = new ArrayList<>();
        for (WebElement element:loggedPage.getALL_POSTS().getListOfElements()) {
            PostPage postPage = new PostPage(element);
            postPageList.add(postPage);
        }
        PostPage postForClick = postPageList.get(new Random().nextInt(postPageList.size()));
        String clickedPost = postForClick.getLINK_FOR_POST().getUrl();
        postForClick.getBUTTON_UP().click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        loggedPage.getFAVORITE().click();

        LoggedPage favoritePage = new LoggedPage();
        List<PostPage> favoritePageList = new ArrayList<>();
        for (WebElement element: favoritePage.getALL_POSTS().getListOfElements()) {
            PostPage postPage = new PostPage(element);
            favoritePageList.add(postPage);
        }

        Boolean assertCheck = false;
        for (PostPage pickedFavoritePost: favoritePageList) {
            String favoritePages = pickedFavoritePost.getLINK_FOR_POST().getUrl();
            if (clickedPost.equals(favoritePages)) {
                assertCheck = true;
                break;
            }
        }
        Assert.assertTrue(assertCheck);
    }
}

//проверить клавиатурные кнопки