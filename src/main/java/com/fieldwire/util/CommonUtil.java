package com.fieldwire.util;

import com.fieldwire.base.Base;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Listeners(com.fieldwire.util.Listeners.class)

public class CommonUtil extends Base {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;
    WebDriverWait wait;
    public static String randomFirstName() {
        String s = RandomStringUtils.randomAlphabetic(8);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String firstname = RandomStringUtils.random(8, alphabet);
        return firstname;
    }

    public static String randomLastName() {
        String s = RandomStringUtils.randomAlphabetic(8);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String lastname = RandomStringUtils.random(8, alphabet);
        return lastname;
    }


    public static String randomEmail() {
        Random rand = new Random();
        int num = rand.nextInt(1000);
        String email = "test" + num + "@" + "gmail.com";
        return email;
    }

    public static String randomPassword() {
        Random rand = new Random();
        int num = rand.nextInt(1000);
        String password = "test" + num + "@" + "123$";
        return password;
    }


    public static void getScreenshot(WebDriver driver) throws IOException {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {

            FileUtils.copyFile(scrFile, new File(
                    System.getProperty("user.dir") + "/src/main/java/com/fieldwire/Screenshots/" + "FieldWire_" + currentDateTime() + ".png"));
        } catch (IOException e) {
            System.out.println("Unable to Capture Screenshot");

        }

    }


    public static String currentDateTime() {

        DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date currentdate = new Date();
        return customformat.format(currentdate);

    }


    public static void visibilityOfElement( WebElement element, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
    }


    public static void sendKeys( WebElement element, int timeout, String value) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

    public static void clickOn(WebElement element, int timeout){

     new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
        element.click();

    }

    public static void selectDropdownValue(WebElement element, String valuetobeselected){

        WebElement company = element;
        List<WebElement> values = company.findElements(By.tagName("option"));
        for(WebElement value : values){
            if(value.getText().equals(valuetobeselected)){
                value.click();
                break;
            }

        }

    }



}
