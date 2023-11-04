package BaiTap;

import POM.CartPage;
import POM.CheckoutPage;
import POM.LoginPage;
import POM.OrderPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
@Test
public class TestCase08 {
    public static void TestCase08(){
        String email_address ="nhanntse172587@fpt.edu.vn";
        String password = "NguyenNha";
        String country = "United States";
        String provice = "Florida";
        String zipid = "1234";
        String address ="Long Thanh - Vinh Loi - Bac Lieu";
        String city = "TP Kien Giang";
        String telephone = "0812281545";
        String newAdress = "New Address";
        WebDriver driver = driverFactory.getChromeDriver();
        try {
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
            orderPage.clickReOrder();



            String GrandBefore = orderPage.getGrandTotal();
            System.out.println("Giá khi chưa thay đổi số lượng là: " + GrandBefore);

            orderPage.ChangeQty();

            orderPage.UpdateQty();

            String GrandAfter = orderPage.getGrandTotal();
            System.out.println("Giá khi cập nhật số lượng là: " + GrandAfter);


            for(String handle: driver.getWindowHandles()){
                driver.switchTo().window(handle);
            }

            CartPage cartPage = new CartPage(driver);
            cartPage.clickproceedLink();
            Thread.sleep(2000);

            for(String handle: driver.getWindowHandles()){
                driver.switchTo().window(handle);
            }

            CheckoutPage checkOutPage = new CheckoutPage(driver);
            Select optionChoose = new Select(driver.findElement(checkOutPage.selectNewAddress()));
            optionChoose.selectByVisibleText(newAdress);
            checkOutPage.enterAddress(address);
            Thread.sleep(1000);
            checkOutPage.enterCity(city);
            Thread.sleep(1000);
            checkOutPage.enterZIP(zipid);
            Thread.sleep(1000);
            Select chooseCountry = new Select(driver.findElement(checkOutPage.chooseCountry()));
            chooseCountry.selectByIndex(1);
            Thread.sleep(1000);
            checkOutPage.enterTelephone(telephone);
            Thread.sleep(1000);
            checkOutPage.clickContinuebutton();
            Thread.sleep(2000);
            checkOutPage.clickshippinginformationLink();
            Thread.sleep(2000);
            checkOutPage.clickContinuebutton2();
            Thread.sleep(2000);
            checkOutPage.clickContinuebutton3();
            Thread.sleep(2000);
            checkOutPage.click_check_money_order();
            Thread.sleep(2000);
            checkOutPage.clickContinuebutton4();
            Thread.sleep(2000);
            checkOutPage.clickplaceorderLink();
            Thread.sleep(3000);


            String OrderId = checkOutPage.getOrderId();
            System.out.println("Đơn hàng đã được tạo với ID: " + OrderId);

            for(String handle: driver.getWindowHandles()){
                driver.switchTo().window(handle);
            }
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String png = ("D:\\CN5\\SWT301\\selenium-webdriver-java-master\\selenium-webdriver-java-master\\src\\test\\java\\BaiTap\\textcase08.png");
            FileUtils.copyFile(srcFile, new File(png));
            Thread.sleep(2000);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
