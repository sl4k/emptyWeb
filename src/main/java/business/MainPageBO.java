package business;

import pages.MainPage;

public class MainPageBO {

    private MainPage mainPage = new MainPage();


    public boolean selectUaLanguageAndCheck() {
        if (mainPage.isUaLanguageSelected()) {
            return mainPage.isUaLanguageSelected();
        }
        mainPage.changeLanguage();
        return mainPage.isUaLanguageSelected();
    }

    public boolean selectRuLanguageAndCheck() {
        if (mainPage.isRuLanguageSelected()) {
            return mainPage.isRuLanguageSelected();
        }
        mainPage.changeLanguage();
        return mainPage.isRuLanguageSelected();
    }

    public String getActiveLanguage() {
        return mainPage.getCurrentLanguage();
    }


}
