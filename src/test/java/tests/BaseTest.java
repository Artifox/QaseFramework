package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import steps.LoginSteps;
import steps.ProjectsSteps;
import utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {
    public static final String EMAIL = "qasetestako@mailinator.com";
    public static final String PASSWORD = "qasetestako@mailinator.com";
    LoginSteps loginSteps;
    ProjectsSteps projectsSteps;

    @BeforeSuite
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.holdBrowserOpen = false;

        loginSteps = new LoginSteps();
        projectsSteps = new ProjectsSteps();
    }
}
