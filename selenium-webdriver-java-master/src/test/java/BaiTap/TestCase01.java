package BaiTap;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

/*

Test Steps

Step 1. Go to http://live.techpanda.org/

Step 2. Verify Title of the page

Step 3. Click on -> MOBILE -> menu

Step 4. In the list of all mobile , select SORT BY -> dropdown as name

Step 5. Verify all products are sorted by name

*/
@Test
public class TestCase01 {
    public static void TestCase01() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            // 1. Open the target page
            driver.get("http://live.techpanda.org/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            // 2. Verify Title of the page
            WebElement titleElem = driver.findElement(By.xpath("//h2[1]"));
            String actualTitle = titleElem.getText();
            String expectTitle = "THIS IS DEMO SITE FOR   ";

            Assert.assertEquals(expectTitle, actualTitle, "Title does not match the expected title");
            Thread.sleep(2000);
            // 3. Click on -> MOBILE -> menu
            WebElement mobileMenu = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
            mobileMenu.click();

            // 4. In the list of all mobile, select SORT BY -> dropdown as name
            WebElement dropdownElem = driver.findElement(By.xpath("//body/div[@class='wrapper']/div[@class='page']/div[@class='main-container col3-layout']/div[@class='main']/div[@class='col-wrapper']/div[@class='col-main']/div[@class='category-products']/div[@class='toolbar']/div[@class='sorter']/div[@class='sort-by']/select[1]"));
            Select optionElem = new Select(dropdownElem);
            optionElem.selectByVisibleText("Name");
            Thread.sleep(2000);
            // 5. Verify all products are sorted by name
            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(srcFile, new File("D:\\CN5\\SWT301\\selenium-webdriver-java-master\\selenium-webdriver-java-master\\src\\test\\java\\BaiTap\\textcase01.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }
}
