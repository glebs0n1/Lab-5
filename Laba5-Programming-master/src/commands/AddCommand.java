package commands;

import generatedClasses.Route;
import manager.*;

import java.util.HashMap;
import java.util.LinkedHashSet;

//ConcreteCommand
public class AddCommand implements Command  {
    Navigator navigator;
    private final String name = "add";
    private final String description = " - добавить новый элемент в коллекцию";

    public AddCommand (Navigator navigator) {
        this.navigator = navigator;
    }


    @Override
    public void execute(HashMap<String, Command> man, LinkedHashSet<Route> routes, String arg) {

        navigator.add(routes, arg);
    }

    public String getDescription() {
        return description;
    }

    public String getName ( ) {
        return name;
    }
}



