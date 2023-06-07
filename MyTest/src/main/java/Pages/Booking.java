package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
public class Booking {
    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public Booking(WebDriver driver) {
        this.driver=driver;
    }

    //Locator for web element
    By BookGolfCourse = By.xpath("/html/body/div/main/table[1]/tbody/tr/td[4]/form/button");

    By drpGolf = By.id("GolfName");

    By BookedBy = By.id("Customer");
    By Email = By.id("Email");
    By Phone = By.id("Phone");

    By calendar = By.id("Date");
    By calendar2 = By.xpath("/html/body/div/main/div[1]/div/form/div[5]/span");
    By calendarToday = By.linkText("Today");

    By StartTime = By.id("StartTime");
    By AM = By.linkText("AM");

    By EndTime = By.id("EndTime");

    By btnCreate = By.xpath("/html/body/div/main/div[1]/div/form/div[8]/input");
    public void BookGolfCourse() {
        driver.findElement(BookGolfCourse).click();
        Select DGolf = new Select(driver.findElement(drpGolf));
        DGolf.selectByVisibleText("Tiger A");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(BookedBy).clear();
        driver.findElement(BookedBy).sendKeys("Low John");
        driver.findElement(Email).clear();
        driver.findElement(Email).sendKeys("low.john@admlucid.com");
        driver.findElement(Phone).clear();
        driver.findElement(Phone).sendKeys("18004033779");
        //driver.findElement(calendar2).click();
        driver.findElement(calendar).sendKeys("2023"+ Keys.ARROW_RIGHT+"0720");
        driver.findElement(StartTime).clear();
        driver.findElement(StartTime).sendKeys("09:30AM");

        driver.findElement(EndTime).clear();
        driver.findElement(EndTime).sendKeys("11:30AM");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(btnCreate).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
