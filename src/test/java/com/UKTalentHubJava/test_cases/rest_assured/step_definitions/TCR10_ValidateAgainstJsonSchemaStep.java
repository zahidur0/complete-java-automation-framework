package com.UKTalentHubJava.test_cases.rest_assured.step_definitions;

import com.UKTalentHubJava.test_cases.rest_assured.line_drawers.LineDrawer;
import com.UKTalentHubJava.test_cases.rest_assured.rest_assured_api_configs.GoRestUserConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import org.junit.Assert;


import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TCR10_ValidateAgainstJsonSchemaStep {

    Response response;

    @Given("I have a JSON response")
    public void iHaveAJSONResponse() {
        LineDrawer.HorizontalLineDrawer();
        String id = GoRestUserConfig.existentId;
        System.out.println(id);
        response = given()
                .auth().oauth2(GoRestUserConfig.token)
                .when()
                .get("https://gorest.co.in/public/v2/users/" + id + ".json");
        System.out.println(response.asString());
        LineDrawer.HorizontalLineDrawer();
    }

    @And("I have a JSON schema")
    public void iHaveAJSONSchema() {
        // here we check if the JSON schema exists
        Assert.assertTrue(new File("src/test/resources/GoRestJsonSchema.json").isFile());
        System.out.println("Schema exists");
        LineDrawer.HorizontalLineDrawer();
    }

    @Then("I find the JSON response agrees with the schema")
    public void iFindTheJSONResponseAgreesWithTheSchema() {
        // check if the response agrees with the format dictated by the JSON schema
        response.then().body(matchesJsonSchemaInClasspath("GoRestJsonSchema.json"));
        System.out.println("Matching successful");
        LineDrawer.HorizontalLineDrawer();
    }
}
