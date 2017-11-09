package pages;

import controls.Text;
import core.Driver;

public class BasePage {

    private Text text_Title() { return Text.byCss("head title");}

    public String getTitleText() {
        return text_Title().getText();
    }

    public String getCurrentUrl() {
        return Driver.get().getCurrentUrl();
    }
}
