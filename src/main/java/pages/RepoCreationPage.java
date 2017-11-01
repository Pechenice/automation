package pages;

import controls.ButtonControl;
import controls.LinkControl;
import controls.TextControl;

public class RepoCreationPage {
    private ButtonControl owner;
    private TextControl repoName;
    private TextControl descriptionField;
    private ButtonControl submitButton;
    private LinkControl validationOfRepoName;

    public RepoCreationPage() {
        owner = ButtonControl.findButtonByCss("div[class^='select-menu']>button[class^='btn'] div[class$='gravatar']");
        repoName = TextControl.findTextByCss("#repository_name");
        descriptionField = TextControl.findTextByCss("#repository_description");
        submitButton = ButtonControl.findButtonByCss("button[type='submit'][class^='btn']");
    }

    public RepoPage createRepo(String repoNameInput) {
        return createRepo(repoNameInput, null);
    }

    public RepoPage createRepo(String repoNameInput, String description) {
        repoName.sendKeys(repoNameInput);
        if (!(description ==null)) {
            descriptionField.sendKeys(description);
        }
        validationOfRepoName = LinkControl.findLinkByCss("dl[class$='successed']");
        validationOfRepoName.waitForElementPresent();
        submitButton.click();
        return new RepoPage();
    }

}
