/* How many ways we can create request body
1. Hashmap, 2.using org.json, 3.using POJO(Plain Old Java Object), 4.using external json file
*/


import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class APIDayTwo {

    @Test(priority = 0, enabled = false) void HmPostReq(){

        HashMap hm = new HashMap();
        hm.put("name","ABC");
        hm.put("age",28);
        hm.put("grade","12th");

        String subArr[] = {"Math","Physics"};
        hm.put("subjects", subArr);

        given()
                .contentType("application/json")
                .body(hm)

                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name", equalTo("ABC"))
                .body("age", equalTo(28))
                .body("subjects[0]", equalTo("Math"))
                .body("subjects[1]", equalTo("Physics"))
                .header("Content-Type","application/json")
                .log().all();
    }

    @Test(priority = 1, enabled = false) void HmDelete(){

        given()

                .when()
                .delete("http://localhost:3000/students/1e97")

                .then()
                .statusCode(200)
                .log().all();
    }
/*
*  Post request body Using external json file
* */

    @Test(priority = 2) void ExternalJsonFilePost() throws FileNotFoundException {
        File fl = new File("/Users/dipikatayde/Desktop/API_Automation/RestAssuredProject1/RawDataFile.json");

        //Read data from file
        FileReader fr = new FileReader(fl);

        JSONTokener jt = new JSONTokener(fr);

        JSONObject jo = new JSONObject(jt);

        given()
                .contentType("application/json")
                .body(jo.toString())

                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
             //   .body("name", equalTo("XYZ"))
             //   .body("age", equalTo(28))
                //  .body("subjects[0]", equalTo("English"))
              //  .body("subjects[1]", equalTo("C++"))
                .header("Content-Type","application/json")
                .log().all();
    }
}
