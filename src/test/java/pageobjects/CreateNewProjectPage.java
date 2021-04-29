package pageobjects;

import com.codeborne.selenide.Selenide;
import models.ProjectAccessType;
import wrappers.Button;
import wrappers.Input;

public class CreateNewProjectPage extends BasePage {
    @Override
    public AbstractPage isOpened() {
        return null;
    }

    @Override
    public CreateNewProjectPage open() {
        Selenide.open("/project/create");
        return new CreateNewProjectPage();
    }

    public ProjectPage createNewProject(String projectName, String projectCode, String description, ProjectAccessType accessType) {
        this.createNewProject(projectName, projectCode);
        return new ProjectPage();
    }

    public ProjectPage createNewProject(String projectName, String projectCode) {
        new Input("Project name").write(projectName);
        new Input("Project Code").write(projectCode);
        new Button("Create project").click();
        return new ProjectPage();
    }
}
