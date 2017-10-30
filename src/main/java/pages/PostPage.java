package pages;

import controls.ButtonControl;
import controls.LinkControl;

import org.openqa.selenium.WebElement;

public class PostPage extends BasePage {

    private ButtonControl BUTTON_UP;
    private LinkControl LINK_FOR_POST;

    public PostPage(WebElement story) {
        BUTTON_UP = ButtonControl.findButtonByXpath(story, "//div[@class='story__rating-block']/div[@title='Поставить плюсик']");
        LINK_FOR_POST = LinkControl.findLinkByXpath(story, "//div[@class='story__header-title']/a");
    }

    public ButtonControl getBUTTON_UP() {
        return BUTTON_UP;
    }

    public LinkControl getLINK_FOR_POST() {
        return LINK_FOR_POST;
    }
}
