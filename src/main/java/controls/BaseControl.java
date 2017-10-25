package controls;

import core.Driver;
import core.PropertiesContainer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseControl {
    protected WebElement element;
    protected By by;

    public void click () {
        element.click();
    }

    public void waitForElement() {
//        new WebDriverWait(Driver.get(), Long.parseLong(PropertiesContainer.get("test.timeout"))).until(ExpectedConditions.presenceOfElementLocated(by));
//        if () {
//            return true;
//        } else return false;
    }

    public void waitForVisability () {

    }

    public void waitForInvisible() {

    }

    public void elementIsClickable () {

    }

    public void elementIsPresent() {

    }

    public void elementIsNotPresent () {
}
}
