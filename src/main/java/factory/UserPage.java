package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserPage {
    private final WebDriver driver;
    public static final String PAGE_URL = "http://training.skillo-bg.com:4300/users/31";
    @FindBy(tagName = "h2")
    private WebElement username;
    @FindBy(xpath = "//*[contains(text(),'Follow')]")
    private WebElement followButtonTestUserUserUserUser;
    @FindBy(xpath = "//*[contains(text(),'Unfollow')]")
    private WebElement unfollowButtonTestUserUserUserUser;

    public UserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isUserUrlLoaded(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.urlContains(PAGE_URL));
    }

    public String getUsername(){
        return username.getText();
    }

    public void clickOnFollowButtonForTestUserUserUserUser(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(followButtonTestUserUserUserUser));
        followButtonTestUserUserUserUser.click();
    }

    public void clickOnUnFollowButtonForTestUserUserUserUser(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(unfollowButtonTestUserUserUserUser));
        unfollowButtonTestUserUserUserUser.click();
    }
}
