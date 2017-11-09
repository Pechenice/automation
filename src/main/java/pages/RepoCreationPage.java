package pages;

import controls.Button;
import controls.Link;
import controls.Text;

public class RepoCreationPage extends BasePage {
    private Button button_Owner() {return Button.byCss("div[class^='select-menu']>button[class^='btn'] div[class$='gravatar']");}
    private Text text_RepoName() {return Text.byCss("#repository_name");}
    private Text text_DescriptionField() {return Text.byCss("#repository_description");}
    private Button button_Submit() {return Button.byCss("button[type='submit'][class^='btn']");}
    private Link link_ValidationOfRepoName() {return Link.byCss("dl[class$='successed']");}

    public RepoPage createRepo(String repoNameInput) {
        return createRepo(repoNameInput, null);
    }

    public RepoPage createRepo(String repoNameInput, String description) {
        text_RepoName().sendKeys(repoNameInput);
        if (!(description ==null)) {
            text_DescriptionField().sendKeys(description);
        }
        link_ValidationOfRepoName().waitForElementPresent();
        button_Submit().click();
        return new RepoPage();
    }

}
