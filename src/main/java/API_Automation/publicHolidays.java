package API_Automation;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.Locale;
import java.util.Scanner;

import org.testng.annotations.Test;


public class publicHolidays {
	
	public static String baseUri = "https://date.nager.at";
	
	@Test
	public static void getHolidays() {
		
		RestAssured.baseURI = baseUri;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the country code: ");
		String country = sc.nextLine();
		
		Locale lc = new Locale("English", country.toUpperCase());
		
		Response response = given()
		.header("Content-Type","application/json").when().get("/api/v3/publicholidays/2023/"+country.toUpperCase())
		.then().assertThat().statusCode(200).and().extract().response();
		
		String jresponse = response.asString();
		JsonPath jsonBody = new JsonPath(jresponse);
		System.out.println("==============Holiday list in "+lc.getDisplayCountry()+"==============");
		int length = jsonBody.getInt("jsonBody.size()");
		for(int i=0; i<length; i++) {
			System.out.println((i+1)+". "+jsonBody.get("["+i+"].date")+": "+jsonBody.get("["+i+"].localName")+" or "+jsonBody.get("["+i+"].name")+" and Type: "+jsonBody.get("["+i+"].types"));
		}
		
		
		
	}

}
