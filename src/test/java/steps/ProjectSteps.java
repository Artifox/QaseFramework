package steps;

import io.qameta.allure.Step;
import pageobjects.ProjectsPage;

public class ProjectSteps {

    ProjectsPage projectsPage;

    public ProjectSteps() {
        projectsPage = new ProjectsPage();
    }

    @Step("Validation that Projects page is opened")
    public ProjectSteps isProjectsPageOpened(){
        projectsPage.isOpened();
        return new ProjectSteps();
    }
}
