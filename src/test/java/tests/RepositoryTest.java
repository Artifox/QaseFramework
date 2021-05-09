package tests;

import models.Project;
import models.Suite;
import org.testng.annotations.Test;
import utils.ProjectFactory;
import utils.SuiteFactory;

import static models.RadioButtonOptions.CreateNewProjectOptions.PRIVATE;

public class RepositoryTest extends BaseTest {

    @Test
    public void suiteShouldBeCreated() {
        ProjectFactory projectFactory = new ProjectFactory();
        SuiteFactory suiteFactory = new SuiteFactory();
        Project project = projectFactory.getProject();
        Suite suite = suiteFactory.getSuite();

        loginSteps
                .login(EMAIL, PASSWORD);
        projectsSteps
                .createNewProject(project);
        repositorySteps
                .createNewSuite(suite);
        //TODO: .validateIsSuiteCreated(suite);
    }

    public void caseShouldBeCreated() {
    }

}
