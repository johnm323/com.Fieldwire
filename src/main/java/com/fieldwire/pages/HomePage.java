package com.fieldwire.pages;

import com.fieldwire.base.Base;
import com.fieldwire.util.AssertConst;
import com.fieldwire.util.CommonUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage extends Base {

    CommonUtil commonUtil;
    String actual_URL;
//Page Factory - OR

    @FindBy(name="name")
    WebElement projectName;

    @FindBy(name="code")
    WebElement projectCode;

    @FindBy(xpath="//*[@class=\"new-project pointer relative-pos project-card\"]")
    WebElement newProject;

    @FindBy(xpath="//*[@class=\"fw-button fw-button-primary\"]")
    WebElement createProjectButton;

    @FindBy(xpath="//*[@class=\"new-project-image\"]")
    WebElement newProjectImagePresent;

    @FindBy(xpath="//*[@class=\"center ng-scope\"]")
    WebElement newProjectHeader;

    @FindBy(xpath="//*[@class=\"close-modal\"]")
    WebElement closePlanOverlay;

    @FindBy(xpath="//*[@class=\"fw-icon fw-icon-dots-vertical\"]")
    List<WebElement> allElements;

    @FindBy(xpath="//*[@class=\"pre-wrap ng-scope\"]")
    WebElement getProjectName;


    @FindBy(xpath="//form/label/strong")
    WebElement projectNameToDelete;


    @FindBy(name="input")
    WebElement enterProjectNameToDelete;

    @FindBy(xpath="//*[contains(text(),'Delete')]")
    WebElement deleteButton;


    @FindBy(xpath="//div[@class=\"modal-footer\"]/fw-button[@label='Delete']/button")
    WebElement confirmDeleteButton;

    @FindBy(xpath="//*[contains(text(),'Sign out')]")
    WebElement signOut;

    @FindBy(xpath="//*[@data-e2e='profile-menu']")
    WebElement profileDropdown;

    @FindBy(xpath="//*[@translate=\"ACCOUNT_LOCKED\"]")
    WebElement accountLocked;

    @FindBy(xpath="//*[@class=\"center ng-binding\"]")
    WebElement uploadYourPlanHeader;

    @FindBy(xpath="//span[contains(@class,'project-name')]")
    WebElement getProjectTitle;

    @FindBy(xpath="//*[@class=\"truncate\"]")
    WebElement clickOnHomeIcon;

    @FindBy(xpath="//div[@class=\"modal-header\"]/h1")
    WebElement overTheLimitTitle;

    @FindBy(xpath="//div[@class=\"center modal-body\"]/div")
    WebElement overTheLimitDescription;

    @FindBy(xpath="//*[@class=\"fw-button fw-button-primary\"]")
    WebElement upgradeButton;



    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    public void clickOnNewProject(){
        try{
            CommonUtil.clickOn(newProject, 10);
        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void enterProjectName(String projectname){
        try{
            CommonUtil.sendKeys(projectName, 10, projectname );
        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void enterProjectCode(String projectcode){
        try{
            CommonUtil.sendKeys(projectCode, 10, projectcode );
        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }


    public void clickOnCreateProjectButton(){
        try{
            CommonUtil.clickOn(createProjectButton, 10);
        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void closePlanOverlay(){
        try{
            CommonUtil.clickOn(closePlanOverlay, 10);
        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void clickOnProjectMenuDots(){
        try{
            CommonUtil.clickOn(newProject, 10);
        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void clickOnProjectProfile(){
        try{
            CommonUtil.clickOn(profileDropdown, 10);
        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void clickOnSignOut(){
        try{
            CommonUtil.clickOn(signOut, 10);
            Assert.assertEquals(accountLocked.getText(), AssertConst.Account_locked);
        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void clickOnUpgradeButton(){
        try{
            CommonUtil.clickOn(upgradeButton,10);
            actual_URL = driver.getCurrentUrl();
            Assert.assertEquals(AssertConst.Pricing_Expected_URL, actual_URL);
        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }


    public void verifyOverTimeLimitTitleAndDescription(){
        try{
            CommonUtil.visibilityOfElement(overTheLimitTitle,10);
            Assert.assertEquals(AssertConst.Over_The_Limit_Title, overTheLimitTitle.getText());
            CommonUtil.visibilityOfElement(overTheLimitDescription,10);
            Assert.assertEquals(AssertConst.Over_The_Limit_Description, overTheLimitDescription.getText());

        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void createProjectTest(){
        try{
            clickOnNewProject();
            enterProjectName(excel.getStringData(0, 3, 1));
            enterProjectCode(excel.getStringData(0, 3, 2));
            clickOnCreateProjectButton();
            Thread.sleep(2000);
            Assert.assertEquals(AssertConst.Upload_Your_Plan_Header, uploadYourPlanHeader.getText());
            Thread.sleep(2000);
            closePlanOverlay();
            Assert.assertTrue(getProjectTitle.isDisplayed());
        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }


    public void createProjectOverTheLimit(){
        try{
            clickOnNewProject();
            enterProjectName(excel.getStringData(0, 3, 1));
            enterProjectCode(excel.getStringData(0, 3, 2));
            clickOnCreateProjectButton();
            Thread.sleep(2000);
            verifyOverTimeLimitTitleAndDescription();
            Thread.sleep(2000);
            clickOnUpgradeButton();
        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }


    public void SignOutTest(){
        try{
            clickOnProjectProfile();
            clickOnSignOut();
        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }


    public void deleteProjectTest(){
        try{
            CommonUtil.clickOn(allElements.get(0), 10);
            CommonUtil.clickOn(deleteButton, 10);
            CommonUtil.visibilityOfElement(enterProjectNameToDelete,10);
            CommonUtil.sendKeys(enterProjectNameToDelete, 10, projectNameToDelete.getText());
            CommonUtil.clickOn(confirmDeleteButton, 10);
        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void deleteAfterCreatingProjectTest(){
        try{
            CommonUtil.clickOn(getProjectTitle,10);
            CommonUtil.clickOn(clickOnHomeIcon,10);
            CommonUtil.clickOn(allElements.get(0), 10);
            CommonUtil.clickOn(deleteButton, 10);
            CommonUtil.visibilityOfElement(enterProjectNameToDelete,10);
            CommonUtil.sendKeys(enterProjectNameToDelete, 10, projectNameToDelete.getText());
            CommonUtil.clickOn(confirmDeleteButton, 10);
        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }


}
