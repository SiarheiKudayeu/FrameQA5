package driver;

import functions.Action;
import functions.Assertions;
import functions.Elements;
import functions.Waiters;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    static Waiters wait;
    static Action action;
    static Assertions assertions;
    static Elements elements;
    private static WebDriver driver;

    private static final long IMPLICITY_WAIT = 20L;

    private static WebDriver setUpDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
        wait = new Waiters(driver);
        action = new Action(driver);
        assertions = new Assertions(driver);
        elements = new Elements(driver);
        return driver;
    }

    private static WebDriver getInstance() {
        if(driver == null){
            try {
                driver = setUpDriver();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static WebDriver startChromeDriver(){
        driver = getInstance();
        return driver;
    }
}
