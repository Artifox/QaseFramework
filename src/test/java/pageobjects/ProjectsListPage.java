package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import models.Project;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectsListPage extends BasePage {

    private SelenideElement createNewProjectButton = $("#createButton");
    private String projectNameLocator = "//a[@href='/project/%s']";

    @Override
    public ProjectsListPage isOpened() {
        createNewProjectButton.shouldBe(Condition.visible);
        return this;
    }

    @Override
    public ProjectsListPage open() {
        Selenide.open("/projects");
        return this;
    }

    public CreateNewProjectPage pressCreateNewProjectButton() {
        createNewProjectButton.click();
        return new CreateNewProjectPage();
    }

    //Todo: Возвращать булин или пэйджу?
    public ProjectsListPage isProjectExist(Project project) {
        String projectName = project.getName();
        projectName = projectName.toUpperCase();
        projectName = projectName.substring(0, 10);
        $x(String.format(projectNameLocator, projectName)).shouldBe(Condition.visible);
        return this;
    }
}
