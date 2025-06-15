package testClasses;

import BaseClass.BaseClass;
import org.apache.logging.log4j.core.net.Priority;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webPages.GiftCardPage;
import webPages.HomePage;

import javax.sound.midi.ShortMessage;

public class GiftCardTest extends BaseClass
{
    private HomePage home = new HomePage();
    private GiftCardPage gift = new GiftCardPage();




    @Test(priority = 1)
    @Parameters("browserName")
    public void GiftCardExploringTest(String browserName)
    {
        home.launch(browserName);
        home.clickGiftCardBtn();
        gift.clickExploreBenfiTSBtn();
        gift.contactUs();
        home.clickLogo();

    }

}
