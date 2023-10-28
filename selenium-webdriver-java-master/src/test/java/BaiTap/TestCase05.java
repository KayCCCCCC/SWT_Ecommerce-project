package BaiTap;

import POM.RegisterPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;


//Test Steps:
//
//        1. Go to http://live.techpanda.org/
//
//        2. Click on my account link
//
//        3. Click Create an Account link and fill New User information excluding the registered Email ID.
//
//        4. Click Register
//
//        5. Verify Registration is done. Expected account registration done.
//
//        6. Go to TV menu
//
//        7. Add product in your wish list - use product - LG LCD
//
//        8. Click SHARE WISHLIST
//
//        9. In next page enter Email and a message and click SHARE WISHLIST
//
//        10.Check wishlist is shared. Expected wishlist shared successfully.
@Test
public class TestCase05 {
    public static void TestCase05() {

        String firstname = "Nha";
        String lastname = "Nguyen";
        String email_address ="Nhanntse172587@fpt.edu.vn";
        String password = "NguyenNha";
        String confirm_password = password;



        WebDriver driver = new ChromeDriver();
        try {
//            1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            RegisterPage registerPage = new RegisterPage(driver);


//        2. Click on my account link
            registerPage.clickMyAccountLink();


            for(String handle: driver.getWindowHandles()){
                driver.switchTo().window(handle);
            }
//        3. Click Create an Account link and fill New User information excluding the registered Email ID.
            registerPage.clickCreateAccountLink();


            for(String handle: driver.getWindowHandles()){
                driver.switchTo().window(handle);
            }

            registerPage.enterFirstName(firstname);
            Thread.sleep(1000);
            registerPage.enterLastName(lastname);
            Thread.sleep(1000);
            registerPage.enterEmail(email_address);
            Thread.sleep(1000);
            registerPage.enterPassword(password);
            Thread.sleep(1000);
            registerPage.enterConfirmPassword(confirm_password);
            Thread.sleep(1000);

//        4. Click Register
            registerPage.clickRegister();
            Thread.sleep(1000);

            for(String handle: driver.getWindowHandles()){
                driver.switchTo().window(handle);
            }

//        5. Verify Registration is done. Expected account registration done.
            String expectWelcome = ("HELLO, " + firstname.toUpperCase() + " " + lastname.toUpperCase() + "!");
            String actualWelcome = driver.findElement(By.cssSelector("p[class='hello'] strong")).getText().toUpperCase();
            System.out.println("actualWelcome = " + actualWelcome);

            Assert.assertEquals(expectWelcome, actualWelcome);

//        6. Go to TV menu
            driver.findElement(By.xpath("//a[normalize-space()='TV']")).click();
            Thread.sleep(2000);

//        7. Add product in your wish list - use product - LG LCD
            driver.findElement(By.xpath("(//a[@class='link-wishlist'][normalize-space()='Add to Wishlist'])[1]")).click();
            Thread.sleep(2000);


//        8. Click SHARE WISHLIST
            driver.findElement(By.xpath("//span[contains(text(),'Share Wishlist')]")).click();
            Thread.sleep(2000);

            for(String handle: driver.getWindowHandles()){
                driver.switchTo().window(handle);
            }
//        9. In next page enter Email and a message and click SHARE WISHLIST
            driver.findElement(By.xpath("//textarea[@id='email_address']")).sendKeys("Nhanntse172587@fpt.edu.vn");
            Thread.sleep(2000);

//        10.Check wishlist is shared. Expected wishlist shared successfully.
            driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Nguyen Nha share list with you!");
            Thread.sleep(2000);
            driver.findElement(By.xpath("(//span[contains(text(),'Share Wishlist')])[1]")).click();
            Thread.sleep(2000);

            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(srcFile, new File("D:\\CN5\\SWT301\\selenium-webdriver-java-master\\selenium-webdriver-java-master\\src\\test\\java\\BaiTap\\textcase05.png"));



        } catch (Exception e) {
            e.printStackTrace();
        }
//        driver.quit();
    }

}
