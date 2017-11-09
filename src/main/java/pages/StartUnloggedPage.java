package pages;

import controls.Button;

public class StartUnloggedPage extends BasePage {
    private Button button_SignIn() {return Button.byCss("a[href='/login']");}

    public LoginPage goToLoginPage() {
        button_SignIn().click();
        return new LoginPage();
    }
}
