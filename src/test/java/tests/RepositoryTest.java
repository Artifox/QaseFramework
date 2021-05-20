package tests;

import models.Case;
import models.Project;
import models.Suite;
import org.testng.annotations.Test;
import utils.CaseFactory;
import utils.ProjectFactory;
import utils.SuiteFactory;

public class RepositoryTest extends BaseTest {

    @Test
    public void suiteCRUD() {
        ProjectFactory projectFactory = new ProjectFactory();
        SuiteFactory suiteFactory = new SuiteFactory();
        Project project = projectFactory.getProject();
        Suite suite = suiteFactory.getSuite();
        Suite suite2 = suiteFactory.getSuite();

        projectsSteps
                .createNewProject(project);
        repositorySteps
                .createNewSuite(suite)
                .updateSuite(suite.getTitle(), suite2)
                .validateSuiteFields(suite2)
                .deleteSuite(suite2.getTitle())
                .isSuiteDeleted(suite2.getTitle());
    }

    @Test
    public void caseCRUD() {
        ProjectFactory projectFactory = new ProjectFactory();
        Project project = projectFactory.getProject();
        CaseFactory caseFactory = new CaseFactory();
        Case aCase = caseFactory.getCase();
        Case aCase2 = caseFactory.getCase();

        projectsSteps
                .createNewProject(project);
        repositorySteps
                .createNewCaseWithoutSuite(aCase)
                .updateCase(aCase.getTitle(), aCase2)
                .validateCaseFields(aCase2.getTitle(), aCase2)
                .deleteCase(aCase2.getTitle())
                .isCaseDeleted(aCase2.getTitle());
    }
}
