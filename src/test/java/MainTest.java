import data.DataGenerator;
import rest.RestScooterSend;
import io.restassured.response.Response;
import model.Courier;
import org.junit.After;
import org.junit.Before;
import rest.ScooterRestUrl;
import util.JacksonObjectMapper;

public class MainTest {
    protected Courier courier;
    protected RestScooterSend restScooterSend;
    protected Courier courierId;
    protected Response responseRegistration;
    protected Response responseAuthorization;

    @Before
    public void init() {
        restScooterSend = new RestScooterSend();
        courier = DataGenerator.generatorNewCourier();
        responseRegistration = restScooterSend.postRequestAndReturnResponse(courier, ScooterRestUrl.REGISTER_COURIER);
        responseAuthorization = restScooterSend.postRequestAndReturnResponse(courier, ScooterRestUrl.AUTHORIZATION_COURIER);
        courierId = JacksonObjectMapper.getObject(responseAuthorization.getBody().print(), Courier.class);
        courier.setId(courierId.getId());
    }

    @After
    public void afterClose(){
        restScooterSend.deleteCourierByIdAndReturnResponse(courierId, courierId.getId(),ScooterRestUrl.DELETE_COURIER_URL);
    }
}
