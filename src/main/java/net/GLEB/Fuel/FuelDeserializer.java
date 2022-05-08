package net.GLEB.Fuel;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.GLEB.App.ObjectInterfaces.StoredType;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class FuelDeserializer {
    private static JsonDeserializer<StoredType> des = // Vechicle(String name, Long numberOfWheels, Location location
            //Fuel(long id, String name, Coordinates coordinates, LocalDateTime creationDate, Long enginePower, long numberOfWheels, FuelType type,VehicleType type, Vehicle vehicle
            FuelDeserializer::deserialize;

    public static JsonDeserializer<StoredType> getDeserializer(){
        return des;
    }

    private static StoredType deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        long id = jsonObject.get("id").getAsLong();
        String name = jsonObject.get("name").getAsString();
        Coordinates coordinates = new Coordinates(
                jsonObject.get("coordinates").getAsJsonObject().get("x").getAsDouble(),
                jsonObject.get("coordinates").getAsJsonObject().get("y").getAsFloat()
        );
        JsonObject creationDateJson = jsonObject.get("creationDate").getAsJsonObject();
        JsonObject date = creationDateJson.get("date").getAsJsonObject();
        JsonObject time = creationDateJson.get("time").getAsJsonObject();
        LocalDateTime creationDate = LocalDateTime.of(
                date.get("year").getAsInt(),
                date.get("month").getAsInt(),
                date.get("day").getAsInt(),
                time.get("hour").getAsInt(),
                time.get("minute").getAsInt(),
                time.get("second").getAsInt());
        Long enginePower = jsonObject.get("enginePower").getAsLong();
        long numberOfWheels = jsonObject.get("numberOfWheels").getAsLong();
        FuelType fuelType;
        try {
            fuelType = FuelType.valueOf(jsonObject.get("type").getAsString());
        } catch (NullPointerException ex) {
            fuelType = null;
        }
        VehicleType Type = VehicleType.valueOf(jsonObject.get("type").getAsString());
        Vechicle vechicle;
        try {
            JsonObject vechicleJson = jsonObject.get("vechicle").getAsJsonObject();
            SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy, hh:mm:ss a");
            Location location;
            Date birthday;
            try {
                birthday = format.parse(vechicleJson.get("birthday").getAsString());
            } catch (NullPointerException | ParseException ex) {
                birthday = null;
            }
            try {
                JsonObject locationJson = vechicleJson.get("location").getAsJsonObject();
                location = new Location(
                        locationJson.get("x").getAsDouble(),
                        locationJson.get("y").getAsFloat(),
                        locationJson.get("z").getAsLong(),
                        locationJson.get("name").getAsString());
            } catch (NullPointerException ex) {
                location = null;
            }
            vechicle = new Vechicle( // Vechicle(String name, Long numberOfWheels, Location location
                    vechicleJson.get("name").getAsString(),
                    birthday,
                    location);
        } catch (NullPointerException ex) {
            vechicle = null;
        }
        //Fuel(long id, String name, Coordinates coordinates, LocalDateTime creationDate, Long enginePower, long numberOfWheels, FuelType type,VehicleType type, Vehicle vehicle)
        return (StoredType) new Fuel(id, name, coordinates, creationDate, enginePower, numberOfWheels, fuelType, vechicle) {
            @Override
            public Long getEngine() {
                return null;
            }
        };
    }
}