package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//import static io.restassured.RestAssured.given;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"C:\\Users\\russi\\IdeaProjects\\untitled\\src\\test\\java\\org\\example\\features"})
public class CucumberTest {
}
