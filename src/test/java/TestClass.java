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


//    @Test()
//    public void firefoxRun() throws InterruptedException {
//        WebDriver driver = new FirefoxDriver();
//        driver.get(homePageUrl);
//        Thread.sleep(5000);
////        driver.close();
//        driver.quit();
//    }
//
//    @Test()
//    public void chromeRun() throws InterruptedException {
//
//        String langBeforeTest = mainPage.getActiveLanguage();
//        boolean isLangChanged = mainPage.selectUaLanguageAndCheck();
//
//        Assert.assertTrue(isLangChanged, "Language wasn't changed");
//
////        driver.close();
//        Driver.quit();
//    }
//
//    @Test()
//    public void operaRun() throws InterruptedException {
//        WebDriver driver = new OperaDriver();
//        driver.get(homePageUrl);
//        Thread.sleep(5000);
//        driver.close();
//        driver.quit();
//    }
//
//    @Test()
//    public void iERun() throws InterruptedException {
//        WebDriver driver = new InternetExplorerDriver();
//        driver.manage().window().setSize(new Dimension(900,512));
//        driver.get(homePageUrl);
//        Thread.sleep(5000);
//        driver.close();
//        driver.quit();
//    }
}
