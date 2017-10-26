package pages;

import controls.ButtonControl;
import controls.TextControl;

public class PikabuHomePage {

    private TextControl LOGIN_FIELD = TextControl.findTextByCss("input#username");
    private TextControl PASSWORD_FIELD = TextControl.findTextByCss("input#password");
    private ButtonControl SIGN_IN_BUTTON = ButtonControl.findButtonByCss("button.b-button.b-button_type_default");

    public void login(String login, String password) {
        LOGIN_FIELD.sendKeys(login);
        PASSWORD_FIELD.sendKeys(password);
        SIGN_IN_BUTTON.click();
    }
}
