package pages;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//div[contains(@class, 'lang-switcher-i')]/*[contains(text(), 'ua')]")
    private WebElement uaLanguage;

    @FindBy(xpath = "//div[contains(@class, 'lang-switcher-i')]/*[contains(text(), 'ru')]")
    private WebElement ruLanguage;

    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void setUaLanguage(){
        uaLanguage.click();
    }

    public boolean isUaLanguageSelected(){
        return uaLanguage.isSelected();
    }

    public void setRuLanguage(){
        ruLanguage.click();
    }

    public boolean isRuLanguageSelected(){
        return ruLanguage.isSelected();
    }


}
