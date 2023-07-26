package finalProjectTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import object.Header;
import object.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class SearchFieldTestWithoutLogin extends TestObject {

    @Test
    public void testSearchField() {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateTo();

        Header header = new Header(getDriver());
        Assert.assertFalse(header.isSearchFieldVisible(),"The field is visible");

    }
}
