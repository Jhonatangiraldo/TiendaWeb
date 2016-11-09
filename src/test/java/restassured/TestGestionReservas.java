package restassured;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.http.ContentType;

public class TestGestionReservas {
String link;
	
	@Before
	public void preparar(){
		link = " http://localhost:8090/Tienda/rest/reservas/reservas";
	}
	
	@Test 
	public void registroFallido(){
		given().
        	contentType(ContentType.JSON).
        when().
	        post(link).
	    then().
	        statusCode(200).
	        assertThat().body("size()", equalTo(3));
	}

}
