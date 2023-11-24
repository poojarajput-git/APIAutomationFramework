package userManagement;

import helper.JSONReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class getUsers {

    @Test
    public void getUserData(){
        given().when().get("https://reqres.in/api/users?page=2").
                then().assertThat().statusCode(200);
    }

    @Test
    public void validateGetResponseBody(){
        RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
        given()
                .when()
                .get("/todos/1")
                .then()
                .assertThat()
                .statusCode(200)
                .body(not(isEmptyString()))
                .body("title", equalTo("delectus aut autem"))
                .body("userId", equalTo(1));
    }

    @Test
    public void validateReponseHasItems(){
        RestAssured.baseURI ="https://jsonplaceholder.typicode.com";

         Response response= given()
                 .when().get("/posts")
                 .then()
                 .extract()
                 .response();

         assertThat(response.jsonPath().getList("title"), hasItems("qui est esse","eum et est occaecati"));
         System.out.println(response.body().asString());
    }

    @Test
    public void validateTestDataFromJSON() throws IOException, ParseException {
        String username  = JSONReader.getTestData("username");
        String password  = JSONReader.getTestData("password");
        System.out.println(username);
        System.out.println(password);
        System.out.println(password);
    }





}
