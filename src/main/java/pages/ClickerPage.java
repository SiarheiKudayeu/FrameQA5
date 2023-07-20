package pages;


import enums.Symbol;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickerPage extends BasePage {
    public ClickerPage(WebDriver driver) {
        super(driver);
    }

    private static class Labels {
        private final static String url = "https://www.clickspeedtester.com/click-counter/";
    }

    private static class Locators {
        private final static By plusButton = By.id("plus-btn");
        private final static By minusButton = By.id("minus-btn");
        private final static By counterField = By.xpath("//div[@id='counter']//span");
        private final static By acceptCookies = By.xpath("//button[@aria-label='Consent']/p");
        private final static By frame = By.xpath("//iframe[@src='https://www.clickspeedtester.com/online-click-counter/']");
    }

    public void clickOnPlusOrMinus(Symbol symbol, int countOfNumber){
        switch (symbol) {
            case PLUS:
                for(int i = 0; i < countOfNumber; i++){
                    elements.findElement(Locators.plusButton).click();
                }
                break;
            case MINUS:
                for(int i = 0; i < countOfNumber; i++){
                    elements.findElement(Locators.minusButton).click();
                }
                break;
        }
    }
    public void openMainPage(){
        driver.get(Labels.url);
    }

    public void acceptCoockies(){
        elements.clickOnElement(Locators.acceptCookies);
    }
    public int getCountOfClicksFromCountedrField(){
        return Integer.parseInt(elements.getTextOnElement(Locators.counterField));
    }
    public void switchToFrame(){
        wait.switchToFrame(Locators.frame);
    }
}
