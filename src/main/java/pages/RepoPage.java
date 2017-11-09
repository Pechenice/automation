package pages;


import controls.Button;
import controls.Text;
import core.PropertiesContainer;

public class RepoPage extends BasePage {
    private Button button_Settings() {return Button.byCss("a[data-selected-links$='settings']");}
    private Button button_Watch() {return Button.byCss("a[class$='js-menu-target']");}
    private Button button_Issues() {return Button.byCss("a[href$='/issues/new'][class^='btn']");}
    public enum subscriptionTypes {Watch, UnWatch, Ignore}

    public SettingsPage goToSettings() {
        button_Settings().click();
        return new SettingsPage();
    }

    public IssuesPage goToIssues() {
        button_Issues().click();
        return new IssuesPage();
    }

    public void subscription(subscriptionTypes subscriptionTypes) {
        button_Watch().click();
        switch (subscriptionTypes) {
            case Watch:
                Button watch = Button.byXpath("//input[@value='subscribed']/..");
                watch.moveAndClickElement();
                break;
            case UnWatch:
                Button unWatch = Button.byXpath("//input[@value='included']/..");
                unWatch.moveAndClickElement();
                break;
            case Ignore:
                Button ignore = Button.byCss("//input[@value='ignore']/..");
                ignore.moveAndClickElement();
                break;
            default:
                throw new IllegalStateException("Such type does not exist");
        }
    }

}
