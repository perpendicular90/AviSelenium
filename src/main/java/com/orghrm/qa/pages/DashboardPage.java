package com.orghrm.qa.pages;

import com.orghrm.qa.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class DashboardPage extends BaseClass {

    @FindBy(xpath = "//span[text()='My Info']")
    WebElement myInfo;
    @FindBy(xpath = "//span[text()='Admin']" )
    WebElement admin;
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    WebElement verifDashboard;




    public DashboardPage() throws FileNotFoundException {
        PageFactory.initElements(driver,this);

    }
    public String verifyTitle(){
        return verifDashboard.getText();
    }

    public MyInfoPage clickmyInfo() throws FileNotFoundException {
        myInfo.click();
        return new MyInfoPage();

    }
    public AdminPage clickAdmin() throws FileNotFoundException {
        admin.click();
        return new AdminPage();

    }

}
