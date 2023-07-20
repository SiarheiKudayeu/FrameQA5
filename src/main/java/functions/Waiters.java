package functions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class Waiters {
    private final WebDriver driver;

    private static final long EXPLICITY_WAIT = 10L;

    public Waiters(WebDriver driver){
        this.driver = driver;
    }

    private FluentWait<WebDriver> fluentWait (Long duration){
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    private void waitForFunction(Function function, Long timeOutInSeconds){
        FluentWait<WebDriver> wait = fluentWait(timeOutInSeconds);
        wait.until(function);
    }
    public WebElement waitForVisabilityOfWebElementReturn(By locator){
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForVisabilityOfWebElement(WebElement element){
        waitForFunction(ExpectedConditions.visibilityOfAllElements(element), EXPLICITY_WAIT);
    }
    public void waitForVisabilityOfWebElement(By locator){
        waitForFunction(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator), EXPLICITY_WAIT);
    }
    public void switchToFrame(By locator){
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator), EXPLICITY_WAIT);
    }
    public Alert switchToAlert(){
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.alertIsPresent());
    }




}
