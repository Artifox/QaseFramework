package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import pages.WelcomePage;

public class BaseTest {

    WelcomePage welcomePage;

    @BeforeClass
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://qase.io";
        Configuration.holdBrowserOpen = true;

        welcomePage = new WelcomePage();
    }
}
