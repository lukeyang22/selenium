import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class Form {
    private static WebDriver driver;
    @Before
    public void setup(){
        //Start chrome web browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        //Maximize browser window
        driver.manage().window().maximize();
    }
    @Test
    public void submitform(){
        driver.get("https://www.admlucid.com/Home/WebElements");
        Pages.Form form = new Pages.Form(driver);
        form.EnterTextsForm();
        form.DropdownListForm();
        form.ClickSubmit();

    }
    @After
    public void teardown(){
        //Close browser
        driver.quit();
    }
}
