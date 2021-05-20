package tests.api;

import adapters.ProjectAdapter;
import models.Project;
import org.testng.annotations.Test;
import utils.ProjectFactory;

public class ProjectTest {

    @Test
    public void createAdnDeleteProject() {
        ProjectFactory projectFactory = new ProjectFactory();
        Project project = projectFactory.getProject();

        ProjectAdapter projectAdapter = new ProjectAdapter();
        projectAdapter.post(project, true);
        projectAdapter.get(project, 200, true);
        projectAdapter.delete(project.getCode(), true);
        projectAdapter.get(project, 404, false);
    }
}
