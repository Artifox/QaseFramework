package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import pageobjects.LoginPage;
import pageobjects.WelcomePage;
import steps.LoginSteps;

public class BaseTest {

    LoginSteps loginSteps;

    @BeforeClass
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://qase.io";
        Configuration.holdBrowserOpen = true;

        loginSteps = new LoginSteps();
    }
}
