import common.Config;
import driver.Driver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase {


    public static String baseUrl = Config.getProperty("base.url");
    protected RemoteWebDriver driver;
//    public Asserter asserter = new Asserter();

    @BeforeMethod(alwaysRun = true)
    public  void startDriver(){

//        Logger.logDebug("Start TEST");
//        Logger.logDebug("Start BEFORE Method");
        while (true) {
            driver = Driver.getDriver();
//            driver.manage().window().maximize();
            if (driver != null)
                break;
        }

        driver.get(baseUrl);
//        Logger.logDebug("Finish BEFORE Method");
    }

    @AfterMethod(alwaysRun = true)
    public void releaseDriver(){
//        Logger.logDebug("Start AFTER Method");
        Driver.getCurrentDriver().get(baseUrl);
        Driver.releaseDriver();
//        Logger.logDebug("Finish AFTER Method");
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver(){
//        Logger.logDebug("Start AFTER Class");
        Driver.closeAllWindows();
//        Logger.logDebug("Finish AFTER Class");
    }

}
