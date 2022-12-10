package restassure;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
//import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.*;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
public class api1 {
	
	
	
	public static String url="";
	
	@Test(enabled=true)
	public void test()
	{
		
		Response rep=RestAssured.get(url);
		
//int actual=	rep.statusCode();
//Assert.assertEquals(actual, 201);
//		rep.body();
//		rep.asString();
		System.out.println(rep.statusCode());
		System.out.println(rep.body());
		System.out.println(rep.asString());
	}
		
	
	@Test(enabled=true)
	public void test2()
	{
		
		//given().
		//get(url).
		//then().statusCode(200).body("data.first_name",hasItems("Janet"));
		//given().
		//get(url).
		//then().statusCode(200).log().all();
		
		JSONObject js=new JSONObject();
		js.put("name", "sathvik");
		js.put("job","team leader");
		//Response indu=given().body(js).when().post("https://reqres.in/api/users/2").then().statusCode(201).and().log().all();
		Response resp=given().contentType(ContentType.JSON).log().all().body(js).post();
		resp.prettyPrint();
	}
		
		
		
		
	}
	
	
	













