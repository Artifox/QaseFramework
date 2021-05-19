package steps;

import models.Suite;
import pageobjects.RepositoryPage;

public class RepositorySteps {
    RepositoryPage repositoryPage;

    public RepositorySteps() {
        repositoryPage = new RepositoryPage();
    }

    public RepositorySteps createNewSuite(Suite suite) {
        repositoryPage
                .clickCreateNewSuiteButton()
                .createNewSuite(suite);
        return this;
    }

    public RepositorySteps validateSuiteFields(Suite suite) {
        repositoryPage
                .validateSuiteFields(suite);
        return this;
    }

    public RepositorySteps deleteSuite(String suiteName) {
        repositoryPage
                .deleteSuite(suiteName)
                .confirmDeleting();
        return this;
    }
}
