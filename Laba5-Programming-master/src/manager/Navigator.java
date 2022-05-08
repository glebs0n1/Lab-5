package  manager;

import commands.*;
import generatedClasses.*;

import java.sql.SQLOutput;
import java.util.*;

//Receiver
public class Navigator {

    private LinkedHashSet<Route> routes = new LinkedHashSet<>();
    Date date = new Date();

    public void help(HashMap <String, Command> man) {

        System.out.println("Справка по доступным командам: ");

        for(Map.Entry<String, Command> entry: man.entrySet()) {

            System.out.println(entry.getKey() + " " + entry.getValue().getDescription());
        }
    }


    public void info(LinkedHashSet<Route> routes) {
        System.out.println("Информация о коллекции: \n");
        System.out.println("Тип: " + routes.getClass());
        System.out.println("Дата инициализации: " + date);
        System.out.println("Количество элементов: " + routes.size());
    }



    public void show(LinkedHashSet<Route> routes){
       for (Route route : routes){
           System.out.println(route);
       }
    }


    public void add(LinkedHashSet<Route> routes, String arg) {
        Scanner scan = new Scanner(System.in);
        Route route = null;
        System.out.println("Имя объекта: " + arg);
        System.out.println("Идентификационный номер: " + GenerateId.giveMeId());
        System.out.print("Введите текущую координату местанахождения x: ");
        Long x = scan.nextLong();

        System.out.print("Введите текущую координату местанахождения y: ");
        int y = scan.nextInt();
        scan.nextLine();

        System.out.print("Введите название места отправления: ");
        String namefrom = scan.nextLine();

        System.out.print("Введите координату x места отправления: ");
        long xfrom = scan.nextLong();

        System.out.print("Введите координату y места отправления: ");
        Long yfrom = scan.nextLong();
        scan.nextLine();

        System.out.print("Введите название места прибытия: ");
        String nameto = scan.nextLine();

        System.out.print("Введите координату x места прибытия: ");
        long xto = scan.nextLong();

        System.out.print("Введите координату y места прибытия: ");
        Long yto = scan.nextLong();

        System.out.print("Введите длину маршрута: ");
        Float distance = scan.nextFloat();

        Coordinates coordinates = new Coordinates(x, y);
        Location to = new Location(xto, yto, nameto);
        Location from = new Location(xfrom, yfrom, namefrom);
        route = new Route(arg, coordinates, from, to, distance );

        routes.add(route);

        System.out.println("Объект успешно добавлен в коллекцию!");
        scan.nextLine();
    }

    public void clear(LinkedHashSet<Route> routes) {
        routes.clear();
    }

    public void exit() {
        System.exit(0);
    }


}
