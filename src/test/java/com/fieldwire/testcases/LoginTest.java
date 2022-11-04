/*Module Name : Create Login Module
Date: 1 Nov 2022
Summary: Validates Valid and Invalid Login Scenarios and Sign Out Scenario*/


package com.fieldwire.testcases;

import com.fieldwire.base.Base;
import com.fieldwire.pages.HomePage;
import com.fieldwire.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Base {
    LoginPage loginpage;
    HomePage homepage;


    public LoginTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginpage = new LoginPage();
        homepage = new HomePage();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();

    }

    //  @Test(retryAnalyzer=com.fieldwire.util.RetryAnalyzer.class)


    @Test(groups = {"smoke"})
    public void validateLogin() {
        loginpage.loginTest();
    }


    @Test(groups = {"regression"})
    public void validateSignOut() {
        loginpage.loginTest();
        homepage.SignOutTest();
        loginpage.getTextForAccountLockedValidation();
    }


    @Test(groups = {"smoke"})
    public void validateLoginWithInvalidCredentails() {
        loginpage.loginWithIncorrectUserCredentails();
    }


}
