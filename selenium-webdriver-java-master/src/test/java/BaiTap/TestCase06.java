package BaiTap;

import POM.CartPage;
import POM.CheckoutPage;
import POM.LoginPage;
import POM.RegisterPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import org.openqa.selenium.support.ui.Select;

import static org.testng.AssertJUnit.assertEquals;

@Test
public class TestCase06 {
    public static void TestCase06() {


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

            CartPage cartPage = new CartPage(driver);

            cartPage.clickmyWishListLink();
            Thread.sleep(1000);
            cartPage.clickAddtocardLink();
            for(String handle: driver.getWindowHandles()){
                driver.switchTo().window(handle);
            }


            Select drpCountry = new Select(driver.findElement(cartPage.chooseCountry()));
            drpCountry.selectByVisibleText(country);
            Thread.sleep(1000);
            Select drpProvice = new Select(driver.findElement(cartPage.chooseProvice()));
            drpProvice.selectByVisibleText(provice);
            Thread.sleep(1000);
            cartPage.enterZIP(zipid);
            Thread.sleep(1000);
            cartPage.clickestimateLink();
            Thread.sleep(1000);
            String totalwithoutshipcost = cartPage.gettotalWithoutshipcost();
            System.out.println("Giá tổng số khi chưa có chi phí vận chuyển là: " + totalwithoutshipcost);
            Thread.sleep(1000);
            String cost = cartPage.getShippingcost();
            Thread.sleep(1000);
            System.out.println("Giá vận chuyển sau khi ước tính là: " + cost);
            Thread.sleep(1000);
            cartPage.clickefixedLink();
            Thread.sleep(1000);
            cartPage.clickupdatetotalLink();
            Thread.sleep(1000);
            String grandtotalwithupdate = cartPage.getgrandtotal();
            System.out.println("Giá tổng số sau khi cập nhật chi phí vận chuyển là: " + grandtotalwithupdate);
            Thread.sleep(1000);
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
            String png = ("D:\\CN5\\SWT301\\selenium-webdriver-java-master\\selenium-webdriver-java-master\\src\\test\\java\\BaiTap\\textcase06.png");
            FileUtils.copyFile(srcFile, new File(png));
            Thread.sleep(2000);



        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}



