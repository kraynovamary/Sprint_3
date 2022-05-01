package rest;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import util.JacksonObjectMapper;

import static io.restassured.RestAssured.*;

public class RestScooterSend extends RestAssuredClient {

    @Step
    public <T> Response postRequestAndReturnResponse(T requestBody, ScooterRestUrl url) {

        return given()
                .spec(getBaseSpec())
                .and()
                .body(JacksonObjectMapper.objectToJson(requestBody))
                .when()
                .post(url.getId());
    }

    @Step
    public Response getRequestAndReturnResponse(ScooterRestUrl url) {

        return given()
                .spec(getBaseSpec())
                .when()
                .get(url.getId());
    }

    @Step
    public <T> Response deleteCourierByIdAndReturnResponse(T requestBody, int id, ScooterRestUrl url) {

        return given()
                .spec(getBaseSpec())
                .and()
                .body(JacksonObjectMapper.objectToJson(requestBody))
                .when()
                .delete(url.getId() + id);
    }
}