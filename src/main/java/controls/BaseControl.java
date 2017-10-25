package controls;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseControl {

    public static BaseControl click(By by) {
        return new BaseControl(Driver.get().findElement(by).click());
        WebElement element = Driver.get().findElement(by);
    }

    public static Boolean waitForElement(By by) {
        WebElement some = new WebDriverWait(Driver.get(), Long.parseLong(System.getProperty("test.timeouts"))).until(ExpectedConditions.presenceOfElementLocated(by)).size > 0;
        if (some != null) {
            return true;
        } else {
            return false;
        }

    }

    public static Boolean waitForVisability () {

        return true;
    }

    public static Boolean waitForInvisible() {
        return true;
    }

    public static Boolean elementIsClickable () {
        return true;
    }

    public static BaseControl elementIsPresent() {

    }

    public static BaseControl elementIsNotPresent () {
        return BaseControl();
    }
}
