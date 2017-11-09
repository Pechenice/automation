package pages;

import controls.Button;
import controls.Text;

public class SettingsPage extends BasePage {
    private Button button_DeleteRepo() {return Button.byCss("button[data-facebox='#delete_repo_confirm']");}
    private Text text_RepoNameForConfirmationPopup() {return Text.byCss(".facebox-popup input[type='text']");}
    private Button button_DeleteFromConfirmationPopup() {return Button.byCss(".facebox-popup button[type='submit']");}

    public Button deleteRepoButton() {
        return button_DeleteRepo();
    }

    public StartLoggedPage deleteRepo(String repoName) {
        text_RepoNameForConfirmationPopup().sendKeys(repoName);
        button_DeleteFromConfirmationPopup().click();
        return new StartLoggedPage();
    }
}
