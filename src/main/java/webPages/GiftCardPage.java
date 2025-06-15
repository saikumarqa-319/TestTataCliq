package webPages;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import resources.LocatorPropertyconfig;
import resources.PropertyClassconfig;

public class GiftCardPage  extends BaseClass
{
    private By exploreBenfitsBtn = By.xpath(LocatorPropertyconfig.getproperty("exploreBenfitsBtn"));
    private By benfitsText    = By.xpath(LocatorPropertyconfig.getproperty("benfitsVerifyText"));
    private By contactUsBtnClickCare  = By.xpath(LocatorPropertyconfig.getproperty("contactUsBtn"));
    private By namefield = By.xpath(LocatorPropertyconfig.getproperty("NameInCntcForm"));
    private By companyNamefield = By.xpath(LocatorPropertyconfig.getproperty("compnyNameInCntctForm"));
    private By corporateEmailField = By.xpath(LocatorPropertyconfig.getproperty("corportateEmailInCntcForm"));
    private By errorMessage = By.xpath(LocatorPropertyconfig.getproperty("errorText"));
    private By crossIcon   = By.xpath(LocatorPropertyconfig.getproperty("crossIcon"));
    public  void clickExploreBenfiTSBtn()
    {
        waitTime();
        clickTheElement(exploreBenfitsBtn);
        boolean displayed = isDisplayed(benfitsText);
        Assert.assertEquals(displayed, true);


    }

    public void contactUs()
    {
        clickTheElement(contactUsBtnClickCare);
        enterInput(namefield, PropertyClassconfig.getproperty("Nameincnctcform"));
        enterInput(companyNamefield, PropertyClassconfig.getproperty("CompanyName"));
        enterInput(corporateEmailField, PropertyClassconfig.getproperty("CorporateEmail"));
        boolean result = isDisplayed(errorMessage);
        Assert.assertEquals(result, true);
        clickTheElement(crossIcon);



    }


}
