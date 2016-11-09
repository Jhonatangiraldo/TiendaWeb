package restassured;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.http.ContentType;

public class TestGestionPelicula {
String link;
	
	@Before
	public void preparar(){
		link = " http://localhost:8090/Tienda/rest/gestion/consultaDetalle/1";
	}
	
	@Test 
	public void registroFallido(){
		Map<String, String>  jsonAsMap = new HashMap<>();
		jsonAsMap.put("id", "1");
		
		given().
        	contentType(ContentType.JSON).
       	body(jsonAsMap).
        when().
	        post(link).
	    then().
	        statusCode(200).
	        assertThat().body("size()", equalTo(23));
	}
}
