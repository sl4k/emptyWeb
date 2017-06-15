import business.MainPageBO;
import driver.Driver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestClass {
    private String homePageUrl = "http://rozetka.com.ua/ua/";
    private MainPageBO mainPage = new MainPageBO();

    @BeforeClass
    public void setSystemVar() {
        Driver.getDriver().get("http://rozetka.com.ua/ua/");
    }

    @Test()
    public void firefoxRun() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get(homePageUrl);
        Thread.sleep(5000);
//        driver.close();
        driver.quit();
    }

    @Test()
    public void chromeRun() throws InterruptedException {
//        DesiredCapabilities cap = DesiredCapabilities.chrome();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("test-type");
//        options.addArguments("disable-extensions");
//        options.addArguments("disable-infobars");
//        cap.setCapability(ChromeOptions.CAPABILITY, options);
//
//        WebDriver driver = new ChromeDriver(cap);
//        driver.get(homePageUrl);

        String langBeforeTest = mainPage.getActiveLanguage();
        boolean isLangChanged = mainPage.selectUaLanguageAndCheck();

        Assert.assertTrue(isLangChanged, "Language wasn't changed");
        Assert.assertTrue(mainPage.getActiveLanguage().equalsIgnoreCase(langBeforeTest), "Language wasn't changed");

//        driver.close();
        Driver.quit();
    }

    @Test()
    public void operaRun() throws InterruptedException {
        WebDriver driver = new OperaDriver();
        driver.get(homePageUrl);
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }

    @Test()
    public void iERun() throws InterruptedException {
        WebDriver driver = new InternetExplorerDriver();
        driver.manage().window().setSize(new Dimension(900,512));
        driver.get(homePageUrl);
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }
}
