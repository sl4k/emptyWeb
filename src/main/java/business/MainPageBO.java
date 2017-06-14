package business;

import pages.MainPage;

public class MainPageBO {

    private MainPage mainPage = new MainPage();



    public boolean selectUaLanguage(){
        mainPage.setUaLanguage();
        return mainPage.isUaLanguageSelected();
    }

    public boolean selectRuLanguage(){
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
