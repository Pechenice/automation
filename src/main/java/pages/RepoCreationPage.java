package pages;

import controls.Button;
import controls.Link;
import controls.Text;
import org.testng.Assert;

public class RepoCreationPage extends BasePage {
    private Button button_Owner() {return Button.byCss("div[class^='select-menu']>button[class^='btn'] div[class$='gravatar']");}
    private Text text_RepoName() {return Text.byCss("#repository_name");}
    private Text text_DescriptionField() {return Text.byCss("#repository_description");}
    private Button button_Submit() {return Button.byCss("button[type='submit'][class^='btn']");}
    private Link link_ValidationOfRepoName() {return Link.byCss("dl[class$='successed']");}

    public OpenedRepoPage createRepo(String repoNameInput) {
        return createRepo(repoNameInput, null);
    }

    public OpenedRepoPage createRepo(String repoNameInput, String description) {
        text_RepoName().sendKeys(repoNameInput);
        if (!(description ==null)) {
            text_DescriptionField().sendKeys(description);
        }
        link_ValidationOfRepoName().waitForElementPresent();
        button_Submit().click();
        OpenedRepoPage openedRepoPage = new OpenedRepoPage();
        try {
            openedRepoPage.verifyOpenedRepoPage();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
        return openedRepoPage;
    }
    protected void verifyRepoCreation() throws Exception {
        if (!button_Owner().isElementClickable()) {
            throw new Exception("Owner button is not clickable on Repository Creation Page");
        }
    }

}
