package pages;


import controls.Button;

public class RepoPage extends BasePage {
    private Button button_Settings() {return Button.byCss("a[data-selected-links$='settings']");}
    private Button button_NotificationsDropDown() {return Button.byCss("a[class$='js-menu-target']");}
    private Button button_Issues() {return Button.byCss("span a[href$='/issues']");}
    private Button button_Watch() {return Button.byXpath("//input[@value='subscribed']/..");}
    private Button button_UnWatch() {return Button.byXpath("//input[@value='included']/..");}
    private Button button_Ignore() {return Button.byCss("//input[@value='ignore']/..");}

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
        button_NotificationsDropDown().click();
        switch (subscriptionTypes) {
            case Watch: button_Watch().moveAndClickElement();
                break;
            case UnWatch: button_UnWatch().moveAndClickElement();
                break;
            case Ignore: button_Ignore().moveAndClickElement();
                break;
            default:
                throw new IllegalStateException("Such type does not exist");
        }
    }

}
