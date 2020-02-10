public class Car {
    private Integer id;
    private String manufactureYear;
    private String model;
    private Integer price;
    private String color;

    public Car(Integer id, String manufactureYear, String model, Integer price, String color) {
        this.id = id;
        this.manufactureYear = manufactureYear;
        this.model = model;
        this.color = color;
    }

    public Car(String manufactureYear, String model,Integer price, String color) {
        this.manufactureYear = manufactureYear;
        this.model = model;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", manufactureYear='" + manufactureYear + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(String manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
