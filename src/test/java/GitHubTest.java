
import controls.Base;
import core.PropertiesContainer;
import core.TestBase;
import helpers.TestHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static helpers.TestHelper.stringGenerator;

public class GitHubTest extends TestBase{

    @Test
    public void logInTest() {
        StartLoggedPage startLoggedPage = new StartLoggedPage();
        Assert.assertEquals(startLoggedPage.getTitleText(), "GitHub", "Title is different.");
    }

    @Test
    public void createRepo() {
        RepoCreationPage repoCreationPagePage = new StartLoggedPage().goToRepoCreation();
        String repoName = stringGenerator("RepoName");
        RepoPage repoPage = repoCreationPagePage.createRepo(repoName);
        Assert.assertEquals(repoPage.getTitleText(), PropertiesContainer.get("test.login")+"/" + repoName, "Title is different.");

        deleteRepo(repoPage, repoName);
    }

    @Test
    public void updateProfile() {
        String profileName = stringGenerator("Unicorn");
        String profileBio = stringGenerator("Bio");
        String profileCompany = stringGenerator("Company");
        EditProfilePage editProfilePage = new StartLoggedPage().goToProfilePage().goToEditProfilePage();
        String pictureBeforeUpdate = editProfilePage.getImageChecker().getAttribute("src");
        editProfilePage = editProfilePage.upDateAvatar(new File("src/main/resources/unicorn.jpg").getAbsolutePath());
        String pictureAfterUpdate = editProfilePage.getImageChecker().getAttribute("src");
        ProfilePage profilePage = editProfilePage.upDateProfile(profileName, profileBio, profileCompany).goToProfileAfterUpdate();
        List<Base> listOfProfileInformation = profilePage.getProfileInformation();
        List<String> itemsText = new ArrayList<>();
        for(Base info: listOfProfileInformation) {
            itemsText.add(info.getText());
        }

        Assert.assertTrue(itemsText.contains(profileName), "Profile name is wrong.");
        Assert.assertTrue(itemsText.contains(profileBio), "Profile bio is absent.");
        Assert.assertTrue(itemsText.contains(profileCompany), "Profile company is absent.");
        Assert.assertTrue(!pictureAfterUpdate.equals(pictureBeforeUpdate), "Avatar picture was same, as previous one.");

        deleteProfileInfo(profilePage);
        }

        @Test
        public void issueNotification() throws Exception {
        RepoPage repoPage = new StartLoggedPage().goToRepoCreation().createRepo(PropertiesContainer.get("test.repositoryName"));
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


    private void deleteRepo(RepoPage repoPage, String repoName) {
        SettingsPage settingsPage = repoPage.goToSettings();
        settingsPage.deleteRepoButton().click();
        settingsPage.deleteRepo(repoName);
    }

    private void deleteProfileInfo(ProfilePage profilePage) {
        profilePage.goToEditProfilePage().upDateAvatar(new File("src/main/resources/no_unicorn.png").getAbsolutePath()).deleteAllInfoFromProfile();
    }
}

//IssueCreationPage - make labels dynamics