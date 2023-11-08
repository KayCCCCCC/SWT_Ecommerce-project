package BaiTap;

import POM.BackedPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;

@Test
public class TestCase10 {
    public static void TestCase10(){
        WebDriver driver = driverFactory.getChromeDriver();
        String userName = "user01";
        String passWord = "guru99com";
        String orderId = "100021174";
        String fromDate = "Nov 8, 2023 1:49:02 AM";
        try {
            driver.get("http://live.techpanda.org/index.php/backendlogin");
            BackedPage backedPage = new BackedPage(driver);
            Thread.sleep(2000);
            backedPage.enterUserName(userName);
            Thread.sleep(2000);
            backedPage.enterPassWord(passWord);
            Thread.sleep(2000);
            backedPage.clickLogin();
            Thread.sleep(2000);

            backedPage.clickClose();
            backedPage.chooseSale();
            Thread.sleep(2000);
            backedPage.clickOrders();
            Thread.sleep(2000);
            backedPage.enterOrderId(orderId);
            Thread.sleep(2000);
            backedPage.enterFromDate(fromDate);
            Thread.sleep(2000);
            backedPage.clickSearch();
            Thread.sleep(2000);

            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String png = ("D:\\CN5\\SWT301\\selenium-webdriver-java-master\\selenium-webdriver-java-master\\src\\test\\java\\BaiTap\\textcase10.png");
            FileUtils.copyFile(srcFile, new File(png));
            Thread.sleep(2000);


        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
