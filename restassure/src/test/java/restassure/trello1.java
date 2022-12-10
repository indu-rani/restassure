package restassure;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class trello1 {
	public String url="https://api.trello.com";
	public String id;
	
	
	
	
@Test(enabled=true)
public void create() {
	
	RestAssured.baseURI=url;
	//given().queryParam("name","Testing").queryParam("key","451ea0895531a964a7eb002a58c76de9")
	//.queryParam("token","ed913e90a3caca48f718a1d65272a83d53efc2930c7febacfa20cd6d72c76575")
	//.when()
	//.contentType(ContentType.JSON).accept(ContentType.JSON)
	//.post("/1/boards/").then().log().all();
	Response resp=given().queryParam("name","Testing").queryParam("key","451ea0895531a964a7eb002a58c76de9")
			.queryParam("token","ed913e90a3caca48f718a1d65272a83d53efc2930c7febacfa20cd6d72c76575").header("Content-Type", "application/json")
			.when()
			.post("/1/boards/")
			.then()
			.assertThat().statusCode(200).contentType(ContentType.JSON)
			.extract().response();
			resp.prettyPrint();
	String jsonresponse = resp.asString();
	JsonPath js= new JsonPath(jsonresponse);
	id=js.get("id");
	System.out.println(id);
	
	
}
@Test(enabled=true)
public void delete1()
{
	
JSONObject js=new JSONObject();

	js.put("place_id", "c21a4ec5521e4d6d69b7b687020a9e4f");
	
	given().queryParam("key","qaclick123").contentType(ContentType.JSON).accept(ContentType.JSON).body(js)
	.when().post("http://216.10.245.166/maps/api/place/delete/json/").then().statusCode(200).log().all();
	
	System.out.println(js);		
}

@Test(enabled=false)
public void delete() {
	JSONObject js=new JSONObject();
	RestAssured.baseURI=url;
	js.put("place_id", "c21a4ec5521e4d6d69b7b687020a9e4f");
	given().queryParam("name","devasena").queryParam("key","451ea0895531a964a7eb002a58c76de9")
	.queryParam("token","ed913e90a3caca48f718a1d65272a83d53efc2930c7febacfa20cd6d72c76575")
	.when()
	.contentType(ContentType.JSON).accept(ContentType.JSON)
	.delete("/1/boards/vIge0Upx").then().log().all();
	

}
}
