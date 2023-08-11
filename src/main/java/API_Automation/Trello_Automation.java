package API_Automation;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Trello_Automation {

	public static String baseUri = "https://api.trello.com";
	
	
	public static void getMethodAutomation() {
		RestAssured.baseURI = baseUri;
		given()
		.param("key", "ff610fa201701453eb6bd406cc7285f9")
		.param("token", "ATTA88fa1548c3f8d53ff57dfde8286a6bdba1cad6dfc9523216162d931ce654abb09FD821A0").
		when().get("/1/boards/dh9b4Z4O").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
		.header("Referrer-Policy", equalTo("strict-origin-when-cross-origin")).and()
		.header("X-Trello-Environment", equalTo("Production")).and()
		.body("name", equalTo("First Project")).and()
		.body("desc", equalTo("This is my first project."));
		
		System.out.println("This is first Get Automation call");
		System.out.println("Get call executed successfully");
		
	}
	
	@Test
	public static void getMethodAutomationLog() {
		RestAssured.baseURI = baseUri;
		given()
		.param("key", "ff610fa201701453eb6bd406cc7285f9")
		.param("token", "ATTA88fa1548c3f8d53ff57dfde8286a6bdba1cad6dfc9523216162d931ce654abb09FD821A0").log().all().
		when().get("/1/boards/dh9b4Z4O").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
		.header("Referrer-Policy", equalTo("strict-origin-when-cross-origin")).and()
		.header("X-Trello-Environment", equalTo("Production")).and()
		.body("name", equalTo("First Project")).and()
		.body("desc", equalTo("This is my first project."));
		
		System.out.println("This is first Get Automation call");
		System.out.println("Get call executed successfully");
		
	}
	
	
	public static void postMethodAutomation() {
		RestAssured.baseURI = baseUri;
		String board_name = "API Auto Board " + (int)(Math.random()*100);
		given()
		.queryParam("key", "ff610fa201701453eb6bd406cc7285f9")
		.queryParam("token", "ATTA88fa1548c3f8d53ff57dfde8286a6bdba1cad6dfc9523216162d931ce654abb09FD821A0")
		.queryParam("name", board_name)
		.header("content-type", "application/json").
		when().post("/1/boards").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
		.body("name", equalTo(board_name));
		
		System.out.println("This is first Post Automation call");
		System.out.println("Post call executed successfully");
		
	}

}
