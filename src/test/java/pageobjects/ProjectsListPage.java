package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import models.Project;
import wrappers.Button;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectsListPage extends BasePage {

    private String projectNameLabel = "//table[contains(@class,'table')]//*[contains(text(), '%s')]";
    private String threeDotsButton = "//*[contains(text(),'%s')]/parent::div/parent::td/following-sibling::td[@class='text-end']/descendant::a[contains(@class, 'btn')]";
    private String deleteDropdownOption = "//*[contains(text(),'%s')]/parent::div/parent::td/following-sibling::td[@class='text-end']/descendant::div[contains(@class, 'dropdown-menu')]/descendant::a[contains(text(), 'Delete')]";
    private String settingsDropdownOption = "//*[contains(text(),'%s')]/parent::div/parent::td/following-sibling::td[@class='text-end']/descendant::div[contains(@class, 'dropdown-menu')]/descendant::a[contains(text(), 'Settings')]";

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
        $x(String.format(projectNameLabel, project.getName())).shouldBe(Condition.visible);
        return this;
    }

    public ProjectsListPage isProjectNotExist(Project project) {
        $x(String.format(projectNameLabel, project.getName())).shouldNotBe(Condition.visible);
        return this;
    }

    public DeleteConfirmationPage findProjectAndPressDeleteButton(Project project) {
        findProjectAndPressThreeDotsButton(project);
        $x(String.format(deleteDropdownOption, project.getName())).click();
        return new DeleteConfirmationPage();
    }

    public RepositoryPage openProject(Project project) {
        $x(String.format(projectNameLabel, project.getName())).click();
        return new RepositoryPage();
    }

    public void findProjectAndPressSettingsButton(Project project) {
        findProjectAndPressThreeDotsButton(project);
        $x(String.format(deleteDropdownOption, project.getName())).click();

    }

    public ProjectsListPage findProjectAndPressThreeDotsButton(Project project) {
        $x(String.format(threeDotsButton, project.getName())).click();
        return this;
    }
}
