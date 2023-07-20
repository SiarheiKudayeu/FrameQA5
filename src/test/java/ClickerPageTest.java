import enums.Symbol;
import org.testng.annotations.Test;

public class ClickerPageTest extends BaseTest {

    @Test
    public void clickPlusCheckTest(){
        int countOfClicks = 5;
        clickerPage.openMainPage();
        clickerPage.switchToFrame();
        clickerPage.clickOnPlusOrMinus(Symbol.PLUS,countOfClicks);
        assertions.equalsOfInt(34, clickerPage.getCountOfClicksFromCountedrField());
        clickerPage.clickOnPlusOrMinus(Symbol.MINUS,15);
    }

        @Test
    public void clickPlusCheckTest2(){
        int countOfClicks = 5;
        clickerPage.openMainPage();
        clickerPage.switchToFrame();
        clickerPage.clickOnPlusOrMinus(Symbol.PLUS,countOfClicks);
        assertions.equalsOfInt(countOfClicks, clickerPage.getCountOfClicksFromCountedrField());
        clickerPage.clickOnPlusOrMinus(Symbol.MINUS,15);
    }
}
