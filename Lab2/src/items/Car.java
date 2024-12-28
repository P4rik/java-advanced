package items;

import annotations.JsonField;
import annotations.XmlField;

/**
 * Represents a items.Car with a model, manufacturer, and production year.
 * This class uses annotations to map the fields to JSON and XML formats.
 */
public class Car {

    /**
     * The model of the car.
     * Mapped to the JSON field "model" and XML field "Model".
     */
    @JsonField("model")
    @XmlField("Model")
    private String model;

    /**
     * The manufacturer of the car.
     * Mapped to the JSON field "manufacturer" and XML field "Manufacturer".
     */
    @JsonField("manufacturer")
    @XmlField("Manufacturer")
    private String manufacturer;

    /**
     * The year the car was manufactured.
     * Mapped to the JSON field "year" and XML field "Year".
     */
    @JsonField("year")
    @XmlField("Year")
    private int year;

    /**
     * Constructs a new items.Car object with the specified model, manufacturer, and year.
     *
     * @param model the model of the car
     * @param manufacturer the manufacturer of the car
     * @param year the year the car was manufactured
     */
    public Car(String model, String manufacturer, int year) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
    }

    /**
     * Gets the model of the car.
     *
     * @return the model of the car
     */
    public String getModel() {
        return model;
    }

    /**
     * Gets the manufacturer of the car.
     *
     * @return the manufacturer of the car
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Gets the year the car was manufactured.
     *
     * @return the year the car was manufactured
     */
    public int getYear() {
        return year;
    }
}
