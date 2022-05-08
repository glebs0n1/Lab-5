package  manager;

import commands.*;
import generatedClasses.*;
import com.google.gson.Gson;

import java.util.LinkedHashSet;
import java.util.Scanner;


public class CommandApp {

    {
        LinkedHashSet<Route> routes = new LinkedHashSet<>();

        Navigator navigator = new Navigator();

        HelpCommand help = new HelpCommand(navigator);
        InfoCommand info = new InfoCommand(navigator);
        ShowCommand show = new ShowCommand(navigator);
        AddCommand add = new AddCommand(navigator);
        ClearCommand clear = new ClearCommand(navigator);
        ExitCommand exit = new ExitCommand(navigator);

        Driver d = new Driver(help, info, show, add, clear, exit);


        Scanner in = new Scanner(System.in);
        String line = null;

        while (line!="exit") {
            line = in.nextLine();
            String arg = null;
            d.execute(line, routes, arg);
        }


    }

}
