package testClasses;

import BaseClass.BaseClass;
import org.testng.annotations.Test;
import webPages.ClickCare;
import webPages.HomePage;

public class HomePageTest extends BaseClass
{
    private HomePage home = new HomePage();
    private ClickCare care = new ClickCare();



    @Test
    public void signInwithValidCredentials() throws InterruptedException {
        home.launch();
        home.categoriesFunctionInHomePage();
        home.clickTheClicQcareBtn();
        care.clickTheShoppingLinkInClicqcare();
        care.clickTheoffersLinkInClicqcare();

    }

}
