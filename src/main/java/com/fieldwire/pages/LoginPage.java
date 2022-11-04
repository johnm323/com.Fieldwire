package com.fieldwire.pages;

import com.fieldwire.base.Base;
import com.fieldwire.util.CommonUtil;
import com.fieldwire.util.AssertConst;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends Base {

    String currentUrl;
    CommonUtil commonUtil;
//Page Factory - OR

    @FindBy(id="email-input")
    WebElement userName;

    @FindBy(xpath="//*[@class='fw-button fw-button-primary']")
    WebElement nextButton;

    @FindBy(xpath="//*[@id=\"password-input\"]")
    WebElement passWord;

    @FindBy(xpath="//*[@class='fw-button fw-button-primary']")
    WebElement loginButton;

    @FindBy(xpath="//*[@translate=\"ACCOUNT_LOCKED\"]")
    WebElement accountLocked;

    @FindBy(xpath="//*[contains(text(),'Invalid email or password.')]")
    WebElement loginError;

    @FindBy(xpath="//*[@data-e2e='profile-menu']")
    WebElement profileDropdown;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }


    public void enterUsername(String username){
       try{
           CommonUtil.sendKeys(userName, 10, username );
       }catch(Exception e){
          System.out.println("Unable to find element" + e.getMessage());
       }

    }

    public void enterPassword(String enterpassword){
        try{
            CommonUtil.sendKeys(passWord, 10, enterpassword );
        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }


    public void clickOnNextButton(){
        try{
            CommonUtil.clickOn(nextButton, 10);
        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void clickOnLoginButton(){
        try{
            loginButton.click();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void visibilityOfProfileNameInHomeScreen(){
        try{
            loginButton.click();
            commonUtil.visibilityOfElement(profileDropdown,10);
            currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(AssertConst.HomePage_Expected_URL, currentUrl);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void getTextForAccountLockedValidation(){
            Assert.assertEquals(accountLocked.getText(), AssertConst.Account_locked);
    }


    public void loginTest(){
        try{
            enterUsername(prop.getProperty("username"));
            Assert.assertTrue(nextButton.isEnabled());
            clickOnNextButton();
            enterPassword(prop.getProperty("password"));
            Assert.assertTrue(loginButton.isEnabled());
            clickOnLoginButton();
            visibilityOfProfileNameInHomeScreen();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void loginWithOverTheLimitUser(){
        try{
            enterUsername(excel.getStringData(0,4,1));
            Assert.assertTrue(nextButton.isEnabled());
            clickOnNextButton();
            enterPassword(excel.getStringData(0,4,2));
            Assert.assertTrue(loginButton.isEnabled());
            clickOnLoginButton();
            visibilityOfProfileNameInHomeScreen();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void loginWithIncorrectUserCredentails(){
        try{
            enterUsername(excel.getStringData(0, 2, 1));
            Assert.assertTrue(nextButton.isEnabled());
            clickOnNextButton();
            enterPassword(excel.getStringData(0, 2, 2));
            Assert.assertTrue(loginButton.isEnabled());
            clickOnLoginButton();
            Assert.assertTrue(loginError.getText().contains(AssertConst.Login_Error_Message));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


}
