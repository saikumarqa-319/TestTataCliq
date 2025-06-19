package testClasses;

import BaseClass.BaseClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webPages.ClickCare;
import webPages.HomePage;
import BaseClass.RetryAnalyzer;

public class HomePageTest extends BaseClass
{
    private HomePage home = new HomePage();
    private ClickCare care = new ClickCare();





    @Test(priority = 1 , retryAnalyzer = RetryAnalyzer.class)
    @Parameters("browserName")
    public void signInwithValidCredentials(String browserName) throws InterruptedException {
        home.launch(browserName);
        home.categoriesFunctionInHomePage();
        home.clickTheClicQcareBtn();
        care.clickTheShoppingLinkInClicqcare();
        care.clickTheoffersLinkInClicqcare();

    }


    @Test(priority = 2)
    @Parameters("browserName")
    public void signInwithValidCredentials2(String browserName) throws InterruptedException {
        home.launch(browserName);
        home.categoriesFunctionInHomePage();
        home.clickTheClicQcareBtn();
        care.clickTheShoppingLinkInClicqcare();
        care.clickTheoffersLinkInClicqcare();

    }

}
