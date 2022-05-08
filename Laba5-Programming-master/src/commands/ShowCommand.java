package commands;

import generatedClasses.Route;
import manager.*;

import java.util.HashMap;
import java.util.LinkedHashSet;

//ConcreteCommand
public class ShowCommand implements Command  {
    Navigator navigator;
    private final String name = "show";
    private final String description = " - вывести в стандартный поток вывода все элементы коллекции в строковом представлении";

        public ShowCommand (Navigator navigator) {
            this.navigator = navigator;
        }


        @Override
        public void execute(HashMap<String, Command> man, LinkedHashSet<Route> routes, String arg) {

            navigator.show(routes);
        }

        public String getDescription() {
            return description;
        }


    public String getName() {
    return name;
    }

}



