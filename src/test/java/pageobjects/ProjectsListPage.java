package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import models.Project;
import wrappers.Button;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectsListPage extends BasePage {

    //private SelenideElement createNewProjectButton = $("#createButton");
    private String projectNameLocator = "//*[contains(text(),'%s')]";

    @Override
    public ProjectsListPage isOpened() {
        new Button("Create new project").shouldBe(Condition.visible);
        return this;
    }

    @Override
    public ProjectsListPage open() {
        Selenide.open("/projects");
        return this;
    }

    public CreateNewProjectPage pressCreateNewProjectButton() {
        new Button("Create new project").click();
        return new CreateNewProjectPage();
    }

    public ProjectsListPage isProjectExist(Project project) {
        $x(String.format(projectNameLocator, project.getName())).shouldBe(Condition.visible);
        return this;
    }
}
