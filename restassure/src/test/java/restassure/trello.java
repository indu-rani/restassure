package restassure;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class trello {
	public String url="https://api.trello.com";
	public String id;
	
	
	//@Test
	public void test1() {
		Response res=RestAssured.get(url);	
	}	
	
@Test(enabled=true)
public void create() {
	//String jsonresponse = resp.asString();
	//JsonPath js= new JsonPath(jsonresponse);
	//JSONObject js=new JSONObject();
	//JsonPath jk=new JsonPath(s.asString());

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
			//.when()
			//.contentType(ContentType.JSON).accept(ContentType.JSON)
			//.post("/1/boards/");
	resp.prettyPrint();
	String jsonresponse = resp.asString();
	JsonPath js= new JsonPath(jsonresponse);
	id=js.get("id");
	System.out.println(id);
	
	
}
@Test(enabled=false)
public void createBoard()
{
	RestAssured.baseURI=url;
Response response=given().queryParam("name", "sushant")
	.queryParam("key", "451ea0895531a964a7eb002a58c76de9")
	.queryParam("token", "ed913e90a3caca48f718a1d65272a83d53efc2930c7febacfa20cd6d72c76575")
	.header("Content-Type", "application/json")
	.when()
	.post("/1/boards/")
	.then()
	.assertThat().statusCode(200).contentType(ContentType.JSON)
	.extract().response();
	String jsonresponse = response.asString();
	JsonPath js= new JsonPath(jsonresponse);
	
	id = js.get("id");
	System.out.println(id);		
}


@Test(enabled=false)
public void delete() {
	JSONObject js=new JSONObject();
	RestAssured.baseURI=url;
	given().queryParam("name","devasena").queryParam("key","451ea0895531a964a7eb002a58c76de9")
	.queryParam("token","ed913e90a3caca48f718a1d65272a83d53efc2930c7febacfa20cd6d72c76575")
	.when()
	.contentType(ContentType.JSON).accept(ContentType.JSON)
	.delete("/1/boards/vIge0Upx").then().log().all();
	
	
}
@Test(enabled=false)
public void update() {
	JSONObject js=new JSONObject();
	RestAssured.baseURI=url;
	given().queryParam("name","devasena").queryParam("key","451ea0895531a964a7eb002a58c76de9")
	.queryParam("token","ed913e90a3caca48f718a1d65272a83d53efc2930c7febacfa20cd6d72c76575")
	.when()
	.contentType(ContentType.JSON).accept(ContentType.JSON)
	.put("/1/boards/hIGyQQuc").then().log().all();
	
}
@Test(enabled=false)
public void getallusers() {
	JSONObject js=new JSONObject();
	RestAssured.baseURI=url;
	given().queryParam("key","451ea0895531a964a7eb002a58c76de9")
	.queryParam("token","ed913e90a3caca48f718a1d65272a83d53efc2930c7febacfa20cd6d72c76575")
	.when()
	.contentType(ContentType.JSON).accept(ContentType.JSON)
	.put("/1/members/me/boards").then().log().all();
	
}
}



