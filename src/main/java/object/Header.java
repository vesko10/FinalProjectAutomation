package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
    private final WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogin() {
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();
    }

    public void clickProfileLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement profileLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-profile")));
        profileLink.click();
    }

    public void populateSearchField(String dataForSearchField) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.id("search-bar")));
        searchField.sendKeys(dataForSearchField);
    }

    public void checkDropDownWithUsers() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement dropDownWithUsers = driver.findElement(By.xpath("//div[@class='dropdown-container']"));
        wait.until(ExpectedConditions.visibilityOf(dropDownWithUsers));
    }

//    public void clickOnFollowButtonForTestUserUserUserUser() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//        WebElement followButtonTestUserUserUserUser = driver.findElement(By.xpath("(//button[@class='btn btn-primary ng-star-inserted'])[1]"));
//        wait.until(ExpectedConditions.visibilityOf(followButtonTestUserUserUserUser));
//        followButtonTestUserUserUserUser.click();
//    }

//    public void clickOnUnfollowButtonForTestUserUserUserUser() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//        WebElement unfollowButtonTestUserUserUserUser = driver.findElement(By.xpath("//*[contains(text(),'Unfollow')]"));
//        wait.until(ExpectedConditions.visibilityOf(unfollowButtonTestUserUserUserUser));
//        unfollowButtonTestUserUserUserUser.click();
//    }

    public void clickOnTestUserUserUserUser() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement testUserUserUserUser = driver.findElement(By.xpath("//*[contains(text(),'TestUserUserUserUser')]"));
        wait.until(ExpectedConditions.visibilityOf(testUserUserUserUser));
        testUserUserUserUser.click();
    }

    public void clickNewPost() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement postLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-new-post")));
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


