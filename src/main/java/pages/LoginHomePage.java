package pages;

import controls.ButtonControl;

public class LoginHomePage extends PikabuHomePage {
    private final ButtonControl LOGOUT = ButtonControl.findButtonByClassName("b-user-menu__logout");

    public ButtonControl getLOGOUT() {
        return LOGOUT;
    }
}
