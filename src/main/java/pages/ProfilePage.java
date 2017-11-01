package pages;

import controls.BaseControl;
import controls.ButtonControl;
import controls.TextControl;

import java.util.ArrayList;
import java.util.List;

public class ProfilePage {
    private ButtonControl editProfile;
    private TextControl profileName;
    private TextControl profileBio;
    private TextControl profileCompany;

    public ProfilePage() {
        editProfile = ButtonControl.findButtonByCss("a[href='/account']");
        profileName = TextControl.findTextByCss("span[class^='p-name']");
        profileBio = TextControl.findTextByCss("div[class^='p-note']>div");
        profileCompany = TextControl.findTextByCss("a[href='https://github.com/company']");
    }

    public EditProfilePage goToEditProfilePage() {
        editProfile.click();
        return new EditProfilePage();
    }

    public List<BaseControl> getProfileInformation() {
        List<BaseControl> listOfProfileInfo = new ArrayList<>();
        listOfProfileInfo.add(profileName);
        listOfProfileInfo.add(profileBio);
        listOfProfileInfo.add(profileCompany);
        return listOfProfileInfo;
    }

}
