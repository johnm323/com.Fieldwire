package com.fieldwire.pages;

import com.fieldwire.base.Base;
import com.fieldwire.util.AssertConst;
import com.fieldwire.util.CommonUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TasksPage extends Base {

    CommonUtil commonUtil;

//Page Factory - OR
    @FindBy(xpath="//span[@data-e2e=\"task-edit-name\"]")
    WebElement editTaskName;

    @FindBy(xpath="//textarea[contains(@class,\"edit-task-name-input\")]")
    WebElement enterTaskName;

    @FindBy(xpath="//*[@data-e2e=\"task-edit-check\"]")
    WebElement acceptButton;

    @FindBy(xpath="//*[@ng-click=\"onTabSelect('Tasks')\"]")
    WebElement tasksOption;

    @FindBy(xpath="//*[contains(text(),'New task')]")
    WebElement newTask;

    @FindBy(xpath="//*[@class=\"close-modal\"]")
    WebElement closeTask;

    @FindBy(xpath="//div[contains(@class,\"truncate ng\")]")
    WebElement getTaskNameAfterCreatingTask;



    @FindBy(xpath="//*[@class=\"status-label ng-binding\"]")
    WebElement priority;




    public TasksPage() {
        PageFactory.initElements(driver, this);
    }


    public void clickOnTaskMenu(){
        try{
            CommonUtil.clickOn(tasksOption, 10);
        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void clickOnNewTask(){
        try{
            CommonUtil.clickOn(newTask, 10);
        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void clickOnEditTaskName(){
        try{
            CommonUtil.clickOn(editTaskName, 10);
        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void enterTaskName(){
        try{
            CommonUtil.sendKeys(enterTaskName, 10, excel.getStringData(0,5,1));
        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void acceptTaskName(){
        try{
            CommonUtil.clickOn(acceptButton, 10);
        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }

    public void closeTaskName(){
        try{
            CommonUtil.clickOn(closeTask, 10);
        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }


    public void createTaskTest(){
        try{
            clickOnTaskMenu();
            clickOnNewTask();
            clickOnEditTaskName();
            enterTaskName();
            acceptTaskName();
            closeTaskName();
            Assert.assertEquals(AssertConst.Get_TaskName_After_Creating_Task, getTaskNameAfterCreatingTask.getText());
        }catch(Exception e){
            System.out.println("Unable to find element" + e.getMessage());
        }

    }



}
