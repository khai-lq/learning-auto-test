package PlsDontBug;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class Run2Mean {
    @Test
    public  void runrunrun(){
        System.out.println("STARTING");
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.thegioididong.com/");
        String title = driver.getTitle();
        System.out.println(title);
        String text = driver.findElement(By.className("name-order")).getText();
        System.out.println(text);
        WebElement stepForSearch = driver.findElement(By.id("skw"));
        stepForSearch.click();
        stepForSearch.sendKeys("iphone 14 pro max 1t");
        WebElement search = driver.findElement(By.className("icon-search"));
        search.submit();

        String firstWindow = driver.getWindowHandle();
        System.out.println(firstWindow);
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.thegioididong.com/laptop-ldp','');");

        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            System.out.println(window);
            if (!firstWindow.equals(window)) {
                driver.switchTo().window(window);
                System.out.println("Đã chuyển đến lớp Window con");
                //driver.close();
            }
        }

    }
}
