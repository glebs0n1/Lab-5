package net.GLEB.Fuel;
import net.GLEB.App.ObjectInterfaces.StoredType;
import net.GLEB.App.ObjectInterfaces.StoredTypeReader;
import net.GLEB.App.UI;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FuelReader<Release> implements StoredTypeReader {
    private UI ui;

    public FuelReader(){ }

    @Override
    public void setUI(UI ui) {
        this.ui = ui;
    }
    public StoredType create(String id){

        String name = ui.readField("Fuel name: ");
        double coordinatesx;
        while (true) {
            try {
                coordinatesx = Double.parseDouble(ui.readField("coordinates.x"));
                break;
            }catch (NumberFormatException ex){
                ui.print("Ваш формат числа неверный");
            }
        }
        float coordinatesy;
        while (true) {
            try {
                coordinatesy = Float.parseFloat(ui.readField("coordinates.y"));
                break;
            }catch (NumberFormatException ex){
                ui.print("Ваш формат числа неверный");//сверяем,верный ли формат числа
            }
        }

        Coordinates coordinates = new Coordinates(coordinatesx, coordinatesy);
        long engine;
        while (true) {
            try {
               engine = Long.parseLong(ui.readField("engine"));
                if(engine> 0)
                    break;
                else
                    ui.print("Значение "+ "engine" +" должно быть больше 0");
            }catch (NumberFormatException ex){
                ui.print("Ваш формат числа неверный"); //сверяем,верный ли формат числа
            }
        }
        long iteger;
        while (true) {
            try {
                iteger = Long.parseLong(ui.readField("iteger"));
                if(iteger > 0)
                    break;
                else
                    ui.print("Значение "+ "iteger" +" должно быть больше 0");
            }catch (NumberFormatException ex){
                ui.print("Ваш формат числа неверный");//сверяем,верный ли формат числа
            }
        }

        FuelType fuelType;
        while (true) {
            try {
                fuelType = FuelType.valueOf(ui.readField("type:\n" + FuelType.GASOLINE + "\n" + FuelType.ALCOHOL + "\n" + FuelType.PLASMA + "\n" +"type"));
                break;
            }catch (IllegalArgumentException ex){
                ui.print("Такого типа нету :(( ");//проверяем,есть ли такой тип
            }
        }
        VehicleType vehicleType;
        while (true) {
            try{
                vehicleType = VehicleType.valueOf(ui.readField("Type:\n" + VehicleType.CHOPPER +"\n" +  VehicleType.SHIP + "\n" + VehicleType.SPACESHIP + "\n" + "Type"));
                break;
            }catch (IllegalArgumentException ex){
                ui.print("Такого Type нету :((");//проверяем,есть ли такой тип
            }
        }
        Kind liquid;

        String liquidname = ui.readField("liquid.name");

        if (liquidname.isEmpty()){
            liquid = null;
        }else {
            SimpleDateFormat format = new SimpleDateFormat("dd-mmm-yyyy");//задаем формат времени
            Release date;
            Location location;
            Object Release = null;
            while (true) {
                try {
                    String
                            releasestr = ui.readField("\n" + "release(format: dd-mmm-yyyy)");//задаем формат времени

                    if (!
                            releasestr.isEmpty()) {

                        Release = format.parse(
                                releasestr);

                    }
                    break;
                } catch(ParseException e) {
                    ui.print("Ваш формат даты неверный");//проверяем формат даты
                }
            }
            long liquidvolume;
            while (true) {
                try {
                    liquidvolume = Long.parseLong(ui.readField("liquid.volume"));
                    if(liquidvolume > 0)
                        break;
                    else
                        ui.print("Значение "+ "liquidvolume" +" должно быть больше 0");
                }catch (NumberFormatException ex){
                    ui.print("Ваш формат числа неверный");//сверяем,верный ли формат числа
                }
            }
            long liquiditeger;
            while (true) {
                try {
                    liquiditeger = Long.parseLong(ui.readField("liquid.iteger"));
                    if(liquiditeger > 0)
                        break;
                    else
                        ui.print("Значение "+ "iteger" +" должно быть больше 0");
                }catch (NumberFormatException ex){
                    ui.print("Ваш формат числа неверный");//сверяем,верный ли формат числа
                }
            }

            double locationxd = 0.;
            String locationx;
            while (true) {
                locationx = ui.readField("locationx");
                try {
                    if (locationx.isEmpty())
                        break;
                    locationxd = Double.parseDouble(locationx);
                    break;
                }catch (NumberFormatException ex){
                    ui.print("Ваш формат числа неверный");//сверяем,верный ли формат числа
                }
            }
            if(locationx.isEmpty()){
                location=null;
            }else {

                float locationyd;
                while (true){
                    String locationy = ui.readField("locationy");
                    try {
                        locationyd = Float.parseFloat(locationy);
                        break;
                    }catch (NumberFormatException ex){
                        ui.print("Ваш формат числа неверный");//сверяем,верный ли формат числа
    }
}
    long locationzd;
                while(true){
                        String locationz = ui.readField("locationz");
                        try {
                        locationzd = Long.parseLong(locationz);
                        break;
                        }catch (NumberFormatException ex){
                        ui.print("Ваш формат числа неверный");
                        }
                        }
                        String locationname = ui.readField("locationname");
                        location = new Location(locationxd, locationyd, locationzd, locationname);
                        }

                        liquid = new Kind( // Person(String name, Release date, long volume, Long iteger, Location location
                        liquidname,
                        Release,
                        liquidvolume,
                        liquiditeger,
                        location);

                        }
                        Fuel fuel = new Fuel(name,543,543,432,432,VehicleType.CHOPPER,FuelType.ALCOHOL);
        // задали значения в X AND Y, такжн в TYPE
        if(!id.equals("null")){
            fuel.setId(Long.parseLong(id));
        }
        //Fuel(long id, String name, Coordinates coordinates, ZoneDateTime creationDate, Long engine, long iteger, FuelType type, VehicleType)
        assert false;
        return (StoredType) fuel;
    }


    private static class Kind {
        Kind(String liquidname, Object release, long liquidvolume, long liquiditeger, Location location) {
        }
    }
}