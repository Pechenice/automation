package pages;

import controls.TextControl;

import org.openqa.selenium.By;
import static core.Locators.*;
import static helpers.FinderOfElements.*;

public class PikabuHomePage {

    private TextControl loginField = TextControl.findTextByLocator("PikabuHomePage.loginField");
    private TextControl passwordField = TextControl.findTextByLocator("PikabuHomePage.passwordField");
    private static By signInButton = get("PiPikabuHomePage.signInButton");

    public void login(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        findElement(signInButton).click();
    }
}
