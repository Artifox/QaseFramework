package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import models.Project;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage extends BasePage {

    private String header = "//*[contains(text(),'%s')]";

    //TODO: Implement isOpened and open() methods

    @Override
    public ProjectPage isOpened() {
        return this;
    }

    public ProjectPage isCertainProjectOpened(Project project) {
        $x(String.format(header, project.getName()))
                .shouldBe(Condition.exactText(project.getName()));
        return this;
    }

    @Deprecated
    @Override
    public ProjectPage open() {
        return null;
    }
    public ProjectPage open(String name) {
        return null;
    }
}
