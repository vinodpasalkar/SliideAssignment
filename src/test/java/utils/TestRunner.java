package utils;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.util.Map;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"/Users/vinodpasalkar/IdeaProjects/SliideAssignment/src/test/java/test/resources/features"},
        glue = {"test.java.news.stepDefinitions"},
        tags = "@Login",
        plugin = { "pretty", "json:target/cucumber.json"},
        monochrome = true,
        publish = true,
        stepNotifications = true
)
public class TestRunner {
    public static Map<String, String> config;
}
