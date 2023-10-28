package BaiTap;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

/*

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on �MOBILE� menu

3. In mobile products list , click on �Add To Compare� for 2 mobiles (Sony Xperia & Iphone)

4. Click on �COMPARE� button. A popup window opens

5. Verify the pop-up window and check that the products are reflected in it

Heading "COMPARE PRODUCTS" with selected products in it.

6. Close the Popup Windows

*/
@Test
public class TestCase04 {
    public void TestCase04() {
        WebDriver driver = new ChromeDriver();

        try {
            // 1. Truy cập vào trang web http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            // 2. Click on "MOBILE" menu
            WebElement mobileMenu = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
            mobileMenu.click();

            // 3. Trong danh sách sản phẩm di động, nhấp vào "Add To Compare" cho 2 sản phẩm di động (Sony Xperia & samsung)
            WebElement sonyXperiaCompare = driver.findElement(By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[2]//a[1]"));
            sonyXperiaCompare.click();

            WebElement samsungCompare = driver.findElement(By.xpath("//li[2]//div[1]//div[3]//ul[1]//li[2]//a[1]"));
            samsungCompare.click();

            // 4. Nhấp vào nút "COMPARE". Một cửa sổ popup sẽ mở ra
            WebElement compareButton = driver.findElement(By.xpath("//button[@title='Compare']//span//span[contains(text(),'Compare')]"));
            compareButton.click();

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // 5. Xác minh cửa sổ popup và kiểm tra rằng các sản phẩm được hiển thị trong đó
            String mes = "COMPARE PRODUCTS";
            WebElement headerPopup = driver.findElement(By.xpath("//h1[normalize-space()='Compare Products']"));
            Assert.assertEquals(headerPopup.getText(), mes);

            WebElement samsumWeb = driver.findElement(By.xpath("//a[@title='Samsung Galaxy'][normalize-space()='Samsung Galaxy']"));
            WebElement sonyWeb = driver.findElement(By.xpath("//a[@title='Sony Xperia'][normalize-space()='Sony Xperia']"));

            WebElement sonyPopup = driver.findElement(By.xpath("//a[normalize-space()='Sony Xperia']"));
            WebElement samsungPopup = driver.findElement(By.xpath("//a[normalize-space()='Samsung Galaxy']"));

            Assert.assertEquals(samsumWeb.getText(), samsungPopup.getText());
            Assert.assertEquals(sonyWeb.getText(), sonyPopup.getText());


            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(srcFile, new File("D:\\CN5\\SWT301\\selenium-webdriver-java-master\\selenium-webdriver-java-master\\src\\test\\java\\BaiTap\\textcase04.png"));

            // 6. Đóng cửa sổ popup
            WebElement closePopupButton = driver.findElement(By.xpath("//span[contains(text(),'Close Window')]"));
            closePopupButton.click();

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Xảy ra lỗi trong quá trình kiểm thử.");
        }
    }
}
