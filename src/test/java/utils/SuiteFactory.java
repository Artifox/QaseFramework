package utils;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import models.Suite;

import java.util.Locale;

public class SuiteFactory {

    FakeValuesService fakeValuesService;

    public Suite getSuite() {
        fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        Suite suite = Suite.builder()
                .name(fakeValuesService.regexify("[a-z1-9]{10}"))
                .description(fakeValuesService.regexify("[a-z1-9]{10}"))
                .preconditions(fakeValuesService.regexify("[a-z1-9]{10}"))
                .build();
        return suite;
    }
}
