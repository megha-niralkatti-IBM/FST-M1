package Project;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.extension.ExtendWith;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@ExtendWith(PactConsumerTestExt.class)
public class consumerTest {
    //headers
    Map<String, String> headers = new HashMap<String, String>();

    //resource path
    String createUser = "/api/users";

    //create the contract provider = "UserProvider"
    @Pact(provider = "UserProvider", consumer = "UserConsumer")
    public RequestResponsePact createPact(PactDslWithProvider builder) throws ParseException {

        headers.put("content-Type", "application/json; charset=UTF-8");
        headers.put("Accept","application/json; charset=UTF-8");
        DslPart requestResponseBody = new PactDslJsonBody()
                .numberType("id", 345)
                .stringType("firstName", "Justin")
                .stringType("lastName", "Case")
                .stringType("email", "justincase@mail.com");
        return builder.given("A request to create a user")//PactDslWithState
                .uponReceiving("A request to create a user") //PactDslRequestWithoutPath
                .path(createUser)//PactDslRequestWithPath
                .method("POST")
                .headers(headers)
                .body(requestResponseBody)
                .willRespondWith()//PactDslResponse
                .status(201)
                .body(requestResponseBody)
                .toPact();
    }
    @Test
    @PactTestFor(providerName = "UserProvider", port = "8080")
    public void runTest() {
        RestAssured.baseURI = "http://localhost:8080";
        RequestSpecification rq = RestAssured.given().headers(headers).when();
        // Create request body
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 1);
        map.put("firstName", "Justin");
        map.put("lastName", "Case");
        map.put("email", "justincase@mail.com");
        // Send POST request
        Response response = rq.body(map).post(createUser);
        // Debug code to print the response status code
        System.out.println("Response Status Code: " + response.getStatusCode());
// Assertion
        //assert (response.getStatusCode() == 201);
        assert (response.getStatusCode() == 201);
    }
}


