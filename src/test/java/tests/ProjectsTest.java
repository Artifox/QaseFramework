package tests;

import models.Project;
import org.testng.annotations.Test;
import utils.ProjectFactory;

public class ProjectsTest extends BaseTest {

    @Test
    public void projectCRUD() {
        ProjectFactory projectsFactory = new ProjectFactory();
        Project project = projectsFactory.getProject();
        Project project2 = projectsFactory.getProject();

        projectsSteps
                .createNewProject(project)
                .updateProject(project.getCode(), project2)
                .validateProjectFields(project2)
                .deleteProject(project.getName());
    }
}

