package pages;

import controls.ButtonControl;
import controls.LinkControl;
import controls.TextControl;

public class EditProfilePage extends BasePage {
    private TextControl name;
    private TextControl bio;
    private TextControl company;
    private ButtonControl uploadProfilePicture;
    private ButtonControl updateProfile;
    private LinkControl goToProfileAfterUpdate;

    public EditProfilePage() {
        name = TextControl.findTextByCss("#user_profile_name");
        bio = TextControl.findTextByCss("#user_profile_bio");
        company = TextControl.findTextByCss("#user_profile_company");
        uploadProfilePicture = ButtonControl.findButtonByCss("#upload-profile-picture");
        updateProfile = ButtonControl.findButtonByCss("button[type='submit'][class$='btn-primary']");
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
        goToProfileAfterUpdate = LinkControl.findLinkByCss("button+a[href='/glaaadis']");
        goToProfileAfterUpdate.click();
        return new ProfilePage();
    }

}
