package pages;

import controls.BaseControl;
import controls.ButtonControl;
import controls.TextControl;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.List;

public class ProfilePage extends BasePage {
    private Boolean isProfileEmpty;

    public ProfilePage() {
        isProfileEmpty = !TextControl.findTextByCss("span[class^='p-name']").isElementVisible();
    }

    public ButtonControl getEditemptyProfile() {
        if (isProfileEmpty) {
            return ButtonControl.findButtonByCss("a[href='/account'][class$='mb-3']");
        } else throw new IllegalStateException();
    }

    public TextControl getProfileName() {
        if (!isProfileEmpty) {
            return TextControl.findTextByCss("span[class^='p-name']");
        } else throw new IllegalStateException();
    }

    public ButtonControl getChangeAvatar() {
        return ButtonControl.findButtonByCss("a[href='/account'][aria-label^='Change']");
    }

    public TextControl getProfileBio() {
        try {
            return TextControl.findTextByCss("div[class^='p-note']>div");
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public TextControl getProfileCompany() {
        try {
            return TextControl.findTextByCss("span[class='p-org']>div");
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public EditProfilePage goToEditProfilePage() {
        getChangeAvatar().click();
        return new EditProfilePage();
    }

    public List<BaseControl> getProfileInformation() {
        List<BaseControl> listOfProfileInfo = new ArrayList<>();
        listOfProfileInfo.add(getProfileName());
        listOfProfileInfo.add(getProfileBio());
        listOfProfileInfo.add(getProfileCompany());
        return listOfProfileInfo;
    }
}
