package pages;

import controls.Button;
import controls.Text;
import core.PropertiesContainer;

public class IssueCreationPage extends BasePage{
    private Button button_Assignees() {
        return Button.byCss("button[aria-label^='Assign']");
    }
    private Button button_Labels() {
        return Button.byCss("button[aria-label^='Apply']");
    }
    private Text text_TitleField() {
        return Text.byCss("input[aria-label='Title']");
    }
    private Button button_SubmitNewIssue() {
        return Button.byCss(".form-actions button[type='submit']");
    }
    private Text text_DescriptionField() {
        return Text.byCss("#issue_body");
    }
    private Button button_CommentSubmit() {
        return Button.byCss("#partial-new-comment-form-actions button[type='submit']");
    }

    public void leaveCommentToUser(String toUser, String comment) {
        Text commentField = Text.byCss("#new_comment_field");
        commentField.sendKeys("@"+toUser +" "+ comment);
        button_CommentSubmit().click();
    }

    public void makeAssigneer(String nameOfAssigneer) {
        button_Assignees().click();
        Button selfAssign = Button.byCss("div[data-contents-url^='/glaaadis/'] div[role='menuitem']");
//        ButtonControl selfAssign = ButtonControl.findButtonByCss("div[data-contents-url^='/"+nameOfAssigneer+"/'] div[role='menuitem']");
        selfAssign.waitForElementVisible();
        selfAssign.moveAndClickElement();
        Button shutDownAssigneer = Button.byCss("div[data-contents-url^='/"+ PropertiesContainer.get("test.login")+"/'] svg[aria-label='Close'][class^='octicon']");
        shutDownAssigneer.moveAndClickElement();
    }

    public void markWithLabel() {
        button_Labels().click();
        Button bug = Button.byCss("div[data-name='bug']");
        bug.click();
        Button shutDownLabels = Button.byCss(".js-new-issue-labels-container svg[aria-label='Close'][class^='octicon']");
        shutDownLabels.click();
    }

    public IssuesPage fillTheIssue(String name, String description) {
        text_TitleField().sendKeys(name);
        text_DescriptionField().sendKeys(description);
        button_SubmitNewIssue().click();
        return new IssuesPage();
    }
}
