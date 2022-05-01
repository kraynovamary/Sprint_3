package model;

import java.util.List;

public class Order {

    private String firstName;

    private String lastName;

    private String address;

    private String metroStation;

    private String phone;

    private int rentTime;

    private String deliveryDate;

    private String comment;

    private List<ColorOrder> color;

    public Order(String firstName, String lastName, String address, String metroStation, String phone, int rentTime, String deliveryDate, String comment, List<ColorOrder> color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }

    public Order() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMetroStation() {
        return metroStation;
    }

    public void setMetroStation(String metroStation) {
        this.metroStation = metroStation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRentTime() {
        return rentTime;
    }

    public void setRentTime(int rentTime) {
        this.rentTime = rentTime;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<ColorOrder> getColor() {
        return color;
    }

    public void setColor(List<ColorOrder> color) {
        this.color = color;
    }

    public static class Builder {
        private Order newOrder;

        public Builder() {
            newOrder = new Order();
        }

        public Builder firstName(String firstName){
            newOrder.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            newOrder.lastName = lastName;
            return this;
        }

        public Builder address(String address){
            newOrder.address = address;
            return this;
        }

        public Builder metroStation(String metroStation){
            newOrder.metroStation = metroStation;
            return this;
        }

        public Builder phone(String phone){
            newOrder.phone = phone;
            return this;
        }

        public Builder rentTime(int rentTime){
            newOrder.rentTime = rentTime;
            return this;
        }

        public Builder deliveryDate(String deliveryDate){
            newOrder.deliveryDate = deliveryDate;
            return this;
        }

        public Builder comment(String comment){
            newOrder.comment = comment;
            return this;
        }

        public Builder color(List<ColorOrder> color){
            newOrder.color = color;
            return this;
        }

        public Order build(){
            return newOrder;
        }
    }
}
