package restassure;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import io.restassured.response.ResponseBody;
public class googlemapsapi {
	
	
	public static String Addurl="http://216.10.245.166";///maps/api/place/add/json?key= qaclick123";
	
	public static String delurl="http://216.10.245.166";///maps/api/place/delete/json?key=qaclick123";
	Response rep=RestAssured.get(Addurl);
	
	int actual=	rep.statusCode();
	//Assert.assertEquals(actual, 200);
//	@Test
//	public void srinath()
//	{
//		
//		Response res=RestAssured.get(Addurl);
//	}
	@Test
	public void add()
	{
		
	JSONObject js=new JSONObject();
	js.put("lat", 38.383494);
		
	js.put("lng", 38.383494);
	
		js.put("accuracy", 50);
		js.put("name", "Frontline house");
		js.put("phone_number", "983 893 3937");
		js.put("address", "29, side layout, cohen 09");
		js.put("types", "shoe park");
		js.put("website", "http://google.com");
		js.put("language", "French-IN");
		given().queryParam("key","qaclick123").contentType(ContentType.JSON).accept(ContentType.JSON).body(js.toJSONString())
		.when().post("http://216.10.245.166/maps/api/place/add/json/").then().statusCode(200).log().all().extract().response();
		//Response resp=RestAssured.given().headers("Content type","application/json\r\n", "Accept", "application/json\r\n").when().post("http://216.10.245.166/maps/api/place/add/json/").then().contentType("application/json\r\n")c
		
		//Response resp=given().queryParam("Key","qaclick123").contentType(ContentType.JSON)
		//	.log().all().body(js).when().post("http://216.10.245.166/maps/api/place/add/json/");
		//resp.prettyPrint();
		System.out.println(rep.statusCode());
		//System.out.println(rep.body());
		System.out.println(rep.asString());
		//ResponseBody body=rep.getBody();
		//body.prettyPrint();
	//	System.out.println("ResponseBody is: "+body.asString());
		rep.prettyPrint();
	}
	
	
	
	
	
}




