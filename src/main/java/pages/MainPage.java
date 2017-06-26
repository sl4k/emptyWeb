package pages;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//div[contains(@class, 'lang-switcher-i')]/a")
    private WebElement changeLanguage;

    @FindBy(xpath = "//div[contains(@class, 'lang-switcher-i')]//span")
    private WebElement getCurrentLang;

    public MainPage() {
        PageFactory.initElements(Driver.getCurrentDriver(), this);
    }

    public void changeLanguage(){
        changeLanguage.click();
    }

    public String getCurrentLanguage(){
        return getCurrentLang.getText();
    }

    public boolean isUaLanguageSelected(){
        return getCurrentLanguage().equalsIgnoreCase("ua");
    }

    public boolean isRuLanguageSelected(){
        return getCurrentLanguage().equalsIgnoreCase("ru");
    }
}
