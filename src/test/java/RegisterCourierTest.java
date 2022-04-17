import data.DataGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.Courier;
import org.junit.Test;
import rest.ScooterRestUrl;

import static org.hamcrest.Matchers.*;


public class RegisterCourierTest extends MainTest {

    @Test
    @DisplayName("Check created new courier of /api/v1/courier")
    @Description("Basic success test for /api/v1/courier endpoint")
    public void createNewCourierTest() {

        responseRegistration.then().assertThat()
                .statusCode(201)
                .and().body("ok", equalTo(true));
    }

    @Test
    @DisplayName("Check created Duplicate Login courier of /api/v1/courier")
    @Description("Duplicate login test for /api/v1/courier endpoint")
    public void createNewCourierDuplicateLoginTest() {

        responseRegistration.then().assertThat()
                .statusCode(201)
                .and().body("ok", equalTo(true));

        Courier courierDuplicate = DataGenerator.generatorNewCourier();
        courierDuplicate.setLogin(courier.getLogin());

        Response responseDuplicate = restScooterSend.postRequestAndReturnResponse(courierDuplicate, ScooterRestUrl.REGISTER_COURIER);

        responseDuplicate.then().assertThat()
                .statusCode(409)
                .and().body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
    }
}
