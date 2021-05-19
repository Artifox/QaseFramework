package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import models.Suite;
import wrappers.Button;

import static com.codeborne.selenide.Selenide.$x;

public class RepositoryPage extends BasePage {

    private String header = "//*[contains(text(),'%s')]";
    private String suiteNameLabel = "//a[@class='suite-header-title' and contains(text(),'%s')]";
    private String suiteDescription = "//*[@class='suite-description']/child::p[contains(text(),'%s')]";
    private String suiteDeleteButton = "//*[@class='suite-header-title' and contains(text(),'%s')]/following-sibling::button/i[contains(@class, 'fa-trash')]";


    public RepositoryPage isOpened(String projectName) {
        $x(String.format(header, projectName))
                .shouldBe(Condition.exactText(projectName));
        return this;
    }

    public RepositoryPage open(String name) {
        Selenide.open("/project/" + name);
        return this;
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

    public RepositoryPage validateSuiteFields(Suite suite) {
        $x(String.format(suiteNameLabel, suite.getName())).shouldHave(Condition.exactText(suite.getName()));
        $x(String.format(suiteDescription, suite.getDescription())).shouldHave(Condition.exactText(suite.getDescription()));
        return this;
    }

    public RepositoryPage hoverOnSuiteName(String suiteName) {
        $x(String.format(suiteNameLabel, suiteName)).hover();
        return this;
    }

    public RepositoryPage deleteSuite(String suiteName) {
        hoverOnSuiteName(suiteName);
        $x(String.format(suiteDeleteButton,suiteName)).click();
        return this;
    }

    public RepositoryPage confirmDeleting() {
        new Button("Delete suite").click();
        return this;
    }
}
