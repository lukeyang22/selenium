package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
public class Form {
    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public Form(WebDriver driver) {
        this.driver=driver;
    }

    //Locator for web element
    By NameInput = By.name("Name");
    By EmailInput = By.name("EMail");
    By PhoneInput = By.name("Telephone");
    By Age = By.name("age");
    By dService =By.xpath("/html/body/div/main/form/p[6]/select");
    By submitBtn = By.xpath("/html/body/div/main/form/p[7]/input[1]");

    //Methods to submit form
    public void EnterTextsForm(){
        driver.findElement(NameInput).clear();
        driver.findElement(NameInput).sendKeys("Smith Dan");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        driver.findElement(EmailInput).clear();
        driver.findElement(EmailInput).sendKeys("smith.dan@admlucid.com");

        driver.findElement(PhoneInput).clear();
        driver.findElement(PhoneInput).sendKeys("18005899998");
    }

    public void DropdownListForm(){
        Select drpAge = new Select(driver.findElement(Age));
        drpAge.selectByVisibleText("8");

        Select DService = new Select(driver.findElement(dService));
        DService.selectByVisibleText("Preschool");

    }
    public void ClickSubmit(){
        try{Thread.sleep(2000);}catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(submitBtn).click();
        driver.switchTo().alert().accept();
    }
}
