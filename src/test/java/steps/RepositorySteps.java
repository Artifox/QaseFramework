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
}
