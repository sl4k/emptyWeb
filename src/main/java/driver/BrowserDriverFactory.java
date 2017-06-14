package driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserDriverFactory {

    public RemoteWebDriver getAppropriateDriver(String browserName){
        if (browserName != null) {
            if (browserName.equals("FF")) {
                return getFireFoxDriver();
            }
            if (browserName.equals("CHROME")) {
                return getChromeDriver();
            }
            if (browserName.equals("IE")) {
                return getInternetExplorerDriver();
            }
            if (browserName.equals("opera")) {
                return getOperaDriver();
            }
        }
        return getFireFoxDriver();
    }


    private RemoteWebDriver getFireFoxDriver() {
        System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
        return new FirefoxDriver();
    }

    private RemoteWebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("disable-extensions");
        options.addArguments("disable-infobars");
        cap.setCapability(ChromeOptions.CAPABILITY, options);

        return new ChromeDriver(cap);
    }

    private RemoteWebDriver getInternetExplorerDriver() {
        System.setProperty("webdriver.ie.driver", "src\\test\\resources\\IEDriverServer.exe");
        RemoteWebDriver driver = new InternetExplorerDriver();
        driver.manage().window().setSize(new Dimension(900,512));
        return driver;
    }

    private RemoteWebDriver getOperaDriver() {
        System.setProperty("webdriver.opera.driver", "src\\test\\resources\\operadriver.exe");
        return new OperaDriver();
    }


}
