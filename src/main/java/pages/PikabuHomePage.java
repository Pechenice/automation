package pages;

import org.openqa.selenium.By;

import static core.Locators.*;
import static helpers.FinderOfElements.*;

public class PikabuHomePage {

    private static By loginField = get("PikabuHomePage.loginField");
    private static By passwordField = get("PikabuHomePage.passwordField");
    private static By signInButton = get("PiPikabuHomePage.signInButton");

    public static void login(String login, String password) {
        findElement(loginField).sendKeys(login);
        findElement(passwordField).sendKeys(password);
        findElement(signInButton).click();
    }
}
