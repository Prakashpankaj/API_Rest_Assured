package Test;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;

public class GetAndPostExample {
    @Test
    public void testGet(){
        baseURI="https://reqres.in/api/";
        given().get("users?page=2").then().statusCode(200).
                body("data[4].first_name", equalTo("George")).
                body("data.first_name",hasItems("George","Rachel"));

    }
    @Test
    public void testPost(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("name","prakash");
        map.put("job","software");
        System.out.println(map);
        JSONObject request=new JSHONObject(map);
        request.put("name","prakash");
        request.put("job","software");
        System.out.println(request.toJSONString());

        baseURI="https://reqres.in/api/";

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
          body(request.toJSONString()).
        when().
          post("/users").
        then().
         StatusCode(201).log().all();
    }


    }


