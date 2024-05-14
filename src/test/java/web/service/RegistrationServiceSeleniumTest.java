package web.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationServiceSeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("file:C:\\Users\\INTEL\\OneDrive\\Documents\\2024T1\\Software Quality and Testing\\Week 8\\pages\\register.html");
        sleep(5);
    }

    @Test
    public void testRegistrationSuccess() {
        register("Seth", "Johnson", "seth@example.com", "2000-01-01");
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains("{\"status\": \"success\"}"));
    }

    @Test
    public void testRegistrationFailureEmptyFields() {
        register("", "", "", "");
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains("{\"status\": \"fail\"}"));
    }

    @Test
    public void testRegistrationFailureInvalidEmail() {
        register("Seth", "Johnson", "invalid-email", "2000-01-01");
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains("{\"status\": \"fail\"}"));
    }

    @Test
    public void testRegistrationFailureMissingFirstName() {
        register("", "Johnson", "seth@example.com", "2000-01-01");
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains("{\"status\": \"fail\"}"));
    }

    @Test
    public void testRegistrationFailureMissingLastName() {
        register("Seth", "", "seth@example.com", "2000-01-01");
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains("{\"status\": \"fail\"}"));
    }

    @Test
    public void testRegistrationFailureMissingEmail() {
        register("Seth", "Johnson", "", "2000-01-01");
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains("{\"status\": \"fail\"}"));
    }

    @Test
    public void testRegistrationFailureMissingDob() {
        register("Seth", "Johnson", "seth@example.com", "");
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains("{\"status\": \"fail\"}"));
    }

    // Helper method to perform registration
    private void register(String fname, String lname, String email, String dob) {
        WebElement fnameElement = driver.findElement(By.id("fname"));
        fnameElement.clear();
        fnameElement.sendKeys(fname);

        WebElement lnameElement = driver.findElement(By.id("lname"));
        lnameElement.clear();
        lnameElement.sendKeys(lname);

        WebElement emailElement = driver.findElement(By.id("email"));
        emailElement.clear();
        emailElement.sendKeys(email);

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
