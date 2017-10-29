import java.util.ArrayList;
import java.util.List;

import core.Driver;
import core.PropertiesContainer;
import core.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginHomePage;
import pages.PikabuHomePage;
import pages.PostPage;

public class PikabuTest extends TestBase {

    @Test
    public void enterSiteFail() {
        PikabuHomePage homePage = new PikabuHomePage();
        homePage.login(PropertiesContainer.get("test.login"), "12345Password_Incorrect");
//        Assert.assertTrue(homePage.getFailToLogin().waitForElementVisible().isElementVisible());
    }

    @Test
    public void enterSiteSuccess() {
        PikabuHomePage homePage = new PikabuHomePage();
        LoginHomePage loginPage = homePage.login(PropertiesContainer.get("test.login"), PropertiesContainer.get("test.password"));
        Assert.assertTrue(loginPage.getLOGOUT().isElementVisible());
    }

    @Test
    public void searchPostInFavorite() {
        PikabuHomePage homePage = new PikabuHomePage();
        LoginHomePage loginHomePage = homePage.login(PropertiesContainer.get("test.login"), PropertiesContainer.get("test.password"));
        List<WebElement> postCollection = Driver.get().findElements(By.className("story"));
        List<PostPage> postPageList = new ArrayList<>();
        for (WebElement element:postCollection) {
            PostPage postPage = new PostPage(element);
            postPageList.add(postPage);
        }
        PostPage postForClick = postPageList.get(0);
        String clickedPost = postForClick.getLINK_FOR_POST().getUrl();
        postForClick.getBUTTON_UP().click();
        loginHomePage.getFAVORITE().click();

        List<WebElement> favoriteCollection = Driver.get().findElements(By.className("story"));
        List<PostPage> favoritePageList = new ArrayList<>();
        for (WebElement element: favoriteCollection) {
            PostPage postPage = new PostPage(element);
            favoritePageList.add(postPage);
        }

        Boolean assertCheck = false;
        for (PostPage favoritePage: favoritePageList) {
            String favoritePages = favoritePage.getLINK_FOR_POST().getUrl();
            if (clickedPost.equals(favoritePages)) {
                assertCheck = true;
                break;
            }
        }
        Assert.assertTrue(assertCheck);
    }
}

//    добавь в избранное рандомный пост
//или просто оценку вверх поставь
//и найти этот пост в списке рейтнутых в менюшке юзера
//
//проверить клавиатурные кнопки