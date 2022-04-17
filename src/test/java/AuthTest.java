import data.DataGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import rest.ScooterRestUrl;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class AuthTest extends MainTest {

    @Test
    @DisplayName("Check authorization courier of /api/v1/courier/login")
    @Description("Basic success test for /api/v1/courier/login")
    public void authorizationNewCourierTest() {

        responseAuthorization.then().assertThat()
                .statusCode(200)
                .and().body("id", notNullValue());
    }

    @Test
    @DisplayName("Check authorization without field login of /api/v1/courier/login")
    @Description("Basic test without field login for /api/v1/courier/login")
    public void authorizationWithoutLoginTest() {

        courier.setLogin(null);
        Response response = restScooterSend.postRequestAndReturnResponse(courier, ScooterRestUrl.AUTHORIZATION_COURIER);

        response.then().assertThat()
                .statusCode(400)
                .and().body("message", equalTo("Недостаточно данных для входа"));
    }

    @Test
    @DisplayName("Check authorization without field password of /api/v1/courier/login")
    @Description("Basic test without field password for /api/v1/courier/login")
    public void authorizationWithoutPasswordTest() {

        courier.setPassword(null);
        Response response = restScooterSend.postRequestAndReturnResponse(courier, ScooterRestUrl.AUTHORIZATION_COURIER);

        response.then().assertThat()
                .statusCode(400)
                .and().body("message", equalTo("Недостаточно данных для входа"));
    }

    @Test
    @DisplayName("Check authorization does not exist courier of /api/v1/courier/login")
    @Description("Basic test does not exist courier for /api/v1/courier/login endpoint")
    public void authorizationDoesNotExistCourierTest() {

        courier = DataGenerator.generatorNewCourier();
        Response response = restScooterSend.postRequestAndReturnResponse(courier, ScooterRestUrl.AUTHORIZATION_COURIER);

        response.then().assertThat()
                .statusCode(404)
                .and().body("message", equalTo("Учетная запись не найдена"));
    }

    @Test
    @DisplayName("Check authorization NotCorrectCourierLogin of /api/v1/courier/login")
    @Description("Basic test NotCorrectCourierLogin for /api/v1/courier/login endpoint")
    public void authorizationNotCorrectLoginCourierTest() {

        courier.setLogin(courier.getLogin() + "Test");
        Response response = restScooterSend.postRequestAndReturnResponse(courier, ScooterRestUrl.AUTHORIZATION_COURIER);

        response.then().assertThat()
                .statusCode(404)
                .and().body("message", equalTo("Учетная запись не найдена"));
    }

    @Test
    @DisplayName("Check authorization NotCorrectPassword courier of /api/v1/courier/login")
    @Description("Basic test NotCorrectPassword courier for /api/v1/courier/login endpoint")
    public void authorizationNotCorrectPasswordCourierTest() {

        courier.setPassword(courier.getLogin() + "Test");
        Response response = restScooterSend.postRequestAndReturnResponse(courier, ScooterRestUrl.AUTHORIZATION_COURIER);

        response.then().assertThat()
                .statusCode(404)
                .and().body("message", equalTo("Учетная запись не найдена"));
    }
}