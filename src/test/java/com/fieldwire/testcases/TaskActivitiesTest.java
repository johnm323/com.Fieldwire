/*Module Name : Task Creation Module
Date: 4 Nov 2022
Summary: Validates Task Creation*/



package com.fieldwire.testcases;

import com.fieldwire.base.Base;
import com.fieldwire.pages.HomePage;
import com.fieldwire.pages.LoginPage;
import com.fieldwire.pages.SignUpPage;
import com.fieldwire.pages.TasksPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskActivitiesTest extends Base {

    HomePage homepage;
    SignUpPage signuppage;
    LoginPage loginpage;
    TasksPage taskpage;

    public TaskActivitiesTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        homepage = new HomePage();
        signuppage = new SignUpPage();
        loginpage = new LoginPage();
        taskpage = new TasksPage();

    }


    @AfterMethod
    public void tearDown(){
        driver.close();
    }


    @Test(groups={"regression"})
    public void validateCreateTaskAfterSignUp(){
        signuppage.createaccountTest();
        homepage.createProjectTest();
        taskpage.createTaskTest();
    }



}
