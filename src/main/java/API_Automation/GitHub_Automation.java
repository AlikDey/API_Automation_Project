package API_Automation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GitHub_Automation {
	
	public static String baseUri = "https://api.github.com";
	
	public static void postMethodAutomation() {
		RestAssured.baseURI = baseUri;
		String bearerToken = "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";
		
		given()
		.header("content-type", "application/json")
		.header("Authorization", "Bearer "+ bearerToken)
		.body("{\r\n"
				+ "    \"name\": \"repo-api-automation\",\r\n"
				+ "    \"description\": \"This is created by restassured\"\r\n"
				+ "}").
		when().post("/user/repos").
		then().assertThat().statusCode(201).and().contentType(ContentType.JSON).and()
		.body("name", equalTo("repo-api-automation")).and()
		.body("description", equalTo("This is created by restassured"));
		
		System.out.println("Repository created successfully in Github");
		
	}
	
	public static void extractResponse() {
		RestAssured.baseURI = baseUri;
		String bearerToken = "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";
		
		Response response = given()
		.header("content-type", "application/json")
		.header("Authorization", "Bearer "+ bearerToken)
		.body("{\r\n"
				+ "    \"name\": \"repo-api-automation-1\",\r\n"
				+ "    \"description\": \"This is created by restassured\"\r\n"
				+ "}").
		when().post("/user/repos").
		then().assertThat().statusCode(201).and().contentType(ContentType.JSON).extract().response();
		
		String jsonResponse = response.asString();
		JsonPath body = new JsonPath(jsonResponse);
		
		System.out.println(body.get("id"));
		
	}
	
	@Test
	public void deleteRepository() {
		
		RestAssured.baseURI = baseUri;
		String bearerToken = "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";
		given()
		.header("content-type", "application/json")
		.header("Authorization", "Bearer "+ bearerToken)
		.when().delete("/repos/alik161989/repo-api-automation-1")
		.then().assertThat().statusCode(204);
		
		System.out.println("Repository deleted successfully: alik161989/repo-api-automation-1");
	}

}
