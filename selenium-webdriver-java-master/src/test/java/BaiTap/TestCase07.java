package BaiTap;

import POM.LoginPage;
import POM.OrderPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
@Test
public class TestCase07 {
    public static void TestCase07(){
        String email_address ="nhanntse172587@fpt.edu.vn";
        String password = "NguyenNha";
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            driver.get("http://live.techpanda.org/");
            LoginPage loginPage = new LoginPage(driver);
            Thread.sleep(1000);

            loginPage.clickMyAccountLink();
            Thread.sleep(2000);

            loginPage.enterEmail(email_address);
            Thread.sleep(1000);
            loginPage.enterPassword(password);
            Thread.sleep(1000);
            loginPage.clickloginButton();
            Thread.sleep(1000);

            for(String handle: driver.getWindowHandles()){
                driver.switchTo().window(handle);
            }

            OrderPage orderPage = new OrderPage(driver);
            Thread.sleep(1000);
            orderPage.clickOrderLink();
            Thread.sleep(1000);
            orderPage.clickViewOrder();
            Thread.sleep(1000);
            orderPage.clickPrintOrder();
            Thread.sleep(1000);
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String png = ("D:\\CN5\\SWT301\\selenium-webdriver-java-master\\selenium-webdriver-java-master\\src\\test\\java\\BaiTap\\textcase07.png");
            FileUtils.copyFile(srcFile, new File(png));
            Thread.sleep(2000);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
