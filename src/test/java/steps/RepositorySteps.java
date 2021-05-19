package steps;

import io.qameta.allure.Step;
import models.Case;
import models.Suite;
import pageobjects.CreateNewCasePage;
import pageobjects.RepositoryPage;

public class RepositorySteps {
    RepositoryPage repositoryPage;
    CreateNewCasePage createNewCasePage;

    public RepositorySteps() {
        repositoryPage = new RepositoryPage();
    }

    @Step
    public RepositorySteps createNewSuite(Suite suite) {
        repositoryPage
                .clickCreateNewSuiteButton()
                .createNewSuite(suite);
        return this;
    }

    @Step
    public RepositorySteps validateSuiteFields(Suite suite) {
        repositoryPage
                .validateSuiteFields(suite);
        return this;
    }

    @Step
    public RepositorySteps deleteSuite(String suiteName) {
        repositoryPage
                .deleteSuite(suiteName)
                .confirmDeletingSuite();
        return this;
    }

    @Step
    public RepositorySteps updateSuite(String suiteName, Suite suite) {
        repositoryPage
                .clickEditSuiteButton(suiteName)
                .updateSuite(suite);
        return this;
    }

    @Step
    public RepositorySteps createNewCaseWithoutSuite(Case aCase) {
        repositoryPage
                .clickCreateNewCaseButton()
                .createCase(aCase);
        return this;
    }

    public RepositorySteps updateCase(String caseName, Case aCase) {
        repositoryPage
                .clickEditCaseButton(caseName)
                .updateCase(aCase);
        return this;
    }

    public RepositorySteps validateCaseFields(String caseName, Case aCase) {
        repositoryPage
                .clickEditCaseButton(caseName)
                .validateCaseFields(aCase);
        return this;
    }

    public RepositorySteps deleteCase(String caseName) {
        repositoryPage
                .deleteCase(caseName)
                .confirmDeletingCase();
        return this;
    }

    public RepositorySteps isSuiteDeleted(String suiteName) {
        repositoryPage
                .isSuiteDeleted(suiteName);
        return this;
    }

    public RepositorySteps isCaseDeleted(String caseName) {
        repositoryPage
                .isCaseDeleted(caseName);
        return this;
    }
}
