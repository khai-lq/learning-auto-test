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

public class Exam2_1 {
    @Test
    public  void demoqa(){
        System.out.println("+ Step 1: Khởi chạy trình duyệt Chrome!...");
        WebDriver driver;
        Select selectMonth, selectYear;
        String[] monthExpected = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("+ Step 2: Truy cập demoqa.com!...");
        driver.get("https://demoqa.com/automation-practice-form");
        Actions action = new Actions(driver);

        //firstName
        System.out.println("+ Step 3: Điền thông tin!...");
        WebElement fillFirstName = driver.findElement(By.id("firstName"));
        fillFirstName.click();
        fillFirstName.sendKeys("Lê Quang");

        WebElement fillLastName = driver.findElement(By.id("lastName"));
        fillLastName.click();
        fillLastName.sendKeys("Khải");

        WebElement fillEmail = driver.findElement(By.id("userEmail"));
        fillEmail.click();
        fillEmail.sendKeys("lqkhai.me@gmail.com");

        WebElement choseTheGender = driver.findElement(By.cssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label"));
        choseTheGender.click();

        WebElement fillPhoneNumber = driver.findElement(By.id("userNumber"));
        fillPhoneNumber.click();
        fillPhoneNumber.sendKeys("0338102248");

        WebElement fillDateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        fillDateOfBirth.click();
        selectMonth = new Select(driver.findElement(By.className("react-datepicker__month-select")));
        List<WebElement> monthItems = selectMonth.getOptions();
        List<String> monthItemText = new ArrayList<String>();
        for (WebElement element : monthItems) {
            monthItemText.add(element.getText());
        }
        Assert.assertEquals(monthItemText, Arrays.asList(monthExpected));
        selectMonth.selectByVisibleText("November");
        selectYear = new Select(driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select")));
        selectYear.selectByValue("1998");
        List<WebElement> dates = driver.findElements(By.cssSelector("#dateOfBirth > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__month > div:nth-child(1) > div.react-datepicker__day.react-datepicker__day--001.react-datepicker__day--weekend"));
        int count = dates.size();
        for (int i = 0; i < count; i++){
            String text = driver.findElements(By.cssSelector("#dateOfBirth > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__month > div:nth-child(1) > div.react-datepicker__day.react-datepicker__day--001.react-datepicker__day--weekend"))
                    .get(i).getText();
            if (text.equalsIgnoreCase("1")){
                driver.findElements(By.cssSelector("#dateOfBirth > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__month > div:nth-child(1) > div.react-datepicker__day.react-datepicker__day--001.react-datepicker__day--weekend")).get(i).click();
                break;
            }
        }

        WebElement subjectInput = driver.findElement(By.id("subjectsInput"));
        subjectInput.sendKeys("Com");
        WebElement firstSuggestedItem = driver.findElement(By.cssSelector("[class*='subjects-auto-complete__menu']"));
        firstSuggestedItem.click();

        WebElement choseTheHobby = driver.findElement(By.cssSelector("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(3) > label"));
        choseTheHobby.click();

        WebElement updPicture = driver.findElement(By.id("uploadPicture"));
        updPicture.sendKeys("C:\\Users\\quang\\IdeaProjects\\AutoTestExam1\\src\\test\\java\\PlsDontBug\\wp5510903.jpg");

        WebElement fillAddress = driver.findElement(By.cssSelector("#currentAddress"));
        fillAddress.sendKeys("ở đâu còn lâu mới nói ");


        WebElement state = driver.findElement(By.xpath("//input[@id='react-select-3-input']"));
        state.sendKeys("NCR");
        action.sendKeys(Keys.ENTER);
        action.perform();

        WebElement city = driver.findElement(By.cssSelector("#react-select-4-input"));
        city.sendKeys("Delhi");
        action.sendKeys(Keys.ENTER);
        action.perform();

        WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
        submit.submit();
    }
}
