package pages;

import controls.ButtonControl;
import controls.TextControl;

public class PikabuHomePage {

    private final TextControl LOGIN_FIELD = TextControl.findTextByCss("input#username");
    private final TextControl PASSWORD_FIELD = TextControl.findTextByCss("input#password");
    private final ButtonControl SIGN_IN_BUTTON = ButtonControl.findButtonByCss("button.b-button.b-button_type_default");
    private final ButtonControl CONTROL_BUTTON = ButtonControl.findButtonByCss("div.b-navigator");
    private final TextControl FAIL_TO_LOGIN_TEXT = TextControl.findTextByClassName("b-sign__error-message");

    public LoginHomePage login(String login, String password) {
        LOGIN_FIELD.sendKeys(login);
        PASSWORD_FIELD.sendKeys(password);
        SIGN_IN_BUTTON.click();
        return new LoginHomePage();
    }

    public TextControl getFailToLogin() {
        return FAIL_TO_LOGIN_TEXT;
    }

}
