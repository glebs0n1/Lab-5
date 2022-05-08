package net.GLEB.Fuel;
import net.GLEB.JSON.Workerable;

import java.util.UUID;

public class Fuel {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int enginePower; //Значение поля должно быть больше 0
    private Integer numberOfWheels; //Поле может быть null, Значение поля должно быть больше 0
    private VehicleType type; //Поле не может быть null
    private FuelType fuelType; //Поле не может быть null

    Fuel(String name, double x, float y, int engine, int iteger, VehicleType type, FuelType fuelType) {
        this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        this.name = name;
        this.coordinates = new Coordinates(x,y);
       //this.creationDate = creationDate;
        this.enginePower = engine;
        this.numberOfWheels = iteger;
        this.type = type;
        this.fuelType = fuelType;
    }

    public void setId(long id){
        this.id = id;
    }

    public String toString(Workerable worker){
        return worker.writeValue(this);
    }

    public void getEnginePower() {//enginePower создаем,как ВОЙД
    }
    public long getId() {
        return id;
    }  //создаем,как Лонг

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public java.time.ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public int getEngine() {
        return enginePower;
    }


    public VehicleType getType() {
        return type;
    }

    public FuelType getCharacter() {
        return fuelType;
    }

    public Integer getNumberOfWheels() {
        return numberOfWheels;
    }
}