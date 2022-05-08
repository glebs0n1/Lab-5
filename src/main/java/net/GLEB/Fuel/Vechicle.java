package net.GLEB.Fuel;
import java.util.Date;

class Vechicle {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.util.Date birthday; //Поле может быть null
    private Location location; //Поле может быть null

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Location getLocation() {
        return location;
    }
    @Override
    public int hashCode() {
        return birthday.hashCode()
                * location.hashCode();
    }
    Vechicle(String name, Date birthday, Location location) throws IllegalArgumentException, NullPointerException {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
        this.birthday = birthday;
        this.location = location;
    }
}