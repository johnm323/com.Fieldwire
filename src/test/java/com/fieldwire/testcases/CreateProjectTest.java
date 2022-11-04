/*Module Name : Create Project Module
Date: 2 Nov 2022
Summary: Creates Projects, Deletes Projects, Validates Overlimit of Project Creation*/



package com.fieldwire.testcases;

import com.fieldwire.base.Base;
import com.fieldwire.pages.HomePage;
import com.fieldwire.pages.LoginPage;
import com.fieldwire.pages.SignUpPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateProjectTest extends Base {

    HomePage homepage;
    SignUpPage signuppage;
    LoginPage loginpage;


    public CreateProjectTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        homepage = new HomePage();
        signuppage = new SignUpPage();
        loginpage = new LoginPage();

    }


    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test(groups={"smoke"})
    public void validateCreateProject(){
        loginpage.loginTest();
        homepage.createProjectTest();

    }

    @Test(groups={"smoke"})
    public void validateDeleteProject() {
        loginpage.loginTest();
        homepage.deleteProjectTest();
    }

    @Test(groups={"regression"})
    public void validateCreateAndDeleteProject(){

        loginpage.loginTest();
        homepage.createProjectTest();
        homepage.deleteAfterCreatingProjectTest();
    }
    @Test(groups={"smoke"})
    public void validateOverTheLimitProjectCreation(){

        loginpage.loginWithOverTheLimitUser();
        homepage.createProjectOverTheLimit();
    }

}
