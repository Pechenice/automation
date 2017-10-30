package pages;

import controls.ButtonControl;
import controls.LinkControl;
import controls.PostControl;

public class LoggedPage extends BasePage{

    private final ButtonControl LOGOUT = ButtonControl.findButtonByClassName("b-user-menu__logout");
    private final LinkControl FAVORITE = LinkControl.findLinkByXpath("//a[@href='/index.php?cmd=interested']");

    public ButtonControl getLOGOUT() {
        return LOGOUT;
    }

    public LinkControl getFAVORITE() {
        return FAVORITE;
    }
}
