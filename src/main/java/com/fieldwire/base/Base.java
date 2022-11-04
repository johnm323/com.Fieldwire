package com.fieldwire.base;

import com.fieldwire.util.CommonUtil;
import com.fieldwire.util.ExcelDataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver driver;
   public static Properties prop;
   public static ExcelDataProvider excel;



    public Base(){

        try{
            prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/fieldwire/config/config.properties");
            prop.load(fis);

             excel = new ExcelDataProvider();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equals("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        } else{
            System.out.println("Please enter correct browser value" + browserName);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
/*        report = new ExtentReports(System.getProperty("user.dir") + "/src/Reports/report.html", true);
        test = report.startTest("Extent report");*/
        driver.manage().timeouts().pageLoadTimeout(CommonUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(CommonUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));

    }

}