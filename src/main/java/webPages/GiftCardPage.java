package webPages;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import resources.LocatorPropertyconfig;

public class GiftCardPage  extends BaseClass
{
    private By exploreBenfitsBtn = By.xpath(LocatorPropertyconfig.getproperty("exploreBenfitsBtn"));
    private By benfitsText    = By.xpath(LocatorPropertyconfig.getproperty("benfitsVerifyText"));
    private By contactUsBtnClickCare  = By.xpath(LocatorPropertyconfig.getproperty("offersLink"));

    public  void clickExploreBenfiTSBtn()
    {
        clickTheElement(exploreBenfitsBtn);
        boolean displayed = isDisplayed(benfitsText);
        Assert.assertEquals(displayed, true);
        clickTheElement(contactUsBtnClickCare);

    }
}
