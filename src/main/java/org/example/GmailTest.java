package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class GmailTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void enterGmailID() {
        // Step 1: Open Gmail login page
        driver.get("https://accounts.google.com/signin/v2/identifier");

        // Step 2: Wait for email input field
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));

        // Step 3: Enter your Gmail ID
        String yourGmail = "divyacse1234@gmail.com";  // <-- Replace with your test email
        emailField.sendKeys(yourGmail);

        System.out.println("✅ Gmail ID entered: " + yourGmail);

        // (Optional) Click Next button
        WebElement nextBtn = driver.findElement(By.xpath("//span[text()='Next']/parent::button"));
        nextBtn.click();

        // Wait briefly to observe transition
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
      //  driver.quit();
    }
}

