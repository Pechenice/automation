package pages;

import controls.Button;
import controls.Link;
import controls.Text;
import core.PropertiesContainer;

public class EditProfilePage extends BasePage {
    private Text text_Name() {return Text.byCss("#user_profile_name");}
    private Text text_Bio() {return Text.byCss("#user_profile_bio");}
    private Text text_Company() {return Text.byCss("#user_profile_company");}
    private Button button_uploadProfilePicture() {return Button.byCss("#upload-profile-picture");}
    private Button button_UpdateProfile(){return Button.byCss("button[type='submit'][class$='btn-primary']");}
    private Link link_ImageChecker() {return Link.byCss("img[class$='rounded-2']");}
    private Link link_GoToProfileAfterUpdate(){return Link.byCss("button+a[href='/"+ PropertiesContainer.get("test.login")+"']");}

    public EditProfilePage upDateProfile(String name, String bio, String company) {
        this.text_Name().clear();
        this.text_Name().sendKeys(name);
        this.text_Bio().clear();
        this.text_Bio().sendKeys(bio);
        this.text_Company().clear();
        this.text_Company().sendKeys(company);
        button_UpdateProfile().click();
        return new EditProfilePage();
    }

    public EditProfilePage upDateAvatar(String pass) {
        button_uploadProfilePicture().sendKeys(pass);
        Button.byCss("button[type='submit'][value='save']").click();
        return new EditProfilePage();
    }

    public EditProfilePage deleteAllInfoFromProfile() {
        text_Name().clear();
        text_Bio().clear();
        text_Company().clear();
        button_UpdateProfile().click();
        return new EditProfilePage();
    }

    public ProfilePage goToProfileAfterUpdate() {
        link_GoToProfileAfterUpdate().click();
        return new ProfilePage();
    }

    public Link getImageChecker() {
        return link_ImageChecker();
    }
}
