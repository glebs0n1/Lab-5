package net.GLEB.Fuel;
import java.util.Date;

public class Kind {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.util.Date release; //Поле может быть null
    private long volume; //Значение поля должно быть больше 0
    private Long iteger; //Поле не может быть null, Значение поля должно быть больше 0
    private Location location; //Поле может быть null

    public String getName() {
        return name;
    }

    public Date getRelease() {
        return release;
    }

    public long getHeight() {
        return volume;
    }

    public Long getIteger() {
        return iteger;
    }

    public Location getLocation() {
        return location;
    }

    Kind(String name, Date Release, long volume, Long iteger, Location location) throws IllegalArgumentException, NullPointerException {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Invalid name");
        }
        if (volume <= 0){
            throw new IllegalArgumentException("Invalid height");
        }
        if (iteger == null || iteger<=0){
            throw new IllegalArgumentException("Invalid iteger");
        }
        this.name = name;
        this.release = Release;
        this.volume = volume;
        this.iteger = iteger;
        this.location = location;
    }
}