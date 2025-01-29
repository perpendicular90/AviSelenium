package com.orghrm.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class BaseClass {

    static WebDriver driver;
    static Properties prop;


    public BaseClass() throws FileNotFoundException {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\Users\\rahul\\OneDrive\\Desktop\\selenium\\sel1\\src\\main\\java\\com\\orghrm\\qa\\config\\config.properties");
            prop.load(ip);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void initialization() {

        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.getProperty("webDriver.chrome.driver", "C:\\Users\\rahul\\Downloads\\chromedriver-win64");
            driver = new ChromeDriver();

        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
}









