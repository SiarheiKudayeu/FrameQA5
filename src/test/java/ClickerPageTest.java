import enums.Symbol;
import org.testng.annotations.Test;

public class ClickerPageTest extends BaseTest {

    @Test
    public void clickPlusCheckTest(){
        int countOfClicks = 5;
        clickerPage.openMainPage();
        clickerPage.switchToFrame();
        clickerPage.clickOnPlusOrMinus(Symbol.PLUS,countOfClicks);
        assertions.equalsOfInt(4, clickerPage.getCountOfClicksFromCountedrField());
        clickerPage.clickOnPlusOrMinus(Symbol.MINUS,15);
    }
}
