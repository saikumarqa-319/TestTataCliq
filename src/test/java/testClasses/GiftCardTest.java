package testClasses;

import BaseClass.BaseClass;
import org.testng.annotations.Test;
import webPages.GiftCardPage;
import webPages.HomePage;

import javax.sound.midi.ShortMessage;

public class GiftCardTest extends BaseClass
{
    private HomePage home = new HomePage();
    private GiftCardPage gift = new GiftCardPage();




    @Test
    public void GiftCardExploringTest()
    {
        home.launch();
        home.clickGiftCardBtn();
        gift.clickExploreBenfiTSBtn();
        gift.contactUs();
        home.clickLogo();

    }

}
