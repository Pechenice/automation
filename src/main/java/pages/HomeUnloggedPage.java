package pages;

import controls.Button;
import org.testng.Assert;

public class HomeUnloggedPage extends BasePage {
    private Button button_SignIn() {return Button.byCss("a[href='/login']");}

    public LoginPage goToLoginPage() {
        button_SignIn().click();
        LoginPage loginPage = new LoginPage();
        try {
            loginPage.verifyLoginPage();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
        return loginPage;
    }

    protected void verifyHomeUnloggedPage() throws Exception {
        if (!button_SignIn().isElementClickable()) {
            throw new Exception("Sign In button is not clickable on Unlogged Home Page.");
        }
    }
}
