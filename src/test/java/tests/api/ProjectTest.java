package tests.api;

import adapters.ProjectAdapter;
import models.Project;
import org.testng.annotations.Test;
import utils.ProjectFactory;

public class ProjectTest {

    @Test
    public void createAndDeleteProject() {
        ProjectFactory projectFactory = new ProjectFactory();
        Project project = projectFactory.getProject();

        ProjectAdapter projectAdapter = new ProjectAdapter();
        projectAdapter.post(project, true);
        projectAdapter.get(project, 200, true);
        projectAdapter.delete(project, true);
        projectAdapter.get(project, 404, false);
    }
}
