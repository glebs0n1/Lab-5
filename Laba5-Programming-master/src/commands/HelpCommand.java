package commands;

import generatedClasses.Route;
import manager.*;

import java.util.HashMap;
import java.util.LinkedHashSet;

//ConcreteCommand
public class HelpCommand implements Command{
    private Navigator navigator;
    private final String name = "help";
    private final String description = "- вывести справку по доступным командам";


    public HelpCommand (Navigator navigator) {
        this.navigator = navigator;
    }

    @Override
    public void execute(HashMap<String, Command>  man, LinkedHashSet<Route> routes, String arg) {

        navigator.help(man);
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }


}
