package functions;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class Assertions {
    private final WebDriver driver;
    private final Elements elements;
    private final Waiters waiters;
    private final Action action;

    public Assertions(WebDriver driver) {
        this.driver = driver;
        elements = new Elements(driver);
        waiters = new Waiters(driver);
        action = new Action(driver);
    }

    public void equalsOfInt(int actual, int expected) {
        assertEquals(actual, expected,
                "Я ожидал получить число " + expected + ". А получил " + actual + ".");
    }


}
