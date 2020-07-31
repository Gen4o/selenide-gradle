package com.socks.tests.brutal;

import com.github.javafaker.Faker;
import com.socks.api.model.User;
import com.socks.api.services.UserApiService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {
            "genm+1@test.uk",
            "genm+2@test.uk",
            "genm+3@test.uk",
            "genm+4@test.uk",
            "genm+5@test.uk",
            "genm+6@test.uk",
            "genm+7@test.uk",
            "genm+8@test.uk",
            "genm+9@test.uk",
            "genm+10@test.uk",
            "genm+11@test.uk",
            "genm+12@test.uk",
            "genm+13@test.uk",
            "genm+14@test.uk",
            "genm+15@test.uk",
            "genm+16@test.uk",
            "genm+17@test.uk",
            "genm+18@test.uk",
            "genm+19@test.uk",
            "genm+20@test.uk",
            "genm+21@test.uk",
            "genm+22@test.uk",
            "genm+23@test.uk",
            "genm+24@test.uk",
            "genm+25@test.uk",
            "genm+26@test.uk",
            "genm+27@test.uk",
            "genm+28@test.uk",
            "genm+29@test.uk",
            "genm+30@test.uk",
            "genm+31@test.uk",
            "genm+32@test.uk",
            "genm+33@test.uk",
            "genm+34@test.uk",
            "genm+35@test.uk",
            "genm+36@test.uk",
            "genm+37@test.uk",
            "genm+38@test.uk",
            "genm+39@test.uk",
            "genm+40@test.uk",
            "genm+41@test.uk",
            "genm+42@test.uk",
            "genm+43@test.uk",
            "genm+44@test.uk",
            "genm+45@test.uk",
            "genm+46@test.uk",
            "genm+47@test.uk",
            "genm+48@test.uk",
            "genm+49@test.uk",
            "genm+50@test.uk",
            "genm+51@test.uk",
            "genm+52@test.uk",
            "genm+53@test.uk",
            "genm+54@test.uk",
            "genm+55@test.uk",
            "genm+56@test.uk",
            "genm+57@test.uk",
            "genm+58@test.uk",
            "genm+59@test.uk",
            "genm+60@test.uk",
            "genm+61@test.uk",
            "genm+62@test.uk",
            "genm+63@test.uk",
            "genm+64@test.uk",
            "genm+65@test.uk",
            "genm+66@test.uk",
            "genm+67@test.uk",
            "genm+68@test.uk",
            "genm+69@test.uk",
            "genm+70@test.uk"

    })
    void  testCanRegisterUserWithValidCredentialsApproachWithService(String email){
        //given
        String password = "123Qwerty";
        String birthdate = "20010101";
        String city = "BIG CITY";
        User user = new User()
                .setEmail(email)
                .setPassword(password)
                .setBirthdate(birthdate)
                .setFirstname(faker.name().firstName())
                .setLastname(faker.name().lastName())
                .setCity(city)
                .setLanguage("en")
                .setCountry("GB")
                .setSalutation("MR")
                .setCountryCode(1)
                .setPostCode("AA1 1AA")
                .setStreetName("HIGH STREET")
                .setStreetNr("1")
                .setLimitAmount("200000");


        //expect
        userApiService.registerUser(user)
                //.shouldHave(body("id", not(empty())))
                .shouldHave(statusCode(200));


    }
}
