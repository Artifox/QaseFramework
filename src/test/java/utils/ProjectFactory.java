package utils;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import models.Project;

import java.util.Locale;

public class ProjectFactory {
    FakeValuesService fakeValuesService;
    Faker faker;

    public Project getProject() {
        fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        faker = new Faker();
        String accessType = faker.options().option("private", "public");
        Project project = Project.builder()
                .name(fakeValuesService.regexify("[a-z1-9]{10}"))
                .code(fakeValuesService.regexify("[A-Z1-9]{5}"))
                .description(fakeValuesService.regexify("[a-z1-9]{10}"))
                .accessType(accessType)
                .build();
        return project;
    }
}
