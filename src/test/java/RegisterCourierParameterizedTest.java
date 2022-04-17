import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.Courier;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import rest.ScooterRestUrl;

import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class RegisterCourierParameterizedTest extends MainTest {

    private Courier courierWithoutFields;

    public RegisterCourierParameterizedTest(Courier courierWithoutFields) {
        this.courierWithoutFields = courierWithoutFields;
    }

    @Parameterized.Parameters
    public static Object[][] getCourierData() {
        return new Object[][]{
                {new Courier(null, RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(10))},
                {new Courier(RandomStringUtils.randomAlphabetic(10),null, RandomStringUtils.randomAlphabetic(10))},
        };
    }

    @Test
    @DisplayName("Check created courier without required fields of /api/v1/courier")
    @Description("Required fields test for /api/v1/courier endpoint")
    public void createNewCourierWithoutRequiredFieldLoginTest() {

        Response response = restScooterSend.postRequestAndReturnResponse(courierWithoutFields, ScooterRestUrl.REGISTER_COURIER);

        response.then().assertThat()
                .statusCode(400)
                .and().body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }
}
