package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {

        // Set the path to your ChromeDriver executable if not already in PATH
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the OrangeHRM login page
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            // Maximize browser window
            driver.manage().window().maximize();

            // Wait for page to load (basic wait)
            Thread.sleep(3000);

            // Locate username and password fields and input credentials
            WebElement usernameField = driver.findElement(By.name("username"));
            WebElement passwordField = driver.findElement(By.name("password"));

            usernameField.sendKeys("Admin");
            passwordField.sendKeys("admin123");

            // Locate and click the login button
            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
            loginButton.click();

            // Wait for navigation to dashboard
            Thread.sleep(5000);

            // Optional: Validate login success by checking URL or presence of dashboard element
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("/dashboard")) {
                System.out.println("Login successful. Navigated to Dashboard.");
            } else {
                System.out.println("Login failed. Still on login page.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
           // driver.quit();
        }
    }
}
