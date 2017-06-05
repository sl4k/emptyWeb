import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClass {
    String homePageUrl = "http://rozetka.com.ua/ua/";

    @BeforeClass
    public void setSystemVar() {
        System.setProperty("webdriver.gecko.driver", "E:\\work\\workspace\\emptyWeb\\src\\test\\resources\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "E:\\work\\workspace\\emptyWeb\\src\\test\\resources\\chromedriver.exe");
        System.setProperty("webdriver.opera.driver", "E:\\work\\workspace\\emptyWeb\\src\\test\\resources\\operadriver.exe");
        System.setProperty("webdriver.ie.driver", "E:\\work\\workspace\\emptyWeb\\src\\test\\resources\\IEDriverServer.exe");
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
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("disable-extensions");
        options.addArguments("disable-infobars");
        cap.setCapability(ChromeOptions.CAPABILITY, options);

        WebDriver driver = new ChromeDriver(cap);
        driver.get(homePageUrl);
        Thread.sleep(5000);
//        driver.close();
        driver.quit();
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
