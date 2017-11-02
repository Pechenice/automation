package pages;

import controls.ButtonControl;

public class StartUnloggedPage extends BasePage {
    private ButtonControl signIn;

    public StartUnloggedPage() {
        signIn = ButtonControl.findButtonByCss("a[href='/login']");
    }

    public LoginPage goToLoginPage() {
        signIn.click();
        return new LoginPage();
    }
}
