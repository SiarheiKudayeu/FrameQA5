package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Elements {
    private final WebDriver driver;
    private final Waiters waiters;

    public Elements(WebDriver driver){
        this.driver = driver;
        waiters = new Waiters(driver);
    }

    public WebElement findElement(By by){
        try {
            waiters.waitForVisabilityOfWebElement(by);
            return driver.findElement(by);
        } catch (NoSuchElementException e){
            e.printStackTrace();
        }return null;
    }

    public WebElement findElementByXpath(String xpath) {
        try {
            waiters.waitForVisabilityOfWebElement(By.xpath(xpath));
            return driver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void clickOnElement(By by){
        WebElement element = findElement(by);
        element.click();
    }

    public String getTextOnElement(By by){
        return findElement(by).getText();
    }
}
