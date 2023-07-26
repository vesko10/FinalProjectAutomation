package finalProjectTest;

import object.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class SearchFieldTestFromHomePage extends TestObject {

    @DataProvider(name = "getUser")
    public Object[][] getUser() {
        return new Object[][]{{"test123489@gmail.com", "Abc123", "vesko201","test1"}, //login with email
        };
    }

    @Test(dataProvider = "getUser")
    public void testSearchField(String user, String password, String name, String dataForSearchField) {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateTo();

        Header header = new Header(getDriver());
        header.clickLogin();

        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isUrlLoaded(),"The Login URL is not correct!");
        String signInText = loginPage.getSingInElementText();
        Assert.assertEquals(signInText,"Sign in");
        loginPage.populateUsername(user);
        loginPage.populatePassword(password);
        loginPage.clickSignIn();
        Assert.assertTrue(homePage.isUrlLoaded(),"The Home URL is not correct!");

        header.populateSearchField(dataForSearchField);
        header.checkDropDownWithUsers();


        header.clickOnTestUserUserUserUser();

        UserPage userPage = new UserPage(getDriver());
        Assert.assertTrue(userPage.isUserUrlLoaded(),"The Login URL is not correct!");
        String userNameTitle = userPage.getUsername();
        Assert.assertEquals(userNameTitle,"TestUserUserUserUser");

        userPage.clickOnFollowButtonForTestUserUserUserUser();

        userPage.clickOnUnFollowButtonForTestUserUserUserUser();


    }
}


