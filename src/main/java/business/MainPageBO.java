package business;

import pages.MainPage;

public class MainPageBO {

    private MainPage mainPage = new MainPage();



    public boolean selectUaLanguageAndCheck(){
        mainPage.setUaLanguage();
        return mainPage.isUaLanguageSelected();
    }

    public boolean selectRuLanguageAndCheck(){
        mainPage.setRuLanguage();
        return mainPage.isRuLanguageSelected();
    }

    public String getActiveLanguage(){
        if(mainPage.isUaLanguageSelected()){
            return "UA";
        }else{
            return "RU";
        }
    }


}
