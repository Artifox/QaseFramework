package tests.api;

import adapters.ProjectAdapter;
import models.Project;
import org.testng.annotations.Test;
import utils.ProjectFactory;

public class ProjectTest {

    @Test
    public void createProject() {
        ProjectFactory projectFactory = new ProjectFactory();
        Project project = projectFactory.getProject();
        ProjectAdapter projectAdapter = new ProjectAdapter();
        projectAdapter.post(project);
        projectAdapter.get(project.getCode());
    }
}
