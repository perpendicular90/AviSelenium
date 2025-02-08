package com.orghrm.qa.testcases;

import com.orghrm.qa.base.BaseClass;
import com.orghrm.qa.pages.DashboardPage;
import com.orghrm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;


public class DashboardPageTest extends BaseClass {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    public DashboardPageTest() throws FileNotFoundException {
        super();
    }

    @BeforeMethod
    public void setup() throws FileNotFoundException {
        initialization();
        loginPage=new LoginPage();
        dashboardPage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));


    }

    @Test
    public void verifyDashboardPageTitleTest(){
        String dashboardTitle =dashboardPage.verifyTitle();
        Assert.assertEquals(dashboardTitle,"Dashboard", "Title not matched for Dashboard");


    }
    @Test
    public void validateMyinfo() throws FileNotFoundException {
        dashboardPage.clickmyInfo();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(8000);
        driver.quit();
    }





}
