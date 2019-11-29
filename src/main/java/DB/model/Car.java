package DB.model;

public class Car {
    private String car_name;
    private int car_id;
    private String power;
    private String max_speed;
    private  String weight;
    private  String waste;
    private  String acceleration;
    private  String country;
    private String body;


    public Car() {
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public Car(String car_name, int car_id, String power, String max_speed, String weight, String waste, String acceleration, String country, String body) {
        this.car_name = car_name;
        this.car_id = car_id;
        this.power = power;
        this.max_speed = max_speed;
        this.weight = weight;
        this.waste = waste;
        this.acceleration = acceleration;
        this.country = country;
        this.body = body;
    }

    public Car( String car_name, String power, String max_speed, String weight, String waste, String acceleration, String country, String body) {
        this.car_name = car_name;
        this.power = power;
        this.max_speed = max_speed;
        this.weight = weight;
        this.waste = waste;
        this.acceleration = acceleration;
        this.country = country;
        this.body = body;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getMax_speed() {
        return max_speed;
    }

    public void setMax_speed(String max_speed) {
        this.max_speed = max_speed;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWaste() {
        return waste;
    }

    public void setWaste(String waste) {
        this.waste = waste;
    }

    public String getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(String acceleration) {
        this.acceleration = acceleration;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
