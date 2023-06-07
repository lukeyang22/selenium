package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
public class Golf {
    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public Golf(WebDriver driver) {
        this.driver=driver;
    }

    //Locator for web element
    By SearchInput = By.className("input");
    By btnSearch = By.xpath("/html/body/div/main/table[1]/tbody/tr/td[1]/form/button");
    By NameText1 = By.xpath("/html/body/div/main/table[2]/tbody/tr[1]/td[1]");
    By AddressText1 =By.xpath("/html/body/div/main/table[2]/tbody/tr[1]/td[2]");
    By drpCountry = By.name("CurrentFilter");

    By btnFilter = By.xpath("/html/body/div/main/table[1]/tbody/tr/td[2]/form/fieldset/button");
    //Methods to submit form
    public void Search(){
        driver.findElement(SearchInput).clear();
        driver.findElement(SearchInput).sendKeys("Sky Golf Course");
        driver.findElement(btnSearch).click();
        try{Thread.sleep(2000);}catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(driver.findElement(NameText1).getText().equals("Sky Golf Course"))
        {
            System.out.println("Found Name -- "+driver.findElement(NameText1).getText());
        }
        if(driver.findElement(AddressText1).getText().equals("100 Avenue, Davenport,Northern Territory,Australia"));
        {
            System.out.println("Found Address -- "+driver.findElement(AddressText1).getText());
        }
    }
    public void SelectCountry(){
        Select DCountry = new Select(driver.findElement(drpCountry));
        DCountry.selectByVisibleText("Sweden");
        driver.findElement(btnFilter).click();
        if(driver.findElement(NameText1).getText().equals("PGA Sweden National (Links)"))
        {
            System.out.println("Found Name -- "+driver.findElement(NameText1).getText());
        }
        if(driver.findElement(AddressText1).getText().equals("230 40 Bara, Klubbhuset,SW,Sweden"));
        {
            System.out.println("Found Address -- "+driver.findElement(AddressText1).getText());
        }
    }
}
