package pages;

import controls.Base;
import controls.Button;
import controls.Text;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

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
        try {
            return Text.byCss("span[class^='p-name']");
        } catch (NoSuchElementException exp) {
            return null;
        }
    }
    private Button button_ChangeAvatar() {
        return Button.byCss("a[href='/account'][aria-label^='Change']");
    }
    private Text text_ProfileBio() {
        try {
            return Text.byCss("div[class^='p-note']>div");
        } catch (NoSuchElementException exp) {
            return null;
        }
    }
    private Text text_ProfileCompany() {
        try {
            return Text.byCss("span[class='p-org']>div");
        } catch (NoSuchElementException exp) {
            return null;
        }
    }
    private Text text_WhenUserJoined() {return Text.byCss("li[aria-label^='Member'][aria-label$='since']");}

    public ProfilePage() {
        isProfileEmpty = !Text.byCss("span[class^='p-name']").isElementVisible();
    }

    public EditProfilePage goToEditProfilePage() {
        button_ChangeAvatar().click();
        EditProfilePage editProfilePage = new EditProfilePage();
        try {
            editProfilePage.verifyEditProfile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
        return editProfilePage;
    }

    public List<Base> getProfileInformation() {
        List<Base> listOfProfileInfo = new ArrayList<>();
        if (text_ProfileName() != null) {
            listOfProfileInfo.add(text_ProfileName());
        }
        if (text_ProfileBio() != null) {
            listOfProfileInfo.add(text_ProfileBio());
        }
        if (text_ProfileCompany()!= null) {
            listOfProfileInfo.add(text_ProfileCompany());
        }
        return listOfProfileInfo;
    }

    protected void verifyProfile() throws Exception {
        if (!text_WhenUserJoined().isElementVisible()) {
            throw new Exception("Text field with information about when user joined is not Visible in Profile Page");
        }
    }
}
