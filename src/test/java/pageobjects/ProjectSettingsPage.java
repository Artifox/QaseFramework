package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import models.Project;
import wrappers.Button;
import wrappers.Input;
import wrappers.RadioButton;
import wrappers.TextArea;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectSettingsPage extends BasePage {
    private SelenideElement settingsLabel = $x("//*[contains(@class, 'project-settings-tab')]/descendant::h1[text()='Settings']");
    private SelenideElement deleteProjectButton = $x("//*[contains(@class,'text-start')]/*[contains(@class,'btn-cancel')]");

    @Override
    public ProjectSettingsPage isOpened() {
        settingsLabel.shouldBe(Condition.visible);
        return this;
    }

    @Deprecated
    @Override
    public BasePage open() throws Exception {
        throw new Exception("You are using deprecated method");
    }

    public ProjectSettingsPage open(String projectCode) {
        Selenide.open("/project/" + projectCode + "/settings/general");
        return this;
    }

    public ProjectSettingsPage editProject(Project project) {
        new Input("Project name").clear().write(project.getTitle());
        new Input("Project Code").clear().write(project.getCode());
        new TextArea("Description").clear().write(project.getDescription());
        new RadioButton(project.getAccess()).setRadioButton();
        new Button("Update settings").click();
        return this;
    }

    public void validateProjectSettings(Project project) {
        new Input("Project name").shouldHave(project.getTitle());
        new Input("Project Code").shouldHave(project.getCode());
        new TextArea("Description").shouldHave(project.getDescription());
        new RadioButton(project.getAccess()).shouldBe(Condition.selected);
    }

    public DeleteConfirmationPage clickDeleteProjectButton() {
        deleteProjectButton.click();
        return new DeleteConfirmationPage();
    }
}
