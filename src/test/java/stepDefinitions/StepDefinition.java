package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import pojo.placesAPI.AddPlace;
import pojo.placesAPI.Location;
import resources.TestDataBuild;
import resources.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class StepDefinition extends Utils {


    ResponseSpecification res;
    Response response;
    TestDataBuild data = new TestDataBuild();

    @Given("Add place payload")
    public void add_place_payload() throws IOException {

        //    Deserialization
        res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        req = given().spec(requestSpecification()).body(data.addPlacePayload());

}
    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String string, String string2) {
        response = req
                .when().post("maps/api/place/add/json")
                .then().spec(res).extract().response();

    }
    @Then("API call is success with status code {int}")
    public void api_call_is_success_with_status_code(Integer int1) {
        assertEquals(response.getStatusCode(),200);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String key,String expected) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        assertEquals(js.get(key),expected);
    }
}
