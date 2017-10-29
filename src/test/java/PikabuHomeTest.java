import core.PropertiesContainer;
import core.TestBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginHomePage;
import pages.PikabuHomePage;

public class PikabuHomeTest extends TestBase {

    @Test
    public static void enterSiteFail() {
        PikabuHomePage homePage = new PikabuHomePage();
        homePage.login(PropertiesContainer.get("test.login"), "12345Password_Incorrect");
        Assert.assertTrue(homePage.getFailToLogin().waitForElementVisible().isElementVisible());
    }

    @Test
    public static void enterSiteSuccess() {
        PikabuHomePage homePage = new PikabuHomePage();
        LoginHomePage loginPage = homePage.login(PropertiesContainer.get("test.login"), PropertiesContainer.get("test.password"));
        Assert.assertTrue(loginPage.getLOGOUT().isElementVisible());
    }
}

//добавь ассерты
//    добавь в избранное рандомный пост
//или просто оценку вверз поставь
//и найти этот пост в списке рейтнутыз в менюшке юзера
//
//проверить клавиатурные кнопки