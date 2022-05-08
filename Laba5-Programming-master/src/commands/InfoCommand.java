package commands;

import generatedClasses.Route;
import manager.*;


import java.util.HashMap;
import java.util.LinkedHashSet;

//ConcreteCommand
public class InfoCommand implements Command {
    private Navigator navigator;
    private final String name = "info";
    private final String description = "- вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";

    public InfoCommand (Navigator navigator) {
        this.navigator = navigator;
    }


    @Override
    public void execute(HashMap<String, Command> man, LinkedHashSet<Route> routes, String arg) {

        navigator.info(routes);
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
