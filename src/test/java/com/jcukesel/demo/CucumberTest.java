package com.jcukesel.demo;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        plugin = {"pretty", "json"},
        snippets= CucumberOptions.SnippetType.CAMELCASE,
        strict=true,
        glue="com.jcukesel.demo.stepdef"
)

public class CucumberTest {
}
