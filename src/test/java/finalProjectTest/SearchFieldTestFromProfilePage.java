package finalProjectTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import object.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class SearchFieldTestFromProfilePage extends TestObject {

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

        header.clickProfileLink();

        ProfilePage profilePage = new ProfilePage(getDriver());
        Assert.assertTrue(profilePage.isUrlLoaded(),"The Profile URL is not correct!");
        String actualUsername = profilePage.getUsername();
        Assert.assertEquals(actualUsername,name,"Username is incorrect!");

        header.populateSearchField(dataForSearchField);
        header.checkDropDownWithUsers();

//        header.clickOnFollowButtonForTestUserUserUserUser();

//        header.clickOnUnfollowButtonForTestUserUserUserUser();

        header.clickOnTestUserUserUserUser();

        UserPage userPage = new UserPage(getDriver());
        Assert.assertTrue(userPage.isUserUrlLoaded(),"The Login URL is not correct!");
        String userNameTitle = userPage.getUsername();
        Assert.assertEquals(userNameTitle,"TestUserUserUserUser");

        userPage.clickOnFollowwButtonForTestUserUserUserUser();

        userPage.clickOnUnFollowwButtonForTestUserUserUserUser();


    }
}
