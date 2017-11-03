package pages;

import controls.ButtonControl;
import controls.LinkControl;
import controls.TextControl;
import core.PropertiesContainer;

public class EditProfilePage extends BasePage {
    private TextControl name;
    private TextControl bio;
    private TextControl company;
    private ButtonControl uploadProfilePicture;
    private ButtonControl updateProfile;
    private LinkControl goToProfileAfterUpdate;
    private LinkControl imageChecker;

    public EditProfilePage() {
        name = TextControl.findTextByCss("#user_profile_name");
        bio = TextControl.findTextByCss("#user_profile_bio");
        company = TextControl.findTextByCss("#user_profile_company");
        uploadProfilePicture = ButtonControl.findButtonByCss("#upload-profile-picture");
        updateProfile = ButtonControl.findButtonByCss("button[type='submit'][class$='btn-primary']");
        imageChecker = LinkControl.findLinkByCss("img[class$='rounded-2']");
    }

    public EditProfilePage upDateProfile(String name, String bio, String company) {
        this.name.clear();
        this.name.sendKeys(name);
        this.bio.clear();
        this.bio.sendKeys(bio);
        this.company.clear();
        this.company.sendKeys(company);
        updateProfile.click();
        return new EditProfilePage();
    }

    public EditProfilePage upDateAvatar(String pass) {
//        imageChecker = LinkControl.findLinkByCss("img[class$='rounded-2']");
        uploadProfilePicture.sendKeys(pass);
        ButtonControl.findButtonByCss("button[type='submit'][value='save']").click();
        return new EditProfilePage();
    }

    public EditProfilePage deleteAllInfoFromProfile() {
        name.clear();
        bio.clear();
        company.clear();
        updateProfile.click();
        return new EditProfilePage();
    }

    public ProfilePage goToProfileAfterUpdate() {
        goToProfileAfterUpdate = LinkControl.findLinkByCss("button+a[href='/"+ PropertiesContainer.get("test.login")+"']");
        goToProfileAfterUpdate.click();
        return new ProfilePage();
    }

    public LinkControl getImageChecker() {
        return imageChecker;
    }
}
