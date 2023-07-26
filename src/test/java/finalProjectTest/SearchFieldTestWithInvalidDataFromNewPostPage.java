package finalProjectTest;

import object.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchFieldTestWithInvalidDataFromNewPostPage extends TestObject{
    @DataProvider(name = "getUser")
    public Object[][] getUser() {
        return new Object[][]{{"test123489@gmail.com", "Abc123", "vesko201", "футбол€%*/;"}, //login with email
        };
    }

    @Test(dataProvider = "getUser")
    public void testSearchField(String user, String password, String name, String dataForSearchField) {
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
        Assert.assertTrue(newPostPage.isUrlLoaded(),"The Profile URL is not correct!");

        header.populateSearchField(dataForSearchField);
        Assert.assertFalse(header.isDropDownWithUsersVisible(),"The field is visible");
    }
}


