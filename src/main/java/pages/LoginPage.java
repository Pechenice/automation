package pages;

import controls.Button;
import controls.Link;
import controls.Text;

public class LoginPage extends BasePage {
    private Text text_LoginField() {return Text.byCss("#login_field");}
    private Text text_PasswordField() {return Text.byCss("#password");}
    private Button button_SignIn() {return Button.byCss("input[name='commit']");}
    private Button button_ForgotPassword() {return Button.byCss(".label-link");}
    private Link link_CreateNewAccount() {return Link.byCss("a[href='/join?source=login']");}

    public StartLoggedPage logIn(String login, String password) {
        text_LoginField().sendKeys(login);
        text_PasswordField().sendKeys(password);
        button_SignIn().click();
        return new StartLoggedPage();
    }

}
