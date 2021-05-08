package steps;

import io.qameta.allure.Step;
import models.Project;
import pageobjects.ProjectSettingsPage;
import pageobjects.ProjectsListPage;

public class ProjectsSteps {
    ProjectsListPage projectsListPage;
    ProjectSettingsPage projectSettingsPage;

    public ProjectsSteps() {
        projectsListPage = new ProjectsListPage();
        projectSettingsPage = new ProjectSettingsPage();
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

    @Step
    public ProjectsSteps validateIsProjectUpdated(Project project, Project project2) {
        validateIsProjectCreated(project2);
        projectsListPage
                .isProjectNotExist(project);
        return this;
    }

    @Step
    public void deleteProject(Project project) {
        projectsListPage
                .open()
                .findProjectAndPressDeleteButton(project)
                .confirmDeleting();
    }

    @Step
    public ProjectsSteps editProject(Project project, Project project2) {
        projectSettingsPage
                .open(project.getCode())
                .editProject(project2);
        return this;
    }
}
