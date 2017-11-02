package pages;

import controls.ButtonControl;
import controls.TextControl;

public class SettingsPage extends BasePage {
    private ButtonControl deleteRepoButton;
    private TextControl repoNameForConfirmationPopup;
    private ButtonControl deleteFromConfirmationPopup;

    public SettingsPage() {
        deleteRepoButton = ButtonControl.findButtonByCss("button[data-facebox='#delete_repo_confirm']");
    }

    public ButtonControl deleteRepoButton() {
        return deleteRepoButton;
    }

    public StartLoggedPage deleteRepo(String repoName) {
        repoNameForConfirmationPopup = TextControl.findTextByCss(".facebox-popup input[type='text']");
        deleteFromConfirmationPopup = ButtonControl.findButtonByCss(".facebox-popup button[type='submit']");
        repoNameForConfirmationPopup.sendKeys(repoName);
        deleteFromConfirmationPopup.click();
        return new StartLoggedPage();
    }
}
