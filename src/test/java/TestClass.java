import business.MainPageBO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass extends TestBase{
    private MainPageBO mainPage = new MainPageBO();

    @Test()
    public void checkUaLang() throws InterruptedException {
        boolean isLangChanged = mainPage.selectUaLanguageAndCheck();
        Assert.assertTrue(isLangChanged, "Language wasn't changed");
    }

    @Test()
    public void checkRuLang() throws InterruptedException {
        boolean isLangChanged = mainPage.selectRuLanguageAndCheck();
        Assert.assertTrue(isLangChanged, "Language wasn't changed");
    }

}
