package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    WebDriver driver;

    By myWishListLink = By.cssSelector("li:nth-child(8) a:nth-child(1)");
    By AddtocardLink = By.xpath("//button[@title='Add to Cart']");

    By countryInputlocator = By.xpath("//select[@id='country']");
    By proviceInputlocator = By.xpath("//select[@id='region_id']");

    By zipInputlocator = By.xpath("//input[@id='postcode']");


    By estimateLink = By.cssSelector("button[title='Estimate'] span span");

    By fixedLink = By.xpath("//label[contains(text(),'Fixed')]");

    By totalwithoutshipcostLink = By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(2) > span:nth-child(1)");

    By updatetotalLink = By.xpath("//span[contains(text(),'Update Total')]");

    By grandtotalLink = By.cssSelector("strong span[class='price']");

    By proceedLink = By.xpath("//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@title='Proceed to Checkout']//span//span[contains(text(),'Proceed to Checkout')]");



    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickmyWishListLink() {
        driver.findElement(myWishListLink).click();
    }

    public void clickAddtocardLink() {
        driver.findElement(AddtocardLink).click();
    }

    public By chooseCountry() {
        WebElement country = driver.findElement(countryInputlocator);
        return countryInputlocator;
    }

    public  By chooseProvice() {
        WebElement element = driver.findElement(proviceInputlocator);
        return proviceInputlocator;
    }

    public void enterZIP(String zipid) {
        WebElement element = driver.findElement(zipInputlocator);
        element.clear();
        element.sendKeys(zipid);
    }

    public void clickestimateLink() {
        driver.findElement(estimateLink).click();
    }

    public String getShippingcost(){
        String Shippingcost = driver.findElement(fixedLink).getText().substring(7);
        return Shippingcost;
    }

    public void clickefixedLink() {
        driver.findElement(fixedLink).click();
    }

    public void clickupdatetotalLink() {
        driver.findElement(updatetotalLink).click();
    }
    public String gettotalWithoutshipcost(){
        String totalwithoutshipcost = driver.findElement(totalwithoutshipcostLink).getText();
        return totalwithoutshipcost;
    }
    public String getgrandtotal(){
        String grandtotal = driver.findElement(grandtotalLink).getText();
        return grandtotal;
    }
    public void clickproceedLink(){
        driver.findElement(proceedLink).click();
    }
}