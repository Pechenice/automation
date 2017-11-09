package pages;

import controls.Base;
import controls.Button;
import controls.Text;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.List;

public class ProfilePage extends BasePage {
    private Boolean isProfileEmpty;
    private Button button_EditemptyProfile() {
        if (isProfileEmpty) {
            return Button.byCss("a[href='/account'][class$='mb-3']");
        } else throw new IllegalStateException();
    }
    private Text text_ProfileName() {
        if (!isProfileEmpty) {
            return Text.byCss("span[class^='p-name']");
        } else throw new IllegalStateException();
    }
    private Button button_ChangeAvatar() {
        return Button.byCss("a[href='/account'][aria-label^='Change']");
    }
    private Text button_ProfileBio() {
        try {
            return Text.byCss("div[class^='p-note']>div");
        } catch (NoSuchElementException e) {
            return null;
        }
    }
    private Text text_ProfileCompany() {
        try {
            return Text.byCss("span[class='p-org']>div");
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public ProfilePage() {
        isProfileEmpty = !Text.byCss("span[class^='p-name']").isElementVisible();
    }

    public EditProfilePage goToEditProfilePage() {
        button_ChangeAvatar().click();
        return new EditProfilePage();
    }

    public List<Base> getProfileInformation() {
        List<Base> listOfProfileInfo = new ArrayList<>();
        listOfProfileInfo.add(text_ProfileName());
        listOfProfileInfo.add(button_ProfileBio());
        listOfProfileInfo.add(text_ProfileCompany());
        return listOfProfileInfo;
    }
}
