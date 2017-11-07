package pages;

import controls.ButtonControl;
import controls.TextControl;
import core.PropertiesContainer;

public class IssueCreationPage extends BasePage{

    private ButtonControl getAssignees() {
        return ButtonControl.findButtonByCss("button[aria-label^='Assign']");
    }

    private ButtonControl getLabels() {
        return ButtonControl.findButtonByCss("button[aria-label^='Apply']");
    }

    private TextControl getTitleField() {
        return TextControl.findTextByCss("input[aria-label='Title']");
    }

    private ButtonControl getSubmitNewIssue() {
        return ButtonControl.findButtonByCss(".form-actions button[type='submit']");
    }

    private TextControl getDescriptionField() {
        return TextControl.findTextByCss("#issue_body");
    }

    private ButtonControl getCommentSubmit() {
        return ButtonControl.findButtonByCss("#partial-new-comment-form-actions button[type='submit']");
    }

    public void leaveCommentToUser(String toUser, String comment) {
        TextControl commentField = TextControl.findTextByCss("#new_comment_field");
        commentField.sendKeys("@"+toUser +" "+ comment);
        getCommentSubmit().click();
    }

    public void makeAssigneer(String nameOfAssigneer) {
        getAssignees().click();
        ButtonControl selfAssign = ButtonControl.findButtonByCss("div[data-contents-url^='/glaaadis/'] div[role='menuitem']");
//        ButtonControl selfAssign = ButtonControl.findButtonByCss("div[data-contents-url^='/"+nameOfAssigneer+"/'] div[role='menuitem']");
        selfAssign.waitForElementVisible();
        selfAssign.moveAndClickElement();
        ButtonControl shutDownAssigneer = ButtonControl.findButtonByCss("div[data-contents-url^='/"+ PropertiesContainer.get("test.login")+"/'] svg[aria-label='Close'][class^='octicon']");
        shutDownAssigneer.moveAndClickElement();
    }

    public void markWithLabel() {
        getLabels().click();
        ButtonControl bug = ButtonControl.findButtonByCss("div[data-name='bug']");
        bug.click();
        ButtonControl shutDownLabels = ButtonControl.findButtonByCss(".js-new-issue-labels-container svg[aria-label='Close'][class^='octicon']");
        shutDownLabels.click();
    }

    public IssuesPage fillTheIssue(String name, String description) {
        getTitleField().sendKeys(name);
        getDescriptionField().sendKeys(description);
        getSubmitNewIssue().click();
        return new IssuesPage();
    }
}
