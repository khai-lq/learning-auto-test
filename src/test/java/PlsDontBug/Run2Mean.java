package PlsDontBug;

import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

import static java.lang.Thread.sleep;

public class Run2Mean {
    @Test
    public  void runrunrun() throws InterruptedException {
        long startTask, endTask;
        long startStep, endStep;
        long totalTask, totalStep;

        System.out.println("- - - - - - - - - STARTING - - - - - - - - - -");
        startTask = System.currentTimeMillis();

        System.out.println("+ Step 1: Khởi chạy trình duyệt Chrome!...");
        startStep = System.currentTimeMillis();
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        endStep = System.currentTimeMillis();
        totalStep = endStep-startStep;
        System.out.println("---> Khởi chạy hoàn tất, thời gian " + totalStep + " MilliSecond!" );

        System.out.println("+ Step 2: Truy cập website Thế Giới Di Động!...");
        startStep = System.currentTimeMillis();
        driver.get("https://www.thegioididong.com/");
        String title = driver.getTitle();
        endStep = System.currentTimeMillis();
        totalStep = endStep-startStep;
        System.out.println("---> Truy cập thành công, thời gian " + totalStep + " MilliSecond!" );
        System.out.println("Title: " + title);

        System.out.println("+ Step 3: Tìm kiếm sản phẩm!...");
        startStep = System.currentTimeMillis();
        WebElement stepForSearch = driver.findElement(By.id("skw"));
        stepForSearch.click();
        stepForSearch.sendKeys("iphone 14 pro max 1t");
        WebElement search = driver.findElement(By.className("icon-search"));
        search.submit();
        String temp = driver.findElement(By.xpath("/html/body/section[1]/aside/div[1]/a")).getText();
        endStep = System.currentTimeMillis();
        totalStep = endStep-startStep;
        if (temp.trim().length() > 0) {
            System.out.println("---> Tìm kiếm thành công, thời gian " + totalStep + " MilliSecond!");
            System.out.println("---> Kết quả tìm kiếm: " + temp);
        }
        else
            System.out.println("---> Sản phẩm không tồn tại, thời gian " + totalStep + " MilliSecond!" );

        System.out.println("+ Step 4: Tab mới và truy cập website Bách Hóa Xanh!...");
        startStep = System.currentTimeMillis();
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.bachhoaxanh.com','');");
        ArrayList<String> windows = new ArrayList<String> (driver.getWindowHandles());
        if (windows.size() < 2) {
            System.out.println("---> Tab mới thất bại, thời gian " + totalStep + " MilliSecond!" );
        }
        System.out.println("---> Tab mới thành công, thời gian " + totalStep + " MilliSecond!" );
        sleep(5000);
        System.out.println("---> Đóng tab Bách Hóa Xanh!...");
        driver.switchTo().window(windows.get(1));
        driver.close();
        sleep(5000);
        System.out.println("+ Step 5: Đóng trình duyệt Chrome!...");
        driver.quit();
        endTask = System.currentTimeMillis();
        totalTask = endTask - startTask;
        System.out.println("- - - - - - - - - - Task complete, total: " + totalTask +" MilliSecond - - - - - - - - - -" );
    }
}
