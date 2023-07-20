import driver.DriverFactory;
import functions.Action;
import functions.Assertions;
import functions.Elements;
import functions.Waiters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import pages.BasePage;
import pages.ClickerPage;
import utils.TestResultListeners;

@Listeners(TestResultListeners.class)
public class BaseTest {
    protected WebDriver driver = DriverFactory.startChromeDriver();

    protected Action action = new Action(driver);
    protected Assertions assertions = new Assertions(driver);
    protected Elements elements = new Elements(driver);
    protected Waiters waiters = new Waiters(driver);

    protected BasePage basePage = new BasePage(driver);
    protected ClickerPage clickerPage = new ClickerPage(driver);

    @BeforeSuite
    public void cookied(){
        clickerPage.openMainPage();
        clickerPage.acceptCoockies();
    }

    @AfterSuite
    public void closeDriver(){
        driver.quit();
    }


}
