package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserPage {
    private final WebDriver driver;
    private  WebDriverWait wait;

    public UserPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isUserUrlLoaded(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4300/users/31"));
    }

    public String getUsername(){
        WebElement username = driver.findElement(By.tagName("h2"));
        return username.getText();
    }

    public void clickOnFollowwButtonForTestUserUserUserUser(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement followButtonTestUserUserUserUser = driver.findElement(By.xpath("//*[contains(text(),'Follow')]"));
        wait.until(ExpectedConditions.visibilityOf(followButtonTestUserUserUserUser));
        followButtonTestUserUserUserUser.click();
    }

    public void clickOnUnFollowwButtonForTestUserUserUserUser(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement unfollowButtonTestUserUserUserUser = driver.findElement(By.xpath("//*[contains(text(),'Unfollow')]"));
        wait.until(ExpectedConditions.visibilityOf(unfollowButtonTestUserUserUserUser));
        unfollowButtonTestUserUserUserUser.click();
    }
}
