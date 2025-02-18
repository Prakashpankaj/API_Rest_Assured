package Test;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;
public class PutPatchDeleteExample {
    @Test
    public void testPut(){
        //payload
        JSONObject request=new JSHONObject();
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
                put("/users/2").
                then().
                StatusCode(200).log().all();
    }
    @Test
    public void testPatch(){
        //payload
        JSONObject request=new JSHONObject();
        request.put("name","prakash");
        request.put("job","software");
        System.out.println(request.toJSONString());

        baseURI="https://reqres.in";

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("/api/users/2").
                then().
                StatusCode(200).log().all();
    }

    @Test
    public void testDelete(){

        baseURI="https://reqres.in";

        given().
                when().
                delete("/api/users/2").
                then().
                statusCode(204).log().all();
    }
}

}
