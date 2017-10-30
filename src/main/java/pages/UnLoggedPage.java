package pages;

import controls.ButtonControl;
import controls.TextControl;

public class UnLoggedPage extends BasePage{

    private final TextControl LOGIN_FIELD = TextControl.findTextByCss("input#username");
    private final TextControl PASSWORD_FIELD = TextControl.findTextByCss("input#password");
    private final ButtonControl SIGN_IN_BUTTON = ButtonControl.findButtonByCss("button.b-button.b-button_type_default");

    public LoggedPage login(String login, String password) {
        LOGIN_FIELD.sendKeys(login);
        PASSWORD_FIELD.sendKeys(password);
        SIGN_IN_BUTTON.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LoggedPage();
    }

    public TextControl getFailToLogin() {
        return TextControl.findTextByClassName("b-sign__error-message");
    }

}
