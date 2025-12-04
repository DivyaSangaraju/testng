package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class DemoTest {

    //test trigger
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup(); // Automatically manages ChromeDriver
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void testClickRegisterButton() {
        // Step 1: Navigate to the OpenCart Demo page
        driver.get("https://www.opencart.com/index.php?route=cms/demo");

        // Step 2: Wait for the "Register" button to be clickable
        // Wait for the Register button
        By registerLocator = By.cssSelector("a.btn.btn-black.navbar-btn");
        WebElement registerBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(registerLocator));
        wait.until(ExpectedConditions.elementToBeClickable(registerBtn));

        // Click using JS (more reliable)
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", registerBtn);

        // Wait for URL to change
        wait.until(ExpectedConditions.urlContains("route=account/register"));
        System.out.println("✅ Clicked Register and navigated!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
