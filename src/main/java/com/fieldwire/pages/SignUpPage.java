package com.fieldwire.pages;

import com.fieldwire.base.Base;
import com.fieldwire.util.CommonUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends Base {

    CommonUtil commonUtil;

    //Page Factory - OR

    @FindBy(xpath = "//*[@id=\"signup-link\"]/a")
    WebElement createAccountButton;

    @FindBy(id = "firstNameInput")
    WebElement firstName;

    @FindBy(id = "lastNameInput")
    WebElement lastName;

    @FindBy(id = "emailInput")
    WebElement email;

    @FindBy(id = "passwordInput")
    WebElement password;

    @FindBy(id = "explicitAgreement")
    WebElement checkBoxAgreement;

    @FindBy(xpath = "//*[@id=\"login\"]/form/fw-button/button")
    WebElement createAccount;

    @FindBy(id = "company")
    WebElement companyName;

    @FindBy(id = "companyType")
    WebElement companyType;

    @FindBy(id = "companySize")
    WebElement companySize;

    @FindBy(id = "phone")
    WebElement phoneNumber;

    @FindBy(xpath = "//*[@id='login']/form/fw-button/button/span")
    WebElement completeProfileButton;

//****************************Complete your profile

    @FindBy(id = "company")
    WebElement profileCompanyName;

    @FindBy(id = "companyType")
    WebElement selectCompanyType;

    @FindBy(id = "companySize")
    WebElement selectCompanySize;

    @FindBy(id = "phone")
    WebElement enterPhoneNumber;

    @FindBy(xpath = "//*[@id=\"login\"]/form/fw-button/button")
    WebElement clickOnCompleteButton;


    //**************************************************************************************************
    public SignUpPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterCompanyName(String companyname) {
        try {
            CommonUtil.sendKeys(companyName, 10, companyname);
        } catch (Exception e) {
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void selectCompanyType(String companytype) {
        try {
            CommonUtil.selectDropdownValue(selectCompanyType, companytype);
        } catch (Exception e) {
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void selectNumberofEmployee(String numberofemp) {
        try {
            CommonUtil.selectDropdownValue(selectCompanySize, numberofemp);
        } catch (Exception e) {
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void enterPhoneNumber(String phonenumber) {
        try {
            CommonUtil.sendKeys(enterPhoneNumber, 10, phonenumber);
        } catch (Exception e) {
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void clickCompleteButton() {
        try {
            CommonUtil.clickOn(clickOnCompleteButton, 10);
        } catch (Exception e) {
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void enterFirstName(String firstname) {
        try {
            CommonUtil.sendKeys(firstName, 10, firstname);
        } catch (Exception e) {
            System.out.println("Unable to find element" + e.getMessage());
        }

    }


    public void enterLastName(String lastname) {
        try {
            CommonUtil.sendKeys(lastName, 10, lastname);
        } catch (Exception e) {
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void enterEmailAddress(String emailaddress) {
        try {
            CommonUtil.sendKeys(email, 10, emailaddress);
        } catch (Exception e) {
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void createPassword(String createpassword) {
        try {
            CommonUtil.sendKeys(password, 10, createpassword);
        } catch (Exception e) {
            System.out.println("Unable to find element" + e.getMessage());
        }

    }


    public void clickOnAgreement() {
        try {
            CommonUtil.clickOn(checkBoxAgreement, 10);
        } catch (Exception e) {
            System.out.println("Unable to find element" + e.getMessage());
        }

    }


    public void clickCreateAccountButton() {
        try {
            CommonUtil.clickOn(createAccountButton, 10);
        } catch (Exception e) {
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void clickCreateButton() {
        try {
            CommonUtil.clickOn(createAccount, 10);
        } catch (Exception e) {
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void createaccountTest() {
        try {
            clickCreateAccountButton();
            enterFirstName(CommonUtil.randomFirstName());
            enterLastName(CommonUtil.randomLastName());
            enterEmailAddress(CommonUtil.randomEmail());
            createPassword(CommonUtil.randomPassword());
            clickOnAgreement();
            clickCreateButton();
            enterCompanyName(excel.getStringData(0, 1, 1));
            selectCompanyType(excel.getStringData(0, 1, 2));
            selectNumberofEmployee(excel.getStringData(0, 1, 3));
            enterPhoneNumber(excel.getStringData(0, 1, 4));
            clickCreateButton();
        } catch (Exception e) {
            System.out.println("Unable to find element" + e.getMessage());
        }

    }


}
