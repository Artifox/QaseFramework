package tests;

import models.Project;
import models.Suite;
import org.testng.annotations.Test;

import static models.RadioButtonOptions.CreateNewProjectOptions.PRIVATE;

public class RepositoryTest extends BaseTest {

    @Test
    public void suiteShouldBeCreated(){
        Project project = Project.builder()
                .name(fakeValuesService.regexify("[a-z1-9]{10}"))
                .code(fakeValuesService.regexify("[a-z1-9]{10}"))
                .description(fakeValuesService.regexify("[a-z1-9]{10}"))
                .accessType(PRIVATE)
                .build();

        Suite suite = Suite.builder()
                .name(fakeValuesService.regexify("[a-z1-9]{10}"))
                .description(fakeValuesService.regexify("[a-z1-9]{10}"))
                .preconditions(fakeValuesService.regexify("[a-z1-9]{10}"))
                .build();

        loginSteps
                .login(EMAIL, PASSWORD);
        projectsSteps
                .createNewProject(project);
        repositorySteps
                .createNewSuite(suite);
                //.validateIsSuiteCreated(suite);
    }

    public void caseShouldBeCreated(){
    }

}
