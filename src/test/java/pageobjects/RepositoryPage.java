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
    private String suiteEditButton = "//*[@class='suite-header-title' and contains(text(),'%s')]/following-sibling::button/i[contains(@class, 'fa-pencil-alt')]";
    private String aCaseNameLabel = "//*[contains(text(),'%s')]";
    private String editCaseButton = "//*[contains(@title,'Edit case')]";
    private String deleteCaseButton = "//*[contains(@title,'Delete case')]";
    private String confirmDeleteCaseButton = "//*[contains(@class,'modal-footer')]/*[contains(text(),'Delete')]";


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
    public RepositoryPage open() throws Exception {
        throw new Exception("You are using deprecated method");
    }

    public SuiteModal clickCreateNewSuiteButton() {
        new Button("Create new suite").click();
        return new SuiteModal();
    }

    public RepositoryPage validateSuiteFields(Suite suite) {
        $x(String.format(suiteNameLabel, suite.getTitle())).shouldHave(Condition.exactText(suite.getTitle()));
        $x(String.format(suiteDescription, suite.getDescription())).shouldHave(Condition.exactText(suite.getDescription()));
        return this;
    }

    public RepositoryPage hoverOnSuiteName(String suiteName) {
        $x(String.format(suiteNameLabel, suiteName)).hover();
        return this;
    }

    public RepositoryPage deleteSuite(String suiteName) {
        hoverOnSuiteName(suiteName);
        $x(String.format(suiteDeleteButton, suiteName)).click();
        return this;
    }

    public RepositoryPage confirmDeletingSuite() {
        new Button("Delete suite").click();
        return this;
    }

    public RepositoryPage confirmDeletingCase() {
        $x(confirmDeleteCaseButton).click();
        return this;
    }

    public SuiteModal clickEditSuiteButton(String suiteName) {
        hoverOnSuiteName(suiteName);
        $x(String.format(suiteEditButton, suiteName)).click();
        return new SuiteModal();
    }

    public CreateNewCasePage clickCreateNewCaseButton() {
        new Button("Create new case").click();
        return new CreateNewCasePage();
    }

    public CreateNewCasePage clickEditCaseButton(String caseName) {
        clickOnCaseName(caseName);
        $x(editCaseButton).click();
        return new CreateNewCasePage();
    }

    private RepositoryPage clickOnCaseName(String caseName) {
        $x(String.format(aCaseNameLabel, caseName)).click();
        return this;
    }

    public RepositoryPage deleteCase(String caseName) {
        clickOnCaseName(caseName);
        $x(deleteCaseButton).click();
        return this;
    }

    public RepositoryPage isSuiteDeleted(String suiteName) {
        $x(String.format(suiteNameLabel, suiteName)).shouldNotBe(Condition.visible);
        return this;
    }

    public RepositoryPage isCaseDeleted(String caseName) {
        $x(String.format(aCaseNameLabel, caseName)).shouldNotBe(Condition.visible);
        return this;
    }
}
