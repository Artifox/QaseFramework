package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import steps.RepositorySteps;
import wrappers.Button;

import static com.codeborne.selenide.Selenide.$x;

public class RepositoryPage extends BasePage {

    private String header = "//*[contains(text(),'%s')]";


    public RepositoryPage isOpened(String projectName) {
        $x(String.format(header, projectName))
                .shouldBe(Condition.exactText(projectName));
        return this;
    }

    public RepositoryPage open(String name) {
        Selenide.open("/project/" + name);
        return null;
    }

    @Deprecated
    @Override
    public RepositoryPage isOpened() {
        return this;
    }

    @Deprecated
    @Override
    public RepositoryPage open() {
        try {
            throw new Exception("This method is deprecated");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public SuiteModal clickCreateNewSuiteButton() {
        new Button("Create new suite").click();
        return new SuiteModal();
    }
}
