package restassure;
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
public class api2 {
	public static String url="https://reqres.in/api/users?page=2";

@Test(enabled=true)
public void test()
{
	
	Response rep=RestAssured.get(url);
	
//int actual=	rep.statusCode();
//Assert.assertEquals(actual, 201);
//	rep.body();
//	rep.asString();
	System.out.println(rep.statusCode());
	System.out.println(rep.body());
	System.out.println(rep.asString());
	
}

@Test(enabled=true)
public void test2()
{
	
	
	given().get(url).then().statusCode(200).log().all();
	
	
	
	given().
	get(url).
	then().statusCode(200).body("data.first_name",hasItems("Michael"));
}
	@Test(enabled=true)
	public void test3()
	{
		JSONObject js=new JSONObject();//
		js.put("name", "sathvik");
		js.put("job","team leader");
		//Response indu=given().body(js).when().post("https://reqres.in/api/users/2").then().statusCode(201).and().log().all();
		Response resp=given().contentType(ContentType.JSON).log().all().body(js).post("https://reqres.in/api/users/2");
		resp.prettyPrint();
	}
	
		@Test(enabled=true)
		public void test4()
		{
		given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();//delete user.
		
		}
		@Test(enabled=true)
		public void test5()
		{
			given().get("https://reqres.in/api/users/2").then().statusCode(200).log().all();//getting single user
	
}

}
