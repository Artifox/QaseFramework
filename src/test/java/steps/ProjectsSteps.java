package steps;

import models.Project;
import pageobjects.CreateNewProjectPage;
import pageobjects.ProjectPage;
import pageobjects.ProjectsListPage;

public class ProjectsSteps{
    CreateNewProjectPage createNewProjectPage;
    ProjectsListPage projectsListPage;
    ProjectPage projectPage;

    public ProjectsSteps(){
        createNewProjectPage = new CreateNewProjectPage();
        projectsListPage = new ProjectsListPage();
        projectPage = new ProjectPage();
    }

    public ProjectsSteps createNewProject(Project project){
        projectsListPage
                .open()
                .pressCreateNewProjectButton()
                .createNewProject(project.getName(), project.getCode());
        return this;
    }

    public ProjectsSteps validateIsProjectCreated(Project project){
        projectsListPage
                .open()
                .isProjectExist(project);
        return this;
    }
}
