package rest;

public enum ScooterRestUrl {

    BASE_URL("https://qa-scooter.praktikum-services.ru"),
    REGISTER_COURIER("/api/v1/courier"),
    AUTHORIZATION_COURIER("/api/v1/courier/login"),
    ORDER_URL("/api/v1/orders"),
    DELETE_COURIER_URL("/api/v1/courier/");

    private final String id;

    ScooterRestUrl(String s) {
        this.id = s;
    }

    public String getId() {
        return id;
    }
}
