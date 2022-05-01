package data;

import model.ColorOrder;
import model.Courier;
import model.Order;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

public class DataGenerator {

    public static Courier generatorNewCourier() {
        String courierLogin = RandomStringUtils.randomAlphabetic(10);
        // с помощью библиотеки RandomStringUtils генерируем пароль
        String courierPassword = RandomStringUtils.randomAlphabetic(10);
        // с помощью библиотеки RandomStringUtils генерируем имя курьера
        String courierFirstName = RandomStringUtils.randomAlphabetic(10);

        return new Courier(courierLogin, courierPassword, courierFirstName);
    }

    public static Order generatorNewOrder(List<ColorOrder> orderColors) {

        return new Order.Builder()
                .firstName(RandomStringUtils.randomAlphabetic(10))
                .lastName(RandomStringUtils.randomAlphabetic(10))
                .address(RandomStringUtils.randomAlphabetic(10))
                .metroStation("4")
                .phone("+78003553535")
                .rentTime(5)
                .deliveryDate("2020-06-06")
                .comment(RandomStringUtils.randomAlphabetic(10))
                .color(orderColors)
                .build();
    }
}
