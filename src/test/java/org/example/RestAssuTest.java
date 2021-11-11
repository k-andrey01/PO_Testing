package org.example;

import io.restassured.RestAssured;
import org.example.ConfProperties;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestAssuTest {
   // @Before
    public void setup() {
        RestAssured.baseURI = ConfProperties.getProperty("loginpage");
        RestAssured.port = 443;
    }

    @Test
    public void loginTest(){
        given().auth().basic(ConfProperties.getProperty("login"), ConfProperties.getProperty("password")).when().get(ConfProperties.getProperty("loginpage"));

    }
}
