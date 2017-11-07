package pages;


import controls.ButtonControl;
import controls.TextControl;
import core.PropertiesContainer;

public class RepoPage extends BasePage {
    private ButtonControl settings;
    private ButtonControl watchButton = ButtonControl.findButtonByCss("a[href='/glaaadis/Gladiko/subscription']");
    private ButtonControl issues = ButtonControl.findButtonByCss("a[href='/glaaadis/Gladiko/issues']");
    public enum subscriptionTypes {Watch, UnWatch, Ignore}

    public RepoPage() {
//        title = TextControl.findTextByCss("h3>strong");
//        settings = ButtonControl.findButtonByCss("a[href='/"+ PropertiesContainer.get("test.login")+"/"+PropertiesContainer.get("test.repositoryName")+"/settings']");
//        watchButton = ButtonControl.findButtonByCss("a[href='/"+ PropertiesContainer.get("test.login")+"/"+PropertiesContainer.get("test.repositoryName")+"/subscription']");
//        issues = ButtonControl.findButtonByCss("a[href='/"+ PropertiesContainer.get("test.login")+"/"+PropertiesContainer.get("test.repositoryName")+"/issues']");
    }

    public SettingsPage goToSettings() {
        settings.click();
        return new SettingsPage();
    }

    public IssuesPage goToIssues() {
        issues.click();
        return new IssuesPage();
    }

    public void subscription(subscriptionTypes subscriptionTypes) {
        watchButton.click();
        switch (subscriptionTypes) {
            case Watch:
                ButtonControl watch = ButtonControl.findButtonByCss("input[value='subscribed']");
                watch.moveAndClickElement();
                break;
            case UnWatch:
                ButtonControl unWatch = ButtonControl.findButtonByCss("input[value='included']");
                unWatch.moveAndClickElement();
                break;
            case Ignore:
                ButtonControl ignore = ButtonControl.findButtonByCss("input[value='ignore']");
                ignore.moveAndClickElement();
                break;
            default:
                throw new IllegalStateException("Such type does not exist");
        }
    }

}
