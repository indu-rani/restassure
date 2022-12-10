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
import org.testng.annotations.Test;

public class ecommerse {
	public static String url="https://ecommerceservice.herokuapp.com/";
	public String token;

@Test(enabled=true)
public void test()
{
given().get(url).then().statusCode(200).log().all();
}
@Test(enabled=false)
public void registration()
{
 JSONObject js=new JSONObject();
 js.put("email", "mohankrishna176@gmail.com");
 js.put("password",  "krishna@123");
 given().contentType(ContentType.JSON).accept(ContentType.JSON).body(js).post("https://ecommerceservice.herokuapp.com/");
}
@Test(enabled=false)
public void login()
{
	JSONObject js=new JSONObject();
	js.put("email", "mohankrishna176@gmail.com");
	 js.put("password",  "krishna@123");
	 Response response= given().contentType(ContentType.JSON).accept(ContentType.JSON).body(js).post("https://ecommerceservice.herokuapp.com/user/login").then()
				.assertThat().statusCode(200).contentType(ContentType.JSON)
				.extract().response();
	 response.prettyPrint();
	 String jsonresponse = response.asString();
		JsonPath jk= new JsonPath(jsonresponse);
		token = jk.get("token");
		System.out.println(token);	
}
@Test(enabled=false)
public void getallusers()
{
	//Response res=given().get("https://ecommerceservice.herokuapp.com/user");
	//res.prettyPrint();
	//Response resp=given().contentType(ContentType.JSON).log().all().get("https://ecommerceservice.herokuapp.com/user");
	//resp.prettyPrint();
	Response resp=given().queryParam("accessToken","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzM4MjkxYzEyNWExMTAwMTc1YmY2NmQiLCJpYXQiOjE2Njg1MzMxODQsImV4cCI6MTY2ODYxOTU4NH0.YEzIijiJOwqzk1GCDj-OHpxc_aAyt7rrsBnMT_KYW0o").
		contentType(ContentType.JSON).accept(ContentType.JSON)
			.when()
			.get("https://ecommerceservice.herokuapp.com/user")
			.then().extract().response();
			resp.prettyPrint();
}
@Test(enabled=true)
public void getallusers1()
{
given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzM4MjkxYzEyNWExMTAwMTc1YmY2NmQiLCJpYXQiOjE2Njg2NTk2NDEsImV4cCI6MTY2ODc0NjA0MX0.WiP6gQATXTUivPvaPYO-Bpg1rZbzKHo_9VE_sYhtH-M")
.contentType(ContentType.JSON).when().get("https://ecommerceservice.herokuapp.com/user").then().log().all();
}
@Test(enabled=false)
public void delete()
{
	RestAssured.baseURI=url;
JSONObject js=new JSONObject();
given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjY1NzUsImV4cCI6MTY2ODYxMjk3NX0.ZyGFo64dH_4O-G6C0UYmf3-fe05DTGW9ZI4mdaG3jz4")
.contentType(ContentType.JSON).accept(ContentType.JSON).when().
delete("/user/6357601a8754360017c355e2").then().log().all();
	
	

	
}
@Test(enabled=false)
public void getallproducts()
{
	
	
	RestAssured.baseURI=url;
	JSONObject js=new JSONObject();
	
	given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjY1NzUsImV4cCI6MTY2ODYxMjk3NX0.ZyGFo64dH_4O-G6C0UYmf3-fe05DTGW9ZI4mdaG3jz4")
	.contentType(ContentType.JSON).accept(ContentType.JSON).when().get("/products").then().log().all();
			
	
}
	

@Test(enabled=false)
public void creat_product()
{
	
	RestAssured.baseURI=url;
	JSONObject js=new JSONObject();
	js.put("name", "Handbags_School");
	js.put("price", "500");
	
	
	given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjY1NzUsImV4cCI6MTY2ODYxMjk3NX0.ZyGFo64dH_4O-G6C0UYmf3-fe05DTGW9ZI4mdaG3jz4")
	.contentType(ContentType.JSON).accept(ContentType.JSON).body(js.toJSONString()).when().post("/products").then().log().all();
	
}
@Test(enabled=false)
public void getproduct()
{
	
	RestAssured.baseURI=url;
	JSONObject js=new JSONObject();
	given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjY1NzUsImV4cCI6MTY2ODYxMjk3NX0.ZyGFo64dH_4O-G6C0UYmf3-fe05DTGW9ZI4mdaG3jz4")
	.contentType(ContentType.JSON).accept(ContentType.JSON).when().get("/products/63746a0a347b900017d6fde2").then().log().all();
			
		
}

@Test(enabled=false)
public void update_product()
{
	
	RestAssured.baseURI=url;
	JSONObject js=new JSONObject();
	js.put("name", "Handbags_School");
	js.put("price", 1000);
	
	given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjY1NzUsImV4cCI6MTY2ODYxMjk3NX0.ZyGFo64dH_4O-G6C0UYmf3-fe05DTGW9ZI4mdaG3jz4")
	.contentType(ContentType.JSON).accept(ContentType.JSON).body(js.toJSONString()).when().patch("/products/6374af22904d2b0017e8017c").then().log().all();
			
	
}
@Test(enabled=false)
public void delete_product()
{
	
	RestAssured.baseURI=url;
	
	//JSONObject js=new JSONObject();
	given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjY1NzUsImV4cCI6MTY2ODYxMjk3NX0.ZyGFo64dH_4O-G6C0UYmf3-fe05DTGW9ZI4mdaG3jz4")
	.contentType(ContentType.JSON).accept(ContentType.JSON).when().
	delete("/products/63746195347b900017d6fde1").then().log().all();
	
	
}

@Test(enabled=false)
public void getall_orders()
{
	
	RestAssured.baseURI=url;
	given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjY1NzUsImV4cCI6MTY2ODYxMjk3NX0.ZyGFo64dH_4O-G6C0UYmf3-fe05DTGW9ZI4mdaG3jz4")
	.contentType(ContentType.JSON).accept(ContentType.JSON).when().
	get("/orders").then().log().all();
	
		
	
}


@Test(enabled=false)
public void creat_order()
{
	
	RestAssured.baseURI=url;
	JSONObject js=new JSONObject();
	js.put("product", "6374af22904d2b0017e8017c");
	js.put("quantity", 100);
	
	given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjY1NzUsImV4cCI6MTY2ODYxMjk3NX0.ZyGFo64dH_4O-G6C0UYmf3-fe05DTGW9ZI4mdaG3jz4")
	.contentType(ContentType.JSON).accept(ContentType.JSON).body(js.toJSONString()).when().
	post("/orders").then().log().all();	
	
}
@Test(enabled=false)
public void getorder_id()
{
	RestAssured.baseURI=url;
	
	given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjY1NzUsImV4cCI6MTY2ODYxMjk3NX0.ZyGFo64dH_4O-G6C0UYmf3-fe05DTGW9ZI4mdaG3jz4")
	.contentType(ContentType.JSON).accept(ContentType.JSON).when().
	get("/orders/6374c33aab8672001707bbde").then().log().all();
	
}

@Test(enabled=false)
public void update_order_id()
{
	RestAssured.baseURI=url;
	
	JSONObject js=new JSONObject();
	js.put("product", "6374c33aab8672001707bbde");
	js.put("quantity", "1000");
	
	given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjY1NzUsImV4cCI6MTY2ODYxMjk3NX0.ZyGFo64dH_4O-G6C0UYmf3-fe05DTGW9ZI4mdaG3jz4")
	.contentType(ContentType.JSON).accept(ContentType.JSON).body(js.toJSONString()).when().
	patch("/orders/6373c8009eb713001762a677").then().log().all();
	
}

@Test(enabled=true)
public void delete_order_id()
{
	RestAssured.baseURI=url;
	
	JSONObject js=new JSONObject();
	
	
	given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjY1NzUsImV4cCI6MTY2ODYxMjk3NX0.ZyGFo64dH_4O-G6C0UYmf3-fe05DTGW9ZI4mdaG3jz4")
	.contentType(ContentType.JSON).accept(ContentType.JSON).when().
	delete("/orders/6374c33aab8672001707bbde").then().log().all();
	
}

}





