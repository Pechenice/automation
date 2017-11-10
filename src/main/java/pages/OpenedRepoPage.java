package pages;

import controls.Button;
import org.testng.Assert;

public class OpenedRepoPage extends BasePage {
    private Button button_Settings() {return Button.byCss("a[data-selected-links$='settings']");}
    private Button button_NotificationsDropDown() {return Button.byCss("a[class$='js-menu-target']");}
    private Button button_Issues() {return Button.byCss("span a[href$='/issues']");}
    private Button button_Watch() {return Button.byXpath("//input[@value='subscribed']/..");}
    private Button button_UnWatch() {return Button.byXpath("//input[@value='included']/..");}
    private Button button_Ignore() {return Button.byCss("//input[@value='ignore']/..");}
    private Button button_SetUpInDesktop() {return Button.byCss("a[href='https://desktop.github.com']");}

    public enum subscriptionTypes {Watch, UnWatch, Ignore}

    public SettingsPage goToSettings() {
        button_Settings().click();
        SettingsPage settingsPage = new SettingsPage();
        try {
            settingsPage.verifySettings();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
        return settingsPage;
    }

    public IssuesPage goToIssues() {
        button_Issues().click();
        IssuesPage issuesPage = new IssuesPage();
        try {
            issuesPage.verifyIssuePage();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
        return issuesPage;
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

    protected void verifyOpenedRepoPage() throws Exception {
        if (!button_SetUpInDesktop().isElementClickable()) {
            throw new Exception("Set up in Desktop button is not clickable on opened certain Repository Page.");
        }
    }

}
