package pages;

import controls.Button;
import controls.Link;
import controls.Text;
import org.testng.Assert;

public class LoginPage extends BasePage {
    private Text text_LoginField() {return Text.byCss("#login_field");}
    private Text text_PasswordField() {return Text.byCss("#password");}
    private Button button_SignIn() {return Button.byCss("input[name='commit']");}
    private Button button_ForgotPassword() {return Button.byCss(".label-link");}
    private Link link_CreateNewAccount() {return Link.byCss("a[href='/join?source=login']");}

    public HomeLoggedPage logIn(String login, String password) {
        text_LoginField().sendKeys(login);
        text_PasswordField().sendKeys(password);
        button_SignIn().click();
        HomeLoggedPage homeLoggedPage = new HomeLoggedPage();
        try {
            homeLoggedPage.verifyHomeLoggedPage();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
        return homeLoggedPage;
    }

    protected void verifyLoginPage() throws Exception {
        if (!link_CreateNewAccount().isElementVisible()) {
            throw new Exception("Create an account link is absent on Login Page.");
        }
    }

}
