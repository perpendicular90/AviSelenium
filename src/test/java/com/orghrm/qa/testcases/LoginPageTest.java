package com.orghrm.qa.testcases;

import com.orghrm.qa.base.BaseClass;
import com.orghrm.qa.pages.DashboardPage;
import com.orghrm.qa.pages.LoginPage;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class LoginPageTest extends BaseClass {
    LoginPage loginPage;
    DashboardPage dashboardPage ;

    public LoginPageTest() throws FileNotFoundException {
        super();
    }

    @BeforeMethod
    public void setup() throws FileNotFoundException {
        initialization();
        loginPage=new LoginPage();


    }
    @Test
    public void loginPageTitleTest(){
      String title=  loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"OrangeHRM");
    }
    @Test
    public void orghrmImage(){
        boolean flag=loginPage.validateOrgHrmImage();
        Assert.assertTrue(flag);
    }
    @Test
    public void loginTest() throws FileNotFoundException {
        dashboardPage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(8000);
        driver.quit();
    }

}
