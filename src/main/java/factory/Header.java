package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
    private final WebDriver driver;
    private  WebDriverWait wait;
    @FindBy(id="nav-link-login")
    private WebElement loginLink;
    @FindBy(id="nav-link-profile")
    private WebElement profileLink;
    @FindBy(id="search-bar")
    private WebElement searchField;
    @FindBy(xpath="//div[@class='dropdown-container']")
    private WebElement dropDownWithUsers;
    @FindBy(xpath="//*[contains(text(),'TestUserUserUserUser')]")
    private WebElement testUserUserUserUser;
    @FindBy(id="nav-link-new-post")
    private WebElement postLink;
    public Header(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }
    public void clickLogin(){
        loginLink.click();
    }

    public void clickProfileLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(profileLink));
        profileLink.click();
    }

    public void populateSearchField(String dataForSearchField) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        searchField.sendKeys(dataForSearchField);
    }
    public void checkDropDownWithUsers() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(dropDownWithUsers));
    }
    public void clickOnTestUserUserUserUser() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(testUserUserUserUser));
        testUserUserUserUser.click();
    }
    public void clickNewPost() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        postLink.click();
    }
    public boolean isSearchFieldVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search-bar")));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public boolean isDropDownWithUsersVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dropdown-container']")));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
