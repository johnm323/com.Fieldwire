/*Module Name : Create SignUp Module
Date: 1 Nov 2022
Summary: Validates Create Account Scenario*/


package com.fieldwire.testcases;

import com.fieldwire.base.Base;
import com.fieldwire.pages.SignUpPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest extends Base {

    SignUpPage signuppage;

    public SignUpTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        signuppage = new SignUpPage();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(groups={"regression", "smoke"})
    public void CreateAccount(){
        signuppage.createaccountTest();

    }


}
