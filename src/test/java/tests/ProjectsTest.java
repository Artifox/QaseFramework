package tests;

import models.Project;
import org.testng.annotations.Test;

import static models.ProjectAccessType.PUBLIC;

public class ProjectsTest extends BaseTest {

    @Test
    public void projectShouldBeCreated() {
        //Todo: как создать класс по созданию проектов и отдавать сюда готовый?
        Project project = Project.builder()
                .name("projectName")
                .code("projectCode")
                .description("description")
                .accessType(PUBLIC)
                .build();

        loginSteps
                .login(EMAIL, PASSWORD);
        projectsSteps
                .createNewProject(project)
                .validateIsProjectCreated(project);
    }
}

