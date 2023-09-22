package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try{
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            //Create a driver instance using WebDriver interface.
            //Navigate to the URL https://qaarticlehub.ccbp.tech/
            driver.get("https://qaarticlehub.ccbp.tech/");
            String parentWindowHandle = driver.getWindowHandle();
            //Click the article element.
            driver.findElement(By.className("article-container")).click();
            //Switch to the new tab.
            ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(newTab.get(1));

            //Print the article title.

            String articleTitle = driver.getTitle();
            System.out.println(articleTitle);

            //Print the article content.
            String articleContent = driver.findElement(By.className("article-content")).getText();
            System.out.println(articleContent);
            //Close the new tab.
            driver.close();
            //Quit the parent window.
            driver.quit();


        }catch(Exception e){
            System.out.println("Error Message of "+ e);
        }
    }
}