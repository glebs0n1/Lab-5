package net.GLEB.Fuel;
public class Location {
    private double x;
    private float y;

    public double getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Long getZ() {
        return z;
    }

    public String getName() {
        return name;
    }

    Location(double x, float y, Long z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    private Long z; //Поле не может быть null
    private String name; //Длина строки не должна быть больше числа, Поле не может быть null
}