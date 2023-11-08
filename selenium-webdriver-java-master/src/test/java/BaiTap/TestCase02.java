package BaiTap;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
//        1. Goto http://live.techpanda.org/
//
//        2. Click on �MOBILE� menu
//
//        3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
//
//        4. Click on Sony Xperia mobile
//
//        5. Read the Sony Xperia mobile from detail page.
//
//        6. Compare Product value in list and details page should be equal ($100).
@Test
public class TestCase02 {

    public static void TestCase02() {
        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // 2. Click on "MOBILE" menu
            WebElement mobileMenu = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
            mobileMenu.click();

            // 3. Read the cost of Sony Xperia mobile (which is $100)
            WebElement sonyXperiaPriceElement = driver.findElement(By.xpath("//span[contains(text(),'$100.00')]"));
            String sonyXperiaPrice = sonyXperiaPriceElement.getText();

            // 4. Click on Sony Xperia mobile
            WebElement sonyXperiaLink = driver.findElement(By.xpath("//img[@id='product-collection-image-1']"));
            sonyXperiaLink.click();

            // 5. Read the Sony Xperia mobile from the detail page
            WebElement sonyXperiaDetailPriceElement = driver.findElement(By.xpath("//span[@class='price']"));
            String sonyXperiaDetailPrice = sonyXperiaDetailPriceElement.getText();

            Assert.assertEquals(sonyXperiaPrice, sonyXperiaDetailPrice, "Price does not match the expected Price");

            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(srcFile, new File("D:\\CN5\\SWT301\\selenium-webdriver-java-master\\selenium-webdriver-java-master\\src\\test\\java\\BaiTap\\textcase02.png"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the browser
            driver.quit();
        }
    }
}
