package tests;

import models.Project;
import models.Suite;
import org.testng.annotations.Test;
import utils.ProjectFactory;
import utils.SuiteFactory;

public class RepositoryTest extends BaseTest {

    @Test
    public void suiteCRUD() {
        ProjectFactory projectFactory = new ProjectFactory();
        SuiteFactory suiteFactory = new SuiteFactory();
        Project project = projectFactory.getProject();
        Suite suite = suiteFactory.getSuite();

        projectsSteps
                .createNewProject(project);
        repositorySteps
                .createNewSuite(suite)
                .validateSuiteFields(suite)
                .deleteSuite(suite.getName());
    }
}
