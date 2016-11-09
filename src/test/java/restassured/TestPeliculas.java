package restassured;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.http.ContentType;

public class TestPeliculas {
	String link;
	
	@Before
	public void preparar(){
		link = "http://localhost:8090/Tienda/rest/peliculas";
	}
	
	@Test 
	public void registroFallido(){
		given().
        	contentType(ContentType.JSON).
        when().
	        post(link + "/peliculas").
	    then().
	        statusCode(200).
	        assertThat().body("size()", equalTo(23));
	}

}
