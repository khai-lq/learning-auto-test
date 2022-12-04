package PlsDontBug;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;


public class debug {
    @Test
    public  void debug(){
        System.out.println("+ Step 1: Khởi chạy trình duyệt Chrome!...");
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");



        WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
        submit.submit();

    }
}
