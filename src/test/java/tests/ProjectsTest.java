package tests;

import models.Project;
import org.testng.annotations.Test;

import static models.RadioButtonOptions.CreateNewProjectOptions.PRIVATE;

public class ProjectsTest extends BaseTest {

    @Test
    public void projectShouldBeCreated() {
        //Todo: создать класс по созданию проектов и отдавать сюда готовый
        Project project = Project.builder()
                .name(fakeValuesService.regexify("[a-z1-9]{10}"))
                .code(fakeValuesService.regexify("[a-z1-9]{10}"))
                .description(fakeValuesService.regexify("[a-z1-9]{10}"))
                .accessType(PRIVATE)
                .build();

        loginSteps
                .login(EMAIL, PASSWORD);
        projectsSteps
                .createNewProject(project)
                .validateIsProjectCreated(project);
    }
}

