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

    public EditProfilePage() {
        name = TextControl.findTextByCss("#user_profile_name");
        bio = TextControl.findTextByCss("#user_profile_bio");
        company = TextControl.findTextByCss("#user_profile_company");
        uploadProfilePicture = ButtonControl.findButtonByCss("#upload-profile-picture");
        updateProfile = ButtonControl.findButtonByCss("button[type='submit'][class$='btn-primary']");
    }

    public EditProfilePage upDateProfile() {
        name.clear();
        name.sendKeys(PropertiesContainer.get("test.profileName"));
        bio.clear();
        bio.sendKeys(PropertiesContainer.get("test.profileBio"));
        company.clear();
        company.sendKeys(PropertiesContainer.get("test.profileCompany"));
        updateProfile.click();
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
        return new ProfilePage(true);
    }

}
