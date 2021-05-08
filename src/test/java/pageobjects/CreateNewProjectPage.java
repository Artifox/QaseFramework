package pageobjects;

import com.codeborne.selenide.Selenide;
import models.Project;
import wrappers.Button;
import wrappers.Input;
import wrappers.RadioButton;
import wrappers.TextArea;

import static com.codeborne.selenide.Condition.visible;

public class CreateNewProjectPage extends BasePage {

    @Override
    public CreateNewProjectPage isOpened() {
        new Button("Create project").shouldBe(visible);
        return this;
    }

    @Override
    public CreateNewProjectPage open() {
        Selenide.open("/project/create");
        return new CreateNewProjectPage();
    }

    public RepositoryPage createNewProject(Project project) {
        new Input("Project name").write(project.getName());
        new Input("Project Code").clear().write(project.getCode());
        new TextArea("Description").write(project.getDescription());
        new RadioButton(project.getAccessType()).setRadioButton();
        new Button("Create project").click();
        return new RepositoryPage();
    }

    private void clearProjectCode() {

    }

}
