package com.fieldwire.util;

import com.fieldwire.base.Base;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends Base implements ITestListener {


    @Override
    public void onTestFailure(ITestResult result) {
        if(result.FAILURE==result.getStatus())
        try {
            CommonUtil.getScreenshot(driver);
        } catch (Exception e) {
            System.out.println("Test Case Failed" + e.getMessage());
        }

    }


    @Override
    public void onTestSuccess(ITestResult result) {
        if(result.SUCCESS==result.getStatus())
        try {
            CommonUtil.getScreenshot(driver);
        } catch (Exception e) {
            System.out.println("Test Case Passed" + e.getMessage());
        }

    }

}

