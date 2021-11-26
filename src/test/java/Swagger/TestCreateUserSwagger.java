package Swagger;

import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class TestCreateUserSwagger {

    @Test
    public void createSingleUser(){
        CreateUserRequest request = new CreateUserRequest();
        CreateUserResponse response = new CreateUserResponse();
        request.setId(12);
        request.setUsername("User12");
        request.setFirstName("Usha");
        request.setLastName("Sathish");
        request.setEmail("usha@gmail.com");
        request.setPassword("testpassword");
        request.setPhone("12345");
        request.setUserStatus(0);

        CreateUserResponse user1 =
                given().
                        contentType(ContentType.JSON).body(request).
                        when().
                        post("https://petstore.swagger.io/v2/user").as(CreateUserResponse.class);
        user1.printResponseBody();
        Assert.assertEquals(200,user1.getCode());
    }
    @Test
    public void createMultipleUsers(){
        ArrayList<CreateUserRequest> multipleUsers = new ArrayList<CreateUserRequest>();

        CreateUserRequest request1 = new CreateUserRequest();
        request1.setId(15);
        request1.setUsername("User15");
        request1.setFirstName("Usha");
        request1.setLastName("Sathish");
        request1.setEmail("adhiya@gmail.com");
        request1.setPassword("testpassword");
        request1.setPhone("1234567");
        request1.setUserStatus(1);
        multipleUsers.add(request1);

        CreateUserRequest request2 = new CreateUserRequest();
        request2.setId(16);
        request2.setUsername("User16");
        request2.setFirstName("Usha");
        request2.setLastName("Sathish");
        request2.setEmail("sathish@gmail.com");
        request2.setPassword("testpassword");
        request2.setPhone("123456789");
        request2.setUserStatus(1);
        multipleUsers.add(request2);

        CreateUserResponse users =
                given().
                        contentType(ContentType.JSON).body(multipleUsers).log().body().
                        when().
                        post("https://petstore.swagger.io/v2/user/createWithArray").as(CreateUserResponse.class);
        users.printResponseBody();
        Assert.assertEquals(200,users.getCode());
    }
}