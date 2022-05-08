package net.GLEB.Fuel;
import java.util.Objects;

public class Coordinates {
    private Double x;//Поле не может быть null
    private float y;//Поле не может быть null
    public Double getX() {
        return x;
    }//Координат x с классом Double

    public float getY() {
        return y;
    }//Координат y с типом float

    Coordinates(Double x, float y) throws IllegalArgumentException, NullPointerException{
        this.x = Objects.requireNonNull(x,"неверный x");
        this.y = y;
    }
}