package driver;

import common.Config;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserGridDriverFactory {

    public RemoteWebDriver getAppropriateDriver(String browserName) {
        if (browserName != null) {

            if (browserName.equalsIgnoreCase("FF")) {
                return getGridFireFoxDriver();
            }
            if (browserName.equalsIgnoreCase("chrome")) {
                return getGridChromeDriver();
            }
            if (browserName.equalsIgnoreCase("IE")) {
                return getGridInternetExplorerDriver();
            }
            if (browserName.equalsIgnoreCase("opera")) {
                return getGridOperaDriver();
            }
        }
        return getGridFireFoxDriver();
    }


    private RemoteWebDriver getGridFireFoxDriver() {
        DesiredCapabilities cap = DesiredCapabilities.firefox();
        try {
            return new RemoteWebDriver(new URL(Config.getProperty("grid.hub")), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private RemoteWebDriver getGridChromeDriver() {
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("disable-extensions");
        options.addArguments("disable-infobars");
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        try {
            return new RemoteWebDriver(new URL(Config.getProperty("grid.hub")), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private RemoteWebDriver getGridInternetExplorerDriver() {
        DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
        try {
            RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
            driver.manage().window().setSize(new Dimension(900, 512));
            return driver;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private RemoteWebDriver getGridOperaDriver() {
        DesiredCapabilities cap = DesiredCapabilities.opera();
        try {
            return new RemoteWebDriver(new URL(Config.getProperty("grid.hub")), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
