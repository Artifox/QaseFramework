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

    @Step("Creating a new suite: {suite.title}")
    public RepositorySteps createNewSuite(Suite suite) {
        repositoryPage
                .clickCreateNewSuiteButton()
                .createNewSuite(suite);
        return this;
    }

    @Step("Validating fields of suite: {suite.title}")
    public RepositorySteps validateSuiteFields(Suite suite) {
        repositoryPage
                .validateSuiteFields(suite);
        return this;
    }

    @Step("Deleting suite: 'suiteName'")
    public RepositorySteps deleteSuite(String suiteName) {
        repositoryPage
                .deleteSuite(suiteName)
                .confirmDeletingSuite();
        return this;
    }

    @Step("Updating suite 'suiteName' with new fields")
    public RepositorySteps updateSuite(String suiteName, Suite suite) {
        repositoryPage
                .clickEditSuiteButton(suiteName)
                .updateSuite(suite);
        return this;
    }

    @Step("Creating a new case: {aCase.title}")
    public RepositorySteps createNewCaseWithoutSuite(Case aCase) {
        repositoryPage
                .clickCreateNewCaseButton()
                .createCase(aCase);
        return this;
    }

    @Step("Updating case 'caseName' with new fields")
    public RepositorySteps updateCase(String caseName, Case aCase) {
        repositoryPage
                .clickEditCaseButton(caseName)
                .updateCase(aCase);
        return this;
    }

    @Step("Validating fields of case: 'caseName'")
    public RepositorySteps validateCaseFields(String caseName, Case aCase) {
        repositoryPage
                .clickEditCaseButton(caseName)
                .validateCaseFields(aCase);
        return this;
    }

    @Step("Deleting case: 'caseName'")
    public RepositorySteps deleteCase(String caseName) {
        repositoryPage
                .deleteCase(caseName)
                .confirmDeletingCase();
        return this;
    }

    @Step("Verifying is 'suiteName' suite deleted")
    public RepositorySteps isSuiteDeleted(String suiteName) {
        repositoryPage
                .isSuiteDeleted(suiteName);
        return this;
    }

    @Step("Verifying is 'caseName' case deleted")
    public RepositorySteps isCaseDeleted(String caseName) {
        repositoryPage
                .isCaseDeleted(caseName);
        return this;
    }
}
