package webPages;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import resources.LocatorPropertyconfig;
import resources.PropertyClassconfig;

public class HomePage extends BaseClass
{



    private By categoriesBtn = By.xpath(LocatorPropertyconfig.getproperty("categoriesbtnInHomePage"));
    private By logo     = By.xpath(LocatorPropertyconfig.getproperty("Logo"));
    private By ClickCareBtn = By.xpath(LocatorPropertyconfig.getproperty("QlickCare"));
    private By clickGiftCardBtn = By.xpath(LocatorPropertyconfig.getproperty("GiftCardbtn"));


    public void clickTheClicQcareBtn()
    {
        clickTheElement(ClickCareBtn);
        String gettitle = getTitle();
        Assert.assertEquals(PropertyClassconfig.getproperty("shoppingliNKTitleInClickCare"), gettitle);
    }

    public void clickGiftCardBtn()
    {
        clickTheElement(clickGiftCardBtn);
        String gettitle = getTitle();
        Assert.assertEquals(PropertyClassconfig.getproperty("shoppingliNKTitleInClickCare"), gettitle);
    }


    public void clickLogo()
    {

       refreshThePage();
        clickTheElement(logo);
    }
    public void launch(String BrowserName)
    {

        selectBrowser(BrowserName);
        threadDriver.get().get(PropertyClassconfig.getproperty("Url"));
    }

    public void categoriesFunctionInHomePage() throws InterruptedException {
         clickTheElement(categoriesBtn);
        // Thread.sleep(3000);
         //clickTheElement(logo);
         openNewWindowwithJavaScript(logo);
         waitTime();

    }

    public void SignIn()
    {
        
    }


}
