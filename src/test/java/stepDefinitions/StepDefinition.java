package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class StepDefinition extends Utils {

    ResponseSpecification res;
    Response response;
    TestDataBuild data = new TestDataBuild();
    static String place_id;

    @Given("Add place payload with {string} {string} {string}")
    public void add_place_payload(String name,String language, String address) throws IOException {
//        res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        req = given().spec(requestSpecification()).body(data.addPlacePayload(name,language,address));

}
    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String endpoint, String method) {
        APIResources resources = APIResources.valueOf(endpoint);
        if(method.equalsIgnoreCase("POST"))
            response = req.when().post(resources.getResource());
        else if(method.equalsIgnoreCase("GET"))
            response = req.when().get(resources.getResource());

    }
    @Then("API call is success with status code {int}")
    public void api_call_is_success_with_status_code(Integer int1) {
        assertEquals(200,response.getStatusCode());
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String key,String expected) {
        assertEquals(extractFromResponse(response,key),expected);
    }

    @Then("verify place_Id created maps to {string} using {string}")
    public void verify_place_id_created_maps_to_using(String str, String endPoint) throws IOException {
        place_id = extractFromResponse(response,"place_id");
        APIResources resources = APIResources.valueOf(endPoint);
        req = given().spec(requestSpecification()).queryParam("place_id",extractFromResponse(response,"place_id"));
        user_calls_with_http_request(endPoint, "GET");
        assertEquals(str,extractFromResponse(response,"name"));
    }

    @Given("DeletePlace payload")
    public void delete_place_payload() throws IOException {
        req = given().spec(requestSpecification()).body(data.DeletePlacePayload(place_id));
    }
}
