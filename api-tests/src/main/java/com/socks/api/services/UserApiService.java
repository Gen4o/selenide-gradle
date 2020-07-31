package com.socks.api.services;

import com.socks.api.AssertableResponse;
import com.socks.api.model.User;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserApiService {

    public RequestSpecification setup() {
        RestAssured.baseURI = "https://pro-320.test.lottoland.co.uk:443";
        return RestAssured
                .given().headers(
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON,
                        "X-API-KEY",
                        "AABB138",
                        "Content-Encoding",
                        "gzip")
                .filters(new RequestLoggingFilter(),
                        new ResponseLoggingFilter(),
                        new AllureRestAssured());
    }

    @Step
    public AssertableResponse registerUser(User user) {
        log.info("register user {}", user);

        return new AssertableResponse((ValidatableResponse) setup()
                .body(user)
                .when()
                .post("/api/client/v1/players")
                .then());
    }
}
