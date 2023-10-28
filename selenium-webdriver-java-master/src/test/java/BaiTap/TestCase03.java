package BaiTap;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

//        1. Go to http://live.techpanda.org/
//
//        2. Click on �MOBILE� menu
//
//        3. In the list of all mobile , click on �ADD TO CART� for Sony Xperia mobile
//
//        4. Change �QTY� value to 1000 and click �UPDATE� button. Expected that an error is displayed
//
//        "The requested quantity for "Sony Xperia" is not available.
//
//        5. Verify the error message
//
//        6. Then click on �EMPTY CART� link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
//
//        7. Verify cart is empty
@Test
public class TestCase03 {
    public static void TestCase03() {
        WebDriver driver = new ChromeDriver();
        try {
            // 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            // 2. Click on "MOBILE" menu
            WebElement mobileMenu = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
            mobileMenu.click();

            // 3. In the list of all mobiles, click on "ADD TO CART" for Sony Xperia mobile
            WebElement sonyXperiaAddToCart = driver.findElement(By.xpath("//li[2]//div[1]//div[3]//button[1]"));
            sonyXperiaAddToCart.click();

            // 4. Change "QTY" value to 1000 and click "UPDATE" button
            WebElement qtyInput = driver.findElement(By.xpath("//input[@title='Qty']"));
            qtyInput.clear();
            qtyInput.sendKeys("1000");
            WebElement updateButton = driver.findElement(By.xpath("//button[@title='Update']"));
            updateButton.click();


            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(srcFile, new File("D:\\CN5\\SWT301\\selenium-webdriver-java-master\\selenium-webdriver-java-master\\src\\test\\java\\BaiTap\\textcase03.png"));

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
            // 5. Verify the error message
            String expectedError = "The requested quantity for \"Sony Xperia\" is not available.";
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='item-msg error']")));
            String actualError = errorMessage.getText();
            Assert.assertEquals(actualError, expectedError, "Error message does not match the expected error");



            // 6. Click on "EMPTY CART" link in the footer of the list of all mobiles
            WebElement emptyCartLink = driver.findElement(By.xpath("//span[contains(text()"));
            emptyCartLink.click();
            WebElement cartEmptyMessage = driver.findElement(By.xpath("//h1[normalize-space()='Shopping Cart is Empty']"));
            Assert.assertTrue(cartEmptyMessage.isDisplayed());
            // 7. Verify cart is empty
            String mesCart = "You have no items in your shopping cart.";
            WebElement CartMessage = driver.findElement(By.xpath("//div[@class='col-main']"));
            Assert.assertEquals(CartMessage, mesCart, "mesCart does not match the expected CartMessage");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            /*            driver.quit();*/
        }
    }
}
