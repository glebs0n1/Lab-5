package generatedClasses;


public class Location {
    private long x;
    private Long y; //Поле не может быть null
    private String name; //Поле может быть null

    public Location(long x, Long y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    @Override
    public String toString ( ) {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                '}';
    }
}