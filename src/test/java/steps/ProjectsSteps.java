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
    public ProjectsSteps validateProjectFields(Project project) {
        projectSettingsPage
                .open(project.getCode())
                .validateProjectSettings(project);
        return this;
    }

    @Step
    public ProjectsSteps deleteProject(String projectName) {
        projectsListPage
                .open()
                .findProjectAndPressDeleteButton(projectName)
                .confirmDeleting();
        return this;
    }

    @Step
    public ProjectsSteps updateProject(String sourceProject, Project project2) {
        projectSettingsPage
                .open(sourceProject)
                .editProject(project2);
        return this;
    }

    public ProjectsSteps isProjectDeleted(String projectName) {
        projectsListPage
                .isProjectDeleted(projectName);
        return this;
    }
}
