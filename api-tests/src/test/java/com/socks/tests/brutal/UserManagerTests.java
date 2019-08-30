package com.socks.tests.brutal;

import com.github.javafaker.Faker;
import com.socks.api.model.User;
import com.socks.api.services.UserApiService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.socks.api.conditions.Conditions.statusCode;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;


public class UserManagerTests {

    @BeforeAll
    static void setUp() {
        RestAssured.port = 80;
    }

    private UserApiService userApiService = new UserApiService();
    Faker faker = new Faker();

    @Test
    void  testCanRegisterUserWithValidCredentials(){
        User user = new User()
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setUsername(faker.name().username())
                .setEmail(faker.internet().emailAddress())
                .setPassword(faker.internet().password());

        RestAssured
                .given().contentType(ContentType.JSON).log().all()
                .body(user)
                .when()
                .post("register")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("id", not(empty()));
        }

    @Test
    void  testCanRegisterUserWithValidCredentialsApproachWithService(){
        //given
        User user = new User()
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setUsername(faker.name().username())
                .setEmail(faker.internet().emailAddress())
                .setPassword(faker.internet().password());

        //expect
        userApiService.registerUser(user)
                //.shouldHave(body("id", not(empty())))
                .shouldHave(statusCode(200));


    }
}
