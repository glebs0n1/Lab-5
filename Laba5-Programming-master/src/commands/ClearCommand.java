package commands;

import generatedClasses.Route;
import manager.*;

import java.util.HashMap;
import java.util.LinkedHashSet;

//ConcreteCommand
public class ClearCommand implements Command  {
    Navigator navigator;
    private final String name = "clear";
    private final String description = " - очистить коллекцию";

    public ClearCommand (Navigator navigator) {
        this.navigator = navigator;
    }


    @Override
    public void execute(HashMap<String, Command> man, LinkedHashSet<Route> routes, String arg) {

        navigator.clear(routes);
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}



