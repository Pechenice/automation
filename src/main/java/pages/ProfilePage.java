package pages;

import controls.BaseControl;
import controls.ButtonControl;
import controls.TextControl;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.List;

public class ProfilePage extends BasePage {
    private TextControl profileName;
    private TextControl profileBio;
    private TextControl profileCompany;
    private ButtonControl changeAvatar;
    private ButtonControl editEmptyProfile;
    private Boolean isProfileEmpty;

    public ProfilePage() {
        if (!TextControl.findTextByCss("span[class^='p-name']").isElementVisible()){
            editEmptyProfile = ButtonControl.findButtonByCss("a[href='/account'][class$='mb-3']");
            changeAvatar = ButtonControl.findButtonByCss("a[href='/account'][aria-label^='Change']");
            isProfileEmpty = true;
        } else {
            profileName = TextControl.findTextByCss("span[class^='p-name']");
            changeAvatar = ButtonControl.findButtonByCss("a[href='/account'][aria-label^='Change']");
            isProfileEmpty = false;
        }
        try {
            profileBio = TextControl.findTextByCss("div[class^='p-note']>div");
        } catch (NoSuchElementException exp) {
        }

        try {
            profileCompany = TextControl.findTextByCss("span[class='p-org']>div");
        } catch (NoSuchElementException exp) {
        }
    }

    public EditProfilePage goToEditProfilePage() {
        changeAvatar.click();
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
