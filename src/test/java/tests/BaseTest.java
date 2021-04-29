package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pageobjects.CreateNewProjectPage;
import pageobjects.LoginPage;
import pageobjects.WelcomePage;
import steps.LoginSteps;
import steps.ProjectsSteps;

public class BaseTest {
    public static final String EMAIL = "qasetestako@mailinator.com";
    public static final String PASSWORD = "qasetestako@mailinator.com";
    LoginSteps loginSteps;
    ProjectsSteps projectsSteps;

    @BeforeSuite
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.holdBrowserOpen = true;

        loginSteps = new LoginSteps();
        projectsSteps = new ProjectsSteps();
    }
}
