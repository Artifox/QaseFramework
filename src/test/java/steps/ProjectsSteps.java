package steps;

import io.qameta.allure.Step;
import models.Project;
import pageobjects.CreateNewProjectPage;
import pageobjects.ProjectPage;
import pageobjects.ProjectsListPage;

public class ProjectsSteps {
    CreateNewProjectPage createNewProjectPage;
    ProjectsListPage projectsListPage;
    ProjectPage projectPage;

    public ProjectsSteps() {
        createNewProjectPage = new CreateNewProjectPage();
        projectsListPage = new ProjectsListPage();
        projectPage = new ProjectPage();
    }

    @Step
    public ProjectsSteps createNewProject(Project project) {
        projectsListPage
                .open()
                .pressCreateNewProjectButton()
                .createNewProject(project);
        return this;
    }

    @Step
    public ProjectsSteps validateIsProjectCreated(Project project) {
        projectsListPage
                .open()
                .isProjectExist(project);
        return this;
    }
}
