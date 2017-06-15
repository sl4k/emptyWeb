import driver.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    @BeforeClass
    public void getHomePage() {
        Driver.getDriver().get("http://rozetka.com.ua/ua/");
    }

    @AfterClass
    public void driverQuit(){
        Driver.quit();
    }
}
