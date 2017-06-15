package driver;

import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver {

    private static RemoteWebDriver driver;

    private void setPath() {
        System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        System.setProperty("webdriver.opera.driver", "src\\test\\resources\\operadriver.exe");
        System.setProperty("webdriver.ie.driver", "src\\test\\resources\\IEDriverServer.exe");
    }

    public static synchronized RemoteWebDriver getDriver() {
        if (driver == null) {
            driver = initializeDriver();
        }
        return driver;
    }

    public static RemoteWebDriver initializeDriver(){
            BrowserDriverFactory factory = new BrowserDriverFactory();
            return factory.getAppropriateDriver("chrome");
    }

    public static void quit(){
        if (driver != null) {
            driver.quit();
        }
    }

}
