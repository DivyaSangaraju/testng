package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.opencart.com/index.php?route=cms/demo");
        driver.manage().window().maximize();

        //name locator
       // driver.findElement(By.name("q")).sendKeys("mobiles");
        //id locator
      //  driver.findElement(By.id("nav-logo-sprites"));
        //link text[text between the <a> anchor tag]locator
      //  driver.findElement(By.linkText("Demo")).click();

        //partialLinkText

        driver.findElement(By.partialLinkText("Dem"));


    }
}