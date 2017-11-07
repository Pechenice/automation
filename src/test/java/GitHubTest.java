
import controls.BaseControl;
import core.Driver;
import core.PropertiesContainer;
import core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GitHubTest extends TestBase{

    public StartLoggedPage logIn(String userLogin, String userPassword) {
        StartUnloggedPage startUnloggedPagePage = new StartUnloggedPage();
        return startUnloggedPagePage.goToLoginPage().logIn(userLogin, userPassword);
    }

    @Test
    public void logInTest() {
        StartLoggedPage startLoggedPage = logIn(PropertiesContainer.get("test.login"), PropertiesContainer.get("test.password"));
        Assert.assertEquals(startLoggedPage.getTitleText(), "GitHub");
    }

    @Test
    public void createRepo() {
        StartLoggedPage startLoggedPage = logIn(PropertiesContainer.get("test.login"), PropertiesContainer.get("test.password"));
        RepoCreationPage repoCreationPagePage = startLoggedPage.goToRepoCreation();
        RepoPage repoPage = repoCreationPagePage.createRepo(PropertiesContainer.get("test.repositoryName"));
        Assert.assertEquals(repoPage.getTitleText(), "Quick setup");

        deleteRepo(repoPage);
    }

    @Test
    public void updateProfile() {
        StartLoggedPage startLoggedPage = logIn(PropertiesContainer.get("test.login"), PropertiesContainer.get("test.password"));
        EditProfilePage editProfilePage = startLoggedPage.goToProfilePage().goToEditProfilePage();
        String pictureBeforeUpdate = editProfilePage.getImageChecker().getAttribute("src");
        editProfilePage = editProfilePage.upDateAvatar(new File("src/main/resources/unicorn.jpg").getAbsolutePath());
        String pictureAfterUpdate = editProfilePage.getImageChecker().getAttribute("src");
        ProfilePage profilePage = editProfilePage.upDateProfile(
                PropertiesContainer.get("test.profileName"),
                PropertiesContainer.get("test.profileBio"),
                PropertiesContainer.get("test.profileCompany")).goToProfileAfterUpdate();
        List<BaseControl> listOfProfileInformation = profilePage.getProfileInformation();
        List<String> itemsText = new ArrayList<>();
        for(BaseControl info: listOfProfileInformation) {
            itemsText.add(info.getText());
        }
        List<String> propertiesTexts = new ArrayList<>();
        propertiesTexts.add(PropertiesContainer.get("test.profileName"));
        propertiesTexts.add(PropertiesContainer.get("test.profileBio"));
        propertiesTexts.add(PropertiesContainer.get("test.profileCompany"));

        Assert.assertTrue(itemsText.containsAll(propertiesTexts));
        Assert.assertTrue(!pictureAfterUpdate.equals(pictureBeforeUpdate));

        deleteProfileInfo(profilePage);
        }

        @Test
        public void issueNotification() throws Exception {
        StartLoggedPage startLoggedPage = logIn(PropertiesContainer.get("test.login"),PropertiesContainer.get("test.password"));
//        RepoCreationPage repoCreationPagePage = startLoggedPage.goToRepoCreation();
//        RepoPage repoPage = repoCreationPagePage.createRepo(PropertiesContainer.get("test.repositoryName"));
         Driver.get().get("https://github.com/glaaadis/Gladiko");
            RepoPage repoPage = new RepoPage();
                    repoPage.subscription(RepoPage.subscriptionTypes.Watch);

            IssueCreationPage issueCreationPage = repoPage.goToIssues().goToIssueCreation();
            issueCreationPage.makeAssigneer(PropertiesContainer.get("test.login"));
            issueCreationPage.markWithLabel();
            IssuesPage issuesPage = issueCreationPage.fillTheIssue(PropertiesContainer.get("test.issueCreationTitle"), PropertiesContainer.get("test.issueCreationDescription"));
            String createdIssueUrl = issuesPage.getCurrentUrl();
            StartLoggedPage loggedPage = new StartLoggedPage().signOut().goToLoginPage().logIn(PropertiesContainer.get("test.otherlogin"),PropertiesContainer.get("test.otherpassword"));
//            loggedPage.search(PropertiesContainer.get("test.repositoryName"));
            List<SearchResultPage> searchResults = loggedPage.search("Gladiko").resultsOfSearch();
            SearchResultPage resultPage = null;
            for (SearchResultPage searchResult: searchResults) {
                String link = searchResult.getSearches().getAttribute("href");
                if (link.equals("https://github.com/glaaadis/Gladiko")) {
//                if (link.equals("https://github.com/"+PropertiesContainer.get("test.login")+"/"+PropertiesContainer.get("test.repositoryName"))) {
                    resultPage = searchResult;
                    break;
                }
            }
            if (resultPage == null) {
                throw new Exception("Searched element wasn't found");
            }
            resultPage.getSearches().click();
            RepoPage anotherRepoPage = new RepoPage();
            List<IssuesPage> listOfIssuesPage = new ArrayList<>();
//            anotherRepoPage.goToIssues();
//            IssuesPage issuesPage1 = anotherRepoPage.goToIssues().getCreatedIssues();
            listOfIssuesPage = anotherRepoPage.goToIssues().getCreatedIssues();
            IssuesPage foundedIssuePage = null;
            for (IssuesPage onePage: listOfIssuesPage) {
                String issueUrl = onePage.getSearchResult().getAttribute("href");
                if (issueUrl.equals(createdIssueUrl)) {
                    foundedIssuePage = onePage;
                    break;
                }
            }
            foundedIssuePage.getSearchResult().click();
            IssueCreationPage openedIssue = new IssueCreationPage();
            openedIssue.leaveCommentToUser(PropertiesContainer.get("test.login"), PropertiesContainer.get("test.comment"));

            // remove issues from story
            // make find all issues
            // watch it doesn't work correctly
        }


    private void deleteRepo(RepoPage repoPage) {
        SettingsPage settingsPage = repoPage.goToSettings();
        settingsPage.deleteRepoButton().click();
        settingsPage.deleteRepo(PropertiesContainer.get("test.repositoryName"));
    }

    private void deleteProfileInfo(ProfilePage profilePage) {
        profilePage.goToEditProfilePage().upDateAvatar(new File("src/main/resources/no_unicorn.png").getAbsolutePath()).deleteAllInfoFromProfile();
    }
}

//RepoPage - переинициализирует title (29 of code)
//EditProfilePage - upDateProfile - поддержка нескольких вариаций данных

//IssueCreationPage - make labels dynamics
//RepoPage, IssuePage - make correct init of elements