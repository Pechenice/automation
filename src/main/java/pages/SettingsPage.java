package pages;

import controls.Button;
import controls.Text;
import org.testng.Assert;

public class SettingsPage extends BasePage {
    private Button button_DeleteRepo() {return Button.byCss("button[data-facebox='#delete_repo_confirm']");}
    private Text text_RepoNameForConfirmationPopup() {return Text.byCss(".facebox-popup input[type='text']");}
    private Button button_DeleteFromConfirmationPopup() {return Button.byCss(".facebox-popup button[type='submit']");}

    public Button deleteRepoButton() {
        return button_DeleteRepo();
    }

    public HomeLoggedPage deleteRepo(String repoName) {
        text_RepoNameForConfirmationPopup().sendKeys(repoName);
        button_DeleteFromConfirmationPopup().click();
        HomeLoggedPage homeLoggedPage = new HomeLoggedPage();
        try {
            homeLoggedPage.verifyHomeLoggedPage();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
        return homeLoggedPage;
    }

    protected void verifySettings() throws Exception {
        if (!button_DeleteRepo().isElementClickable()) {
            throw new Exception("Delete this repository button is not clickable on Settings page.");
        }
    }
}
