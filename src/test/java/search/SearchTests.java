package search;

import object.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTests extends TestObject {

    @DataProvider(name = "getUser1")
    public Object[][] getUser1() {
        return new Object[][]{{"test123489@gmail.com", "Abc123", "vesko201", "test1"}, //login with email
        };
    }

    @DataProvider(name = "getUser2")
    public Object[][] getUser2() {
        return new Object[][]{{"test123489@gmail.com", "Abc123", "vesko201", "футбол€%*/;"}, //login with email
        };
    }

    @DataProvider(name = "getUser3")
    public Object[][] getUser3() {
        return new Object[][]{{"test123489@gmail.com", "Abc123", "test1"}, //login with email
        };
    }

    @DataProvider(name = "getUser4")
    public Object[][] getUser4() {
        return new Object[][]{{"test123489@gmail.com", "Abc123", "футбол€%*/;"}, //login with email
        };
    }

    @Test(dataProvider = "getUser3")
    public void testSearchFieldHomePage(String user, String password, String dataForSearchField) {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateTo();

        Header header = new Header(getDriver());
        header.clickLogin();

        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isUrlLoaded(), "The Login URL is not correct!");
        String signInText = loginPage.getSingInElementText();
        Assert.assertEquals(signInText, "Sign in");
        loginPage.populateUsername(user);
        loginPage.populatePassword(password);
        loginPage.clickSignIn();
        Assert.assertTrue(homePage.isUrlLoaded(), "The Home URL is not correct!");

        header.populateSearchField(dataForSearchField);
        header.checkDropDownWithUsers();


        header.clickOnTestUserUserUserUser();

        UserPage userPage = new UserPage(getDriver());
        Assert.assertTrue(userPage.isUserUrlLoaded(), "The Login URL is not correct!");
        String userNameTitle = userPage.getUsername();
        Assert.assertEquals(userNameTitle, "TestUserUserUserUser");

        userPage.clickOnFollowButtonForTestUserUserUserUser();

        userPage.clickOnUnFollowButtonForTestUserUserUserUser();
    }

    @Test(dataProvider = "getUser3")
    public void testSearchFieldNewPostPage(String user, String password, String dataForSearchField) {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateTo();

        Header header = new Header(getDriver());
        header.clickLogin();

        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isUrlLoaded(), "The Login URL is not correct!");
        String signInText = loginPage.getSingInElementText();
        Assert.assertEquals(signInText, "Sign in");
        loginPage.populateUsername(user);
        loginPage.populatePassword(password);
        loginPage.clickSignIn();
        Assert.assertTrue(homePage.isUrlLoaded(), "The Home URL is not correct!");

        header.clickNewPost();

        NewPostPage newPostPage = new NewPostPage(getDriver());
        Assert.assertTrue(newPostPage.isUrlLoaded(), "The Profile URL is not correct!");

        header.populateSearchField(dataForSearchField);
        header.checkDropDownWithUsers();

        header.clickOnTestUserUserUserUser();


        UserPage userPage = new UserPage(getDriver());
        Assert.assertTrue(userPage.isUserUrlLoaded(), "The Login URL is not correct!");
        String userNameTitle = userPage.getUsername();
        Assert.assertEquals(userNameTitle, "TestUserUserUserUser");
        userPage.clickOnFollowButtonForTestUserUserUserUser();
        userPage.clickOnUnFollowButtonForTestUserUserUserUser();
    }

    @Test(dataProvider = "getUser1")
    public void testSearchFieldProfilePage(String user, String password, String name, String dataForSearchField) {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateTo();

        Header header = new Header(getDriver());
        header.clickLogin();

        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isUrlLoaded(), "The Login URL is not correct!");
        String signInText = loginPage.getSingInElementText();
        Assert.assertEquals(signInText, "Sign in");
        loginPage.populateUsername(user);
        loginPage.populatePassword(password);
        loginPage.clickSignIn();
        Assert.assertTrue(homePage.isUrlLoaded(), "The Home URL is not correct!");

        header.clickProfileLink();

        ProfilePage profilePage = new ProfilePage(getDriver());
        Assert.assertTrue(profilePage.isUrlLoaded(), "The Profile URL is not correct!");
        String actualUsername = profilePage.getUsername();
        Assert.assertEquals(actualUsername, name, "Username is incorrect!");

        header.populateSearchField(dataForSearchField);
        header.checkDropDownWithUsers();

        header.clickOnTestUserUserUserUser();

        UserPage userPage = new UserPage(getDriver());
        Assert.assertTrue(userPage.isUserUrlLoaded(), "The Login URL is not correct!");
        String userNameTitle = userPage.getUsername();
        Assert.assertEquals(userNameTitle, "TestUserUserUserUser");

        userPage.clickOnFollowButtonForTestUserUserUserUser();

        userPage.clickOnUnFollowButtonForTestUserUserUserUser();
    }


    @Test(dataProvider = "getUser4")
    public void testSearchFieldHomePageNegative(String user, String password, String dataForSearchField) {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateTo();

        Header header = new Header(getDriver());
        header.clickLogin();

        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isUrlLoaded(), "The Login URL is not correct!");
        String signInText = loginPage.getSingInElementText();
        Assert.assertEquals(signInText, "Sign in");
        loginPage.populateUsername(user);
        loginPage.populatePassword(password);
        loginPage.clickSignIn();
        Assert.assertTrue(homePage.isUrlLoaded(), "The Home URL is not correct!");

        header.populateSearchField(dataForSearchField);
        Assert.assertFalse(header.isDropDownWithUsersVisible(), "The field is visible");
    }

    @Test(dataProvider = "getUser4")
    public void testSearchFieldNewPostPageNegative(String user, String password, String dataForSearchField) {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateTo();

        Header header = new Header(getDriver());
        header.clickLogin();

        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isUrlLoaded(), "The Login URL is not correct!");
        String signInText = loginPage.getSingInElementText();
        Assert.assertEquals(signInText, "Sign in");
        loginPage.populateUsername(user);
        loginPage.populatePassword(password);
        loginPage.clickSignIn();
        Assert.assertTrue(homePage.isUrlLoaded(), "The Home URL is not correct!");

        header.clickNewPost();

        NewPostPage newPostPage = new NewPostPage(getDriver());
        Assert.assertTrue(newPostPage.isUrlLoaded(), "The Profile URL is not correct!");

        header.populateSearchField(dataForSearchField);
        Assert.assertFalse(header.isDropDownWithUsersVisible(), "The field is visible");
    }

    @Test(dataProvider = "getUser2")
    public void testSearchFieldProfilePageNegative(String user, String password, String name, String dataForSearchField) {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateTo();

        Header header = new Header(getDriver());
        header.clickLogin();

        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isUrlLoaded(), "The Login URL is not correct!");
        String signInText = loginPage.getSingInElementText();
        Assert.assertEquals(signInText, "Sign in");
        loginPage.populateUsername(user);
        loginPage.populatePassword(password);
        loginPage.clickSignIn();
        Assert.assertTrue(homePage.isUrlLoaded(), "The Home URL is not correct!");

        header.clickProfileLink();

        ProfilePage profilePage = new ProfilePage(getDriver());
        Assert.assertTrue(profilePage.isUrlLoaded(), "The Profile URL is not correct!");
        String actualUsername = profilePage.getUsername();
        Assert.assertEquals(actualUsername, name, "Username is incorrect!");

        header.populateSearchField(dataForSearchField);
        Assert.assertFalse(header.isDropDownWithUsersVisible(), "The field is visible");
    }

    @Test
    public void testSearchFieldWithoutLogin() {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateTo();

        Header header = new Header(getDriver());
        Assert.assertFalse(header.isSearchFieldVisible(), "The field is visible");
    }
}
