package restassured;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import com.jayway.restassured.http.ContentType;

public class TestSeguridad {
	
	String link;
	
	@Before
	public void preparar(){
		link = "http://localhost:8090/Tienda/rest/security_service";
	}
	
	@Test 
	public void registroFallido(){
		Map<String, String>  jsonAsMap = new HashMap<>();
		jsonAsMap.put("usuario", "jhonatan");
		jsonAsMap.put("pass", "1234");
		
		given().
        	contentType(ContentType.JSON).
       	body(jsonAsMap).
        when().
	        post(link + "/registro/jhonatan/1234").
	    then().
	        statusCode(200).
	        body("respuesta", equalTo("fail"));
	}
	
	@Test 
	public void login(){
		Map<String, String>  jsonAsMap = new HashMap<>();
		jsonAsMap.put("usuario", "jhonatan");
		jsonAsMap.put("pass", "1234");
		
		given().
        	contentType(ContentType.JSON).
        	body(jsonAsMap).
        when().
	        post(link + "/login/jhonatan/1234").
	    then().
	        statusCode(200).
	        body("respuesta", equalTo("Ok"));
	}
}
