package PlsDontBug.Lesson2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam2_2 {
    @Test
    public void applyProduct(){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://betacrm.thegioididong.com/");
        Actions action = new Actions(driver);

        WebElement username = driver.findElement(By.id("Username"));
        username.sendKeys("12481");
        WebElement pass = driver.findElement(By.id("Password"));
        pass.sendKeys("Crm@12481");
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]"));
        loginButton.submit();

        WebElement choseTheCompany = driver.findElement(By.xpath("//body/div[2]/div[1]/form[1]/div[1]/div[2]/a[1]"));
        choseTheCompany.click();

        WebElement openSaleOrderMenu = driver.findElement(By.cssSelector("#li28"));
        openSaleOrderMenu.click();

        WebElement openSaleOrderListSite = driver.findElement(By.xpath("//span[contains(text(),'Đơn hàng Online')]"));
        openSaleOrderListSite.click();

        WebElement fromDate = driver.findElement(By.xpath("//input[@id='dtDateFrom']"));
        fromDate.clear();
        fromDate.sendKeys("27/11/2022");
        action.sendKeys(Keys.ENTER);
        action.perform();

        WebElement openListKeys = driver.findElement(By.xpath("//select[@id='ddlTypeSearch']"));
        openListKeys.click();
        WebElement selectKey = driver.findElement(By.xpath("//body/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/select[3]/option[4]"));
        selectKey.click();
        WebElement inputKey = driver.findElement(By.xpath("//input[@id='txtkey-SaleList']"));
        inputKey.sendKeys("2116586");
        action.sendKeys(Keys.ENTER);
        action.perform();

        WebElement yesOrNo = driver.findElement(By.xpath("//tbody"));
        Boolean checkYesOrNo = yesOrNo.isSelected();
        if (checkYesOrNo == false){
            openListKeys.click();
            selectKey = driver.findElement(By.xpath("//body/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/select[3]/option[1]"));
            selectKey.click();
            inputKey = driver.findElement(By.xpath("//input[@id='txtkey-SaleList']"));
            inputKey.clear();
            inputKey.sendKeys("0796801846");
            action.sendKeys(Keys.ENTER);
            action.perform();
        }



    }
}
