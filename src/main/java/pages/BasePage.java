package pages;

import core.Driver;

public class BasePage {
    public static String getTitle() {
        return Driver.get().getTitle();
    }
}
