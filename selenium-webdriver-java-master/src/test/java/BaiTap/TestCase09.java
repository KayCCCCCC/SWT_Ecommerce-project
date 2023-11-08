package BaiTap;

import POM.CheckoutPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

@Test
public class TestCase09 {
    public static void TestCase09(){
        WebDriver driver = driverFactory.getChromeDriver();
        String code = "GURU50";
        try{
            driver.get("http://live.techpanda.org/");
            CheckoutPage checkoutPage = new CheckoutPage(driver);
            checkoutPage.clickMobileLink();
            checkoutPage.clickAddIphone();

            String beforApply = checkoutPage.getgrandtotal();
            checkoutPage.enterCode(code);
            checkoutPage.clickApply();
            String afterApply = checkoutPage.getgrandtotal();

            Assert.assertNotEquals(beforApply, afterApply, "GRAND TOTAL is apply counpon?");

            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String png = ("D:\\CN5\\SWT301\\selenium-webdriver-java-master\\selenium-webdriver-java-master\\src\\test\\java\\BaiTap\\textcase09.png");
            FileUtils.copyFile(srcFile, new File(png));
            Thread.sleep(2000);



        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
