package com.orghrm.qa.pages;

import com.orghrm.qa.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class LoginPage extends BaseClass {

    @FindBy(xpath = "//*[@name='username']")
    WebElement username;

    @FindBy(xpath = "//*[@name='password']")
    WebElement password;

    @FindBy(xpath = "//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
    WebElement loginbtn;

    @FindBy(xpath = "//*[@class='orangehrm-login-branding']")
    WebElement orghrmLogo;



    public LoginPage() throws FileNotFoundException {

        PageFactory.initElements(driver,this);

    }

    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateOrgHrmImage(){
        return orghrmLogo.isDisplayed();
    }

    public DashboardPage login(String un, String pw) throws FileNotFoundException {
        username.sendKeys(un);
        password.sendKeys(pw);
        loginbtn.click();

        return new DashboardPage();
    }
}
