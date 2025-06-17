package webPages;

import BaseClass.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import resources.LocatorPropertyconfig;
import resources.PropertyClassconfig;

public class ClickCare  extends BaseClass
{

    private By shoppinLinkInXClicqCare  = By.xpath(LocatorPropertyconfig.getproperty("shoppingLink"));
    private By offersLinkInXClicqCare  = By.xpath(LocatorPropertyconfig.getproperty("offersLink"));




    public void clickTheShoppingLinkInClicqcare()
    {
        clickTheElement(shoppinLinkInXClicqCare);
        String gettitle = getTitle();
        Assert.assertEquals(PropertyClassconfig.getproperty("shoppingliNKTitleInClickCare"), gettitle);

    }

    public void clickTheoffersLinkInClicqcare()
    {
        openNewWindow(offersLinkInXClicqCare);
        String gettitle = getTitle();
        Assert.assertEquals(PropertyClassconfig.getproperty("shoppingliNKTitleInClickCare"), gettitle);


    }




}
