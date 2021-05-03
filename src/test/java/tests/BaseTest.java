package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import steps.LoginSteps;
import steps.ProjectsSteps;
import utils.TestListener;

import java.util.Locale;

@Listeners(TestListener.class)
public class BaseTest {
    public static final String EMAIL = "qasetestako@mailinator.com";
    public static final String PASSWORD = "qasetestako@mailinator.com";
    FakeValuesService fakeValuesService;
    LoginSteps loginSteps;
    ProjectsSteps projectsSteps;

    @BeforeSuite
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.holdBrowserOpen = true;
        loginSteps = new LoginSteps();
        projectsSteps = new ProjectsSteps();

        fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

    }
}
