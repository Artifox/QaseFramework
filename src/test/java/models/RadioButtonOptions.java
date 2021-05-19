package models;

public interface RadioButtonOptions {
    interface CreateNewProjectOptions {
        String PRIVATE = "private";
        String PUBLIC = "public";
    }

    interface CreateTestCaseStatusOptions {
        String ACTUAL = "Actual";
        String DRAFT = "Draft";
        String DEPRECATED = "Deprecated";
    }

    interface CreateTestCaseSuiteOptions {
        String WITHOUTSUITE = "Test cases without suite";
    }

    interface CreateTestCaseTypeOptions {
        String OTHER = "Other";
        String FUNCTIONAL = "Functional";
        String SMOKE = "Smoke";
        String REGRESSION = "Regression";
        String SECURITY = "Security";
        String USABILITY = "Usability";
        String PERFORMANCE = "Performance";
        String ACCEPTANCE = "Acceptance";
        String COMPATIBILITY = "Compatibility";
        String INTEGRATION = "Integration";
        String EXPLORATORY = "Exploratory";
    }

    interface CreateTestCaseSeverityOptions {
        String NOTSET = "Not set";
        String BLOCKER = "Blocker";
        String CRITICAL = "Critical";
        String MAJOR = "Major";
        String NORMAL = "Normal";
    }
}
