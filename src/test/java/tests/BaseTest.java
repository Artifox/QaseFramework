package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import steps.LoginSteps;
import steps.ProjectsSteps;
import steps.RepositorySteps;
import utils.PropertyReader;
import utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

    public static final String EMAIL = System.getenv().getOrDefault("LOGIN", PropertyReader.getProperty("LOGIN"));
    public static final String PASSWORD = System.getenv().getOrDefault("PASSWORD", PropertyReader.getProperty("PASSWORD"));
    LoginSteps loginSteps;
    ProjectsSteps projectsSteps;
    RepositorySteps repositorySteps;

    @BeforeClass
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.holdBrowserOpen = true;
        loginSteps = new LoginSteps();
        projectsSteps = new ProjectsSteps();
        repositorySteps = new RepositorySteps();
        loginSteps
                .login(EMAIL, PASSWORD);
    }
}
