package utils;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import models.Project;

import java.util.Locale;

import static models.RadioButtonOptions.CreateNewProjectOptions.PRIVATE;

public class ProjectFactory {
    FakeValuesService fakeValuesService;

    public Project getProject() {
        fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        Project project = Project.builder()
                .name(fakeValuesService.regexify("[a-z1-9]{10}"))
                .code(fakeValuesService.regexify("[A-Z1-9]{5}"))
                .description(fakeValuesService.regexify("[a-z1-9]{10}"))
                .accessType(PRIVATE)
                .build();
        return project;
    }
}
