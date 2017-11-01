package pages;

import controls.ButtonControl;
import controls.TextControl;
import core.PropertiesContainer;

public class RepoPage {
    private TextControl title;
    private ButtonControl settings;

    public RepoPage() {
        title = TextControl.findTextByCss("h3>strong");
        settings = ButtonControl.findButtonByCss("a[href='/"+ PropertiesContainer.get("test.login")+"/"+PropertiesContainer.get("test.repositoryName")+"/settings']");
    }

    public String getTitle() {
        return title.getText();
    }

    public SettingsPage goToSettings() {
        settings.click();
        return new SettingsPage();
    }

}
