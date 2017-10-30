package pages;

import controls.ButtonControl;
import controls.PostControl;
import core.Driver;
import core.PropertiesContainer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private PostControl ALL_POSTS = PostControl.findElementsByClassName("story");
//    private WebElement TITLE;
    private final ButtonControl CONTROL_BUTTON = ButtonControl.findButtonByCss("div.b-navigator");

//    public static void waitForTitlePresent() {
//        new WebDriverWait(Driver.get(), Long.parseLong(PropertiesContainer.get("test.timeout"))).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver input) {
//                return input.findElements(by).size() > 0;
//            }
//        });
//    }
    public PostControl getALL_POSTS() {
        return ALL_POSTS;
    }
}
