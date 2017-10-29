package controls;

import core.Driver;
import core.PropertiesContainer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseControl {
    protected WebElement element;
    protected By by;

    public BaseControl(By byInput) {
        by = byInput;
        element = Driver.get().findElement(by);
    }

    public void click() {
        element.click();
    }

    public void waitForElementPresent() {
        new WebDriverWait(Driver.get(), Long.parseLong(PropertiesContainer.get("test.timeout"))).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver input) {
                return input.findElements(by).size() > 0;
            }
        });
    }

    public BaseControl waitForElementVisible() {
        new WebDriverWait(Driver.get(), Integer.parseInt(PropertiesContainer.get("test.timeout"))).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver input) {return input.findElement(by).isDisplayed(); }
        });
        return this;
    }

    public Boolean isElementVisible() {
        return element.isDisplayed();
    }

    public Boolean isElementClickable() {
        return element.isEnabled();
    }

    public Boolean isElementPresent() {
        return Driver.get().findElements(by).size() > 0;
    }

    public Boolean isElementNotPresent() {
        return Driver.get().findElements(by).size() == 0;
    }
}