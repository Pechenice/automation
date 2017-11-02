package pages;

import controls.BaseControl;
import controls.ButtonControl;
import controls.TextControl;

import java.util.ArrayList;
import java.util.List;

public class ProfilePage extends BasePage {
    private TextControl profileName;
    private TextControl profileBio;
    private TextControl profileCompany;
    private Boolean isProfileEmpty = false;
    private ButtonControl changeAvatar;
    private ButtonControl editEmptyProfile;

    public ProfilePage() {
        this(false);
    }

    public ProfilePage(Boolean isProfileEmpty) {
        this.isProfileEmpty = isProfileEmpty;
        if (!isProfileEmpty) {
            editEmptyProfile = ButtonControl.findButtonByCss("a[href='/account'][class$='mb-3']");
        } else {
            profileName = TextControl.findTextByCss("span[class^='p-name']");
            profileBio = TextControl.findTextByCss("div[class^='p-note']>div");
            profileCompany = TextControl.findTextByCss("span[class='p-org']>div");
            changeAvatar = ButtonControl.findButtonByCss("a[href='/account'][aria-label^='Change']");
        }
    }

    public EditProfilePage goToEmptyEditProfilePage() {
        editEmptyProfile.click();
        return new EditProfilePage();
    }

    public List<BaseControl> getProfileInformation() {
        List<BaseControl> listOfProfileInfo = new ArrayList<>();
        listOfProfileInfo.add(profileName);
        listOfProfileInfo.add(profileBio);
        listOfProfileInfo.add(profileCompany);
        return listOfProfileInfo;
    }

    public EditProfilePage goToEditProfilePage() {
        changeAvatar.click();
        return new EditProfilePage();
    }

}
