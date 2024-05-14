package web.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("file:C:\\Users\\INTEL\\OneDrive\\Documents\\2024T1\\Software Quality and Testing\\Week 8\\pages/login.html");
        sleep(5);
    }

    @Test
    public void testLoginSuccess() {
        // Test login with valid credentials
        login("ahsan", "ahsan_pass", "01/01/2002");
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains("Login Status: Success"));
    }

    @Test
    public void testLoginFailureInvalidCredentials() {
        // Test login with invalid credentials
    	login("invalid_user", "invalid_password", "01/01/2002");
    	String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains("Login Status: Fail"));
    }

    @Test
    public void testLoginFailureInvalidDOB() {
        // Test login with invalid date of birth
    	login("ahsan", "ahsan_pass", "01/01/2024");
    	String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains("Login Status: Fail"));
    }

    @Test
    public void testLoginFailureEmptyFields() {
        // Test login with empty fields
    	login("", "", "");
    	String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains("Login Status: Fail"));
    }

    // Helper method to perform login
    private void login(String username, String password, String dob) {
        WebElement usernameElement = driver.findElement(By.id("username"));
        usernameElement.clear();
        usernameElement.sendKeys(username);

        WebElement passwordElement = driver.findElement(By.id("passwd"));
        passwordElement.clear();
        passwordElement.sendKeys(password);

        WebElement dobElement = driver.findElement(By.id("dob"));
        dobElement.clear();
        dobElement.sendKeys(dob);

        WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
        submitButton.submit();

        sleep(5);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Helper method to sleep
    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
