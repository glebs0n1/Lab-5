package commands;

import generatedClasses.Route;
import manager.*;

import java.util.HashMap;
import java.util.LinkedHashSet;

//ConcreteCommand
public class ExitCommand implements Command  {
    Navigator navigator;
    private final String name = "exit";
    private final String description = " - завершить программу(без сохранения файла)";

    public ExitCommand (Navigator navigator) {
        this.navigator = navigator;
    }


    @Override
    public void execute(HashMap<String, Command> man, LinkedHashSet<Route> routes, String arg) {

        navigator.exit();
    }

    public String getDescription() {
        return description;
    }

    public String getName ( ) {
        return name;
    }
}



