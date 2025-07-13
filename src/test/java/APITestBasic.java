
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given; // static import package -- for Gherkin keywords
import org.testng.annotations.Test; // dynamic import package - for TestNG
import org.testng.Assert;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;


/*
 given() -- content type, set cookies, add authentication, headers, path parameters -- pre-requisiets

 when() -- all request methods/ request types/ request url -- get, put, post, delete

 then() -- validation -- response code, body, headers, cookies
 */

public class APITestBasic {
    int id;


    @Test(priority = 1)
    void getUsers(){
        given()               /* from package static io.restassured.RestAssured.* */

                .when()
                .get("https://reqres.in/api/users?page=2")

                .then()
                .statusCode(200)
                .body("page", equalTo(2))   /* from package org.hamcrest.Matchers.* */
                .log().all();

    }

    @Test(priority = 2)
    void createUser(){
        HashMap hmData = new HashMap<>();
        hmData.put("name","Dipika");
        hmData.put("job","Test Lead");
      //  Response res = RestAssured.get("https://reqres.in/api/users?page=2");

      id =  given()
                .contentType("application/json")
                .body(hmData)

                .when()
                .post("https://reqres.in/api/users?page=2")
                .jsonPath().getInt("id");



        System.out.println("Auto genrated ID is : "+id);
       // System.out.println("Response is : "+res.getBody().asString());



//                .then()
//                .statusCode(201)
 //               .log().all();
    }

    @Test(priority = 3, dependsOnMethods = ("createUser")) void updateUser(){

        HashMap hmD = new HashMap<>();
        hmD.put("name","DT");
        hmD.put("job","Test Manager");

        given()
                .contentType("application/json")
                .body(hmD)

                .when()
                .put("https://reqres.in/api/users/"+id)

                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 4, dependsOnMethods = ("createUser")) void deleteUser() {
        given()

                .when()
                .delete("https://reqres.in/api/users/"+id)

                .then()
                .statusCode(204)
                .log().all();
    }

    @Test(enabled = false) void test01(){
        Response res = RestAssured.get("https://reqres.in/api/users/page=2");
        System.out.println("Status code is -"+res.getStatusCode());
        System.out.println("Response -"+res.asString());
        System.out.println("Response as body -"+res.getBody());
        System.out.println("Headers -"+res.getHeaders());
        System.out.println("Headers end here...");

        int statusCode = res.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test(enabled = false) void test012(){
        //imported static given() from RestAssured
        given().get("https://reqres.in/api/users?page=2").
        then().statusCode(200);
    }

}
