package tests;

import models.Project;
import org.testng.annotations.Test;

import static models.RadioButtonOptions.CreateNewProjectOptions.PRIVATE;

public class ProjectsTest extends BaseTest {

    @Test
    public void projectCRUD() {
        //Todo: создать класс по созданию проектов и отдавать сюда готовый
         Project project = Project.builder()
                .name(fakeValuesService.regexify("[a-z1-9]{10}"))
                .code(fakeValuesService.regexify("[A-Z1-9]{6}"))
                .description(fakeValuesService.regexify("[a-z1-9]{10}"))
                .accessType(PRIVATE)
                .build();
        Project project2 = Project.builder()
                .name(fakeValuesService.regexify("[a-z1-9]{10}"))
                .code(fakeValuesService.regexify("[A-Z1-9]{6}"))
                .description(fakeValuesService.regexify("[a-z1-9]{10}"))
                .accessType(PRIVATE)
                .build();

        projectsSteps
                .createNewProject(project)
                .validateIsProjectCreated(project)
                .editProject(project, project2)
                .validateIsProjectUpdated(project, project2)
                .deleteProject(project2);
    }
}

