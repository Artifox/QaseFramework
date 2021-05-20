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

    @Step("Create '{project.code}' project")
    public ProjectsSteps createNewProject(Project project) {
        projectsListPage
                .open()
                .pressCreateNewProjectButton()
                .createNewProject(project);
        return this;
    }

    @Step("Validating fields of project: {project.code}")
    public ProjectsSteps validateProjectFields(Project project) {
        projectSettingsPage
                .open(project.getCode())
                .validateProjectSettings(project);
        return this;
    }

    @Step("Deleting project: 'projectCode'")
    public ProjectsSteps deleteProject(String projectCode) {
        projectSettingsPage
                .open(projectCode)
                .clickDeleteProjectButton()
                //.findProjectAndPressDeleteButton(projectName)
                .confirmDeleting();
        return this;
    }

    @Step("Updating project 'sourceProject' with new fields")
    public ProjectsSteps updateProject(String sourceProject, Project project2) {
        projectSettingsPage
                .open(sourceProject)
                .editProject(project2);
        return this;
    }

    @Step("Validating is project deleted")
    public ProjectsSteps isProjectDeleted(String projectName) {
        projectsListPage
                .isProjectDeleted(projectName);
        return this;
    }
}
